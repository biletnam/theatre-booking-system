package tbs.server;

import java.util.*;

/**
 * This class represents a collection of unique items.
 * @param <E> An object with the UniqueItem type.
 */
public class UniqueItems<E extends UniqueItem> implements Iterable<E>
{
    private Set<E> items = new TreeSet<E>(); //using a tree set as it keeps items in order when using comparable

    /**
     * Numeric IDs are the segment (the last segment) of IDs made of digits. This method gets all the numeric
     * IDs.
     * @return A list of the numeric part of IDs.
     */
    private List<Integer> getNumericIDs()
    {
        List<Integer> numericIDs = new ArrayList<Integer>();

        for (E currentUniqueItem : items)
        {
            String IDSections[] = currentUniqueItem.getID().split("-");
            Integer currentIDFrag = Integer.parseInt(IDSections[IDSections.length - 1]);
            numericIDs.add(currentIDFrag);
        }

        Collections.sort(numericIDs);
        return numericIDs;
    }


    /**
     * Numeric IDs are the segment (the last segment) of IDs made of digits. Child collections are sub-groupings of a
     * particular type of group. For example, artists store a reference to acts they put on. A group of artists
     * may be a collection itself and their acts are a sub-grouping or child collection. This method returns all the
     * numeric IDs in a given child collection.
     *
     * @param prefix The prefix to the ID that determines the child collection.
     * @return
     */
    private List<String> getNumericChildCollectionIDs(String prefix)
    {
        List<Integer> numericIDs = new ArrayList<Integer>();

        for (E currentUniqueItem : items)
        {
            String IDSections[] = currentUniqueItem.getID().split("-");
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
     * Get a list of sorted IDs for each element in the collection.
     * @return A List of Strings representing unique IDs.
     */
    public List<String> getIDs()
    {
        List<String> IDs = new ArrayList<String>();

        for (E currentUniqueItem : items)
        {
            String currentID = currentUniqueItem.getID();
            IDs.add(currentID);
        }

        Collections.sort(IDs);
        return IDs;
    }

    /**
     * Add an element to the collection.
     * @param uniqueObj Some UniqueItem.
     */
    public void add(E uniqueObj)
    {
        items.add(uniqueObj);
    }

    /**
     * Finds a particular object by its ID.
     *
     * @param ID The ID used to search for the object.
     * @return The object associated with the ID.
     */
    public E findByID(String ID)
    {

        for (E currentUniqueItem : items)
        {
            if(currentUniqueItem.getID().equals(ID))
            {
                return currentUniqueItem;
            }
        }

        return null;
    }

    /**
     * @return An iterator over elements of type UniqueItem.
     */
    @Override
    public Iterator<E> iterator()
    {
        return items.iterator();
    }

    /**
     * @return A set representation of this collection.
     */
    public Set<E> toSet()
    {
        return items;
    }

    /**
     * Generates a new ID.
     *
     * @param isChildCollection A boolean representing whether or not this ID is part of a child collection.
     * @param parentPrefix The prefix to the ID. Ignored if isChildCollection is set to false.
     * @return
     */
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
