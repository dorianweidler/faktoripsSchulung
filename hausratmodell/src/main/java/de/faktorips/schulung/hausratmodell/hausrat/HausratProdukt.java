package de.faktorips.schulung.hausratmodell.hausrat;

import org.faktorips.runtime.model.annotation.IpsProductCmptType;
import org.faktorips.runtime.model.annotation.IpsAttributes;
import org.faktorips.runtime.model.annotation.IpsAssociations;
import org.faktorips.runtime.model.annotation.IpsConfigures;
import org.faktorips.runtime.model.annotation.IpsDocumented;
import org.faktorips.runtime.internal.ProductComponent;
import org.faktorips.valueset.OrderedValueSet;
import org.faktorips.valueset.IntegerRange;
import org.faktorips.values.Money;
import org.faktorips.valueset.MoneyRange;
import org.faktorips.runtime.IProductComponentLink;
import org.faktorips.runtime.IRuntimeRepository;
import org.faktorips.runtime.model.annotation.IpsAttribute;
import org.faktorips.runtime.model.type.AttributeKind;
import org.faktorips.runtime.model.type.ValueSetKind;
import org.faktorips.runtime.model.annotation.IpsAttributeSetter;
import org.faktorips.runtime.IllegalRepositoryModificationException;
import org.faktorips.runtime.model.annotation.IpsDefaultValue;
import org.faktorips.runtime.model.annotation.IpsDefaultValueSetter;
import org.faktorips.runtime.model.annotation.IpsAllowedValues;
import org.faktorips.valueset.ValueSet;
import org.faktorips.runtime.model.annotation.IpsAllowedValuesSetter;
import org.faktorips.runtime.model.annotation.IpsAssociation;
import org.faktorips.runtime.model.type.AssociationKind;
import org.faktorips.runtime.model.annotation.IpsMatchingAssociation;
import org.faktorips.runtime.model.annotation.IpsAssociationAdder;
import org.faktorips.runtime.internal.ProductComponentLink;
import org.faktorips.runtime.CardinalityRange;
import org.faktorips.runtime.model.annotation.IpsAssociationLinks;
import org.w3c.dom.Element;
import java.util.Map;
import org.faktorips.runtime.internal.ValueToXmlHelper;
import org.faktorips.runtime.internal.IpsStringUtils;
import org.faktorips.runtime.internal.EnumValues;
import java.util.List;
import org.faktorips.runtime.IProductComponent;
import java.util.ArrayList;
import org.faktorips.runtime.internal.Range;
import org.faktorips.runtime.annotation.IpsGenerated;

/**
 * Produktbausteinklasse für Hausratprodukte
 *
 * @since 1.0
 *
 * @generated
 */
@IpsProductCmptType(name = "hausrat.HausratProdukt")
@IpsAttributes({ "produktname", "kurzbezeichnung", "vorschlagVersSummeProQm" })
@IpsAssociations({ "HausratGrunddeckungstyp" })
@IpsConfigures(HausratVertrag.class)
@IpsDocumented(bundleName = "de.faktorips.schulung.hausratmodell.model-label-and-descriptions", defaultLocale = "de")
public class HausratProdukt extends ProductComponent {

    /**
     * The name of the XML tag for the association hausratGrunddeckungstyp.
     *
     * @since 1.0
     *
     * @generated
     */
    private static final String XML_TAG_HAUSRAT_GRUNDDECKUNGSTYP = "HausratGrunddeckungstyp";
    /**
     * The name of the property produktname.
     *
     * @since 1.0
     *
     * @generated
     */
    public static final String PROPERTY_PRODUKTNAME = "produktname";
    /**
     * The name of the property kurzbezeichnung.
     *
     * @since 1.0
     *
     * @generated
     */
    public static final String PROPERTY_KURZBEZEICHNUNG = "kurzbezeichnung";
    /**
     * The name of the property vorschlagVersSummeProQm.
     *
     * @since 1.0
     *
     * @generated
     */
    public static final String PROPERTY_VORSCHLAGVERSSUMMEPROQM = "vorschlagVersSummeProQm";
    /**
     * The product component property Produktname.
     *
     * @since 1.0
     *
     * @generated
     */
    private String produktname;

