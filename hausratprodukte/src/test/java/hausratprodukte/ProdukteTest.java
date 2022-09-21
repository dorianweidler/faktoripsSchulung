package hausratprodukte;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.faktorips.runtime.ClassloaderRuntimeRepository;
import org.faktorips.runtime.IRuntimeRepository;
import org.faktorips.values.Money;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import de.faktorips.schulung.hausratmodell.hausrat.HausratProdukt;
import de.faktorips.schulung.hausratmodell.hausrat.HausratVertrag;

class ProdukteTest {
    
    static IRuntimeRepository runtimeRepository;
    static HausratProdukt hrKompakt;
    static HausratProdukt hrOptimal;
    
    @BeforeAll
    static void setup()  {
        runtimeRepository = ClassloaderRuntimeRepository.create("de/faktorips/schulung/hausratprodukte/internal/faktorips-repository-toc.xml");
        hrKompakt = (HausratProdukt) runtimeRepository.getProductComponent("hausrat.HR-Kompakt 2022-01");
        hrOptimal = (HausratProdukt) runtimeRepository.getProductComponent("hausrat.HR Optimal 2022-01");
    }

    @Test
    void test() {
        System.err.println("Produktname: " + hrKompakt.getProduktname());
        System.err.println("Zahlweise (default): " + hrKompakt.getDefaultValueZahlweise());
        System.err.println("Zahlweise (Wertebereich): " + hrKompakt.getAllowedValuesForZahlweise());
        System.err.println("Versicherungssumme (Wertebereich): " + hrKompakt.getAllowedValuesForVersSumme());
        System.err.println("Wohnfläche (Wertebereich): " + hrKompakt.getAllowedValuesForWohnflaeche());
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

}
