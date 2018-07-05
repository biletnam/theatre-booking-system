package tbs.server;

import java.util.List;

/**
 * A class representing an artist. Artists can
 * put on acts, each of which are broken down into
 * performances.
 */
public class Artist extends UniqueItem
{
    private String name;
    private UniqueItems<Act> acts = new UniqueItems<Act>(); //The acts that this artist is performing

    /**
     * Creates and returns an Artist object.
     *
     * @param name The name of the artist.
     * @param ID The artist's unique ID.
     */
    public Artist(String name, String ID)
    {
        super(ID);
        this.name = name;
    }

    /**
     * Returns the name of the artist.
     * @return The artist's name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString()
    {
        return "Artist " + getName() + " (ID: " + getID() + ")";
    }

    /**
     * @return A list of IDs of all the acts this artist is putting on.
     */
    public List<String> getActIDs()
    {
        return acts.getIDs();
    }

    /**
     * Adds an act to the collection of acts this artist is putting on.
     * @param act
     */
    public void addAct(Act act)
    {
        acts.add(act);
    }
}
