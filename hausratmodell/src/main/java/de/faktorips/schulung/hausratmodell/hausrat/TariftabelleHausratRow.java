package de.faktorips.schulung.hausratmodell.hausrat;

import org.faktorips.values.Decimal;
import org.faktorips.runtime.model.annotation.IpsTableColumn;
import org.faktorips.runtime.annotation.IpsGenerated;

/**
 * This class represents a read-only table row. The values of this row can be
 * retrieved by the according getter methods.
 *
 *
 * @since 1.0
 *
 * @generated
 */
public class TariftabelleHausratRow {
    /**
     * @generated
     */
    public static final TariftabelleHausratRow NULL_ROW = new TariftabelleHausratRow(null, Decimal.NULL);

    /**
     *
     * @since 1.0
     *
     * @generated
     */
    private final String tarifzone;
    /**
     *
     * @since 1.0
     *
     * @generated
     */
    private final Decimal beitragssatz;

    /**
     * Creates a new table row.
     *
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsGenerated
    public TariftabelleHausratRow(String tarifzone, Decimal beitragssatz) {
        this.tarifzone = tarifzone;
        this.beitragssatz = beitragssatz;
    }

    /**
     * @since 1.0
     *
     * @generated
     */
    @IpsTableColumn(name = "Tarifzone")
    @IpsGenerated
    public String getTarifzone() {
        return tarifzone;
    }

    /**
     * @since 1.0
     *
     * @generated
     */
    @IpsTableColumn(name = "Beitragssatz")
    @IpsGenerated
    public Decimal getBeitragssatz() {
        return beitragssatz;
    }

    /**
     * @generated
     */
    @Override
    @IpsGenerated
    public String toString() {
        return "" + tarifzone + "|" + beitragssatz;
    }
}
