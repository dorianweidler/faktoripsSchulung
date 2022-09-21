package de.faktorips.schulung.hausratmodell.hausrat;

import org.faktorips.runtime.model.annotation.IpsPolicyCmptType;
import org.faktorips.runtime.model.annotation.IpsAttributes;
import org.faktorips.runtime.model.annotation.IpsAssociations;
import org.faktorips.runtime.model.annotation.IpsConfiguredBy;
import org.faktorips.runtime.model.annotation.IpsDocumented;
import org.faktorips.runtime.internal.AbstractModelObject;
import org.faktorips.runtime.IDeltaSupport;
import org.faktorips.runtime.ICopySupport;
import org.faktorips.runtime.IVisitorSupport;
import org.faktorips.runtime.IDependantObject;
import org.faktorips.runtime.IConfigurableModelObject;
import org.faktorips.valueset.ValueSet;
import org.faktorips.values.Decimal;
import org.faktorips.values.Money;
import org.faktorips.valueset.UnrestrictedValueSet;
import org.faktorips.runtime.model.annotation.IpsDefaultValue;
import org.faktorips.runtime.internal.ProductConfiguration;
import org.faktorips.runtime.model.annotation.IpsAllowedValues;
import org.faktorips.runtime.model.annotation.IpsAttribute;
import org.faktorips.runtime.model.type.AttributeKind;
import org.faktorips.runtime.model.type.ValueSetKind;
import org.faktorips.runtime.model.annotation.IpsAssociation;
import org.faktorips.runtime.model.type.AssociationKind;
import org.faktorips.runtime.model.annotation.IpsInverseAssociation;
import org.faktorips.runtime.model.annotation.IpsAssociationAdder;
import org.w3c.dom.Element;
import org.faktorips.runtime.IModelObjectDelta;
import org.faktorips.runtime.IModelObject;
import org.faktorips.runtime.IProductComponent;

import java.math.RoundingMode;
import java.util.Calendar;
import org.faktorips.runtime.IRuntimeRepository;
import org.faktorips.runtime.IObjectReferenceStore;
import org.faktorips.runtime.internal.XmlCallback;
import org.faktorips.runtime.IDeltaComputationOptions;
import org.faktorips.runtime.internal.ModelObjectDelta;
import java.util.Map;
import java.util.HashMap;
import org.faktorips.runtime.IModelObjectVisitor;
import org.faktorips.runtime.MessageList;
import org.faktorips.runtime.IValidationContext;
import org.faktorips.runtime.annotation.IpsGenerated;

/**
 * Implementation for HausratGrunddeckung.
 *
 * @since 1.0
 *
 * @generated
 */
