package org.faktorips.schulung.hausratmodell.hausrat;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.faktorips.runtime.InMemoryRuntimeRepository;
import org.faktorips.values.Decimal;
import org.faktorips.values.Money;
import org.junit.jupiter.api.Test;

public class HausratTest {

    private InMemoryRuntimeRepository repository = new InMemoryRuntimeRepository();

    /**
     * Diese Methode testet die Beitragsberechnung der Grunddeckung isoliert, also
     * ohne auf produktive Produktdaten zuzugreifen
     */
    @Test
    void testBerechneJahresbasisbeitrag() {
        // TestConent erzeugen
        createTestContent();
        // Das TestProdukt aus dem Repository abfragen
        HausratProdukt testProdukt = (HausratProdukt) repository.getProductComponent("TestProdukt 2022-01");
        // Erzeugen eines hausratvertrags mit der Factorymethode des Produktes
        HausratVertrag vertrag = testProdukt.createHausratVertrag();
        // Vertragsattribute setzen
        vertrag.setVersSumme(Money.euro(100000));
        vertrag.setPlz("30000"); // Tarifzone III
        // Grunddeckungsbaustein holen, der dem Produkt in der Generation zugeordnet
        // ist.
        HausratGrunddeckungstyp grunddeckungsbaustein = vertrag.getHausratProdukt().getHausratGrunddeckungstyp();
        // Grunddeckung erzeugen und zum Vertag hinzufuegen
        HausratGrunddeckung deckung = vertrag.newHausratGrunddeckung(grunddeckungsbaustein);
        deckung.berechneJahresbasisbeitrag();
        assertThat(deckung.getJahresbasisbeitrag(), is(Money.euro(100)));
    }

    private void createTestContent() {
        // Erstellen eines Test-Produktbausteins
        HausratProdukt testProdukt = new HausratProdukt(repository, "TestProdukt 2022-01", "TestProdukt", "2022-01");
        testProdukt.setProduktname("TestProdukt");
        testProdukt.setVorschlagVersSummeProQm(Money.euro(500));
        // Hinzufügen des Produktbausteins zum Repository.
        repository.putProductComponent(testProdukt);
        // Erstellen eines Test-Grunddeckungsbausteins
        HausratGrunddeckungstyp testDeckungstyp = new HausratGrunddeckungstyp(repository, "TestDeckung 2022-01",
                "TestDeckung", "2022-01");
        // Der Tabellenname muss der gleiche sein unter dem man die
        // Testtariftabelle im Repository abspeichert. Siehe unten
        testDeckungstyp.setTariftabelleHausratName("Tariftabelle");
        testProdukt.setHausratGrunddeckungstyp(testDeckungstyp);
        // Hinzufügen des Produktbausteins zum Repository.
        repository.putProductComponent(testDeckungstyp);
        // Hinzufügen der Testtarifzonentabelle zum Repository
        repository.putTable(new Tarifzonentabelle(List.of(
                new TarifzonentabelleRow("10000", "10001", "I"),
                new TarifzonentabelleRow("20000", "20002", "II"),
                new TarifzonentabelleRow("30000", "30003", "III"))));
        // Hinzufügen der Testtariftabelle zum Repository. Wichtig ist, da es
        // eine Tabelle mit multiplen Inhalten ist, muss der Name der Tabelle
        // angegeben werden, unter dem die Tabelle im Repository gespeichert
        // wird.
        repository.putTable(new TariftabelleHausrat(List.of(
                new TariftabelleHausratRow("I", Decimal.valueOf("0.6")),
                new TariftabelleHausratRow("II", Decimal.valueOf("0.8")),
                new TariftabelleHausratRow("III", Decimal.valueOf("1.0"))
                )), "Tariftabelle");
    }
}
