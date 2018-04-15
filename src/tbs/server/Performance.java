package tbs.server;

import java.util.ArrayList;
import java.util.List;

public class Performance extends Identifiable
{
    private int cheapSeatPrice;
    private int premiuimSeatPrice;
    private int numTicketsSold = 0;
    private int totalSalesReceipt = 0;

    private String startTime;
    private Act act;
    private Theatre theatre;

    private Identifiables<Seat> seats = new Identifiables<Seat>();

    private Seat[][] seatArray;

    private List<String> issuedTicketIDs = new ArrayList<String>();


    public Performance(Act act, Theatre theatre, String ID, String startTime, String premiumPrice,
                       String cheapPrice)
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
     * Returns a string representation of the object.
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString()
    {
        return "Performance " + getID() + " of " + act + ".";
    }

    private Integer priceToInteger(String dollarPrice)
    {
        return Integer.parseInt(dollarPrice.substring(1)); //remove the first character (dollar sign) from string and then convert the rest into an int
    }

    private Identifiables<Seat> getSeats()
    {
        return seats;
    }

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

    public Theatre getTheatre()
    {
        return theatre;
    }

    public Seat findSeatByLocation(int rowNumber, int seatNumber)
    {
        return seatArray[rowNumber - 1][seatNumber - 1];
    }

    public void issueTicket(Seat seat)
    {
        seat.issueTicket();
        numTicketsSold++;
        totalSalesReceipt += seat.getPrice();
        issuedTicketIDs.add(seat.getTicketID());
    }

    public String generateSalesReport()
    {
        String performanceReport = "" + getID() + "\t" + startTime + "\t" + numTicketsSold + "\t" + "$" + totalSalesReceipt;
        return performanceReport;
    }

    public List<String> getIssuedTicketIDs()
    {
        return issuedTicketIDs;
    }
}
