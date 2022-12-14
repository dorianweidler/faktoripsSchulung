package de.faktorips.schulung.hausratmodell.hausrat;

import org.faktorips.runtime.model.annotation.IpsPolicyCmptType;
import org.faktorips.runtime.model.annotation.IpsAttributes;
import org.faktorips.runtime.model.annotation.IpsAssociations;
import org.faktorips.runtime.model.annotation.IpsConfiguredBy;
import org.faktorips.runtime.model.annotation.IpsValidationRules;
import org.faktorips.runtime.model.annotation.IpsDocumented;
import org.faktorips.runtime.internal.AbstractModelObject;
import org.faktorips.runtime.IDeltaSupport;
import org.faktorips.runtime.ICopySupport;
import org.faktorips.runtime.IVisitorSupport;
import org.faktorips.runtime.IConfigurableModelObject;
import org.faktorips.valueset.OrderedValueSet;
import org.faktorips.runtime.model.annotation.IpsDefaultValue;
import org.faktorips.valueset.ValueSet;
import org.faktorips.valueset.StringLengthValueSet;
import org.faktorips.valueset.UnrestrictedValueSet;
import org.faktorips.valueset.IntegerRange;
import org.faktorips.values.Money;
import org.faktorips.valueset.MoneyRange;
import org.faktorips.runtime.internal.ProductConfiguration;
import java.util.List;
import java.util.ArrayList;
import org.faktorips.runtime.model.annotation.IpsAllowedValues;
import org.faktorips.runtime.model.annotation.IpsAttribute;
import org.faktorips.runtime.model.type.AttributeKind;
import org.faktorips.runtime.model.type.ValueSetKind;
import org.faktorips.runtime.model.annotation.IpsConfiguredAttribute;
import org.faktorips.runtime.model.annotation.IpsAttributeSetter;
import org.faktorips.runtime.model.annotation.IpsAssociation;
import org.faktorips.runtime.model.type.AssociationKind;
import org.faktorips.runtime.model.annotation.IpsMatchingAssociation;
import org.faktorips.runtime.model.annotation.IpsInverseAssociation;
import org.faktorips.runtime.model.annotation.IpsAssociationAdder;
import java.util.Collections;
import org.faktorips.runtime.model.annotation.IpsAssociationRemover;
import org.faktorips.runtime.IProductComponent;
import java.util.Calendar;
import org.w3c.dom.Element;
import org.faktorips.runtime.IModelObjectDelta;
import org.faktorips.runtime.IModelObject;
import org.faktorips.runtime.IDeltaComputationOptions;
import org.faktorips.runtime.internal.ModelObjectDelta;
import java.util.Map;
import java.util.regex.Pattern;

import org.faktorips.runtime.IRuntimeRepository;
import org.faktorips.runtime.IObjectReferenceStore;
import org.faktorips.runtime.internal.XmlCallback;
import org.faktorips.runtime.internal.IpsStringUtils;
import java.util.HashMap;
import java.util.Iterator;
import org.faktorips.runtime.IModelObjectVisitor;
import org.faktorips.runtime.MessageList;
import org.faktorips.runtime.IValidationContext;
import org.faktorips.runtime.validation.GenericRelevanceValidation;
import org.faktorips.runtime.Severity;
import org.faktorips.runtime.model.annotation.IpsValidationRule;
import org.faktorips.runtime.model.annotation.IpsConfiguredValidationRule;
import org.faktorips.runtime.Message;
import org.faktorips.runtime.ObjectProperty;
import java.util.Arrays;
import org.faktorips.runtime.util.MessagesHelper;
import java.util.Locale;
import org.faktorips.runtime.MsgReplacementParameter;
import org.faktorips.runtime.annotation.IpsGenerated;

/**
 * Implementation for HausratVertrag.
 *
 * @since 1.0
 *
 * @generated
 */
