package hausratprodukte;

import static org.faktorips.testsupport.IpsMatchers.containsErrorMessage;
import static org.faktorips.testsupport.IpsMatchers.containsNoErrorMessage;
import static org.faktorips.testsupport.IpsMatchers.containsText;
import static org.faktorips.testsupport.IpsMatchers.hasErrorMessage;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

import org.faktorips.runtime.ClassloaderRuntimeRepository;
import org.faktorips.runtime.MessageList;
import org.faktorips.runtime.ValidationContext;
import org.faktorips.runtime.formula.groovy.GroovyFormulaEvaluatorFactory;
import org.faktorips.values.Money;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import de.faktorips.schulung.hausratmodell.hausrat.HausratGrunddeckung;
import de.faktorips.schulung.hausratmodell.hausrat.HausratGrunddeckungstyp;
import de.faktorips.schulung.hausratmodell.hausrat.HausratProdukt;
import de.faktorips.schulung.hausratmodell.hausrat.HausratVertrag;
import de.faktorips.schulung.hausratmodell.hausrat.HausratZusatzdeckung;
import de.faktorips.schulung.hausratmodell.hausrat.HausratZusatzdeckungstyp;
import de.faktorips.schulung.hausratmodell.hausrat.Risikoklasse;

class ProdukteTest {
    
    static ClassloaderRuntimeRepository runtimeRepository;
    static HausratProdukt hrKompakt;
    static HausratProdukt hrOptimal;
    static HausratZusatzdeckungstyp fahrradDiebstahl;
    static HausratZusatzdeckungstyp ueberspannungsSchutz;
    
    @BeforeAll
    static void setup()  {
        runtimeRepository = ClassloaderRuntimeRepository.create("de/faktorips/schulung/hausratprodukte/internal/faktorips-repository-toc.xml");
        runtimeRepository.setFormulaEvaluatorFactory(new GroovyFormulaEvaluatorFactory());
        hrKompakt = (HausratProdukt) runtimeRepository.getProductComponent("hausrat.HR-Kompakt 2022-01");
        hrOptimal = (HausratProdukt) runtimeRepository.getProductComponent("hausrat.HR Optimal 2022-01");
        fahrradDiebstahl = (HausratZusatzdeckungstyp) runtimeRepository.getProductComponent("hausrat.Fahrraddiebstahl 2022-01");
        ueberspannungsSchutz = (HausratZusatzdeckungstyp) runtimeRepository.getProductComponent("hausrat.??berspannung 2022-01");
    }

    @Test
    void test() {
        System.err.println("Produktname: " + hrKompakt.getProduktname());
        System.err.println("Zahlweise (default): " + hrKompakt.getDefaultValueZahlweise());
        System.err.println("Zahlweise (Wertebereich): " + hrKompakt.getAllowedValuesForZahlweise());
        System.err.println("Versicherungssumme (Wertebereich): " + hrKompakt.getAllowedValuesForVersSumme());
        System.err.println("Wohnfl??che (Wertebereich): " + hrKompakt.getAllowedValuesForWohnflaeche());
    }
    
    @Test
    public void testVorschlagVersSummeKompakt() {
        final HausratVertrag hausratVertrag = hrKompakt.createHausratVertrag();
        hausratVertrag.setWohnflaeche(100);
        assertThat(hausratVertrag.getVorschlagVersSumme(), is(Money.euro(60_000L)));
    }
    
    @Test
    public void testVorschlagVersSummeKompakt_WohnflaecheNull() {
        final HausratVertrag hausratVertrag = hrKompakt.createHausratVertrag();
        assertThat(hausratVertrag.getVorschlagVersSumme(), is(Money.NULL));
    }
    
    @Test
    public void testGetTarifzone2() {
        HausratVertrag vertrag = hrKompakt.createHausratVertrag();
        vertrag.setPlz("17236");

        assertThat(vertrag.getTarifzone(), is("II"));
    }
    
    @Test
    public void testGetTarifzone3() {
        HausratVertrag vertrag = hrKompakt.createHausratVertrag();
        vertrag.setPlz("45530");

        assertThat(vertrag.getTarifzone(), is("III"));
    }
    

    @Test
    public void testGetTarifzone_Null() {
        HausratVertrag vertrag = hrKompakt.createHausratVertrag();

        assertThat(vertrag.getTarifzone(), is("I"));
    }
    
