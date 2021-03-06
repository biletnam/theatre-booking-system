package tbs.server;

/**
 * This class represents a seat. Seats are part of theatres, and their location is determined by a row and seat number.
 */
public class Seat extends UniqueItem
{
    private boolean ticketIssued = false;
    private int price;
    private int rowNumber;
    private int seatNumber;

    private String ticketID = getID();

    /**
     * Creates and returns an identifiable.
     *
     * @param id A unique string ID.
     */
    public Seat(String id, int rowNum, int seatNum, int price)
    {
        super(id);
        this.rowNumber = rowNum;
        this.seatNumber = seatNum;
        this.price = price;
    }

    /**
     * Returns a unique ID.
     *
     * @return A string object representing a unique ID.
     */
    @Override
    public String getID()
    {
        return super.getID();
    }

    public String getTicketID()
    {
        return ticketID;
    }

    /**
     * Indicates whether some other object is "equal to" this one
     * by comparing their unique IDs.
     *
     * @param obj the reference object with which to compare.
     * @return {@code true} if this object is the same as the obj
     * argument; {@code false} otherwise.
     * @throws ClassCastException if the specified object is not an UniqueItem
     */
    @Override
    public boolean equals(Object obj)
    {
        return super.equals(obj);
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
    public int compareTo(UniqueItem other)
    {
        return super.compareTo(other);
    }

    /**
     * Records the purchase of the ticket for this seat.
     */
    public void issueTicket()
    {
        ticketIssued = true;
    }

    /**
     * @return True or false, checks if the ticket for this seat has been issued.
     */
    public boolean ticketIsIssued()
    {
        return ticketIssued;
    }

    /**
     * @return The row number of this seat.
     */
    public int getRowNumber()
    {
        return rowNumber;
    }

    /**
     * @return The seat number of this seat. The seat number is how far down the row a seat is in.
     */
    public int getSeatNumber()
    {
        return seatNumber;
    }

    /**
     * @return The price of the ticket for this seat.
     */
    public int getPrice()
    {
        return price;
    }
}

