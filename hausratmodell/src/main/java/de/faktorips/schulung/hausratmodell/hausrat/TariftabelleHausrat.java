package de.faktorips.schulung.hausratmodell.hausrat;

import org.faktorips.runtime.model.table.TableStructureKind;
import org.faktorips.runtime.model.annotation.IpsTableStructure;
import org.faktorips.runtime.model.annotation.IpsDocumented;
import org.faktorips.runtime.internal.Table;
import org.faktorips.runtime.internal.tableindex.UniqueResultStructure;
import org.faktorips.runtime.internal.tableindex.KeyStructure;
import java.util.ArrayList;
import java.util.List;
import org.faktorips.runtime.IRuntimeRepository;
import org.faktorips.values.Decimal;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.faktorips.runtime.annotation.IpsGenerated;

/**
 * This class represents a read-only in memory table. Data can be accessed by
 * the find-methods of this table.
 *
 * @since 1.0
 *
 * @generated
 */
@IpsTableStructure(name = "hausrat.TariftabelleHausrat", type = TableStructureKind.MULTIPLE_CONTENTS, columns = {
        "Tarifzone", "Beitragssatz" })
@IpsDocumented(bundleName = "de.faktorips.schulung.hausratmodell.model-label-and-descriptions", defaultLocale = "de")
public class TariftabelleHausrat extends Table<TariftabelleHausratRow> {

    /**
     * Member variable for key to table row mapping.
     *
     * @since 1.0
     *
     * @generated
     */
    private KeyStructure<Index0, UniqueResultStructure<TariftabelleHausratRow>, TariftabelleHausratRow> key0SearchStructure;

    /**
     * Creates an empty table.
     *
     * @generated
     */
    @IpsGenerated
    public TariftabelleHausrat() {
        super();
        rows = new ArrayList<>();
        init();
    }

    /**
     * Creates a new table based on the indicated rows. The given row list is
     * copied, so modifying it afterwards does not change the created table. This
     * constructor can be used in unit tests to define arbitrary table contents.
     *
     * @generated
     */
    @IpsGenerated
    public TariftabelleHausrat(List<TariftabelleHausratRow> content) {
        super();
        rows = new ArrayList<>(content);
        init();
    }

    /**
     * Adds a new table row during the initialization phase.
     *
     * @generated
     */
    @Override
    @IpsGenerated
    protected void addRow(List<String> values, IRuntimeRepository productRepository) {
        String columnValue = values.get(0);
        String tarifzone = columnValue;
        columnValue = values.get(1);
        Decimal beitragssatz = Decimal.valueOf(columnValue);
        rows.add(new TariftabelleHausratRow(tarifzone, beitragssatz));
    }

    /**
     * Initializes the maps that are used by the finder methods of this table. This
     * method is called during the initialization phase.
     *
     * @generated
     */
    @Override
    @IpsGenerated
    protected final void initKeyMaps() {
        key0SearchStructure = KeyStructure
                .<Index0, UniqueResultStructure<TariftabelleHausratRow>, TariftabelleHausratRow>create();
        for (TariftabelleHausratRow row : rows) {
            key0SearchStructure.put(new Index0(row.getTarifzone()), UniqueResultStructure.createWith(row));
        }
    }

    /**
     * Returns an instance of this table class.
     *
     * @generated
     */
    @IpsGenerated
    public static final TariftabelleHausrat getInstance(IRuntimeRepository repository, String qualifiedTableName) {
        return (TariftabelleHausrat) repository.getTable(qualifiedTableName);
    }

    /**
     * Searches the content of this table for an entry that fits the specified
     * parameters and returns the according row object. If no entry could be found,
     * null is returned.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsGenerated
    public TariftabelleHausratRow findRow(String tarifzone) {
        return key0SearchStructure.get(new Index0(tarifzone)).getUnique(null);
    }

    /**
     * Searches the content of this table for an entry that fits the specified
     * parameters and returns the according row object. If no entry could be found,
     * a 'null' row is returned.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsGenerated
    public TariftabelleHausratRow findRowNullRowReturnedForEmptyResult(String tarifzone) {
        return key0SearchStructure.get(new Index0(tarifzone)).getUnique(TariftabelleHausratRow.NULL_ROW);
    }

    /**
     * Searches the content of this table for an entry that fits the specified
     * parameters and returns the according row object. If no entry could be found,
     * an exception will be thrown.
     *
     * @return The row that fits the specified parameters.
     * @throws IllegalArgumentException If no row could be found.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsGenerated
    public TariftabelleHausratRow findExistingRow(String tarifzone) {
        try {
            return key0SearchStructure.get(new Index0(tarifzone)).getUnique();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("No row could be found in table " + getName()
                    + " for the following search parameters: tarifzone = " + tarifzone);
        }
    }

    /**
     * Instances of this class are used as a hash key. The key specific map of this
     * table representation is set up with instances of this class.
     *
     * @generated
     */
    private static final class Index0 {

        /**
         * @generated
         */
        private final String tarifzone;

        /**
         * Cached hashcode.
         *
         * @generated
         */
        private final int hashCode;

        /**
         * Creates a new key instance with the specified parameters.
         *
         * @generated
         */
        @IpsGenerated
        private Index0(String tarifzone) {
            this.tarifzone = tarifzone;
            hashCode = calculateHashCode();
        }

        /**
         * @generated
         */
        @IpsGenerated
        private int calculateHashCode() {
            int result = 17;
            result = 37 * result + ((tarifzone == null) ? 0 : tarifzone.hashCode());
            return result;
        }

        /**
         * Overrides the super class method and compares each instance variable for
         * equality.
         *
         * @generated
         */
        @Override
        @IpsGenerated
        public boolean equals(Object o) {
            if (o instanceof Index0) {
                Index0 other = (Index0) o;
                return Objects.equals(tarifzone, other.tarifzone);
            }
            return false;
        }

        /**
         * Overrides the super class method and creates a hash code based on the values
         * of the instance variables.
         *
         * @generated
         */
        @Override
        @IpsGenerated
        public int hashCode() {
            return hashCode;
        }
    }

}
