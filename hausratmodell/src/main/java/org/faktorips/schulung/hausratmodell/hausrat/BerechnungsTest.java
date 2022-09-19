package org.faktorips.schulung.hausratmodell.hausrat;

import org.faktorips.runtime.test.IpsTestCase2;
import javax.xml.parsers.ParserConfigurationException;
import org.faktorips.runtime.test.IpsTestResult;
import org.w3c.dom.Element;
import org.faktorips.runtime.annotation.IpsGenerated;
import org.faktorips.runtime.formula.groovy.GroovyFormulaEvaluatorFactory;
import org.faktorips.runtime.IObjectReferenceStore;
import org.faktorips.runtime.IRuntimeRepository;
import org.faktorips.runtime.ClassloaderRuntimeRepository;
import org.faktorips.runtime.DefaultObjectReferenceStore;
import org.faktorips.runtime.DefaultReferenceResolver;
import org.faktorips.runtime.internal.XmlUtil;
import org.faktorips.runtime.internal.XmlCallback;
import org.faktorips.runtime.IModelObject;
import java.util.Map;
import org.faktorips.values.Money;

/**
 * Instanzen dieser Klasse sind fachliche Testfaelle. Das Testen der fachlichen
 * Logik findet in der Methode executeAsserts() statt. Die Daten fuer die
 * Testfaelle werden von FaktorIPS-Testfaellen geliefert, die auf dem
 * Testfalltyp basieren, auf dessen Basis auch diese Klasse generiert wird.
 *
 * @generated
 */
public class BerechnungsTest extends IpsTestCase2 {

    /**
     * @generated
     */
    public static final String TESTATTR_HAUSRAT_VERTRAG_TARIFZONE = "tarifzone";
    /**
     * @generated
     */
    public static final String TESTATTR_HAUSRAT_VERTRAG_VORSCHLAG_VERS_SUMME = "vorschlagVersSumme";
    /**
     * @generated
     */
    public static final String TESTATTR_HAUSRAT_GRUNDDECKUNG_BEITRAG_GEMAESS_ZAHLWEISE = "beitragGemaessZahlweise";
    /**
     * @generated
     */
    public static final String TESTATTR_HAUSRAT_ZUSATZDECKUNG_VERS_SUMME = "versSumme";
    /**
     * @generated
     */
    public static final String TESTATTR_HAUSRAT_ZUSATZDECKUNG_JAHRESBASISBEITRAG = "jahresbasisbeitrag";
    /**
     * @generated
     */
    private HausratVertrag inputHausratVertrag;
    /**
     * @generated
     */
    private HausratVertrag erwartetHausratVertrag;

    /**
     * Erzeugt eine neue Instanz des Testfalls.
     *
     * @restrainedmodifiable
     */
    @IpsGenerated
    public BerechnungsTest(String qualifiedName) throws ParserConfigurationException {
        super(qualifiedName);
        // begin-user-code
        // end-user-code
    }

    /**
     * Fuehrt die zu testende Geschaeftslogik aus.
     *
     * @restrainedmodifiable
     */
    @Override
    @IpsGenerated
    public void executeBusinessLogic() {
        // begin-user-code
        inputHausratVertrag.getHausratGrunddeckung().berechneJahresbasisbeitrag();
        // end-user-code
    }

    @Override
    public void setRepository(IRuntimeRepository runtimeRepository) {
        ((ClassloaderRuntimeRepository) runtimeRepository)
                .setFormulaEvaluatorFactory(new GroovyFormulaEvaluatorFactory());
        super.setRepository(runtimeRepository);
    }

    /**
     * Fuehrt die Pruefungen (Asserts) aus, d.h. vergleicht die erwarteten Werten
     * mit den tatsaechlichen Ergebnissen.
     * <p>
     * Dies geschieht analog zu JUnit mit Aufrufen von assert(..) Methoden. Zum
     * Beispiel assertEquals(erwartetVertrag.getBeitrag(),
     * inputVertrag.getBeitrag(), result); Um das getestete Objekt bzw. das Attribut
     * genauer zu beschreiben, kann zusaetzlich der Name des getesteten Objektes und
     * der Attributname uebergeben werden, bei der Ausfuehrung als Faktor-Ips
     * Testfall, wird dann im Fehlerfall das entsprechende Attribut-Feld im
     * Testfalleditor als rot gekennzeichnet. Der Name des Objektes bzw. der Name
     * des Attributes, muss gleich dem im Testfalltyp definierten Namen sein. Es
     * muss immer der komplette Pfad zu dem Testobjekt angegeben werden, wobei die
     * einzelnen Testobjekte auf den unterschiedlichen Ebenen (Root/Parent/Child)
     * durch "." getrennt werden muessen. Wenn im Testfall mehrere Instanzen des
     * gleiche Testobjektes vorhanden sind, muss ein Index an den Namen (getrennt
     * durch "#") angefuegt werden. Beispiel:
     * assertEquals(erwartetVertrag.getBeitrag(), inputVertrag.getBeitrag(), result,
     * "Police#0.Vertrag#0", "beitrag");
     *
     * @restrainedmodifiable
     */
    @Override
    @IpsGenerated

