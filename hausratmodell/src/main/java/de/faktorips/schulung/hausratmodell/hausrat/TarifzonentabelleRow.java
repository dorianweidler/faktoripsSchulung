package de.faktorips.schulung.hausratmodell.hausrat;

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
public class TarifzonentabelleRow {
    /**
     * @generated
     */
    public static final TarifzonentabelleRow NULL_ROW = new TarifzonentabelleRow(null, null, null);

    /**
     *
     * @since 1.0
     *
     * @generated
     */
    private final String plzVon;
    /**
     *
     * @since 1.0
     *
     * @generated
     */
    private final String plzBis;
    /**
     *
     * @since 1.0
     *
     * @generated
     */
    private final String tarifzone;

    /**
     * Creates a new table row.
     *
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsGenerated
    public TarifzonentabelleRow(String plzVon, String plzBis, String tarifzone) {
        this.plzVon = plzVon;
        this.plzBis = plzBis;
        this.tarifzone = tarifzone;
    }

    /**
     * @since 1.0
     *
     * @generated
     */
    @IpsTableColumn(name = "plzVon")
    @IpsGenerated
    public String getPlzVon() {
        return plzVon;
    }

    /**
     * @since 1.0
     *
     * @generated
     */
    @IpsTableColumn(name = "plzBis")
    @IpsGenerated
    public String getPlzBis() {
        return plzBis;
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
     * @generated
     */
    @Override
    @IpsGenerated
    public String toString() {
        return "" + plzVon + "|" + plzBis + "|" + tarifzone;
    }
}
