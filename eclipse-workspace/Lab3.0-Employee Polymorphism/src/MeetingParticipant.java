// -------------------------------------------------------------------------
/**
 *  This interface represents an individual who can participate in meetings
 *  with other participants.
 *
 *  @author  Partner 1's name (pid)
 *  @author  Partner 2's name (pid)
 *  @version (place the date here, in this format: yyyy.mm.dd)
 */
public interface MeetingParticipant
{
    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Gets the name of the meeting participant.
     * @return the name of the meeting participant
     */
    public String getName();


    // ----------------------------------------------------------
    /**
     * Returns a message to announce that this participant is joining the
     * given participant in a meeting.
     * @param otherParticipant the other meeting participant
     * @return a message describing the nature of the meeting
     */
    public String meetWith(MeetingParticipant otherParticipant);
}