    /**
     * The product component property Kurzbezeichnung.
     *
     * @since 1.0
     *
     * @generated
     */
    private String kurzbezeichnung;

    /**
     * The product component property VorschlagVersSummeProQm.
     *
     * @since 1.0
     *
     * @generated
     */
    private Money vorschlagVersSummeProQm;
    /**
     * The default value for zahlweise.
     *
     * @since 1.0
     *
     * @generated
     */
    private Integer defaultValueZahlweise = null;
    /**
     * Allowed set of values for property zahlweise.
     *
     * @since 1.0
     *
     * @generated
     */
    private OrderedValueSet<Integer> allowedValuesForZahlweise = HausratVertrag.MAX_ALLOWED_VALUES_FOR_ZAHLWEISE;
    /**
     * The default value for wohnflaeche.
     *
     * @since 1.0
     *
     * @generated
     */
    private Integer defaultValueWohnflaeche = null;
    /**
     * Range of allowed values for property wohnflaeche.
     *
     * @since 1.0
     *
     * @generated
     */
    private IntegerRange rangeForWohnflaeche = HausratVertrag.MAX_ALLOWED_RANGE_FOR_WOHNFLAECHE;
    /**
     * The default value for versSumme.
     *
     * @since 1.0
     *
     * @generated
     */
    private Money defaultValueVersSumme = Money.NULL;
    /**
     * Range of allowed values for property versSumme.
     *
     * @since 1.0
     *
     * @generated
     */
    private MoneyRange rangeForVersSumme = HausratVertrag.MAX_ALLOWED_RANGE_FOR_VERS_SUMME;
    /**
     * Member variable for the association HausratGrunddeckungstyp.
     *
     * @since 1.0
     *
     * @generated
     */
    private IProductComponentLink<HausratGrunddeckungstyp> hausratGrunddeckungstyp = null;

    /**
     * Creates a new HausratProdukt.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsGenerated
    public HausratProdukt(IRuntimeRepository repository, String id, String kindId, String versionId) {
        super(repository, id, kindId, versionId);
    }

    /**
     * {@inheritDoc}
     *
     * @generated
     */
    @Override
    @IpsGenerated
    public boolean isChangingOverTime() {
        return false;
    }

