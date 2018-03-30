package tbs.server;

public class Act implements Identifiable
{
    private Artist artist; //the artist putting on this act
    private final String ID;

    public Act(Artist artist, String ID)
    {
        this.artist = artist;
        this.ID = ID;
    }

    @Override
    public String getID()
    {
        return null;
    }
}
