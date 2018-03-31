package tbs.server;

import java.util.ArrayList;
import java.util.List;

/**
 * A class representing objects that are unique from each other.
 * All Identifiable objects have an ID that is used to distinguish
 * and compare them. An Identifiable object should never be directly
 * created, therefore it is abstract.
 */
public abstract class Identifiable implements Comparable<Identifiable>
{
    private final String ID;

    /**
     * Creates and returns an identifiable.
     * @param id A unique string ID.
     */
    public Identifiable(String id)
    {
        this.ID = id;
    }

    /**
     * Returns a unique ID.
     * @return A string object representing a unique ID.
     */
    public String getID()
    {
        return ID;
    }

    /**
     * Indicates whether some other object is "equal to" this one
     * by comparing their unique IDs.
     *
     * @param obj the reference object with which to compare.
     * @return {@code true} if this object is the same as the obj
     * argument; {@code false} otherwise.
     * @throws ClassCastException   if the specified object is not an Identifiable
     */
    @Override
    public boolean equals(Object obj)
    {
        Identifiable other = (Identifiable) obj;
        return ID.equals(other.getID());
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * @param other the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(Identifiable other)
    {
        return getID().compareTo(other.getID());
    }
}
