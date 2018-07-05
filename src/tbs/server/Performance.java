package tbs.server;

import java.util.ArrayList;
import java.util.List;

/**
 * A class representing a performance. Performances make up acts, which are performed by artists.
 */
public class Performance extends UniqueItem
{
    private int cheapSeatPrice;
    private int premiuimSeatPrice;
    private int numTicketsSold = 0;
    private int totalSalesReceipt = 0;

    private String startTime;
    private Act act;
    private Theatre theatre;

    private UniqueItems<Seat> seats = new UniqueItems<Seat>();

    private Seat[][] seatArray;

    private List<String> issuedTicketIDs = new ArrayList<String>();


    /**
     * Creates and returns a performance object.
     *
     * @param act The act that this performance is part of.
     * @param theatre The theatre this this performance will performed at.
     * @param ID The unique identifier of this performance.
     * @param startTime The time that this performance will begin.
     * @param premiumPrice The cost of attending this performance in an expensive seat.
     * @param cheapPrice The cost of attending this performance in a basic seat.
     */
    public Performance(Act act, Theatre theatre, String ID, String startTime, String premiumPrice, String cheapPrice)
    {
        super(ID);
        this.act = act;
        this.theatre = theatre;
        this.startTime = startTime;
        this.cheapSeatPrice = priceToInteger(cheapPrice);
        this.premiuimSeatPrice = priceToInteger(premiumPrice);

        int numRows = this.theatre.getNumRows();
        int currentPrice = premiuimSeatPrice;
        int firstCheapRow = (numRows / 2) + 1;
        seatArray = new Seat[numRows][numRows];

        for (int row = 0; row < numRows; row++)
        {
            if(row == firstCheapRow - 1)
            {
                currentPrice = cheapSeatPrice;
            }

            for (int col = 0; col < numRows; col++)
            {
                String seatID = getSeats().generateID(true, getID());
                Seat newSeat = new Seat(seatID, row + 1, col + 1, currentPrice);
                getSeats().add(newSeat);
                seatArray[row][col] = newSeat;
            }
        }
    }
    /**
     * @return A string representation of the object.
     */
    @Override
    public String toString()
    {
        return "Performance " + getID() + " of " + act + ".";
    }

    /**
     * Converts a money value from a string to an Integer
     * @param dollarPrice The value to be converted.
     * @return The converted integer value.
     */
    private Integer priceToInteger(String dollarPrice)
    {
        //removes the first character (dollar sign) from the string and then convert the rest into an Integer
        return Integer.parseInt(dollarPrice.substring(1));
    }

    /**
     * @return A collection of seats for this performance.
     */
    private UniqueItems<Seat> getSeats()
    {
        return seats;
    }

    /**
     * @return A list of seats (represented as Strings) that are available to be purchased.
     */
    public List<String> getAvailableSeats()
    {
        List<String> availableSeats = new ArrayList<String>();
        for (Seat seat : getSeats())
        {
            //if the ticket has not been issued, add the appropriate info to the list
            if (!seat.ticketIsIssued())
            {
                String currentSeatPosition = "" + seat.getRowNumber() + "\t" + seat.getSeatNumber();
                availableSeats.add(currentSeatPosition);
            }
        }

        return availableSeats;
    }

    /**
     * @return The theatre in which this performance will take place.
     */
    public Theatre getTheatre()
    {
        return theatre;
    }

    /**
     * Returns the seat from the given location.
     * @param rowNumber The row the seat is located in.
     * @param seatNumber The column the seat is located in, or how far down the row the seat is.
     * @return A seat object at the given location.
     */
    public Seat findSeatByLocation(int rowNumber, int seatNumber)
    {
        return seatArray[rowNumber - 1][seatNumber - 1];
    }

    /**
     * Issues a ticket for a seat, and record appropiate stats.
     * @param seat The seat that has been purchased.
     */
    public void issueTicket(Seat seat)
    {
        seat.issueTicket();
        numTicketsSold++;
        totalSalesReceipt += seat.getPrice();
        issuedTicketIDs.add(seat.getTicketID());
    }

    /**
     * Return statistics regarding the performance and sales.
     * @return
     */
    public String generateSalesReport()
    {
        String performanceReport = "" + getID() + "\t" + startTime + "\t" + numTicketsSold + "\t" + "$" + totalSalesReceipt;
        return performanceReport;
    }

    /**
     * @return A collection of the issued ticket IDs.
     */
    public List<String> getIssuedTicketIDs()
    {
        return issuedTicketIDs;
    }
}
