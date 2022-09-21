package de.faktorips.schulung.hausratmodell.hausrat;

import org.faktorips.runtime.model.annotation.IpsProductCmptType;
import org.faktorips.runtime.model.annotation.IpsConfigures;
import org.faktorips.runtime.model.annotation.IpsTableUsages;
import org.faktorips.runtime.model.annotation.IpsDocumented;
import org.faktorips.runtime.internal.ProductComponent;
import org.faktorips.runtime.IRuntimeRepository;
import org.faktorips.runtime.model.annotation.IpsTableUsage;
import org.faktorips.runtime.IllegalRepositoryModificationException;
import org.w3c.dom.Element;
import java.util.Map;
import org.faktorips.runtime.internal.ValueToXmlHelper;
import org.faktorips.runtime.annotation.IpsGenerated;

/**
 * Implementation for HausratGrunddeckungstyp.
 *
 * @since 1.0
 *
 * @generated
 */
@IpsProductCmptType(name = "hausrat.HausratGrunddeckungstyp")
@IpsConfigures(HausratGrunddeckung.class)
@IpsTableUsages({ "Tariftabelle" })
@IpsDocumented(bundleName = "de.faktorips.schulung.hausratmodell.model-label-and-descriptions", defaultLocale = "de")
public class HausratGrunddeckungstyp extends ProductComponent {

    /**
     * The property name of the table Tariftabelle.
     *
     * @since 1.0
     *
     * @generated
     */
    public static final String TABLE_TARIFTABELLE = "Tariftabelle";
    /**
     * The name of the table used as Tariftabelle.
     *
     * @since 1.0
     *
     * @generated
     */
    private String tariftabelleName = null;

    /**
     * Creates a new HausratGrunddeckungstyp.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsGenerated
    public HausratGrunddeckungstyp(IRuntimeRepository repository, String id, String kindId, String versionId) {
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
     * Returns the table used as Tariftabelle.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsTableUsage(name = "Tariftabelle")
    @IpsGenerated
    public TariftabelleHausrat getTariftabelle() {
        if (tariftabelleName == null) {
            return null;
        }
        return (TariftabelleHausrat) getRepository().getTable(tariftabelleName);
    }

    /**
     * Sets the name of the table used as TariftabelleName.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsGenerated
    public void setTariftabelleName(String tableName) {
        if (getRepository() != null && !getRepository().isModifiable()) {
            throw new IllegalRepositoryModificationException();
        }
        this.tariftabelleName = tableName;
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
    }

    /**
     * @generated
     */
    @Override
    @IpsGenerated
    protected void doInitTableUsagesFromXml(Map<String, Element> tableUsageMap) {
        super.doInitTableUsagesFromXml(tableUsageMap);
        doInitTariftabelle(tableUsageMap);
    }

    /**
     * @generated
     */
    @IpsGenerated
    private void doInitTariftabelle(Map<String, Element> tableUsageMap) {
        Element element = tableUsageMap.get(TABLE_TARIFTABELLE);
        if (element != null) {
            tariftabelleName = ValueToXmlHelper.getValueFromElement(element,
                    ValueToXmlHelper.XML_TAG_TABLE_CONTENT_NAME);
        }
    }

    /**
     * Creates a new HausratGrunddeckung that is configured.
     *
     * @generated
     */
    @IpsGenerated
    public HausratGrunddeckung createHausratGrunddeckung() {
        HausratGrunddeckung policy = new HausratGrunddeckung(this);
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
    public HausratGrunddeckung createPolicyComponent() {
        return createHausratGrunddeckung();
    }

}
