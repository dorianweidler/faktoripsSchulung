package org.faktorips.schulung.hausratmodell.hausrat;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.faktorips.values.Money;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class HausratVertragTest {

    @Test
    public void testGetTarifzone() {
        HausratVertrag hausratVertrag = new HausratVertrag();
        assertThat(hausratVertrag.getTarifzone(), is("I"));
    }

    @Test
    @Disabled
    public void testGetVorschlagVersSumme() {
        HausratVertrag hausratVertrag = new HausratVertrag();
        hausratVertrag.setWohnflaeche(100);
        assertThat(hausratVertrag.getVorschlagVersSumme(), is(Money.euro(65_000)));
    }

    @Test
    public void testGetVorschlagVersSumme_WohnflaecheNichtGesetzt() {
        HausratVertrag hausratVertrag = new HausratVertrag();
        assertThat(hausratVertrag.getVorschlagVersSumme(), is(Money.NULL));
    }

}