    @Test
    public void testGetTarifzone_AusserhalbBereich() {
        HausratVertrag vertrag = hrKompakt.createHausratVertrag();
        vertrag.setPlz("11111");

        assertThat(vertrag.getTarifzone(), is("I"));
    }

    @Test
    public void testGetJahresbasisbeitragKompakt() {
        HausratVertrag vertrag = hrKompakt.createHausratVertrag();
        vertrag.setWohnflaeche(100);
        vertrag.setPlz("45530");
        vertrag.setVersSumme(vertrag.getVorschlagVersSumme());
        HausratGrunddeckungstyp grunddeckungstyp = hrKompakt.getHausratGrunddeckungstyp();
        HausratGrunddeckung grunddeckung = vertrag.newHausratGrunddeckung(grunddeckungstyp);
        grunddeckung.berechneJahresbasisbeitrag();
        
        assertThat(grunddeckung.getJahresbasisbeitrag(), is(Money.euro(60)));
    }
    
    @Test
    public void testGetJahresbasisbeitragOptimal() {
        HausratVertrag vertrag = hrOptimal.createHausratVertrag();
        vertrag.setWohnflaeche(100);
        vertrag.setPlz("17236");
        vertrag.setVersSumme(vertrag.getVorschlagVersSumme());
        HausratGrunddeckungstyp grunddeckungstyp = hrOptimal.getHausratGrunddeckungstyp();
        HausratGrunddeckung grunddeckung = vertrag.newHausratGrunddeckung(grunddeckungstyp);
        grunddeckung.berechneJahresbasisbeitrag();
        
        assertThat(grunddeckung.getJahresbasisbeitrag(), is(Money.euro(90)));
    }
    
    @Test
    public void testRisikoklasse() {
        runtimeRepository.getEnumValues(Risikoklasse.class).stream().forEach(System.out::println);
    }
    
    @Test
    public void testZusatzdeckungFahrradVersSumme() {
        HausratVertrag vertrag = hrOptimal.createHausratVertrag();
        vertrag.setWohnflaeche(100);
        vertrag.setPlz("17236");
        vertrag.setVersSumme(Money.euro(1000));
        HausratZusatzdeckung fahrradDeckung = fahrradDiebstahl.createHausratZusatzdeckung();
        vertrag.addZusatzdeckung(fahrradDeckung);
        
        assertThat(fahrradDeckung.getVersSumme(), is(Money.euro(10)));
    }
    
    @Test
    public void testZusatzdeckungFahrradVersSummeMaxVersSumme() {
        HausratVertrag vertrag = hrOptimal.createHausratVertrag();
        vertrag.setVersSumme(Money.euro(1000000));
        HausratZusatzdeckung fahrradDeckung = fahrradDiebstahl.createHausratZusatzdeckung();
        vertrag.addZusatzdeckung(fahrradDeckung);
        
        assertThat(fahrradDeckung.getVersSumme(), is(fahrradDiebstahl.getMaximaleVersSumme()));
    }
    
    @Test
    public void testJahresbeitragZusatzdeckungFahrrad() {
        HausratVertrag vertrag = hrOptimal.createHausratVertrag();
        vertrag.setVersSumme(Money.euro(1000));
        HausratZusatzdeckung fahrradDeckung = fahrradDiebstahl.createHausratZusatzdeckung();
        vertrag.addZusatzdeckung(fahrradDeckung);
        
        assertThat(fahrradDeckung.getJahresbasisbeitrag(), is(Money.euro(1)));
    }
    
    @Test
    public void testJahresbeitragZusatzdeckungUeberspannung() {
        HausratVertrag vertrag = hrOptimal.createHausratVertrag();
        vertrag.setVersSumme(Money.euro(1000));
        HausratZusatzdeckung ueberspannungsSchutzDeckung = ueberspannungsSchutz.createHausratZusatzdeckung();
        vertrag.addZusatzdeckung(ueberspannungsSchutzDeckung);
        
        assertThat(ueberspannungsSchutzDeckung.getJahresbasisbeitrag(), is(Money.euro(31, 50)));
    }
    