    /**
     */
    public void executeAsserts(IpsTestResult result) {
        // begin-user-code

        assertEquals(getExtensionAttributeValue(erwartetHausratVertrag, TESTATTR_HAUSRAT_VERTRAG_VORSCHLAG_VERS_SUMME),
                inputHausratVertrag.getVorschlagVersSumme(), result, "HausratVertrag#0",
                TESTATTR_HAUSRAT_VERTRAG_VORSCHLAG_VERS_SUMME);

        assertEquals(getExtensionAttributeValue(erwartetHausratVertrag, TESTATTR_HAUSRAT_VERTRAG_TARIFZONE),
                inputHausratVertrag.getTarifzone(), result, "HausratVertrag#0", TESTATTR_HAUSRAT_VERTRAG_TARIFZONE);

        HausratGrunddeckung erwartetGrunddeckung = erwartetHausratVertrag.getHausratGrunddeckung();
        HausratGrunddeckung inputGrunddeckung = inputHausratVertrag.getHausratGrunddeckung();

        assertEquals(erwartetGrunddeckung.getJahresbasisbeitrag(), inputGrunddeckung.getJahresbasisbeitrag(), result,
                "HausratVertrag#0.HausratGrunddeckung#0", HausratGrunddeckung.PROPERTY_JAHRESBASISBEITRAG);

        assertEquals(
                getExtensionAttributeValue(erwartetGrunddeckung,
                        TESTATTR_HAUSRAT_GRUNDDECKUNG_BEITRAG_GEMAESS_ZAHLWEISE),
                inputGrunddeckung.getBeitragGemaessZahlweise(), result, "HausratVertrag#0.HausratGrunddeckung#0",
                TESTATTR_HAUSRAT_GRUNDDECKUNG_BEITRAG_GEMAESS_ZAHLWEISE);

        for (int i = 0; i < erwartetHausratVertrag.getNumOfHausratZusatzdeckungen(); i++) {
            HausratZusatzdeckung erwartetZusatzdeckung = erwartetHausratVertrag.getHausratZusatzdeckung(i);
            HausratZusatzdeckung inputZusatzdeckung = inputHausratVertrag.getHausratZusatzdeckung(i);

            assertEquals(getExtensionAttributeValue(erwartetZusatzdeckung, TESTATTR_HAUSRAT_ZUSATZDECKUNG_VERS_SUMME),
                    inputZusatzdeckung.getVersSumme(), result, "HausratVertrag#0.HausratZusatzdeckung#" + i,
                    TESTATTR_HAUSRAT_ZUSATZDECKUNG_VERS_SUMME);

            assertEquals(
                    getExtensionAttributeValue(erwartetZusatzdeckung,
                            TESTATTR_HAUSRAT_ZUSATZDECKUNG_JAHRESBASISBEITRAG),
                    inputZusatzdeckung.getJahresbasisbeitrag(), result, "HausratVertrag#0.HausratZusatzdeckung#" + i,
                    TESTATTR_HAUSRAT_ZUSATZDECKUNG_JAHRESBASISBEITRAG);
        }

        // end-user-code
    }

    /**
     * Initialisiert die Eingabewerte aus dem XML.
     *
     * @restrainedmodifiable
     */
    @Override
    @IpsGenerated

