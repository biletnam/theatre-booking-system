package tbs.server;

import java.util.ArrayList;
import java.util.List;

public class Theatre implements Comparable<Theatre>
{
    private List<Act> actList = new ArrayList<Act>();
    private int[][] seats;
    private String ID;
    private int numRows;
    private int floorArea; //sq metres

    public Theatre(String ID, int numRows, int floorArea)
    {
        this.ID = ID;
        this.numRows = numRows;
        this.floorArea = floorArea;
    }

    /**
     * Request the theatre's ID.
     * @return The theatre's ID.
     */
    public String getID()
    {
        return ID;
    }

    /**
     * Request the string representation of the theatre.
     *
     * @return A string representation of the theatre.
     */
    @Override
    public String toString()
    {
        return "Theatre " + ID + ". It is fully furnished with a " + numRows
                + " by " + numRows + " seating area, and it has a floor space of "
                + floorArea + " square metres!";
    }

    /**
     * Compares this theatre's ID with another theatre's ID in lexicographical order.
     * Returns a negative integer, zero, or a positive integer as this theatre's ID
     * is less than, equal to, or greater than the specified theatre's ID.
     *
     * @param other the theatre to be compared.
     * @return a negative integer, zero, or a positive integer as this theatre's ID
     * is less than, equal to, or greater than the specified theatre's ID.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(Theatre other)
    {
        return this.getID().compareTo(other.getID());
    }
}
