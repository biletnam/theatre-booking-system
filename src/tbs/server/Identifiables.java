package tbs.server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * This class represents a collection of unique items.
 * @param <E> An object with the Identifiable type.
 */
public class Identifiables<E extends Identifiable> implements Iterable<E>
{
    private HashSet<E> items = new HashSet<E>();

    /**
     * Get a list of IDs for each element in the collection.
     * @return A List of Strings representing unique IDs.
     */
    public List<String> getIDs()
    {
        List<String> IDs = new ArrayList<String>();

        for (E currentIdentifiable : items)
        {
            String currentID = currentIdentifiable.getID();
            IDs.add(currentID);
        }

        Collections.sort(IDs);
        return IDs;
    }

    /**
     * Add an element to the collection.
     * @param uniqueObj Some identifiable with a unique ID.
     */
    public void add(E uniqueObj)
    {
        items.add(uniqueObj);
    }

    /**
     * Returns an iterator over elements of type Identifiable.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator()
    {
        return items.iterator();
    }
}