    /**
     */
    public void initInputFromXml(Element element) {
        // begin-user-code
        // end-user-code
        IObjectReferenceStore objectReferenceStore = new DefaultObjectReferenceStore();
        Element childElement = null;
        HausratVertragXmlCallback hausratVertragXmlCallback = new HausratVertragXmlCallback(true);
        childElement = XmlUtil.getFirstElement(element, "HausratVertrag");
        if (childElement != null) {
            try {
                String className = childElement.getAttribute("class");
                inputHausratVertrag = (HausratVertrag) Class
                        .forName(className, true, HausratVertrag.class.getClassLoader()).getConstructor().newInstance();
                inputHausratVertrag.initFromXml(childElement, true, getRepository(), objectReferenceStore,
                        hausratVertragXmlCallback);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        try {
            new DefaultReferenceResolver().resolve(objectReferenceStore);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Initialisiert die erwarteten Werte aus dem XML.
     *
     * @restrainedmodifiable
     */
    @Override
    @IpsGenerated

    /**
     */
    public void initExpectedResultFromXml(Element element) {
        // begin-user-code
        // end-user-code
        IObjectReferenceStore objectReferenceStore = new DefaultObjectReferenceStore();
        Element childElement = null;
        HausratVertragXmlCallback hausratVertragXmlCallback = new HausratVertragXmlCallback(false);
        childElement = XmlUtil.getFirstElement(element, "HausratVertrag");
        if (childElement != null) {
            try {
                String className = childElement.getAttribute("class");
                erwartetHausratVertrag = (HausratVertrag) Class
                        .forName(className, true, HausratVertrag.class.getClassLoader()).getConstructor().newInstance();
                erwartetHausratVertrag.initFromXml(childElement, true, getRepository(), objectReferenceStore,
                        hausratVertragXmlCallback);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        try {
            new DefaultReferenceResolver().resolve(objectReferenceStore);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * XMLCallback Klasse fuer den Testparameter HausratVertrag.
     *
     * @generated
     */
    private class HausratVertragXmlCallback implements XmlCallback {
        /**
         * Gibt an ob die Klasse fuer die Input (<code>true</code>) oder fuer die
         * erwarteten Werte (<code>false</code>) verwendet wird.
         *
         * @generated
         */
        private boolean input;

        /**
         * Erzeugt eine neue XMLCallback Klasse fuer den Testparameter HausratVertrag.
         *
         * @generated
         */
        @IpsGenerated
        public HausratVertragXmlCallback(boolean input) {
            this.input = input;
        }

        /**
         * {@inheritDoc}
         *
         * @generated
         */
        @Override
        @IpsGenerated
        public void initProperties(String pathFromAggregateRoot, IModelObject modelObject,
                Map<String, String> propMap) {
            if (pathFromAggregateRoot.equals("/HausratVertrag")) {
                String value = null;
                if (!input) {
                    value = propMap.get(TESTATTR_HAUSRAT_VERTRAG_TARIFZONE);
                    addExtensionAttribute(modelObject, TESTATTR_HAUSRAT_VERTRAG_TARIFZONE, value);
                }
                if (!input) {
                    value = propMap.get(TESTATTR_HAUSRAT_VERTRAG_VORSCHLAG_VERS_SUMME);
                    addExtensionAttribute(modelObject, TESTATTR_HAUSRAT_VERTRAG_VORSCHLAG_VERS_SUMME,
                            Money.valueOf(value));
                }
            }
            if (pathFromAggregateRoot.equals("/HausratVertrag/HausratGrunddeckung")) {
                String value = null;
                if (!input) {
                    value = propMap.get(TESTATTR_HAUSRAT_GRUNDDECKUNG_BEITRAG_GEMAESS_ZAHLWEISE);
                    addExtensionAttribute(modelObject, TESTATTR_HAUSRAT_GRUNDDECKUNG_BEITRAG_GEMAESS_ZAHLWEISE,
                            Money.valueOf(value));
                }
            }
            if (pathFromAggregateRoot.equals("/HausratVertrag/HausratZusatzdeckung")) {
                String value = null;
                if (!input) {
                    value = propMap.get(TESTATTR_HAUSRAT_ZUSATZDECKUNG_VERS_SUMME);
                    addExtensionAttribute(modelObject, TESTATTR_HAUSRAT_ZUSATZDECKUNG_VERS_SUMME, Money.valueOf(value));
                }
                if (!input) {
                    value = propMap.get(TESTATTR_HAUSRAT_ZUSATZDECKUNG_JAHRESBASISBEITRAG);
                    addExtensionAttribute(modelObject, TESTATTR_HAUSRAT_ZUSATZDECKUNG_JAHRESBASISBEITRAG,
                            Money.valueOf(value));
                }
            }
        }

    }

}
