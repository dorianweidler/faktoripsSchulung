package org.faktorips.schulung.hausratprodukte.produkte_2022;

import org.faktorips.schulung.hausratmodell.hausrat.HausratZusatzdeckungstyp;
import org.faktorips.runtime.IRuntimeRepository;
import org.faktorips.values.Money;
import org.faktorips.schulung.hausratmodell.hausrat.HausratZusatzdeckung;
import org.faktorips.runtime.FormulaExecutionException;
import org.faktorips.values.Decimal;
import java.math.RoundingMode;

public class Fahrraddiebstahl___2022__01 extends HausratZusatzdeckungstyp {

    /**
     * Erzeugt eine neue Produkt Komponente.
     *
     */
    public Fahrraddiebstahl___2022__01(IRuntimeRepository repository, String id, String kindId, String versionId) {
        super(repository, id, kindId, versionId);
    }

    /**
     * {@inheritDoc}
     *
     * @generated
     */
    @Override
    public Money computeJahresbasisbeitrag(final HausratZusatzdeckung hausratZusatzdeckung)
            throws FormulaExecutionException {
        try {
            return hausratZusatzdeckung.getVersSumme().multiply(Decimal.valueOf("0.10"), RoundingMode.HALF_UP);
        } catch (Exception e) {
            StringBuilder parameterValues = new StringBuilder();
            parameterValues.append("hausratZusatzdeckung=");
            parameterValues.append(hausratZusatzdeckung == null ? "null" : hausratZusatzdeckung.toString());
            throw new FormulaExecutionException(toString(), "0.10 * hausratZusatzdeckung.versSumme",
                    parameterValues.toString(), e);
        }
    }

}
