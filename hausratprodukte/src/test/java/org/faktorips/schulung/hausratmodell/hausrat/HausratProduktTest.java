package org.faktorips.schulung.hausratmodell.hausrat;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.faktorips.runtime.ClassloaderRuntimeRepository;
import org.faktorips.runtime.IRuntimeRepository;
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
}