    /**
     * Returns the value of produktname.
     * <p>
     * Der Name des durch den Produktbaustein abgebildeten Produkts.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsAttribute(name = "produktname", kind = AttributeKind.CONSTANT, valueSetKind = ValueSetKind.AllValues)
    @IpsGenerated
    public String getProduktname() {
        return produktname;
    }

    /**
     * Sets the value of attribute produktname.
     * <p>
     * Der Name des durch den Produktbaustein abgebildeten Produkts.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsAttributeSetter("produktname")
    @IpsGenerated
    public void setProduktname(String newValue) {
        if (getRepository() != null && !getRepository().isModifiable()) {
            throw new IllegalRepositoryModificationException();
        }
        setProduktnameInternal(newValue);
    }

    /**
     * Sets the value of attribute produktname.
     * <p>
     * Der Name des durch den Produktbaustein abgebildeten Produkts.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsGenerated
    protected final void setProduktnameInternal(String newValue) {
        this.produktname = newValue;
    }

    /**
     * Returns the value of kurzbezeichnung.
     * <p>
     * Kurzbezeichnung des Produkts
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsAttribute(name = "kurzbezeichnung", kind = AttributeKind.CONSTANT, valueSetKind = ValueSetKind.AllValues)
    @IpsGenerated
    public String getKurzbezeichnung() {
        return kurzbezeichnung;
    }

    /**
     * Sets the value of attribute kurzbezeichnung.
     * <p>
     * Kurzbezeichnung des Produkts
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsAttributeSetter("kurzbezeichnung")
    @IpsGenerated
    public void setKurzbezeichnung(String newValue) {
        if (getRepository() != null && !getRepository().isModifiable()) {
            throw new IllegalRepositoryModificationException();
        }
        setKurzbezeichnungInternal(newValue);
    }

    /**
     * Sets the value of attribute kurzbezeichnung.
     * <p>
     * Kurzbezeichnung des Produkts
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsGenerated
    protected final void setKurzbezeichnungInternal(String newValue) {
        this.kurzbezeichnung = newValue;
    }

    /**
     * Returns the value of vorschlagVersSummeProQm.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsAttribute(name = "vorschlagVersSummeProQm", kind = AttributeKind.CONSTANT, valueSetKind = ValueSetKind.AllValues)
    @IpsGenerated
    public Money getVorschlagVersSummeProQm() {
        return vorschlagVersSummeProQm;
    }

    /**
     * Sets the value of attribute vorschlagVersSummeProQm.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsAttributeSetter("vorschlagVersSummeProQm")
    @IpsGenerated
    public void setVorschlagVersSummeProQm(Money newValue) {
        if (getRepository() != null && !getRepository().isModifiable()) {
            throw new IllegalRepositoryModificationException();
        }
        setVorschlagVersSummeProQmInternal(newValue);
    }

    /**
     * Sets the value of attribute vorschlagVersSummeProQm.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsGenerated
    protected final void setVorschlagVersSummeProQmInternal(Money newValue) {
        this.vorschlagVersSummeProQm = newValue;
    }

    /**
     * Returns the default value for zahlweise.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsDefaultValue("zahlweise")
    @IpsGenerated
    public Integer getDefaultValueZahlweise() {
        return defaultValueZahlweise;
    }

    /**
     * Sets the default value for zahlweise.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsDefaultValueSetter("zahlweise")
    @IpsGenerated
    public void setDefaultValueZahlweise(Integer defaultValueZahlweise) {
        if (getRepository() != null && !getRepository().isModifiable()) {
            throw new IllegalRepositoryModificationException();
        }
        this.defaultValueZahlweise = defaultValueZahlweise;
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
    public ValueSet<Integer> getAllowedValuesForZahlweise() {
        return allowedValuesForZahlweise;
    }

    /**
     * Sets the set of allowed values for the property zahlweise.
     *
     * @throws ClassCastException if the type of value set does not match the
     *                            property's configuration.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsAllowedValuesSetter("zahlweise")
    @IpsGenerated
    public void setAllowedValuesForZahlweise(ValueSet<Integer> allowedValuesForZahlweise) {
        if (getRepository() != null && !getRepository().isModifiable()) {
            throw new IllegalRepositoryModificationException();
        }
        this.allowedValuesForZahlweise = (OrderedValueSet<Integer>) allowedValuesForZahlweise;
    }

    /**
     * Returns the default value for wohnflaeche.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsDefaultValue("wohnflaeche")
    @IpsGenerated
    public Integer getDefaultValueWohnflaeche() {
        return defaultValueWohnflaeche;
    }

    /**
     * Sets the default value for wohnflaeche.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsDefaultValueSetter("wohnflaeche")
    @IpsGenerated
    public void setDefaultValueWohnflaeche(Integer defaultValueWohnflaeche) {
        if (getRepository() != null && !getRepository().isModifiable()) {
            throw new IllegalRepositoryModificationException();
        }
        this.defaultValueWohnflaeche = defaultValueWohnflaeche;
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
        return rangeForWohnflaeche;
    }

    /**
     * Sets the set of allowed values for the property wohnflaeche.
     *
     * @throws ClassCastException if the type of value set does not match the
     *                            property's configuration.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsAllowedValuesSetter("wohnflaeche")
    @IpsGenerated
    public void setAllowedValuesForWohnflaeche(ValueSet<Integer> rangeForWohnflaeche) {
        if (getRepository() != null && !getRepository().isModifiable()) {
            throw new IllegalRepositoryModificationException();
        }
        this.rangeForWohnflaeche = (IntegerRange) rangeForWohnflaeche;
    }

    /**
     * Returns the default value for versSumme.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsDefaultValue("versSumme")
    @IpsGenerated
    public Money getDefaultValueVersSumme() {
        return defaultValueVersSumme;
    }

    /**
     * Sets the default value for versSumme.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsDefaultValueSetter("versSumme")
    @IpsGenerated
    public void setDefaultValueVersSumme(Money defaultValueVersSumme) {
        if (getRepository() != null && !getRepository().isModifiable()) {
            throw new IllegalRepositoryModificationException();
        }
        this.defaultValueVersSumme = defaultValueVersSumme;
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
        return rangeForVersSumme;
    }

    /**
     * Sets the set of allowed values for the property versSumme.
     *
     * @throws ClassCastException if the type of value set does not match the
     *                            property's configuration.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsAllowedValuesSetter("versSumme")
    @IpsGenerated
    public void setAllowedValuesForVersSumme(ValueSet<Money> rangeForVersSumme) {
        if (getRepository() != null && !getRepository().isModifiable()) {
            throw new IllegalRepositoryModificationException();
        }
        this.rangeForVersSumme = (MoneyRange) rangeForVersSumme;
    }

    /**
     * Returns the referenced HausratGrunddeckungstyp or <code>null</code> if there
     * is no referenced HausratGrunddeckungstyp.
     *
     * @throws org.faktorips.runtime.ProductCmptNotFoundException if a product
     *                                                            component is
     *                                                            referenced but can
     *                                                            not be found.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsAssociation(name = "HausratGrunddeckungstyp", pluralName = "", kind = AssociationKind.Composition, targetClass = HausratGrunddeckungstyp.class, min = 1, max = 1)
    @IpsMatchingAssociation(source = HausratVertrag.class, name = "HausratGrunddeckung")
    @IpsGenerated
    public HausratGrunddeckungstyp getHausratGrunddeckungstyp() {
        return hausratGrunddeckungstyp != null ? hausratGrunddeckungstyp.getTarget() : null;
    }

    /**
     * Sets the new HausratGrunddeckungstyp.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsAssociationAdder(association = "HausratGrunddeckungstyp")
    @IpsGenerated
    public void setHausratGrunddeckungstyp(HausratGrunddeckungstyp target) {
        if (getRepository() != null && !getRepository().isModifiable()) {
            throw new IllegalRepositoryModificationException();
        }
        hausratGrunddeckungstyp = (target == null ? null
                : new ProductComponentLink<>(this, target, "HausratGrunddeckungstyp"));
    }

    /**
     * Sets the new HausratGrunddeckungstyp with the given cardinality.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsAssociationAdder(association = "HausratGrunddeckungstyp", withCardinality = true)
    @IpsGenerated
    public void setHausratGrunddeckungstyp(HausratGrunddeckungstyp target, CardinalityRange cardinality) {
        if (getRepository() != null && !getRepository().isModifiable()) {
            throw new IllegalRepositoryModificationException();
        }
        hausratGrunddeckungstyp = (target == null ? null
                : new ProductComponentLink<>(this, target, cardinality, "HausratGrunddeckungstyp"));
    }

    /**
     * Returns the <code>ILink</code> to the HausratGrunddeckungstyp or
     * <code>null</code>, if no object is referenced.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsAssociationLinks(association = "HausratGrunddeckungstyp")
    @IpsGenerated
    public IProductComponentLink<HausratGrunddeckungstyp> getLinkForHausratGrunddeckungstyp() {
        return hausratGrunddeckungstyp;
    }

    /**
     * Returns the <code>ILink</code> to the HausratGrunddeckungstyp at the
     * indicated index.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsGenerated
    public IProductComponentLink<HausratGrunddeckungstyp> getLinkForHausratGrunddeckungstyp(
            HausratGrunddeckungstyp productComponent) {
        return hausratGrunddeckungstyp != null && hausratGrunddeckungstyp.getTargetId().equals(productComponent.getId())
                ? hausratGrunddeckungstyp
                : null;
    }

    /**
     * Returns the cardinality for the number of allowed instanced for
     * HausratGrunddeckung.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsGenerated
    public CardinalityRange getCardinalityForHausratGrunddeckung(HausratGrunddeckungstyp productCmpt) {
        if (productCmpt != null) {
            return hausratGrunddeckungstyp != null && hausratGrunddeckungstyp.getTargetId().equals(productCmpt.getId())
                    ? hausratGrunddeckungstyp.getCardinality()
                    : null;
        }
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @generated
     */
    @Override
    @IpsGenerated
    protected void doInitPropertiesFromXml(Map<String, Element> configMap) {
        super.doInitPropertiesFromXml(configMap);
        doInitProduktname(configMap);
        doInitKurzbezeichnung(configMap);
        doInitVorschlagVersSummeProQm(configMap);
        doInitZahlweise(configMap);
        doInitWohnflaeche(configMap);
        doInitVersSumme(configMap);
    }

