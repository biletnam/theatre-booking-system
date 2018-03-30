package tbs.client;

import tbs.server.TBSServer;
import tbs.server.TBSServerImpl;
import tbs.server.Theatre;

import java.util.List;

public class CLI {
	public static void main(String[] args)
	{
		String path = "theatres1.csv";
		if (args.length > 0) {
			path = args[0]; // This allows a different file to be specified as an argument, but the default is theatres2.csv
		}
		TBSServer server = new TBSServerImpl();
		String result = server.initialise(path);
		System.out.println("Result from initialisation is {" + result + "}");  // Put in { } to make empty strings easier to see.
		server.dump(); // Implement dump() to print something useful here to determine whether your initialise method has worked.

		List<String> debugList = server.getTheatreIDs();
		for (String id: debugList)
		{
		//	System.out.println(id);
		}

		String artistID1 = server.addArtist("Ewan");
		//System.out.println("Result from adding artist 'Ewan' is {" + artistID1 + "}");
		//server.dump(); // Check that the server has been updated
		
		String actID1 = server.addAct("Lecture 3b: Making Objects", artistID1, 50); // this also checks that the artist ID is used properly
		//System.out.println("Result from adding act to artist 'Ewan' is {" + actID1 + "}");
		//server.dump();
	}
}
