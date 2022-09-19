package org.faktorips.schulung.hausratmodell.hausrat;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import org.faktorips.runtime.ClassloaderRuntimeRepository;
import org.faktorips.runtime.IRuntimeRepository;
import org.faktorips.runtime.Message;
import org.faktorips.runtime.MessageList;
import org.faktorips.runtime.ObjectProperty;
import org.faktorips.runtime.Severity;
import org.faktorips.runtime.ValidationContext;
import org.faktorips.runtime.formula.groovy.GroovyFormulaEvaluatorFactory;
import org.faktorips.schulung.hausratmodell.Risikoklasse;
import org.faktorips.values.Money;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class HausratProduktTest {

    private static IRuntimeRepository repository;
    private static HausratProdukt hrKompakt;

    @BeforeAll
    static void setUp() {
        // Repository erzeugen
        repository = ClassloaderRuntimeRepository
                .create("org/faktorips/schulung/hausratprodukte/internal/faktorips-repository-toc.xml");
        ((ClassloaderRuntimeRepository) repository).setFormulaEvaluatorFactory(new GroovyFormulaEvaluatorFactory());
        // Referenz auf das Kompaktprodukt aus dem Repository holen
        hrKompakt = (HausratProdukt) repository.getProductComponent("hausrat.HR-Kompakt 2022-01");
    }

    @Test
    void testProduktdatenLesen() {
        System.out.println("Produktname:                        " + hrKompakt.getProduktname());
        System.out.println("Zahlweise(Default):                 " + hrKompakt.getDefaultValueZahlweise());
        System.out.println("Zahlweise(erlaubte Werte):          " + hrKompakt.getAllowedValuesForZahlweise());
        System.out.println("Versicherungssumme(erlaubte Werte): " + hrKompakt.getAllowedValuesForVersSumme());
        System.out.println("Wohnfläche (erlaubte Werte):        " + hrKompakt.getAllowedValuesForWohnflaeche());
    }

    @Test
    void testGetVorschlagVersSumme() {
        // Erzeugen eines Hausratvertrags mit der Factorymethode des Produktes
        HausratVertrag hausratVertrag = hrKompakt.createHausratVertrag();
        hausratVertrag.setWohnflaeche(100);
        assertThat(hausratVertrag.getVorschlagVersSumme(), is(Money.euro(60_000)));
    }

    @Test
    void testGetVorschlagVersSumme_KeineWohnflaeche() {
        HausratVertrag hausratVertrag = hrKompakt.createHausratVertrag();
        assertThat(hausratVertrag.getVorschlagVersSumme(), is(Money.NULL));
    }

    @Test
    void testGetVorschlagVersSumme_KeinProdukt() {
        HausratVertrag hausratVertrag = new HausratVertrag();
        assertThat(hausratVertrag.getVorschlagVersSumme(), is(Money.NULL));
    }

    @Test
    void testGetTarifzone() {
        HausratVertrag hausratVertrag = hrKompakt.createHausratVertrag();
        hausratVertrag.setPlz("47110");
        assertThat(hausratVertrag.getTarifzone(), is("V"));
    }

    @Test
    void testGetTarifzone_KeinePLZ() {
        HausratVertrag hausratVertrag = hrKompakt.createHausratVertrag();
        assertThat(hausratVertrag.getTarifzone(), is("I"));
    }

    @Test
    void testGetTarifzone_PLZnichtInTabelle() {
        HausratVertrag hausratVertrag = hrKompakt.createHausratVertrag();
        hausratVertrag.setPlz("80639");
        assertThat(hausratVertrag.getTarifzone(), is("I"));
    }

    @Test
    void testGetTarifzone_KeinProdukt() {
        HausratVertrag hausratVertrag = new HausratVertrag();
        assertThat(hausratVertrag.getTarifzone(), is("I"));
    }

    @Test
    void testBerechneJahresbasisbeitrag() {
        HausratVertrag hausratVertrag = hrKompakt.createHausratVertrag();
        hausratVertrag.setPlz("47110");
        hausratVertrag.setVersSumme(Money.euro(60_000));
        // Grunddeckungstyp holen, der dem Produkt zugeordnet ist.
        HausratGrunddeckungstyp hausratGrunddeckungstyp = hrKompakt.getHausratGrunddeckungstyp();
        // Grunddeckung erzeugen und zum Vertag hinzufügen
        HausratGrunddeckung hausratGrunddeckung = hausratVertrag.newHausratGrunddeckung(hausratGrunddeckungstyp);
        hausratGrunddeckung.berechneJahresbasisbeitrag();
        assertThat(hausratGrunddeckung.getJahresbasisbeitrag(), is(Money.euro(84)));
    }

    @Test
    void testBerechneJahresbasisbeitrag_KeinePLZ() {
        HausratVertrag hausratVertrag = hrKompakt.createHausratVertrag();
        // keine PLZ -> Tarifzone I
        hausratVertrag.setVersSumme(Money.euro(60_000));
        HausratGrunddeckung hausratGrunddeckung = hausratVertrag
                .newHausratGrunddeckung(hrKompakt.getHausratGrunddeckungstyp());
        hausratGrunddeckung.berechneJahresbasisbeitrag();
        assertThat(hausratGrunddeckung.getJahresbasisbeitrag(), is(Money.euro(36)));
    }

    @Test
    void testBerechneJahresbasisbeitrag_KeineVersSumme() {
        HausratVertrag hausratVertrag = hrKompakt.createHausratVertrag();
        hausratVertrag.setPlz("47110");
        HausratGrunddeckung hausratGrunddeckung = hausratVertrag
                .newHausratGrunddeckung(hrKompakt.getHausratGrunddeckungstyp());
        hausratGrunddeckung.berechneJahresbasisbeitrag();
        assertThat(hausratGrunddeckung.getJahresbasisbeitrag(), is(Money.NULL));
    }

    @Test
    void testBerechneBeitragGemaessZahlweise() {
        HausratVertrag hausratVertrag = hrKompakt.createHausratVertrag();
        hausratVertrag.setPlz("47110");
        hausratVertrag.setVersSumme(Money.euro(60_000));
        hausratVertrag.setZahlweise(Zahlweise.HALBJAEHRLICH);
        HausratGrunddeckung hausratGrunddeckung = hausratVertrag
                .newHausratGrunddeckung(hrKompakt.getHausratGrunddeckungstyp());
        hausratGrunddeckung.berechneJahresbasisbeitrag();
        assertThat(hausratGrunddeckung.getBeitragGemaessZahlweise(), is(Money.euro(42)));
    }

    @Test
    void testBerechneBeitragGemaessZahlweise_KeinJahresbasisbeitrag() {
        HausratVertrag hausratVertrag = hrKompakt.createHausratVertrag();
        hausratVertrag.setPlz("47110");
        hausratVertrag.setVersSumme(Money.euro(60_000));
        hausratVertrag.setZahlweise(Zahlweise.HALBJAEHRLICH);
        HausratGrunddeckung hausratGrunddeckung = hausratVertrag
                .newHausratGrunddeckung(hrKompakt.getHausratGrunddeckungstyp());
        // keine Berechnung
        // hausratGrunddeckung.berechneJahresbasisbeitrag();
        assertThat(hausratGrunddeckung.getBeitragGemaessZahlweise(), is(Money.NULL));
    }

    @Test
    void testBerechneBeitragGemaessZahlweise_KeineZahlweise() {
        HausratVertrag hausratVertrag = hrKompakt.createHausratVertrag();
        hausratVertrag.setPlz("47110");
        hausratVertrag.setVersSumme(Money.euro(60_000));
        hausratVertrag.setZahlweise(null);
        HausratGrunddeckung hausratGrunddeckung = hausratVertrag
                .newHausratGrunddeckung(hrKompakt.getHausratGrunddeckungstyp());
        hausratGrunddeckung.berechneJahresbasisbeitrag();
        assertThat(hausratGrunddeckung.getBeitragGemaessZahlweise(), is(Money.NULL));
    }

    @Test
    void testBerechneBeitragGemaessZahlweise_Einmalzahlung() {
        HausratVertrag hausratVertrag = hrKompakt.createHausratVertrag();
        hausratVertrag.setPlz("47110");
        hausratVertrag.setVersSumme(Money.euro(60_000));
        hausratVertrag.setZahlweise(Zahlweise.EINMALZAHLUNG);
        HausratGrunddeckung hausratGrunddeckung = hausratVertrag
                .newHausratGrunddeckung(hrKompakt.getHausratGrunddeckungstyp());
        hausratGrunddeckung.berechneJahresbasisbeitrag();
        assertThat(hausratGrunddeckung.getBeitragGemaessZahlweise(), is(Money.NULL));
    }

    @Test
    void testErweiterbareAufzählung() {
        repository.getEnumValues(Risikoklasse.class).forEach(System.out::println);
    }

    @Test
    void testGetVerSumme_Zusatzdeckung_Fahrraddiebstahl() {
        HausratVertrag hausratVertrag = hrKompakt.createHausratVertrag();
        hausratVertrag.setVersSumme(Money.euro(60_000));
        HausratZusatzdeckungstyp fahrraddiebstahlTyp = (HausratZusatzdeckungstyp) repository
                .getProductComponent("hausrat.Fahrraddiebstahl 2022-01");
        HausratZusatzdeckung fahrraddiebstahl = hausratVertrag.newHausratZusatzdeckung(fahrraddiebstahlTyp);
        assertThat(fahrraddiebstahl.getVersSumme(), is(Money.euro(600)));
    }

    @Test
    void testGetVerSumme_Zusatzdeckung_Fahrraddiebstahl_Maximiert() {
        HausratVertrag hausratVertrag = hrKompakt.createHausratVertrag();
        hausratVertrag.setVersSumme(Money.euro(600_000));
        HausratZusatzdeckungstyp fahrraddiebstahlTyp = (HausratZusatzdeckungstyp) repository
                .getProductComponent("hausrat.Fahrraddiebstahl 2022-01");
        HausratZusatzdeckung fahrraddiebstahl = hausratVertrag.newHausratZusatzdeckung(fahrraddiebstahlTyp);
        assertThat(fahrraddiebstahl.getVersSumme(), is(Money.euro(5_000)));
    }

    @Test
    void testGetVerSumme_Zusatzdeckung_Überspannung_NichtMaximiert() {
        HausratVertrag hausratVertrag = hrKompakt.createHausratVertrag();
        hausratVertrag.setVersSumme(Money.euro(600_000));
        HausratZusatzdeckungstyp überspannungTyp = (HausratZusatzdeckungstyp) repository
                .getProductComponent("hausrat.Überspannung 2022-01");
        HausratZusatzdeckung überspannung = hausratVertrag.newHausratZusatzdeckung(überspannungTyp);
        assertThat(überspannung.getVersSumme(), is(Money.euro(30_000)));
    }

    @Test
    void testBerechneJahresbasisbeitrag_Zusatzdeckung_Fahrraddiebstahl() {
        HausratVertrag hausratVertrag = hrKompakt.createHausratVertrag();
        hausratVertrag.setVersSumme(Money.euro(600_000));
        HausratZusatzdeckungstyp fahrraddiebstahlTyp = (HausratZusatzdeckungstyp) repository
                .getProductComponent("hausrat.Fahrraddiebstahl 2022-01");
        HausratZusatzdeckung fahrraddiebstahl = hausratVertrag.newHausratZusatzdeckung(fahrraddiebstahlTyp);
        assertThat(fahrraddiebstahl.getJahresbasisbeitrag(), is(Money.euro(500)));
    }

    @Test
    void testPruefeWohnflaeche_OK() {
        HausratVertrag hausratVertrag = hrKompakt.createHausratVertrag();
        hausratVertrag.setWohnflaeche(75);
        hausratVertrag.setVersSumme(Money.euro(100_000));
        MessageList validationMessages = hausratVertrag.validate(new ValidationContext());
        assertThat(validationMessages.isEmpty(), is(true));
    }

    @Test
    void testPruefeWohnflaeche_ZuHoch() {
        HausratVertrag hausratVertrag = hrKompakt.createHausratVertrag();
        hausratVertrag.setWohnflaeche(250);
        MessageList validationMessages = hausratVertrag.validate(new ValidationContext());
        assertThat(validationMessages.isEmpty(), is(false));
        assertThat(validationMessages.getSeverity(), is(Severity.ERROR));
        Message message = validationMessages.getMessageByCode(HausratVertrag.MSG_CODE_PRUEFE_WOHNFLAECHE);
        assertThat(message, is(notNullValue()));
        assertThat(message.getText(), containsString("0-100"));
        assertThat(message.getText(), containsString("250"));
        assertThat(message.getInvalidObjectProperties(),
                hasItems(new ObjectProperty(hausratVertrag, HausratVertrag.PROPERTY_WOHNFLAECHE)));
    }

    @Test
    void testPruefeWohnflaeche_NichtGesetzt() {
        HausratVertrag hausratVertrag = hrKompakt.createHausratVertrag();
        MessageList validationMessages = hausratVertrag.validate(new ValidationContext());
        assertThat(validationMessages.isEmpty(), is(false));
        assertThat(validationMessages.getSeverity(), is(Severity.ERROR));
        Message message = validationMessages.getMessageByCode(HausratVertrag.MSG_CODE_PRUEFE_WOHNFLAECHE);
        assertThat(message, is(notNullValue()));
        assertThat(message.getText(), containsString("0-100"));
        assertThat(message.getText(), containsString("null"));
        assertThat(message.getInvalidObjectProperties(),
                hasItems(new ObjectProperty(hausratVertrag, HausratVertrag.PROPERTY_WOHNFLAECHE)));
    }

    @Test
    void testPruefePLZ_OK() {
        HausratVertrag hausratVertrag = hrKompakt.createHausratVertrag();
        hausratVertrag.setWohnflaeche(75);
        hausratVertrag.setVersSumme(Money.euro(100_000));
        hausratVertrag.setPlz("50678");
        MessageList validationMessages = hausratVertrag.validate(new ValidationContext());
        assertThat(validationMessages.isEmpty(), is(true));
    }

    @Test
    void testPruefePLZ_ZuKurz() {
        HausratVertrag hausratVertrag = hrKompakt.createHausratVertrag();
        hausratVertrag.setWohnflaeche(75);
        hausratVertrag.setPlz("8000");
        MessageList validationMessages = hausratVertrag.validate(new ValidationContext());
        assertThat(validationMessages.isEmpty(), is(false));
        assertThat(validationMessages.getSeverity(), is(Severity.ERROR));
        Message message = validationMessages.getMessageByCode(HausratVertrag.MSG_CODE_PRUEFE_PLZ);
        assertThat(message, is(notNullValue()));
        assertThat(message.getText(), containsString("8000"));
        assertThat(message.getInvalidObjectProperties(),
                hasItems(new ObjectProperty(hausratVertrag, HausratVertrag.PROPERTY_PLZ)));
    }

    @Test
    void testPruefePLZ_ZuLang() {
        HausratVertrag hausratVertrag = hrKompakt.createHausratVertrag();
        hausratVertrag.setWohnflaeche(75);
        hausratVertrag.setPlz("12345678");
        MessageList validationMessages = hausratVertrag.validate(new ValidationContext());
        assertThat(validationMessages.isEmpty(), is(false));
        assertThat(validationMessages.getSeverity(), is(Severity.ERROR));
        Message message = validationMessages.getMessageByCode(HausratVertrag.MSG_CODE_PRUEFE_PLZ);
        assertThat(message, is(notNullValue()));
        assertThat(message.getText(), containsString("12345678"));
        assertThat(message.getInvalidObjectProperties(),
                hasItems(new ObjectProperty(hausratVertrag, HausratVertrag.PROPERTY_PLZ)));
    }

    @Test
    void testPruefePLZ_KeineZiffer() {
        HausratVertrag hausratVertrag = hrKompakt.createHausratVertrag();
        hausratVertrag.setWohnflaeche(75);
        hausratVertrag.setPlz("ABCDE");
        MessageList validationMessages = hausratVertrag.validate(new ValidationContext());
        assertThat(validationMessages.isEmpty(), is(false));
        assertThat(validationMessages.getSeverity(), is(Severity.ERROR));
        Message message = validationMessages.getMessageByCode(HausratVertrag.MSG_CODE_PRUEFE_PLZ);
        assertThat(message, is(notNullValue()));
        assertThat(message.getText(), containsString("ABCDE"));
        assertThat(message.getInvalidObjectProperties(),
                hasItems(new ObjectProperty(hausratVertrag, HausratVertrag.PROPERTY_PLZ)));
    }

}
