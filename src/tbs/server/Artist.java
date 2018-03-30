package tbs.server;

import java.util.List;

public class Artist implements Identifiable, Comparable<Artist>
{
    private final String ID;

    private String name;
    private List<Act> acts; //The acts that this artist is performing

    /**
     * Creates and returns an Artist object.
     *
     * @param name The name of the artist.
     * @param ID The artist's unique ID.
     */
    public Artist(String name, String ID)
    {
        this.ID = ID;
        this.name = name;
    }

    @Override
    public String getID()
    {
        return ID;
    }

    public String getName()
    {
        return name;
    }

    /**
     * Compares this artist with another artist using their respective IDs.
     * Sorted in lexicographical order.
     *
     * @param other the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(Artist other)
    {
        return this.getID().compareTo(other.getID());
    }

    /**
     * Returns a string representation of the object.
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString()
    {
        return "Artist " + getName() + " " + getID();
    }
}
