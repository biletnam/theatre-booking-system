package tbs.server;

public class Seat extends Identifiable
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
     * @throws ClassCastException if the specified object is not an Identifiable
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
    public int compareTo(Identifiable other)
    {
        return super.compareTo(other);
    }

    public void issueTicket()
    {
        ticketIssued = true;
    }

    public boolean ticketIsIssued()
    {
        return ticketIssued;
    }

    public int getRowNumber()
    {
        return rowNumber;
    }

    public int getSeatNumber()
    {
        return seatNumber;
    }

    public int getPrice()
    {
        return price;
    }
}

