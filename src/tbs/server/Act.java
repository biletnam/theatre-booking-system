package tbs.server;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * A class representing a part of a show.
 * Each act can have multiple performances.
 */
public class Act extends Identifiable
{
    private final Artist ARTIST;
    private final String TITLE;
    private final int DURATION; //in minutes

    private Identifiables<Performance> performances = new Identifiables<Performance>();

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
        addPerformance(new Performance(this, ID + "P" + 0));
    }

    /**
     * Returns a string representation of the object.
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString()
    {
        return "Act -- ID: " + getID() + " \"" + TITLE + "\" by " + ARTIST
                + " - Duration: " + DURATION + " minutes.";
    }

    public List<String> getPerformanceIDs()
    {
        return performances.getIDs();
    }

    public List<Performance> getPerformances()
    {
        return new ArrayList<Performance>(performances.toSet());
    }

    public void addPerformance(Performance performance)
    {
        performances.add(performance);
    }
}