    @Test
    public void testPruefeWohnflaeche() {
        HausratVertrag vertrag = hrOptimal.createHausratVertrag();
        MessageList ml = vertrag.validate(new ValidationContext());
        
        assertThat(ml, containsErrorMessage());
        assertThat(ml,  hasErrorMessage(HausratVertrag.MSG_CODE_PRUEFE_WOHNFLAECHE));
        assertThat(ml.getMessageByCode(HausratVertrag.MSG_CODE_PRUEFE_WOHNFLAECHE), containsText("Wohnfl??che"));
    }
    
    @Test
    public void testPruefeWohnflaecheWohnflaecheZuGro??() {
        HausratVertrag vertrag = hrOptimal.createHausratVertrag();
        vertrag.setWohnflaeche(1000000);
        MessageList ml = vertrag.validate(new ValidationContext());
        
        assertThat(ml, containsErrorMessage());
        assertThat(ml,  hasErrorMessage(HausratVertrag.MSG_CODE_PRUEFE_WOHNFLAECHE));
        assertThat(ml.getMessageByCode(HausratVertrag.MSG_CODE_PRUEFE_WOHNFLAECHE), containsText("Wohnfl??che"));
    }
    
    @Test
    public void testPruefePlz() {
        HausratVertrag vertrag = hrOptimal.createHausratVertrag();
        MessageList ml = vertrag.validate(new ValidationContext());
        
        assertThat(ml, containsErrorMessage());
        assertThat(ml,  hasErrorMessage(HausratVertrag.MSG_CODE_PRUEFE_PLZ));
        assertThat(ml.getMessageByCode(HausratVertrag.MSG_CODE_PRUEFE_PLZ), containsText("PLZ"));
    }
    
    @Test
    public void testPruefePlzFehlerhaftePlz() {
        HausratVertrag vertrag = hrOptimal.createHausratVertrag();
        vertrag.setPlz("123");
        MessageList ml = vertrag.validate(new ValidationContext());
        
        assertThat(ml, containsErrorMessage());
        assertThat(ml,  hasErrorMessage(HausratVertrag.MSG_CODE_PRUEFE_PLZ));
        assertThat(ml.getMessageByCode(HausratVertrag.MSG_CODE_PRUEFE_PLZ), containsText("123"));
    }
    
    @Test
    public void testPruefePlzFehlerhaftePlzZuLang() {
        HausratVertrag vertrag = hrOptimal.createHausratVertrag();
        vertrag.setPlz("123456");
        MessageList ml = vertrag.validate(new ValidationContext());
        
        assertThat(ml, containsErrorMessage());
        assertThat(ml,  hasErrorMessage(HausratVertrag.MSG_CODE_PRUEFE_PLZ));
        assertThat(ml.getMessageByCode(HausratVertrag.MSG_CODE_PRUEFE_PLZ), containsText("123"));
    }
    
    @Test
    public void testPruefePlzKorrektePlz() {
        HausratVertrag vertrag = hrOptimal.createHausratVertrag();
        vertrag.setPlz("12345");
        MessageList ml = vertrag.validate(new ValidationContext());
        
        assertThat(ml, not(hasErrorMessage(HausratVertrag.MSG_CODE_PRUEFE_PLZ)));
    }
    
    @Test
    public void testPruefeVersSummeZuKlein() {
        HausratVertrag vertrag = hrOptimal.createHausratVertrag();
        vertrag.setVersSumme(Money.euro(1));
        MessageList ml = vertrag.validate(new ValidationContext());
        final String errorCode = "INVALID.HausratVertrag.versSumme";
        
        assertThat(ml, containsErrorMessage());
        assertThat(ml, hasErrorMessage(errorCode));
        assertThat(ml.getMessageByCode(errorCode), containsText("Der Wert muss zwischen 10000.00 EUR und 5000000.00 EUR liegen."));
    }
    
    @Test
    public void testValidationCorrect() {
        HausratVertrag vertrag = hrOptimal.createHausratVertrag();
        vertrag.setPlz("12345");
        vertrag.setWohnflaeche(100);
        vertrag.setVersSumme(Money.euro(50_000));
        MessageList ml = vertrag.validate(new ValidationContext());
        
        assertThat(ml, containsNoErrorMessage());
        assertThat(ml, not(hasErrorMessage(HausratVertrag.MSG_CODE_PRUEFE_PLZ)));
    }
}
