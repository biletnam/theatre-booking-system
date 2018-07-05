package tbs.server;

/**
 * This class represents all possible responses from the server.
 */
public enum ResponseMessages
{
    //Error Messages
    FILE_NOT_FOUND_ERR_MSG ("ERROR: the client could not find the file."),
    FILE_FORMAT_ERR_MSG ("ERROR: The format of the input file is incorrect."),
    DUPLICATE_CODE_ERR_MSG ("ERROR: The input file contains duplicate theatre codes."),
    DUPLICATE_NAME_ERR_MSG ("ERROR: Artist name already exists."),
    EMPTY_NAME_ERR_MSG ("ERROR: The input name or title is empty."),
    MISSING_ACTS_ERR_MSG ("ERROR: No acts found with specified artist ID."),
    MISSING_PERFORMANCES_ERR_MSG ("ERROR: No performances found with specified artist ID."),
    SCHEDULE_PERFORMANCE_ERR_MSG ("ERROR: There was an issue with scheduling the performance"),
    ISSUE_TICKET_ERR_MSG ("ERROR: There was a problem with issuing the ticket."),
    PERFORMANCE_NOT_FOUND_ERR_MSG ("ERROR: No performance found with specified ID."),
    ACT_NOT_FOUND_ERR_MSG ("ERROR: No act found with specified ID."),
    ARTIST_NOT_FOUND_ERR_MSG ("ERROR: No artist found with specified ID."),

    //Success Messages
    FILE_FOUND_SUCCESS_MSG ("");



    private final String description;

    /**
     * Create and return a ResponseMessage
     * @param description The message that is displayed to the user.
     */
    ResponseMessages(String description)
    {
        this.description = description;
    }

    /**
     * @return the ResponseMessage's description.
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * @return a string representation of the object.
     */
    @Override
    public String toString()
    {
        return description;
    }
}
