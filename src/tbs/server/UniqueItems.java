package tbs.server;

import java.util.*;

/**
 * This class represents a collection of unique items.
 * @param <E> An object with the UniqueItem type.
 */
public class UniqueItems<E extends UniqueItem> implements Iterable<E>
{
    private Set<E> items = new TreeSet<E>(); //using a tree set as it keeps items in order when using comparable

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
     * Returns an iterator over elements of type UniqueItem.
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
