package de.faktorips.schulung.hausratmodell.hausrat;

import org.faktorips.runtime.model.annotation.IpsDocumented;
import org.faktorips.runtime.model.annotation.IpsEnumType;
import org.faktorips.runtime.model.annotation.IpsExtensibleEnum;
import java.io.Serializable;
import org.faktorips.runtime.IRuntimeRepository;
import org.faktorips.runtime.model.annotation.IpsEnumAttribute;
import org.faktorips.runtime.IRuntimeRepositoryLookup;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.InvalidObjectException;
import org.faktorips.runtime.annotation.IpsGenerated;

/**
 *
 * @since 1.0
 *
 * @generated
 */
@IpsDocumented(bundleName = "de.faktorips.schulung.hausratmodell.model-label-and-descriptions", defaultLocale = "de")
@IpsEnumType(name = "hausrat.Risikoklasse", attributeNames = { "id", "name" })
@IpsExtensibleEnum(enumContentName = "Risikoklasse")
public final class Risikoklasse implements Serializable, Comparable<Risikoklasse> {

    /**
     * The SerialVersionUID.
     *
     * @generated
     */
    public static final long serialVersionUID = 2L;
    /**
     * @generated
     */
    private final int index;
    /**
     * @since 1.0
     *
     * @generated
     */
    private final String id;
    /**
     * @since 1.0
     *
     * @generated
     */
    private final String name;
    /**
     * @generated
     */
    private final IRuntimeRepository productRepository;

    /**
     * Creates a new instance of Risikoklasse.
     *
     * @param productRepository The runtime repository is used to evaluate other
     *                          enumeration contents and for de-/serialization.
     *
     * @generated
     */
    @IpsGenerated
    protected Risikoklasse(int index, String idString, String nameString, IRuntimeRepository productRepository) {
        this.index = index;
        this.id = idString;
        this.name = nameString;
        this.productRepository = productRepository;
    }

    /**
     * Creates a new instance of Risikoklasse.
     *
     * @generated
     */
    @IpsGenerated
    public Risikoklasse(int index, String id, String name) {
        this.index = index;
        this.id = id;
        this.name = name;
        this.productRepository = null;
    }

    /**
     * Returns the value of the attribute id.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsEnumAttribute(name = "id", identifier = true, unique = true)
    @IpsGenerated
    public String getId() {
        return id;
    }

    /**
     * Returns the value of the attribute name.
     *
     * @since 1.0
     *
     * @generated
     */
    @IpsEnumAttribute(name = "name", unique = true, displayName = true)
    @IpsGenerated
    public String getName() {
        return name;
    }

    /**
     * {@inheritDoc}
     *
     * @generated
     */
    @Override
    @IpsGenerated
    public String toString() {
        return "Risikoklasse: " + id + '(' + name + ')';
    }

    /**
     * {@inheritDoc}
     *
     * @generated
     */
    @Override
    @IpsGenerated
    public boolean equals(Object obj) {
        if (obj instanceof Risikoklasse) {
            return this.getId().equals(((Risikoklasse) obj).getId());
        }
        return false;
    }

    /**
     * {@inheritDoc}
     *
     * @generated
     */
    @Override
    @IpsGenerated
    public int hashCode() {
        return getId().hashCode();
    }

    /**
     * This method mustn't be deleted. This method is used (via the java reflection
     * mechanism) by the runtime repository to identify this enumeration value.
     *
     * @generated
     */
    @IpsGenerated
    Object getEnumValueId() {
        return id;
    }

    /**
     * @generated
     */
    @Override
    @IpsGenerated
    public int compareTo(Risikoklasse o) {
        return index - o.index;
    }

    /**
     * @generated
     */
    @IpsGenerated
    private Object writeReplace() {
        return new SerializationProxy(id, getRepositoryLookup());
    }

    /**
     * @generated
     */
    @IpsGenerated
    private IRuntimeRepositoryLookup getRepositoryLookup() {
        if (productRepository != null) {
            IRuntimeRepositoryLookup runtimeRepositoryLookup = productRepository.getRuntimeRepositoryLookup();
            if (runtimeRepositoryLookup == null) {
                throw new IllegalStateException(
                        "For serialization of Risikoklasse instances you need to set an IRuntimeRepositoryLookup in your runtime repository.");
            }
            return runtimeRepositoryLookup;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    @IpsGenerated
    private void readObject(@SuppressWarnings("unused") ObjectInputStream s) throws IOException {
        throw new InvalidObjectException("SerializationProxy required");
    }

    /**
     * @generated
     */
    private static class SerializationProxy implements Serializable {
        private static final long serialVersionUID = 1L;

        private final String id;
        private final IRuntimeRepositoryLookup runtimeRepositoryLookup;

        /**
         * @generated
         */
        @IpsGenerated
        SerializationProxy(String id, IRuntimeRepositoryLookup runtimeRepositoryLookup) {
            this.id = id;
            this.runtimeRepositoryLookup = runtimeRepositoryLookup;
        }

        /**
         * @generated
         */
        @IpsGenerated
        private Object readResolve() {
            return runtimeRepositoryLookup.getRuntimeRepository().getEnumValue(Risikoklasse.class, id);
        }
    }
}
