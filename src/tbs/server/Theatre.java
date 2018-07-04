package tbs.server;

/**
 * A class representing a theatre.
 */
public class Theatre extends UniqueItem
{
    private final int NUM_ROWS;
    private final int FLOOR_AREA; //sq metres

    private UniqueItems<Act> actList = new UniqueItems<Act>();

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
        super(ID);
        this.NUM_ROWS = numRows;
        this.FLOOR_AREA = floorArea;
    }

    /**
     * Request the string representation of the theatre.
     *
     * @return A string representation of the theatre.
     */
    @Override
    public String toString()
    {
        return "Theatre " + getID() + ". It is fully furnished with a " + NUM_ROWS
                + " by " + NUM_ROWS + " seating area, and it has a floor space of "
                + FLOOR_AREA + " square metres.";
    }

    public int getNumRows()
    {
        return NUM_ROWS;
    }

}
