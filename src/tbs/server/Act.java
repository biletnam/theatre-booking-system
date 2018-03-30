package tbs.server;

/**
 * A class representing a part of a show.
 * Each act can have multiple performances.
 */
public class Act extends Identifiable
{
    private Artist artist;

    /**
     * Create and returns an Act object.
     * @param artist The artist that is putting on this act.
     * @param ID A unique ID.
     */
    public Act(Artist artist, String ID)
    {
        super(ID);
        this.artist = artist;
    }
}
