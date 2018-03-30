package tbs.server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Identifiables<E extends tbs.server.Identifiable> extends HashSet<E>
{
    public List<String> getIDs()
    {
        List<String> IDs = new ArrayList<String>();

        for (Identifiable currentIdentifiable : this)
        {
            String currentID = currentIdentifiable.getID();
            IDs.add(currentID);
        }

        Collections.sort(IDs);
        return IDs;
    }
}
