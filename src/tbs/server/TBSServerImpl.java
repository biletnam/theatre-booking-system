package tbs.server;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TBSServerImpl implements TBSServer
{
    private static final String FILE_NOT_FOUND_ERR_MSG = "Sorry, the client could not find the file.";
    private static final String FILE_FORMAT_ERR_MSG = "Sorry, the format of the input file is incorrect.";
    private static final String DUPLICATE_CODE_ERR_MSG = "Sorry, the input file contains duplicate theatre codes.";
    private static final String FILE_FOUND_SUCCESS_MSG = "";
    private static final String THEATRE_NAME_MARKER = "THEATRE";
    private static final String THEATRE_CODE_MARKER = ".*";

    private static List<Theatre> theatreList = new ArrayList<Theatre>();

    /**
     * Request the server to add the theatre details found in the file indicated by the path.
     * The details include the theatre ID (unique across all theatres), the seating dimension, and
     * the floor area (square metres). All theatres have as many seats in a row as they do rows, and the number of
     * rows is indicated by the seating dimension.
     * <p>
     * <p>The file format is, each line consists of
     * "THEATRE" "\t" &lt;theatre ID&gt; "\t" &lt;seating dimension&gt; "\t" &lt;floor area&gt;
     * <p>
     * <p>If there is no file associated with the path, or the file format is incorrect, then
     * the request fails.
     *
     * @param path The path indicating the file to use for the initialisation.
     * @return An empty string if the initialisation is successful, otherwise a
     * message explaining what went wrong beginning with ERROR (e.g. "ERROR incorrect format").
     * <p>
     * <p><b>Marks: 0</b> There are no marks specific to this method. If you do not implement this method, you
     * will be limited as to what else you can implement as this method is the only way to add theatres to
     * the server.
     */
    public String initialise(String path)
    {
        //IO
        File theatreFile = new File(path);
        Scanner fileScanner = null;

        try
        {
            fileScanner = new Scanner(theatreFile);
        }
        catch (FileNotFoundException e)
        {
            return FILE_NOT_FOUND_ERR_MSG;
        }


        String currentID = null;
        int numRows;
        int floorSpace;

        /*Loop through input file tokens, checks if format is correct and if so create a theatre object
        that corresponds with the given data. */
        while(fileScanner.hasNext())
        {
            if(fileScanner.hasNext(THEATRE_NAME_MARKER))
            {
                fileScanner.next();

                if(fileScanner.hasNext(THEATRE_CODE_MARKER))
                {
                    currentID = fileScanner.next();
                    if (getTheatreIDs().contains(currentID))
                    {
                        return DUPLICATE_CODE_ERR_MSG;
                    }

                    if (fileScanner.hasNextInt())
                    {
                        numRows = fileScanner.nextInt();

                        if (fileScanner.hasNextInt())
                        {
                            floorSpace = fileScanner.nextInt();
                        }
                        else
                        {
                            return FILE_FORMAT_ERR_MSG;
                        }
                    }
                    else
                    {
                        return FILE_FORMAT_ERR_MSG;
                    }
                }
                else
                {
                    return FILE_FORMAT_ERR_MSG;
                }
            }
            else
            {
                return FILE_FORMAT_ERR_MSG;
            }

            Theatre newTheatre = new Theatre(currentID, numRows, floorSpace);
            theatreList.add(newTheatre);
        }

        fileScanner.close();
        return FILE_FOUND_SUCCESS_MSG;
    }

    /**
     * Request a list of the IDs for all theatres.
     *
     * @return A list of theatre IDs in alphabetical order.
     * <p>
     * <p><b>Marks: 1</b>
     */
    @Override
    public List<String> getTheatreIDs()
    {
        List<String> theatreIDs = new ArrayList<String>();

        for (Theatre currentTheatre : theatreList)
        {
            String currentID = currentTheatre.getID();
            theatreIDs.add(currentID);
        }

        Collections.sort(theatreIDs);
        return theatreIDs;
    }

    /**
     * Request a list of the IDs for all artists.
     *
     * @return A list of artist IDs in alphabetical order.
     * <p>
     * <p><b>Marks: 1</b>
     */
    @Override
    public List<String> getArtistIDs()
    {
        return null;
    }

    /**
     * Request a list of the names for all artists.
     *
     * @return A list of artist names in alphabetical order
     * <p>
     * <p><b>Marks: 1</b>
     */
    @Override
    public List<String> getArtistNames()
    {
        return null;
    }

    /**
     * Request a list of the IDs for all acts by the artist with the specified ID.
     * <p>If there is a problem with the artist ID (is empty, or there is no artist with that ID)
     * then the request fails.
     *
     * @param artistID The ID to be used to identify the artist
     * @return A list of act IDs in alphabetical order.
     * If the request fails, there should be exactly one entry in the list, and that will be a message explaining
     * what went wrong, beginning with ERROR (e.g. "ERROR no act with specified ID").
     * <p>
     * <p><b>Marks: 1</b>
     */
    @Override
    public List<String> getActIDsForArtist(String artistID)
    {
        return null;
    }

    /**
     * Request a list of the IDs for all performances for the act with the specified ID.
     * <p>If there is a problem with the act ID (is empty, or there is no act with that ID)
     * then the request fails.
     *
     * @param actID The ID to be used to identify the act.
     * @return A list of performance IDs in alphabetical order
     * If the request fails, there should be exactly one entry in the list, and that will be a message explaining
     * what went wrong, beginning with ERROR (e.g. "ERROR actID is empty").
     * <p>
     * <p><b>Marks: 1</b>
     */
    @Override
    public List<String> getPeformanceIDsForAct(String actID)
    {
        return null;
    }

    /**
     * Request a list of the IDs for all tickets issued for the performance with the specified ID.
     * <p>If there is a problem with the performance ID (is empty, or there is no performance with that ID)
     * then the request fails.
     *
     * @param performanceID The ID to be used to identify the performance.
     * @return A list of ticket IDs in alphabetical order
     * If the request fails, there should be exactly one entry in the list, and that will be a message explaining
     * what went wrong, beginning with ERROR (e.g. "ERROR no performance with specified ID").
     * <p>
     * <p><b>Marks: 1</b>
     */
    @Override
    public List<String> getTicketIDsForPerformance(String performanceID)
    {
        return null;
    }

    /**
     * Request that an artist with the specified name be added to the server.
     * <p>If there is a problem with the name (is empty, or there is already
     * an artist with the same name) then the request fails.
     *
     * @param name The name of the artist.
     * @return The ID for the new artist if the addition is successful, otherwise a
     * message explaining what went wrong, beginning with ERROR (e.g. "ERROR artist already exists").
     * The ID must be unique to all artists but is otherwise implementation dependent.
     * <p>
     * <p><b>Marks: 1</b>
     */
    @Override
    public String addArtist(String name)
    {
        return null;
    }

    /**
     * Request that an act by the specified artist with the specified title and of the specified duration be added
     * to the server.
     * <p>If there is a problem with the title (is empty), artist ID (is not unique or is empty), or
     * duration (is less than or equal to zero), then the request fails.
     *
     * @param title           The title of the act
     * @param artistID        The ID to be used to identify the artist
     * @param minutesDuration The time that the act will take in minutes
     * @return The ID for the new act if the addition is successful, otherwise a
     * message explaining what went wrong, beginning with ERROR (e.g. "ERROR title is empty").
     * The ID must be unique to all acts but is otherwise implementation dependent.
     * <p>
     * <p><b>Marks: 1</b>
     */
    @Override
    public String addAct(String title, String artistID, int minutesDuration)
    {
        return null;
    }

    /**
     * Request the server to schedule a performance for the act with the specified ID in the theatre with the specified
     * ID, starting at the specified time and with the specified seat prices. Different performances
     * can have different seat prices (e.g. Monday-Thursday are cheaper than Friday and Saturday).
     * The premium price applies to the seats in the rows closest to the stage, which in this case
     * are rows 1 to floor(Number of Rows/2). The remaining seats have the cheap seat price.
     * For example, if the seating dimension is 5, then rows 1-2 will be premium, and 3-5 cheap.
     * <p>
     * <p>If there is a problem with the act ID (is not unique), theatre ID (no such theatre exists),
     * or other parameters (wrong format), then the request fails.
     *
     * @param actID           The ID that identifies the act. It must be unique with respect to acts already managed by the server.
     * @param theatreID       The ID of the theatre. There must be a theatre with this ID.
     * @param startTimeStr    The start time for this performance. It must be in the ISO8601 format yyyy-mm-ddThh:mm (zero-padded)
     * @param premiumPriceStr The price for the premium seats. It must be in the format $d where &lt;d&gt; is the number of dollars.
     * @param cheapSeatsStr   The price for the cheap seats. It must be in the format $d where &lt;d&gt; is the number of dollars.
     * @return The ID for the new performance if the addition is successful, otherwise a
     * message explaining what went wrong, beginning with ERROR (e.g. "ERROR theatre with theatre ID does not exist").
     * The ID must be unique to all performances but is otherwise implementation dependent.
     * <p>
     * <p><b>Marks: 2</b>
     */
    @Override
    public String schedulePerformance(String actID, String theatreID, String startTimeStr, String premiumPriceStr, String cheapSeatsStr)
    {
        return null;
    }

    /**
     * Request the server to issue a ticket for the performance with the specified ID and for the seat
     * at the specified location.
     * <p>If there is a problem with the performance ID (no performance with that ID exists), or the seat (the
     * seat doesn't exist, or a ticket for it has already been issued), then the request fails.
     *
     * @param performanceID The ID for the performance the ticket should be issued for.
     * @param rowNumber     The row the seat is in
     * @param seatNumber    The number of the seat in the row.
     * @return The ID for the new ticket if the issue is successful, otherwise a
     * message explaining what went wrong, beginning with ERROR (e.g. "ERROR seat has already been taken").
     * The ID must be unique to all tickets but is otherwise implementation dependent.
     * <p>
     * <p><b>Marks: 2</b>
     */
    @Override
    public String issueTicket(String performanceID, int rowNumber, int seatNumber)
    {
        return null;
    }

    /**
     * Request the server to supply a list of the seats that are still available for the performance with
     * the specified ID.
     * <p>The request fails if there is no performance with the specified ID.
     *
     * @param performanceID The ID for the performance to determine the available seats for.
     * @return A list of strings, with each string representing a seat that is available.
     * The format of the string is &lt;row number&gt; "\t" &lt;seat position&gt; (that is the two numbers
     * separated by a tab character).
     * <p>If the request fails, then the only entry in the list will be a message explaining what went wrong,
     * beginning with ERROR.
     * <p>
     * <p><b>Marks: 2</b>
     */
    @Override
    public List<String> seatsAvailable(String performanceID)
    {
        return null;
    }

    /**
     * Request the server to supply a list reporting the sales for the act with the specified ID.
     * <p>The request fails if there is no act with the specified ID.
     *
     * @param actID The ID of the act that the sales report should be generated for.
     * @return A list of strings, with each string representing the sales report for a performance schedule for the act.
     * The format of the string is:<br>
     * &lt;performanceID&gt; "\t" &lt;start time&gt; "\t" &lt;number of tickets sold&gt; "\t' &lt;totals sales receipts for performance&gt;<br>
     * The sales receipts is the sum of the prices for the tickets that have been sold.
     * <p>If the request fails, then the only entry in the list will be a message explaining what went wrong, beginning with ERROR
     * <p>
     * <p><b>Marks: 2</b>
     */
    @Override
    public List<String> salesReport(String actID)
    {
        return null;
    }

    /**
     * Request a list of strings containing information the TBS Server has that is relevant. Implement this how you
     * like to support any debugging you need to do.
     *
     * @return A list of strings that in some way describe information that the TBS Server has.
     * <p>
     * <p><b>Marks: 0</b> This will not be marked. It is for your convenience for debugging.
     */
    public List<String> dump()
    {
        List<String> results = new ArrayList<String>();
        System.out.println("\n-------Dump begins here-------");
        for (int i = 0; i < theatreList.size(); i++)
        {
           results.add(theatreList.get(i).toString());
           System.out.println(theatreList.get(i).toString());
        }

        System.out.println("-------Dump ends here-------\n");
        return results;
    }
}