@IpsPolicyCmptType(name = "hausrat.HausratGrunddeckung")
@IpsAttributes({ "jahresbasisbeitrag" })
@IpsAssociations({ "HausratVertrag" })
@IpsConfiguredBy(HausratGrunddeckungstyp.class)
@IpsDocumented(bundleName = "de.faktorips.schulung.hausratmodell.model-label-and-descriptions", defaultLocale = "de")
public class HausratGrunddeckung extends AbstractModelObject
        implements IDeltaSupport, ICopySupport, IVisitorSupport, IDependantObject, IConfigurableModelObject {

    /**
     * The name of the association hausratVertrag.
     *
     * @since 1.0
     *
     * @generated
     */
    public static final String ASSOCIATION_HAUSRAT_VERTRAG = "hausratVertrag";
    /**
     * The name of the property jahresbasisbeitrag.
     *
     * @since 1.0
     *
     * @generated
     */
    public static final String PROPERTY_JAHRESBASISBEITRAG = "jahresbasisbeitrag";
    /**
     * Max allowed values for property jahresbasisbeitrag.
     *
     * @since 1.0
     *
     * @generated
     */
    public static final ValueSet<Money> MAX_ALLOWED_VALUES_FOR_JAHRESBASISBEITRAG = new UnrestrictedValueSet<>(true);
    /**
     * The default value for jahresbasisbeitrag.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsDefaultValue("jahresbasisbeitrag")
    public static final Money DEFAULT_VALUE_FOR_JAHRESBASISBEITRAG = Money.NULL;
    /**
     * Member variable for jahresbasisbeitrag.
     *
     * @since 1.0
     *
     * @generated
     */
    private Money jahresbasisbeitrag = DEFAULT_VALUE_FOR_JAHRESBASISBEITRAG;
    /**
     * References the current product configuration.
     *
     * @generated
     */
    private ProductConfiguration productConfiguration;
    /**
     * Member variable for the parent object: HausratVertrag.
     *
     * @since 1.0
     *
     * @generated
     */
    private HausratVertrag hausratVertrag;

    /**
     * Creates a new HausratGrunddeckung.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsGenerated
    public HausratGrunddeckung() {
        super();
        productConfiguration = new ProductConfiguration();
    }

    /**
     * Creates a new HausratGrunddeckung.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsGenerated
    public HausratGrunddeckung(HausratGrunddeckungstyp productCmpt) {
        super();
        productConfiguration = new ProductConfiguration(productCmpt);
    }

    /**
     * Returns the set of allowed values for the property jahresbasisbeitrag.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsAllowedValues("jahresbasisbeitrag")
    @IpsGenerated
    public ValueSet<Money> getAllowedValuesForJahresbasisbeitrag() {
        return MAX_ALLOWED_VALUES_FOR_JAHRESBASISBEITRAG;
    }

    /**
     * Returns the jahresbasisbeitrag.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsAttribute(name = "jahresbasisbeitrag", kind = AttributeKind.DERIVED_BY_EXPLICIT_METHOD_CALL, valueSetKind = ValueSetKind.AllValues)
    @IpsGenerated
    public Money getJahresbasisbeitrag() {
        return jahresbasisbeitrag;
    }

    /**
     * Returns the referenced HausratVertrag.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsAssociation(name = "HausratVertrag", pluralName = "", kind = AssociationKind.CompositionToMaster, targetClass = HausratVertrag.class, min = 1, max = 1)
    @IpsInverseAssociation("HausratGrunddeckung")
    @IpsGenerated
    public HausratVertrag getHausratVertrag() {
        return hausratVertrag;
    }

    /**
     * @since 1.0
     *
     * @generated
     */
    @IpsAssociationAdder(association = "HausratVertrag")
    @IpsGenerated
    public void setHausratVertragInternal(HausratVertrag newParent) {
        if (getHausratVertrag() == newParent) {
            return;
        }
        IModelObject parent = getParentModelObject();
        if (newParent != null && parent != null) {
            throw new IllegalStateException(String.format(
                    "HausratGrunddeckung (\"%s\") can't be assigned to parent object of class HausratVertrag (\"%s\"), because object already belongs to the parent object (\"%s\").",
                    toString(), newParent.toString(), parent.toString()));
        }
        this.hausratVertrag = newParent;
        effectiveFromHasChanged();
    }

    /**
     *
     *
     * @since 1.0
     *
     * @generated not
     */
    public void berechneJahresbasisbeitrag() {
        Decimal beitragssatz = getTariftabelle().findRow(getHausratVertrag().getTarifzone()).getBeitragssatz();
        this.jahresbasisbeitrag = getHausratVertrag().getVersSumme()
                .divide(1000, RoundingMode.CEILING)
                .multiply(beitragssatz, RoundingMode.CEILING);
    }

    /**
     * Returns the table Tariftabelle referenced by the corresponding product
     * component.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsGenerated
    public TariftabelleHausrat getTariftabelle() {
        HausratGrunddeckungstyp productCmpt = getHausratGrunddeckungstyp();
        if (productCmpt == null) {
            return null;
        }
        return productCmpt.getTariftabelle();
    }

    /**
     * Initializes the object with the configured defaults.
     *
     * @restrainedmodifiable
     */
    @Override
    @IpsGenerated
    public void initialize() {
        // begin-user-code
        // end-user-code
    }

    /**
     * Returns the HausratGrunddeckungstyp that configures this object.
     *
     * @generated
     */
    @IpsGenerated
    public HausratGrunddeckungstyp getHausratGrunddeckungstyp() {
        return (HausratGrunddeckungstyp) getProductComponent();
    }

    /**
     * Sets the new HausratGrunddeckungstyp that configures this object.
     *
     * @param hausratGrunddeckungstyp                The new
     *                                               HausratGrunddeckungstyp.
     * @param initPropertiesWithConfiguratedDefaults <code>true</code> if the
     *                                               properties should be
     *                                               initialized with the defaults
     *                                               defined in the
     *                                               HausratGrunddeckungstyp.
     *
     * @generated
     */
    @IpsGenerated
    public void setHausratGrunddeckungstyp(HausratGrunddeckungstyp hausratGrunddeckungstyp,
            boolean initPropertiesWithConfiguratedDefaults) {
        setProductComponent(hausratGrunddeckungstyp);
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
        IModelObject parent = getParentModelObject();
        if (parent instanceof IConfigurableModelObject) {
            return ((IConfigurableModelObject) parent).getEffectiveFromAsCalendar();
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
    public IModelObject getParentModelObject() {
        if (hausratVertrag != null) {
            return hausratVertrag;
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
        doInitJahresbasisbeitrag(propMap);
    }

    /**
     * @generated
     */
    @IpsGenerated
    private void doInitJahresbasisbeitrag(Map<String, String> propMap) {
        if (propMap.containsKey(PROPERTY_JAHRESBASISBEITRAG)) {
            this.jahresbasisbeitrag = Money.valueOf(propMap.get(PROPERTY_JAHRESBASISBEITRAG));
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
        return null;
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
        if (!HausratGrunddeckung.class.isAssignableFrom(otherObject.getClass())) {
            return delta;
        }
        HausratGrunddeckung otherHausratGrunddeckung = (HausratGrunddeckung) otherObject;
        delta.checkPropertyChange(HausratGrunddeckung.PROPERTY_JAHRESBASISBEITRAG, jahresbasisbeitrag,
                otherHausratGrunddeckung.jahresbasisbeitrag, options);
        return delta;
    }

    /**
     * {@inheritDoc}
     *
     * @generated
     */
    @Override
    @IpsGenerated
    public HausratGrunddeckung newCopy() {
        Map<IModelObject, IModelObject> copyMap = new HashMap<>();
        HausratGrunddeckung newCopy = newCopyInternal(copyMap);
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
    public HausratGrunddeckung newCopyInternal(Map<IModelObject, IModelObject> copyMap) {
        HausratGrunddeckung newCopy = (HausratGrunddeckung) copyMap.get(this);
        if (newCopy == null) {
            newCopy = new HausratGrunddeckung();
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
    protected void copyProductCmptAndGenerationInternal(HausratGrunddeckung otherObject) {
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
        HausratGrunddeckung concreteCopy = (HausratGrunddeckung) copy;
        concreteCopy.jahresbasisbeitrag = jahresbasisbeitrag;
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
        // Nothing to do.
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

}