@IpsPolicyCmptType(name = "hausrat.HausratVertrag")
@IpsAttributes({ "zahlweise", "plz", "tarifzone", "wohnflaeche", "vorschlagVersSumme", "versSumme" })
@IpsAssociations({ "HausratGrunddeckung", "zusatzdeckung" })
@IpsConfiguredBy(HausratProdukt.class)
@IpsValidationRules({ "pruefeWohnflaeche", "pruefePlz" })
@IpsDocumented(bundleName = "de.faktorips.schulung.hausratmodell.model-label-and-descriptions", defaultLocale = "de")
public class HausratVertrag extends AbstractModelObject
        implements IDeltaSupport, ICopySupport, IVisitorSupport, IConfigurableModelObject {

    /**
     * The maximal multiplicity of the association with the role name
     * HausratGrunddeckung.
     *
     * @since 1.0
     *
     * @generated
     */
    public static final IntegerRange MAX_MULTIPLICITY_OF_HAUSRAT_GRUNDDECKUNG = IntegerRange.valueOf(1, 1);
    /**
     * The name of the association hausratGrunddeckung.
     *
     * @since 1.0
     *
     * @generated
     */
    public static final String ASSOCIATION_HAUSRAT_GRUNDDECKUNG = "hausratGrunddeckung";
    /**
     * The maximal multiplicity of the association with the role name zusatzdeckung.
     *
     * @since 1.0
     *
     * @generated
     */
    public static final IntegerRange MAX_MULTIPLICITY_OF_ZUSATZDECKUNG = IntegerRange.valueOf(0, 2147483647);
    /**
     * The name of the association zusatzdeckungen.
     *
     * @since 1.0
     *
     * @generated
     */
    public static final String ASSOCIATION_ZUSATZDECKUNGEN = "zusatzdeckungen";
    /**
     * Error code for rule pruefeWohnflaeche.
     *
     * @since 1.0
     *
     * @generated
     */
    public static final String MSG_CODE_PRUEFE_WOHNFLAECHE = "WOHNFLAECHE_UNGUELTIG";
    /**
     * The name of the rule pruefeWohnflaeche.
     *
     * @since 1.0
     *
     * @generated
     */
    public static final String RULE_PRUEFE_WOHNFLAECHE = "pruefeWohnflaeche";
    /**
     * Error code for rule pruefePlz.
     *
     * @since 1.0
     *
     * @generated
     */
    public static final String MSG_CODE_PRUEFE_PLZ = "error.HausratVertrag.pruefePlz";
    /**
     * The name of the rule pruefePlz.
     *
     * @since 1.0
     *
     * @generated
     */
    public static final String RULE_PRUEFE_PLZ = "pruefePlz";
    /**
     * The name of the property zahlweise.
     *
     * @since 1.0
     *
     * @generated
     */
    public static final String PROPERTY_ZAHLWEISE = "zahlweise";
    /**
     * Max allowed values for property zahlweise.
     *
     * @since 1.0
     *
     * @generated
     */
    public static final OrderedValueSet<Zahlweise> MAX_ALLOWED_VALUES_FOR_ZAHLWEISE = new OrderedValueSet<>(false, null,
            Zahlweise.MONATLICH, Zahlweise.QUARTALSWEISE, Zahlweise.HALBJAEHRLICH, Zahlweise.JAEHRLICH,
            Zahlweise.EINMALZAHLUNG);
    /**
     * The default value for zahlweise.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsDefaultValue("zahlweise")
    public static final Zahlweise DEFAULT_VALUE_FOR_ZAHLWEISE = null;
    /**
     * The name of the property plz.
     *
     * @since 1.0
     *
     * @generated
     */
    public static final String PROPERTY_PLZ = "plz";
    /**
     * Max allowed values for property plz.
     *
     * @since 1.0
     *
     * @generated
     */
    public static final ValueSet<String> MAX_ALLOWED_STRING_LENGTH_FOR_PLZ = new StringLengthValueSet(5, false);
    /**
     * The default value for plz.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsDefaultValue("plz")
    public static final String DEFAULT_VALUE_FOR_PLZ = null;
    /**
     * The name of the property tarifzone.
     *
     * @since 1.0
     *
     * @generated
     */
    public static final String PROPERTY_TARIFZONE = "tarifzone";
    /**
     * Max allowed values for property tarifzone.
     *
     * @since 1.0
     *
     * @generated
     */
    public static final ValueSet<String> MAX_ALLOWED_VALUES_FOR_TARIFZONE = new UnrestrictedValueSet<>(true);
    /**
     * The name of the property wohnflaeche.
     *
     * @since 1.0
     *
     * @generated
     */
    public static final String PROPERTY_WOHNFLAECHE = "wohnflaeche";
    /**
     * Max allowed range for the property wohnflaeche.
     *
     * @since 1.0
     *
     * @generated
     */
    public static final IntegerRange MAX_ALLOWED_RANGE_FOR_WOHNFLAECHE = IntegerRange.valueOf(Integer.valueOf("0"),
            (Integer) null, (Integer) null, false);
    /**
     * The default value for wohnflaeche.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsDefaultValue("wohnflaeche")
    public static final Integer DEFAULT_VALUE_FOR_WOHNFLAECHE = null;
    /**
     * The name of the property vorschlagVersSumme.
     *
     * @since 1.0
     *
     * @generated
     */
    public static final String PROPERTY_VORSCHLAGVERSSUMME = "vorschlagVersSumme";
    /**
     * Max allowed values for property vorschlagVersSumme.
     *
     * @since 1.0
     *
     * @generated
     */
    public static final ValueSet<Money> MAX_ALLOWED_VALUES_FOR_VORSCHLAG_VERS_SUMME = new UnrestrictedValueSet<>(true);
    /**
     * The name of the property versSumme.
     *
     * @since 1.0
     *
     * @generated
     */
    public static final String PROPERTY_VERSSUMME = "versSumme";
    /**
     * Max allowed range for the property versSumme.
     *
     * @since 1.0
     *
     * @generated
     */
    public static final MoneyRange MAX_ALLOWED_RANGE_FOR_VERS_SUMME = MoneyRange.valueOf(Money.valueOf("0.00 EUR"),
            Money.NULL, Money.NULL, false);
    /**
     * The default value for versSumme.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsDefaultValue("versSumme")
    public static final Money DEFAULT_VALUE_FOR_VERS_SUMME = Money.NULL;
    /**
     * Member variable for zahlweise.
     *
     * @since 1.0
     *
     * @generated
     */
    private Zahlweise zahlweise = DEFAULT_VALUE_FOR_ZAHLWEISE;
    /**
     * Member variable for plz.
     *
     * @since 1.0
     *
     * @generated
     */
    private String plz = DEFAULT_VALUE_FOR_PLZ;
    /**
     * Member variable for wohnflaeche.
     *
     * @since 1.0
     *
     * @generated
     */
    private Integer wohnflaeche = DEFAULT_VALUE_FOR_WOHNFLAECHE;
    /**
     * Member variable for versSumme.
     *
     * @since 1.0
     *
     * @generated
     */
    private Money versSumme = DEFAULT_VALUE_FOR_VERS_SUMME;

    /**
     * References the current product configuration.
     *
     * @generated
     */
    private ProductConfiguration productConfiguration;
    /**
     * Member variable for the association with the role name HausratGrunddeckung.
     *
     * @since 1.0
     *
     * @generated
     */
    private HausratGrunddeckung hausratGrunddeckung = null;

    /**
     * Member variable for the association with the role name zusatzdeckung.
     *
     * @since 1.0
     *
     * @generated
     */
    private List<HausratZusatzdeckung> zusatzdeckungen = new ArrayList<>();

    /**
     * Creates a new HausratVertrag.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsGenerated
    public HausratVertrag() {
        super();
        productConfiguration = new ProductConfiguration();
    }

    /**
     * Creates a new HausratVertrag.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsGenerated
    public HausratVertrag(HausratProdukt productCmpt) {
        super();
        productConfiguration = new ProductConfiguration(productCmpt);
    }

    /**
     * Returns the set of allowed values for the property zahlweise.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsAllowedValues("zahlweise")
    @IpsGenerated
    public ValueSet<Zahlweise> getAllowedValuesForZahlweise() {
        return getHausratProdukt().getAllowedValuesForZahlweise();
    }

    /**
     * Returns the zahlweise.
     * <p>
     * Die Zahlweise des Vertrages.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsAttribute(name = "zahlweise", kind = AttributeKind.CHANGEABLE, valueSetKind = ValueSetKind.Enum)
    @IpsConfiguredAttribute(changingOverTime = false)
    @IpsGenerated
    public Zahlweise getZahlweise() {
        return zahlweise;
    }

    /**
     * Sets the value of attribute zahlweise.
     * <p>
     * Die Zahlweise des Vertrages.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsAttributeSetter("zahlweise")
    @IpsGenerated
    public void setZahlweise(Zahlweise newValue) {
        this.zahlweise = newValue;
    }

    /**
     * Returns the set of allowed values for the property plz.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsAllowedValues("plz")
    @IpsGenerated
    public ValueSet<String> getAllowedValuesForPlz() {
        return MAX_ALLOWED_STRING_LENGTH_FOR_PLZ;
    }

    /**
     * Returns the plz.
     * <p>
     * Postleitzahl des versicherten Hausrats. Maximal 5 Zeichen.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsAttribute(name = "plz", kind = AttributeKind.CHANGEABLE, valueSetKind = ValueSetKind.AllValues)
    @IpsGenerated
    public String getPlz() {
        return plz;
    }

    /**
     * Sets the value of attribute plz.
     * <p>
     * Postleitzahl des versicherten Hausrats. Maximal 5 Zeichen.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsAttributeSetter("plz")
    @IpsGenerated
    public void setPlz(String newValue) {
        this.plz = newValue;
    }

    /**
     * Returns the set of allowed values for the property tarifzone.
     *
     * @since 1.0
     *
     * @restrainedmodifiable
     */
    @IpsAllowedValues("tarifzone")
    @IpsGenerated
    public ValueSet<String> getAllowedValuesForTarifzone() {
        // begin-user-code
        return new UnrestrictedValueSet<>(true);
        // end-user-code
    }

    /**
     * Returns the tarifzone.
     * <p>
     * Die Tarifzone ergibt sich aus der Postleitzahl und ist ma??geblich f??r den zu
     * zahlenden Beitrag.
     *
     * @since 1.0
     *
     * @restrainedmodifiable
     */
    @IpsAttribute(name = "tarifzone", kind = AttributeKind.DERIVED_ON_THE_FLY, valueSetKind = ValueSetKind.AllValues)
    @IpsGenerated
    public String getTarifzone() {
        // begin-user-code
        Tarifzonentabelle tabelle = getProductComponent().getRepository().getTable(Tarifzonentabelle.class);
        final TarifzonentabelleRow tarifzone = tabelle.findRow(getPlz());
        if (tarifzone == null) {
            return "I";
        }
        return tarifzone.getTarifzone();
        // end-user-code
    }

    /**
     * Returns the range of allowed values for the property wohnflaeche.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsAllowedValues("wohnflaeche")
    @IpsGenerated
    public ValueSet<Integer> getAllowedValuesForWohnflaeche() {
        return getHausratProdukt().getAllowedValuesForWohnflaeche();
    }

    /**
     * Returns the wohnflaeche.
     * <p>
     * Die Wohnfl??che des versicherten Hausrats in Quadratmetern.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsAttribute(name = "wohnflaeche", kind = AttributeKind.CHANGEABLE, valueSetKind = ValueSetKind.Range)
    @IpsConfiguredAttribute(changingOverTime = false)
    @IpsGenerated
    public Integer getWohnflaeche() {
        return wohnflaeche;
    }

    /**
     * Sets the value of attribute wohnflaeche.
     * <p>
     * Die Wohnfl??che des versicherten Hausrats in Quadratmetern.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsAttributeSetter("wohnflaeche")
    @IpsGenerated
    public void setWohnflaeche(Integer newValue) {
        this.wohnflaeche = newValue;
    }

    /**
     * Returns the set of allowed values for the property vorschlagVersSumme.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsAllowedValues("vorschlagVersSumme")
    @IpsGenerated
    public ValueSet<Money> getAllowedValuesForVorschlagVersSumme() {
        return MAX_ALLOWED_VALUES_FOR_VORSCHLAG_VERS_SUMME;
    }

    /**
     * Returns the vorschlagVersSumme.
     * <p>
     * Vorschlag f??r die Versicherungssumme. Wird auf Basis der Wohnfl??che bestimmt.
     *
     * @since 1.0
     *
     * @restrainedmodifiable
     */
    @IpsAttribute(name = "vorschlagVersSumme", kind = AttributeKind.DERIVED_ON_THE_FLY, valueSetKind = ValueSetKind.AllValues)
    @IpsGenerated
    public Money getVorschlagVersSumme() {
        // begin-user-code
        final HausratProdukt hausratProdukt = getHausratProdukt();
        if (hausratProdukt == null) {
            return Money.NULL;
        }
        return hausratProdukt.getVorschlagVersSummeProQm().multiply(getWohnflaeche());
        // end-user-code
    }

    /**
     * Returns the range of allowed values for the property versSumme.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsAllowedValues("versSumme")
    @IpsGenerated
    public ValueSet<Money> getAllowedValuesForVersSumme() {
        return getHausratProdukt().getAllowedValuesForVersSumme();
    }

    /**
     * Returns the versSumme.
     * <p>
     * Die Versicherungssumme.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsAttribute(name = "versSumme", kind = AttributeKind.CHANGEABLE, valueSetKind = ValueSetKind.Range)
    @IpsConfiguredAttribute(changingOverTime = false)
    @IpsGenerated
    public Money getVersSumme() {
        return versSumme;
    }

    /**
     * Sets the value of attribute versSumme.
     * <p>
     * Die Versicherungssumme.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsAttributeSetter("versSumme")
    @IpsGenerated
    public void setVersSumme(Money newValue) {
        this.versSumme = newValue;
    }

    /**
     * Returns the referenced HausratGrunddeckung.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsAssociation(name = "HausratGrunddeckung", pluralName = "", kind = AssociationKind.Composition, targetClass = HausratGrunddeckung.class, min = 1, max = 1)
    @IpsMatchingAssociation(source = HausratProdukt.class, name = "HausratGrunddeckungstyp")
    @IpsInverseAssociation("HausratVertrag")
    @IpsGenerated
    public HausratGrunddeckung getHausratGrunddeckung() {
        return hausratGrunddeckung;
    }

    /**
     * Sets the HausratGrunddeckung.
     *
     * @throws ClassCastException If the association is constrained and the given
     *                            object is not of the correct type.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsAssociationAdder(association = "HausratGrunddeckung")
    @IpsGenerated
    public void setHausratGrunddeckung(HausratGrunddeckung newObject) {
        if (hausratGrunddeckung != null) {
            hausratGrunddeckung.setHausratVertragInternal(null);
        }
        if (newObject != null) {
            newObject.setHausratVertragInternal(this);
        }
        hausratGrunddeckung = newObject;
    }

    /**
     * Creates a new HausratGrunddeckung and adds it as HausratGrunddeckung.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsGenerated
    public HausratGrunddeckung newHausratGrunddeckung() {
        HausratGrunddeckung newHausratGrunddeckung = new HausratGrunddeckung();
        setHausratGrunddeckung(newHausratGrunddeckung);
        newHausratGrunddeckung.initialize();
        return newHausratGrunddeckung;
    }

    /**
     * Creates a new HausratGrunddeckung and adds it as HausratGrunddeckung.
     *
     * @param hausratGrunddeckungstyp The product component that configures the new
     *                                object.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsGenerated
    public HausratGrunddeckung newHausratGrunddeckung(HausratGrunddeckungstyp hausratGrunddeckungstyp) {
        if (hausratGrunddeckungstyp == null) {
            return newHausratGrunddeckung();
        }
        HausratGrunddeckung newHausratGrunddeckung = hausratGrunddeckungstyp.createHausratGrunddeckung();
        setHausratGrunddeckung(newHausratGrunddeckung);
        newHausratGrunddeckung.initialize();
        return newHausratGrunddeckung;
    }

    /**
     * Returns the number of zusatzdeckungen.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsGenerated
    public int getNumOfZusatzdeckungen() {
        return zusatzdeckungen.size();
    }

    /**
     * Returns <code>true</code> if the given object is referenced in the
     * association, otherwise <code>false</code>.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsGenerated
    public boolean containsZusatzdeckung(HausratZusatzdeckung objectToTest) {
        return zusatzdeckungen.contains(objectToTest);
    }

    /**
     * Returns the referenced zusatzdeckungen.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsAssociation(name = "zusatzdeckung", pluralName = "zusatzdeckungen", kind = AssociationKind.Composition, targetClass = HausratZusatzdeckung.class, min = 0, max = Integer.MAX_VALUE)
    @IpsMatchingAssociation(source = HausratProdukt.class, name = "zusatzdeckung")
    @IpsInverseAssociation("HausratVertrag")
    @IpsGenerated
    public List<? extends HausratZusatzdeckung> getZusatzdeckungen() {
        return Collections.unmodifiableList(zusatzdeckungen);
    }

    /**
     * Returns the object at the indexed position from the association
     * zusatzdeckung.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsGenerated
    public HausratZusatzdeckung getZusatzdeckung(int index) {
        return zusatzdeckungen.get(index);
    }

    /**
     * Adds the given object as zusatzdeckung.
     *
     * @throws ClassCastException If the association is constrained and the given
     *                            object is not of the correct type.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsAssociationAdder(association = "zusatzdeckung")
    @IpsGenerated
    public void addZusatzdeckung(HausratZusatzdeckung objectToAdd) {
        if (objectToAdd == null) {
            throw new NullPointerException("Can't add null to association zusatzdeckung of " + this);
        }
        if (zusatzdeckungen.contains(objectToAdd)) {
            return;
        }
        objectToAdd.setHausratVertragInternal(this);
        zusatzdeckungen.add(objectToAdd);
    }

    /**
     * Creates a new HausratZusatzdeckung and adds it as zusatzdeckung.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsGenerated
    public HausratZusatzdeckung newZusatzdeckung() {
        HausratZusatzdeckung newZusatzdeckung = new HausratZusatzdeckung();
        addZusatzdeckung(newZusatzdeckung);
        newZusatzdeckung.initialize();
        return newZusatzdeckung;
    }

    /**
     * Creates a new HausratZusatzdeckung and adds it as zusatzdeckung.
     *
     * @param hausratZusatzdeckungstyp The product component that configures the new
     *                                 object.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsGenerated
    public HausratZusatzdeckung newZusatzdeckung(HausratZusatzdeckungstyp hausratZusatzdeckungstyp) {
        if (hausratZusatzdeckungstyp == null) {
            return newZusatzdeckung();
        }
        HausratZusatzdeckung newZusatzdeckung = hausratZusatzdeckungstyp.createHausratZusatzdeckung();
        addZusatzdeckung(newZusatzdeckung);
        newZusatzdeckung.initialize();
        return newZusatzdeckung;
    }

    /**
     * Removes the given object from the association zusatzdeckung.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsAssociationRemover(association = "zusatzdeckung")
    @IpsGenerated
    public void removeZusatzdeckung(HausratZusatzdeckung objectToRemove) {
        if (objectToRemove == null) {
            return;
        }
        if (zusatzdeckungen.remove(objectToRemove)) {
            objectToRemove.setHausratVertragInternal(null);
        }
    }

    /**
     * Initializes the object with the configured defaults.
     *
     * @restrainedmodifiable
     */
    @Override
    @IpsGenerated
    public void initialize() {
        if (getHausratProdukt() != null) {
            setZahlweise(getHausratProdukt().getDefaultValueZahlweise());
            setWohnflaeche(getHausratProdukt().getDefaultValueWohnflaeche());
            setVersSumme(getHausratProdukt().getDefaultValueVersSumme());
        }
        // begin-user-code
        // end-user-code
    }

    /**
     * Returns the HausratProdukt that configures this object.
     *
     * @generated
     */
    @IpsGenerated
    public HausratProdukt getHausratProdukt() {
        return (HausratProdukt) getProductComponent();
    }

    /**
     * Sets the new HausratProdukt that configures this object.
     *
     * @param hausratProdukt                         The new HausratProdukt.
     * @param initPropertiesWithConfiguratedDefaults <code>true</code> if the
     *                                               properties should be
     *                                               initialized with the defaults
     *                                               defined in the HausratProdukt.
     *
     * @generated
     */
    @IpsGenerated
    public void setHausratProdukt(HausratProdukt hausratProdukt, boolean initPropertiesWithConfiguratedDefaults) {
        setProductComponent(hausratProdukt);
        if (initPropertiesWithConfiguratedDefaults) {
            initialize();
        }
    }

    /**
     * {@inheritDoc}
     *
     * @generated
     */
    @Override
    @IpsGenerated
    public IProductComponent getProductComponent() {
        return productConfiguration.getProductComponent();
    }

    /**
     * Sets the current product component.
     *
     * @generated
     */
    @Override
    @IpsGenerated
    public void setProductComponent(IProductComponent productComponent) {
        productConfiguration.setProductComponent(productComponent);
    }

    /**
     * This method is called when the effective from date has changed, so that the
     * reference to the product component generation can be cleared. If this policy
     * component contains child components, this method will also clear the
     * reference to their product component generations.
     * <p>
     * The product component generation is cleared if and only if there is a new
     * effective from date. If {@link #getEffectiveFromAsCalendar()} returns
     * <code>null</code> the product component generation is not reset, for example
     * if this model object was removed from its parent.
     * <p>
     * Clients may change the behavior of resetting the product component by
     * overwriting {@link #resetProductCmptGenerationAfterEffectiveFromHasChanged()}
     * instead of this method.
     *
     * @generated
     */
    @IpsGenerated
    public void effectiveFromHasChanged() {
        if (getEffectiveFromAsCalendar() != null) {
            resetProductCmptGenerationAfterEffectiveFromHasChanged();
        }
        if (hausratGrunddeckung != null) {
            hausratGrunddeckung.effectiveFromHasChanged();
        }
        for (Iterator<HausratZusatzdeckung> it = zusatzdeckungen.iterator(); it.hasNext();) {
            HausratZusatzdeckung child = it.next();
            child.effectiveFromHasChanged();
        }
    }

    /**
     * Clears the product component generation.
     * <p>
     * This method can be overwritten to affect the behavior in case of an
     * effective-date change.
     *
     * @generated
     */
    @IpsGenerated
    protected void resetProductCmptGenerationAfterEffectiveFromHasChanged() {
        productConfiguration.resetProductCmptGeneration();
    }

    /**
     * {@inheritDoc}
     *
     * @generated
     */
    @Override
    @IpsGenerated
    public Calendar getEffectiveFromAsCalendar() {
        // TODO Implement access to effective from.
        // To avoid that the generator overwrites the implementation,
        // you have to add NOT after @generated in the Javadoc!
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @generated
     */
    @Override
    @IpsGenerated
    protected void initFromXml(Element objectEl, boolean initWithProductDefaultsBeforeReadingXmlData,
            IRuntimeRepository productRepository, IObjectReferenceStore store, XmlCallback xmlCallback,
            String currPath) {
        productConfiguration.initFromXml(objectEl, productRepository);
        if (initWithProductDefaultsBeforeReadingXmlData) {
            initialize();
        }
        super.initFromXml(objectEl, initWithProductDefaultsBeforeReadingXmlData, productRepository, store, xmlCallback,
                currPath);
    }

    /**
     * {@inheritDoc}
     *
     * @generated
     */
    @Override
    @IpsGenerated
    protected void initPropertiesFromXml(Map<String, String> propMap, IRuntimeRepository productRepository) {
        super.initPropertiesFromXml(propMap, productRepository);
        doInitZahlweise(propMap);
        doInitPlz(propMap);
        doInitWohnflaeche(propMap);
        doInitVersSumme(propMap);
    }

    /**
     * @generated
     */
    @IpsGenerated
    private void doInitZahlweise(Map<String, String> propMap) {
        if (propMap.containsKey(PROPERTY_ZAHLWEISE)) {
            this.zahlweise = IpsStringUtils.isEmpty(propMap.get(PROPERTY_ZAHLWEISE)) ? null
                    : Zahlweise.getValueByZahlungenProJahr(Integer.parseInt(propMap.get(PROPERTY_ZAHLWEISE)));
        }
    }

    /**
     * @generated
     */
    @IpsGenerated
    private void doInitPlz(Map<String, String> propMap) {
        if (propMap.containsKey(PROPERTY_PLZ)) {
            this.plz = propMap.get(PROPERTY_PLZ);
        }
    }

    /**
     * @generated
     */
    @IpsGenerated
    private void doInitWohnflaeche(Map<String, String> propMap) {
        if (propMap.containsKey(PROPERTY_WOHNFLAECHE)) {
            this.wohnflaeche = IpsStringUtils.isEmpty(propMap.get(PROPERTY_WOHNFLAECHE)) ? null
                    : Integer.valueOf(propMap.get(PROPERTY_WOHNFLAECHE));
        }
    }

    /**
     * @generated
     */
    @IpsGenerated
    private void doInitVersSumme(Map<String, String> propMap) {
        if (propMap.containsKey(PROPERTY_VERSSUMME)) {
            this.versSumme = Money.valueOf(propMap.get(PROPERTY_VERSSUMME));
        }
    }

    /**
     * {@inheritDoc}
     *
     * @generated
     */
    @Override
    @IpsGenerated
    protected AbstractModelObject createChildFromXml(Element childEl) {
        AbstractModelObject newChild = super.createChildFromXml(childEl);
        if (newChild != null) {
            return newChild;
        }
        if ("HausratGrunddeckung".equals(childEl.getNodeName())) {
            return doInitHausratGrunddeckung(childEl);
        }
        if ("zusatzdeckung".equals(childEl.getNodeName())) {
            return doInitZusatzdeckung(childEl);
        }
        return null;
    }

    /**
     * @generated
     */
    @IpsGenerated
    private AbstractModelObject doInitHausratGrunddeckung(Element childEl) {
        String className = childEl.getAttribute("class");
        if (className.length() > 0) {
            try {
                HausratGrunddeckung hausratGrunddeckungLocalVar = (HausratGrunddeckung) Class.forName(className)
                        .getConstructor().newInstance();
                setHausratGrunddeckung(hausratGrunddeckungLocalVar);
                return hausratGrunddeckungLocalVar;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return newHausratGrunddeckung();
    }

    /**
     * @generated
     */
    @IpsGenerated
    private AbstractModelObject doInitZusatzdeckung(Element childEl) {
        String className = childEl.getAttribute("class");
        if (className.length() > 0) {
            try {
                HausratZusatzdeckung zusatzdeckungLocalVar = (HausratZusatzdeckung) Class.forName(className)
                        .getConstructor().newInstance();
                addZusatzdeckung(zusatzdeckungLocalVar);
                return zusatzdeckungLocalVar;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return newZusatzdeckung();
    }

    /**
     * {@inheritDoc}
     *
     * @generated
     */
    @Override
    @IpsGenerated
    public IModelObjectDelta computeDelta(IModelObject otherObject, IDeltaComputationOptions options) {
        ModelObjectDelta delta = ModelObjectDelta.newDelta(this, otherObject, options);
        if (!HausratVertrag.class.isAssignableFrom(otherObject.getClass())) {
            return delta;
        }
        HausratVertrag otherHausratVertrag = (HausratVertrag) otherObject;
        delta.checkPropertyChange(HausratVertrag.PROPERTY_ZAHLWEISE, zahlweise, otherHausratVertrag.zahlweise, options);
        delta.checkPropertyChange(HausratVertrag.PROPERTY_PLZ, plz, otherHausratVertrag.plz, options);
        delta.checkPropertyChange(HausratVertrag.PROPERTY_WOHNFLAECHE, wohnflaeche, otherHausratVertrag.wohnflaeche,
                options);
        delta.checkPropertyChange(HausratVertrag.PROPERTY_VERSSUMME, versSumme, otherHausratVertrag.versSumme, options);
        ModelObjectDelta.createChildDeltas(delta, hausratGrunddeckung, otherHausratVertrag.hausratGrunddeckung,
                ASSOCIATION_HAUSRAT_GRUNDDECKUNG, options);
        ModelObjectDelta.createChildDeltas(delta, zusatzdeckungen, otherHausratVertrag.zusatzdeckungen,
                ASSOCIATION_ZUSATZDECKUNGEN, options);
        return delta;
    }

    /**
     * {@inheritDoc}
     *
     * @generated
     */
    @Override
    @IpsGenerated
    public HausratVertrag newCopy() {
        Map<IModelObject, IModelObject> copyMap = new HashMap<>();
        HausratVertrag newCopy = newCopyInternal(copyMap);
        copyAssociationsInternal(newCopy, copyMap);
        return newCopy;
    }

    /**
     * Internal copy method with a {@link Map} containing already copied instances.
     *
     * @param copyMap the map contains the copied instances
     *
     * @generated
     */
    @IpsGenerated
    public HausratVertrag newCopyInternal(Map<IModelObject, IModelObject> copyMap) {
        HausratVertrag newCopy = (HausratVertrag) copyMap.get(this);
        if (newCopy == null) {
            newCopy = new HausratVertrag();
            copyMap.put(this, newCopy);
            newCopy.copyProductCmptAndGenerationInternal(this);
            copyProperties(newCopy, copyMap);
        }
        return newCopy;
    }

    /**
     * Copies the product component and product component generation from the other
     * object.
     *
     * @generated
     */
    @IpsGenerated
    protected void copyProductCmptAndGenerationInternal(HausratVertrag otherObject) {
        productConfiguration.copy(otherObject.productConfiguration);
    }

    /**
     * This method sets all properties in the copy with the values of this object.
     * If there are copied associated objects they are added to the copyMap in
     * {@link #newCopyInternal(Map)}.
     *
     * @param copy    The copy object
     * @param copyMap a map containing copied associated objects
     *
     * @generated
     */
    @IpsGenerated
    protected void copyProperties(IModelObject copy, Map<IModelObject, IModelObject> copyMap) {
        HausratVertrag concreteCopy = (HausratVertrag) copy;
        concreteCopy.zahlweise = zahlweise;
        concreteCopy.plz = plz;
        concreteCopy.wohnflaeche = wohnflaeche;
        concreteCopy.versSumme = versSumme;
        if (hausratGrunddeckung != null) {
            concreteCopy.hausratGrunddeckung = hausratGrunddeckung.newCopyInternal(copyMap);
            concreteCopy.hausratGrunddeckung.setHausratVertragInternal(concreteCopy);
        }
        for (Iterator<HausratZusatzdeckung> it = zusatzdeckungen.iterator(); it.hasNext();) {
            HausratZusatzdeckung hausratZusatzdeckung = it.next();
            HausratZusatzdeckung copyHausratZusatzdeckung = hausratZusatzdeckung.newCopyInternal(copyMap);
            copyHausratZusatzdeckung.setHausratVertragInternal(concreteCopy);
            concreteCopy.zusatzdeckungen.add(copyHausratZusatzdeckung);
        }
    }

    /**
     * Internal method for setting copied associations. For copied targets, the
     * associations have to be retargeted to the new copied instances. This method
     * have to call {@link #copyAssociationsInternal(IModelObject, Map)} in other
     * instances associated by composite.
     *
     * @param abstractCopy the copy of this policy component
     * @param copyMap      the map contains the copied instances
     *
     * @generated
     */
    @IpsGenerated
    public void copyAssociationsInternal(IModelObject abstractCopy, Map<IModelObject, IModelObject> copyMap) {
        if (hausratGrunddeckung != null) {
            HausratGrunddeckung copyHausratGrunddeckung = (HausratGrunddeckung) copyMap.get(hausratGrunddeckung);
            hausratGrunddeckung.copyAssociationsInternal(copyHausratGrunddeckung, copyMap);
        }
        for (HausratZusatzdeckung hausratZusatzdeckung : zusatzdeckungen) {
            HausratZusatzdeckung copyHausratZusatzdeckung = (HausratZusatzdeckung) copyMap.get(hausratZusatzdeckung);
            hausratZusatzdeckung.copyAssociationsInternal(copyHausratZusatzdeckung, copyMap);
        }
    }

    /**
     * {@inheritDoc}
     *
     * @generated
     */
    @Override
    @IpsGenerated
    public boolean accept(IModelObjectVisitor visitor) {
        if (!visitor.visit(this)) {
            return false;
        }
        if (hausratGrunddeckung != null) {
            hausratGrunddeckung.accept(visitor);
        }
        for (HausratZusatzdeckung zusatzdeckung : zusatzdeckungen) {
            zusatzdeckung.accept(visitor);
        }
        return true;
    }

    /**
     * Validates the object (but not its children). Returns <code>true</code> if
     * this object should continue validating, <code>false</code> otherwise.
     *
     * @generated
     */
    @Override
    @IpsGenerated
    public boolean validateSelf(MessageList ml, IValidationContext context) {
        if (!super.validateSelf(ml, context)) {
            return STOP_VALIDATION;
        }
        ml.add(GenericRelevanceValidation.of(this, HausratVertrag.class, PROPERTY_VERSSUMME, context));
        if (!pruefeWohnflaeche(ml, context)) {
            return STOP_VALIDATION;
        }
        if (!pruefePlz(ml, context)) {
            return STOP_VALIDATION;
        }
        return CONTINUE_VALIDATION;
    }

    /**
     * Validates the object's children.
     *
     * @generated
     */
    @Override
    @IpsGenerated
    public void validateDependants(MessageList ml, IValidationContext context) {
        super.validateDependants(ml, context);
        if (hausratGrunddeckung != null) {
            ml.add(hausratGrunddeckung.validate(context));
        }
        if (getNumOfZusatzdeckungen() > 0) {
            for (HausratZusatzdeckung rel : getZusatzdeckungen()) {
                ml.add(rel.validate(context));
            }
        }
    }

    /**
     * @restrainedmodifiable
     */
    @Override
    @IpsGenerated
    public String toString() {
        // begin-user-code
        return getProductComponent() == null ? getClass().getSimpleName()
                : getClass().getSimpleName() + '[' + getProductComponent().toString() + ']';
        // end-user-code
    }

    /**
     *
     * Executes the rule pruefeWohnflaeche and adds a message to the given list if
     * the object is invalid.
     *
     * @param ml      list to which validation errors are added
     * @param context the validation context
     * @return <code>true</code>, if the validation should be continued,
     *         <code>false</code> if it should be stopped after processing this
     *         rule.
     *
     * @since 1.0
     *
     * @restrainedmodifiable
     */
    @IpsValidationRule(name = "pruefeWohnflaeche", msgCode = MSG_CODE_PRUEFE_WOHNFLAECHE, severity = Severity.ERROR)
    @IpsConfiguredValidationRule(changingOverTime = false, defaultActivated = true)
    @IpsGenerated
    protected boolean pruefeWohnflaeche(MessageList ml, IValidationContext context) {
        if (getProductComponent().isValidationRuleActivated(RULE_PRUEFE_WOHNFLAECHE)) {
            if (!getAllowedValuesForWohnflaeche().contains(getWohnflaeche())) {
                // begin-user-code
                ml.add(createMessageForRulePruefeWohnflaeche(context, wohnflaeche, getAllowedValuesForWohnflaeche()));
                // end-user-code
            }
            return CONTINUE_VALIDATION;
        }
        return CONTINUE_VALIDATION;
    }

    /**
     * Creates a message to indicate that the rule pruefeWohnflaeche has found an
     * invalid state.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsGenerated
    protected Message createMessageForRulePruefeWohnflaeche(IValidationContext context, Object wohnflaeche,
            Object bereich) {
        List<ObjectProperty> invalidObjectProperties = Arrays.asList(new ObjectProperty(this, PROPERTY_WOHNFLAECHE));
        MsgReplacementParameter[] replacementParameters = new MsgReplacementParameter[] {
                new MsgReplacementParameter("wohnflaeche", wohnflaeche),
                new MsgReplacementParameter("bereich", bereich) };
        MessagesHelper messageHelper = new MessagesHelper("de.faktorips.schulung.hausratmodell.message-validation",
                getClass().getClassLoader(), Locale.GERMAN);
        String msgText = messageHelper.getMessage("hausrat.HausratVertrag-pruefeWohnflaeche", context.getLocale(),
                wohnflaeche, bereich);

        Message.Builder builder = new Message.Builder(msgText, Severity.ERROR).code(MSG_CODE_PRUEFE_WOHNFLAECHE)
                .invalidObjects(invalidObjectProperties).replacements(replacementParameters);
        return builder.create();
    }

    /**
     * Pr??ft PLZ auf Validit??t
     * <p>
     *
     * Executes the rule pruefePlz and adds a message to the given list if the
     * object is invalid.
     *
     * @param ml      list to which validation errors are added
     * @param context the validation context
     * @return <code>true</code>, if the validation should be continued,
     *         <code>false</code> if it should be stopped after processing this
     *         rule.
     *
     * @since 1.0
     *
     * @restrainedmodifiable
     */
    @IpsValidationRule(name = "pruefePlz", msgCode = MSG_CODE_PRUEFE_PLZ, severity = Severity.ERROR)
    @IpsConfiguredValidationRule(changingOverTime = false, defaultActivated = true)
    @IpsGenerated
    protected boolean pruefePlz(MessageList ml, IValidationContext context) {
        if (getProductComponent().isValidationRuleActivated(RULE_PRUEFE_PLZ)) {
            // begin-user-code
            // TODO Implement the rule pruefePlz.
            if (getPlz() == null || !Pattern.matches("\\d{5}", getPlz())) {
                ml.add(createMessageForRulePruefePlz(context, getPlz()));
                // TODO Complete the call to createMessage for the rule pruefePlz.
            }
            return CONTINUE_VALIDATION;
            // end-user-code
        }
        return CONTINUE_VALIDATION;
    }

    /**
     * Creates a message to indicate that the rule pruefePlz has found an invalid
     * state.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsGenerated
    protected Message createMessageForRulePruefePlz(IValidationContext context, Object plz) {
        List<ObjectProperty> invalidObjectProperties = Arrays.asList(new ObjectProperty(this, PROPERTY_PLZ));
        MsgReplacementParameter[] replacementParameters = new MsgReplacementParameter[] {
                new MsgReplacementParameter("plz", plz) };
        MessagesHelper messageHelper = new MessagesHelper("de.faktorips.schulung.hausratmodell.message-validation",
                getClass().getClassLoader(), Locale.GERMAN);
        String msgText = messageHelper.getMessage("hausrat.HausratVertrag-pruefePlz", context.getLocale(), plz);

        Message.Builder builder = new Message.Builder(msgText, Severity.ERROR).code(MSG_CODE_PRUEFE_PLZ)
                .invalidObjects(invalidObjectProperties).replacements(replacementParameters);
        return builder.create();
    }

}
