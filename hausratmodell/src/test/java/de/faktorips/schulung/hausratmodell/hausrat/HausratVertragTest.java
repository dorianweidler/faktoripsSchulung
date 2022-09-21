package de.faktorips.schulung.hausratmodell.hausrat;

import static org.hamcrest.MatcherAssert.assertThat;

import org.faktorips.values.Money;

import static org.hamcrest.CoreMatchers.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class HausratVertragTest {

    @Test
    public void testGetTarifzone2() {
        HausratVertrag vertrag = new HausratVertrag();
        vertrag.setPlz("17236");

        assertThat(vertrag.getTarifzone(), is("II"));
    }
    
    @Test
    public void testGetTarifzone3() {
        HausratVertrag vertrag = new HausratVertrag();
        vertrag.setPlz("45530");

        assertThat(vertrag.getTarifzone(), is("III"));
    }
    

    @Test
    public void testGetTarifzone_Null() {
        HausratVertrag vertrag = new HausratVertrag();

        assertThat(vertrag.getTarifzone(), is("I"));
    }
    
    @Test
    public void testGetTarifzone_AusserhalbBereich() {
        HausratVertrag vertrag = new HausratVertrag();
        vertrag.setPlz("11111");

        assertThat(vertrag.getTarifzone(), is("I"));
    }

    @Test
    @Disabled
    public void testGetVorschlagVersSummeKompakt() {
        HausratVertrag vertrag = new HausratVertrag();
        vertrag.setWohnflaeche(100);

        assertThat(vertrag.getVorschlagVersSumme(), is(Money.euro(65000L)));
    }
    
    @Test
    public void testGetVorschlagVersSumme_Wohnflaeche_Null() {
        HausratVertrag vertrag = new HausratVertrag();
        vertrag.setWohnflaeche(null);

        assertThat(vertrag.getVorschlagVersSumme(), is(Money.NULL));
    }

}
