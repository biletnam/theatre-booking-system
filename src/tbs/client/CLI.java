package tbs.client;

import tbs.server.Artist;
import tbs.server.TBSServer;
import tbs.server.TBSServerImpl;
import tbs.server.Theatre;

import java.util.List;

public class CLI
{
    private static String[] someNames = {"Beethoven's Fifth Symphony", "Moonlight Sonata", "Beeblebrox", "Finding Nemo"
    , "Black Panther", "Hunger Games", "Good Kid, MAAD City", "Because the Internet", "Always Blow on the Pie",
"Royal Rumble", "Mucha Lucha", "Hamilton", "The Illiad", "The Half Blood Prince", "Logan", "Interstellar",
"Charlotte's Web", "West World", "The Process", "Country Cats 2", "The Witcher - Blood & Wine",
    "The Phantom of the Opera", "Civilization", "Songo de Volare", "Can't Stop, Wont Stop", "24"};

	public static void main(String[] args)
	{
		String path = "theatres1.csv";
		if (args.length > 0) {
			path = args[0]; // This allows a different file to be specified as an argument, but the default is theatres2.csv
		}
		TBSServer server = new TBSServerImpl();
		String result = server.initialise(path);
		System.out.println("Result from initialisation is {" + result + "}");  // Put in { } to make empty strings easier to see.
		//server.dump(); // Implement dump() to print something useful here to determine whether your initialise method has worked.

		List<String> debugList = server.getTheatreIDs();
		for (String id: debugList)
		{
			//System.out.println(id);
		}

		for (int i = 0; i < 7; i++)
		{
			String someID = server.addArtist("name" + i);
		}
		String artistID1 = server.addArtist("Ewan");
		//System.out.println("Result from adding artist 'Ewan' is {" + artistID1 + "}");
		server.dump(); // Check that the server has been updated

        List<String> ewansActs = server.getActIDsForArtist("7");
		
		String actID1 = server.addAct("Lecture 3b: Making Objects", artistID1, 50); // this also checks that the artist ID is used properly
		System.out.println("Result from adding act to artist 'Ewan' is {" + actID1 + "}");
		for (String artistID : server.getArtistIDs())
        {
            for (int i = 0; i < (int) (Math.random() * 3); i++)
            {
                String ID = server.addAct(someNames[(int) (Math.random() * someNames.length)],
                        artistID,
                        (int) (Math.random() * someNames.length));
                System.out.println("Act ID: " + ID);
            }
        }
		server.dump();
	}
}
