package hausratprodukte;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.faktorips.runtime.ClassloaderRuntimeRepository;
import org.faktorips.runtime.IRuntimeRepository;
import org.faktorips.values.Money;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import de.faktorips.schulung.hausratmodell.hausrat.HausratGrunddeckung;
import de.faktorips.schulung.hausratmodell.hausrat.HausratGrunddeckungstyp;
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

}
