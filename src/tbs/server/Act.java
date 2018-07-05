package tbs.server;

import java.util.List;

/**
 * A class representing a part of a show.
 * Each act can have multiple performances.
 */
public class Act extends UniqueItem
{
    private final Artist ARTIST;
    private final String TITLE;
    private final int DURATION; //in minutes

    private UniqueItems<Performance> performances = new UniqueItems<Performance>();

    /**
     * Create and returns an Act object.
     * @param artist The artist that is putting on this act.
     * @param ID A unique ID.
     */
    public Act(Artist artist, String ID, String title, int duration)
    {
        super(ID);
        this.ARTIST = artist;
        this.TITLE = title;
        this.DURATION = duration;
    }

    /**
     * @return A string representation of the object.
     */
    @Override
    public String toString()
    {
        return "Act -- ID: " + getID() + " \"" + TITLE + "\" by " + ARTIST
                + " - Duration: " + DURATION + " minutes.";
    }

    /**
     * @return The IDs of all the performances of this act.
     */
    public List<String> getPerformanceIDs()
    {
        return performances.getIDs();
    }

    /**
     * @return A collection of the performances of this act.
     */
    public UniqueItems<Performance> getPerformances()
    {
        return performances;
    }

    /**
     * Add a performance to this act.
     * @param performance The performance to be added to this act.
     */
    public void addPerformance(Performance performance)
    {
        performances.add(performance);
    }
}