    /**
     * @generated
     */
    @IpsGenerated
    private void doInitProduktname(Map<String, Element> configMap) {
        Element configElement = configMap.get(PROPERTY_PRODUKTNAME);
        if (configElement != null) {
            String value = ValueToXmlHelper.getValueFromElement(configElement, ValueToXmlHelper.XML_TAG_VALUE);
            this.produktname = value;
        }
    }

    /**
     * @generated
     */
    @IpsGenerated
    private void doInitKurzbezeichnung(Map<String, Element> configMap) {
        Element configElement = configMap.get(PROPERTY_KURZBEZEICHNUNG);
        if (configElement != null) {
            String value = ValueToXmlHelper.getValueFromElement(configElement, ValueToXmlHelper.XML_TAG_VALUE);
            this.kurzbezeichnung = value;
        }
    }

    /**
     * @generated
     */
    @IpsGenerated
    private void doInitVorschlagVersSummeProQm(Map<String, Element> configMap) {
        Element configElement = configMap.get(PROPERTY_VORSCHLAGVERSSUMMEPROQM);
        if (configElement != null) {
            String value = ValueToXmlHelper.getValueFromElement(configElement, ValueToXmlHelper.XML_TAG_VALUE);
            this.vorschlagVersSummeProQm = Money.valueOf(value);
        }
    }

