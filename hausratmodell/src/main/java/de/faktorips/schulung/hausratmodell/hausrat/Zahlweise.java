package de.faktorips.schulung.hausratmodell.hausrat;

import org.faktorips.runtime.model.annotation.IpsDocumented;
import org.faktorips.runtime.model.annotation.IpsEnumType;
import java.util.Map;
import java.util.HashMap;
import org.faktorips.runtime.model.annotation.IpsEnumAttribute;
import org.faktorips.runtime.annotation.IpsGenerated;

/**
 *
 * @since 1.0
 *
 * @generated
 */
@IpsDocumented(bundleName = "de.faktorips.schulung.hausratmodell.model-label-and-descriptions", defaultLocale = "de")
@IpsEnumType(name = "hausrat.Zahlweise", attributeNames = { "zahlungenProJahr", "bezeichnung" })
public enum Zahlweise {
    /**
     * @generated
     */
    MONATLICH(12, "Monatlich"),
    /**
     * @generated
     */
    QUARTALSWEISE(4, "Quartalsweise"),
    /**
     * @generated
     */
    HALBJAEHRLICH(2, "Halbj\u00E4hrlich"),
    /**
     * @generated
     */
    JAEHRLICH(1, "J\u00E4hrlich"),
    /**
     * @generated
     */
    EINMALZAHLUNG(0, "Einmalzahlung")

    ;

    /**
     * This map is used to have high performance access to the values by ID.
     *
     * @generated
     */
    private static final Map<Integer, Zahlweise> ID_MAP;
    /**
     * In this static block the id map is initialized with all the values in this
     * enum.
     *
     * @generated
     */
    static {
        ID_MAP = new HashMap<>();
        for (Zahlweise value : values()) {
            ID_MAP.put(value.zahlungenProJahr, value);
        }
    }

    /**
     * @since 1.0
     *
     * @generated
     */
    private final int zahlungenProJahr;
    /**
     * @since 1.0
     *
     * @generated
     */
    private final String bezeichnung;

    /**
     * Creates a new instance of Zahlweise.
     *
     * @generated
     */
    @IpsGenerated
    private Zahlweise(int zahlungenProJahr, String bezeichnung) {
        this.zahlungenProJahr = zahlungenProJahr;
        this.bezeichnung = bezeichnung;
    }

    /**
     * Returns the enumeration value for the specified parameter
     * <code>zahlungenProJahr</code>. Returns <code>null</code> if no corresponding
     * enumeration value is found, or if the parameter <code>zahlungenProJahr</code>
     * is <code>null</code>.
     *
     * @generated
     */
    @IpsGenerated
    public static final Zahlweise getValueByZahlungenProJahr(int zahlungenProJahr) {
        return ID_MAP.get(zahlungenProJahr);
    }

    /**
     * Returns the enumeration value for the specified parameter
     * <code>bezeichnung</code>. Returns <code>null</code> if no corresponding
     * enumeration value is found, or if the parameter <code>bezeichnung</code> is
     * <code>null</code>.
     *
     * @generated
     */
    @IpsGenerated
    public static final Zahlweise getValueByBezeichnung(String bezeichnung) {
        for (Zahlweise currentValue : values()) {
            if (currentValue.bezeichnung.equals(bezeichnung)) {
                return currentValue;
            }
        }
        return null;
    }

    /**
     * Returns the enumeration value for the specified parameter
     * <code>zahlungenProJahr</code>. If no corresponding enum value is found for
     * the given parameter, an {@link IllegalArgumentException} is thrown.
     *
     * @throws IllegalArgumentException if no corresponding enum value is found
     *
     * @generated
     */
    @IpsGenerated
    public static final Zahlweise getExistingValueByZahlungenProJahr(int zahlungenProJahr) {
        if (ID_MAP.containsKey(zahlungenProJahr)) {
            return ID_MAP.get(zahlungenProJahr);
        } else {
            throw new IllegalArgumentException("No enum value with zahlungenProJahr " + zahlungenProJahr);
        }
    }

    /**
     * Returns the enumeration value for the specified parameter
     * <code>bezeichnung</code>. If no corresponding enum value is found for the
     * given parameter, an {@link IllegalArgumentException} is thrown.
     *
     * @throws IllegalArgumentException if no corresponding enum value is found
     *
     * @generated
     */
    @IpsGenerated
    public static final Zahlweise getExistingValueByBezeichnung(String bezeichnung) {
        for (Zahlweise currentValue : values()) {
            if (currentValue.bezeichnung.equals(bezeichnung)) {
                return currentValue;
            }
        }
        throw new IllegalArgumentException("No enum value with bezeichnung " + bezeichnung);
    }

    /**
     * Returns <code>true</code> if the provided parameter value identifies a value
     * of this enumeration.
     *
     * @generated
     */
    @IpsGenerated
    public static final boolean isValueByZahlungenProJahr(int zahlungenProJahr) {
        return getValueByZahlungenProJahr(zahlungenProJahr) != null;
    }

    /**
     * Returns <code>true</code> if the provided parameter value identifies a value
     * of this enumeration.
     *
     * @generated
     */
    @IpsGenerated
    public static final boolean isValueByBezeichnung(String bezeichnung) {
        return getValueByBezeichnung(bezeichnung) != null;
    }

    /**
     * Returns the value of the attribute zahlungenProJahr.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsEnumAttribute(name = "zahlungenProJahr", identifier = true, unique = true)
    @IpsGenerated
    public int getZahlungenProJahr() {
        return zahlungenProJahr;
    }

    /**
     * Returns the value of the attribute bezeichnung.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsEnumAttribute(name = "bezeichnung", unique = true, displayName = true)
    @IpsGenerated
    public String getBezeichnung() {
        return bezeichnung;
    }

    /**
     * {@inheritDoc}
     *
     * @generated
     */
    @Override
    @IpsGenerated
    public String toString() {
        return "Zahlweise: " + zahlungenProJahr + '(' + bezeichnung + ')';
    }
}
