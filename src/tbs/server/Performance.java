package tbs.server;

public class Performance extends Identifiable
{
    private Act act;

    public Performance(Act act, String ID)
    {
        super(ID);
        this.act = act;
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
}
