package de.faktorips.schulung.hausratmodell.hausrat;

import org.faktorips.runtime.model.table.TableStructureKind;
import org.faktorips.runtime.model.annotation.IpsTableStructure;
import org.faktorips.runtime.model.annotation.IpsDocumented;
import org.faktorips.runtime.internal.Table;
import org.faktorips.runtime.internal.tableindex.UniqueResultStructure;
import org.faktorips.runtime.internal.tableindex.TwoColumnRangeStructure;
import java.util.ArrayList;
import java.util.List;
import org.faktorips.runtime.IRuntimeRepository;
import java.util.NoSuchElementException;
import org.faktorips.runtime.annotation.IpsGenerated;

/**
 * This class represents a read-only in memory table. Data can be accessed by
 * the find-methods of this table.
 *
 * @since 1.0
 *
 * @generated
 */
@IpsTableStructure(name = "hausrat.Tarifzonentabelle", type = TableStructureKind.SINGLE_CONTENT, columns = { "plzVon",
        "plzBis", "Tarifzone" })
@IpsDocumented(bundleName = "de.faktorips.schulung.hausratmodell.model-label-and-descriptions", defaultLocale = "de")
public class Tarifzonentabelle extends Table<TarifzonentabelleRow> {

    /**
     * Member variable for key to table row mapping.
     *
     * @since 1.0
     *
     * @generated
     */
    private TwoColumnRangeStructure<String, UniqueResultStructure<TarifzonentabelleRow>, TarifzonentabelleRow> key0SearchStructure;

    /**
     * Creates an empty table.
     *
     * @generated
     */
    @IpsGenerated
    public Tarifzonentabelle() {
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
    public Tarifzonentabelle(List<TarifzonentabelleRow> content) {
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
        String plzVon = columnValue;
        columnValue = values.get(1);
        String plzBis = columnValue;
        columnValue = values.get(2);
        String tarifzone = columnValue;
        rows.add(new TarifzonentabelleRow(plzVon, plzBis, tarifzone));
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
        key0SearchStructure = TwoColumnRangeStructure
                .<String, UniqueResultStructure<TarifzonentabelleRow>, TarifzonentabelleRow>create();
        for (TarifzonentabelleRow row : rows) {
            key0SearchStructure.put(row.getPlzVon(), row.getPlzBis(), UniqueResultStructure.createWith(row));
        }
    }

    /**
     * Returns an instance of this table class.
     *
     * @generated
     */
    @IpsGenerated
    public static final Tarifzonentabelle getInstance(IRuntimeRepository repository) {
        return repository.getTable(Tarifzonentabelle.class);
    }

    /**
     * Returns an instance of this table class.
     *
     * @generated
     */
    @IpsGenerated
    public static final Tarifzonentabelle getInstance(IRuntimeRepository repository, String qualifiedTableName) {
        return (Tarifzonentabelle) repository.getTable(qualifiedTableName);
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
    public TarifzonentabelleRow findRow(String plzBereich) {
        return key0SearchStructure.get(plzBereich).getUnique(null);
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
    public TarifzonentabelleRow findRowNullRowReturnedForEmptyResult(String plzBereich) {
        return key0SearchStructure.get(plzBereich).getUnique(TarifzonentabelleRow.NULL_ROW);
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
    public TarifzonentabelleRow findExistingRow(String plzBereich) {
        try {
            return key0SearchStructure.get(plzBereich).getUnique();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("No row could be found in table " + getName()
                    + " for the following search parameters: plzBereich = " + plzBereich);
        }
    }

}
