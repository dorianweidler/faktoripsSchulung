package de.faktorips.schulung.hausratmodell.hausrat;

import org.faktorips.runtime.model.annotation.IpsProductCmptType;
import org.faktorips.runtime.model.annotation.IpsConfigures;
import org.faktorips.runtime.model.annotation.IpsDocumented;
import org.faktorips.runtime.internal.ProductComponent;
import org.faktorips.runtime.IRuntimeRepository;
import org.w3c.dom.Element;
import java.util.Map;
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
@IpsDocumented(bundleName = "de.faktorips.schulung.hausratmodell.model-label-and-descriptions", defaultLocale = "de")
public class HausratGrunddeckungstyp extends ProductComponent {

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
