package tbs.server;

import java.util.*;

/**
 * This class represents a collection of unique items.
 * @param <E> An object with the Identifiable type.
 */
public class Identifiables<E extends Identifiable> implements Iterable<E>
{
    private Set<E> items = new TreeSet<E>(); //using a tree set as it keeps items in order using comparable

    /**
     * Get a list of sorted IDs for each element in the collection.
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

    private List<Integer> getNumericIDs()
    {
        List<Integer> numericIDs = new ArrayList<Integer>();

        for (E currentIdentifiable : items)
        {
            String IDSections[] = currentIdentifiable.getID().split("-");
            Integer currentIDFrag = Integer.parseInt(IDSections[IDSections.length - 1]);
            numericIDs.add(currentIDFrag);
        }

        Collections.sort(numericIDs);
        return numericIDs;
    }

    private List<String> getNumericChildCollectionIDs(String prefix)
    {
        List<Integer> numericIDs = new ArrayList<Integer>();

        for (E currentIdentifiable : items)
        {
            String IDSections[] = currentIdentifiable.getID().split("-");
            Integer currentIDFrag = Integer.parseInt(IDSections[IDSections.length - 1]);
            numericIDs.add(currentIDFrag);
        }

        Collections.sort(numericIDs);
        List<String> stringIDs = new ArrayList<String>();
        for (int IDFrag : numericIDs)
        {
            String fullID = prefix + "-" + IDFrag;
            stringIDs.add(fullID);
        }

        return stringIDs;
    }

    /**
     * Add an element to the collection.
     * @param uniqueObj Some identifiable with a unique ID.
     */
    public void add(E uniqueObj)
    {
        items.add(uniqueObj);
    }

    public E findByID(String ID)
    {

        for (E currentIdentifiable : items)
        {
            if(currentIdentifiable.getID().equals(ID))
            {
                return currentIdentifiable;
            }
        }

        return null;
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

    public Set<E> toSet()
    {
        return items;
    }

    public String generateID(boolean isChildCollection, String parentPrefix)
    {
        String newID;
        if (!isChildCollection)
        {
            List<Integer> IDList = this.getNumericIDs();
            if (IDList.isEmpty())
            {
                newID = "0";
            }
            else
            {
                int prevID = IDList.get(IDList.size() - 1);
                newID = String.valueOf(prevID + 1);
            }
        }
        else
        {
            List<String> IDList = this.getNumericChildCollectionIDs(parentPrefix);

            if (IDList.isEmpty())
            {
                newID = parentPrefix + "-" + "0";
            }
            else
            {
                String prevID = IDList.get(IDList.size() - 1);
                String[] IDSections = prevID.split("-");
                int numericSubID = Integer.parseInt(IDSections[IDSections.length - 1]) + 1;
                newID = parentPrefix + "-" + String.valueOf(numericSubID);
            }
        }


        return newID;
    }

}
