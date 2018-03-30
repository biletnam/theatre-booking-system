package tbs.server;

import java.util.ArrayList;

public class Theatre
{
    private ArrayList<Act> actList;
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
     * Returns a string representation of the theatre's ID.
     *
     * @return a string representation of the theatre's ID.
     */
    @Override
    public String toString()
    {
        return "Theatre " + ID;
    }
}
