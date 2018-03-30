package tbs.server;

import java.util.ArrayList;
import java.util.List;

public class Theatre implements Comparable<Theatre>, Identifiable
{
    private final String ID;
    private final int NUM_ROWS;
    private final int FLOOR_AREA; //sq metres

    private List<Act> actList = new ArrayList<Act>();
    private int[][] seats;

    /**
     * Creates and returns a theatre object.
     *
     * @param ID The unique ID of the theatre.
     * @param numRows This represents both the number of rows and the
     *                the number of seats in each row.
     * @param floorArea The area of theatre in square metres.
     */
    public Theatre(String ID, int numRows, int floorArea)
    {
        this.ID = ID;
        this.NUM_ROWS = numRows;
        this.FLOOR_AREA = floorArea;
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
        return "Theatre " + ID + ". It is fully furnished with a " + NUM_ROWS
                + " by " + NUM_ROWS + " seating area, and it has a floor space of "
                + FLOOR_AREA + " square metres!";
    }

    /**
     * Compares this theatre with another theatre using their respective IDs.
     * Sorted in lexicographical order.
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