    /**
     * @generated
     */
    @IpsGenerated
    private void doInitZahlweise(Map<String, Element> configMap) {
        Element defaultValueElement = configMap
                .get(ValueToXmlHelper.CONFIGURED_DEFAULT_PREFIX + HausratVertrag.PROPERTY_ZAHLWEISE);
        if (defaultValueElement != null) {
            String value = ValueToXmlHelper.getValueFromElement(defaultValueElement);
            defaultValueZahlweise = IpsStringUtils.isEmpty(value) ? null : Integer.valueOf(value);
        }
        Element valueSetElement = configMap
                .get(ValueToXmlHelper.CONFIGURED_VALUE_SET_PREFIX + HausratVertrag.PROPERTY_ZAHLWEISE);
        if (valueSetElement != null) {
            EnumValues values = ValueToXmlHelper.getEnumValueSetFromElement(valueSetElement,
                    ValueToXmlHelper.XML_TAG_VALUE_SET);
            if (values != null) {
                List<Integer> enumValues = new ArrayList<>();
                for (int i = 0; i < values.getNumberOfValues(); i++) {
                    enumValues.add(
                            IpsStringUtils.isEmpty(values.getValue(i)) ? null : Integer.valueOf(values.getValue(i)));
                }
                allowedValuesForZahlweise = new OrderedValueSet<>(enumValues, values.containsNull(), null);
            }
        }
    }

    /**
     * @generated
     */
    @IpsGenerated
    private void doInitWohnflaeche(Map<String, Element> configMap) {
        Element defaultValueElement = configMap
                .get(ValueToXmlHelper.CONFIGURED_DEFAULT_PREFIX + HausratVertrag.PROPERTY_WOHNFLAECHE);
        if (defaultValueElement != null) {
            String value = ValueToXmlHelper.getValueFromElement(defaultValueElement);
            defaultValueWohnflaeche = IpsStringUtils.isEmpty(value) ? null : Integer.valueOf(value);
        }
        Element valueSetElement = configMap
                .get(ValueToXmlHelper.CONFIGURED_VALUE_SET_PREFIX + HausratVertrag.PROPERTY_WOHNFLAECHE);
        if (valueSetElement != null) {
            Range range = ValueToXmlHelper.getRangeFromElement(valueSetElement, ValueToXmlHelper.XML_TAG_VALUE_SET);
            if (range != null) {
                if (range.isEmpty()) {
                    rangeForWohnflaeche = IntegerRange.empty();
                } else {
                    rangeForWohnflaeche = IntegerRange.valueOf(range.getLower(), range.getUpper(), range.getStep(),
                            range.containsNull());
                }
            }
        }
    }

    /**
     * @generated
     */
    @IpsGenerated
    private void doInitVersSumme(Map<String, Element> configMap) {
        Element defaultValueElement = configMap
                .get(ValueToXmlHelper.CONFIGURED_DEFAULT_PREFIX + HausratVertrag.PROPERTY_VERSSUMME);
        if (defaultValueElement != null) {
            String value = ValueToXmlHelper.getValueFromElement(defaultValueElement);
            defaultValueVersSumme = Money.valueOf(value);
        }
        Element valueSetElement = configMap
                .get(ValueToXmlHelper.CONFIGURED_VALUE_SET_PREFIX + HausratVertrag.PROPERTY_VERSSUMME);
        if (valueSetElement != null) {
            Range range = ValueToXmlHelper.getRangeFromElement(valueSetElement, ValueToXmlHelper.XML_TAG_VALUE_SET);
            if (range != null) {
                if (range.isEmpty()) {
                    rangeForVersSumme = MoneyRange.empty();
                } else {
                    rangeForVersSumme = MoneyRange.valueOf(range.getLower(), range.getUpper(), range.getStep(),
                            range.containsNull());
                }
            }
        }
    }

    /**
     * @generated
     */
    @Override
    @IpsGenerated
    protected void doInitReferencesFromXml(Map<String, List<Element>> elementsMap) {
        super.doInitReferencesFromXml(elementsMap);
        doInitHausratGrunddeckungstyp(elementsMap);
    }

    /**
     * @generated
     */
    @IpsGenerated
    private void doInitHausratGrunddeckungstyp(Map<String, List<Element>> elementsMap) {
        List<Element> associationElements = elementsMap.get(XML_TAG_HAUSRAT_GRUNDDECKUNGSTYP);
        if (associationElements != null) {
            Element element = associationElements.get(0);
            hausratGrunddeckungstyp = new ProductComponentLink<>(this);
            hausratGrunddeckungstyp.initFromXml(element);
        }
    }

    /**
     * Creates a new HausratVertrag that is configured.
     *
     * @generated
     */
    @IpsGenerated
    public HausratVertrag createHausratVertrag() {
        HausratVertrag policy = new HausratVertrag(this);
        policy.initialize();
        return policy;
    }

    /**
     * {@inheritDoc}
     *
     * @generated
     */
    @Override
    @IpsGenerated
    public HausratVertrag createPolicyComponent() {
        return createHausratVertrag();
    }

    /**
     * {@inheritDoc}
     *
     * @generated
     */
    @Override
    @IpsGenerated
    public IProductComponentLink<? extends IProductComponent> getLink(String linkName, IProductComponent target) {
        if ("HausratGrunddeckungstyp".equals(linkName)) {
            return getLinkForHausratGrunddeckungstyp((HausratGrunddeckungstyp) target);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @generated
     */
    @Override
    @IpsGenerated
    public List<IProductComponentLink<? extends IProductComponent>> getLinks() {
        List<IProductComponentLink<? extends IProductComponent>> list = new ArrayList<>();
        if (getLinkForHausratGrunddeckungstyp() != null) {
            list.add(getLinkForHausratGrunddeckungstyp());
        }
        return list;
    }

}
