/**
 * @author Shenyi Yu
 * @version Sep,14,2018 
 */
public class NotInAcademicProbationException extends RuntimeException {
    /**
     * 
     */
    private static final long serialVersionUID = 2222238255775983841L;
    /**
     * Constructor
     */
    public NotInAcademicProbationException() {
        super();
        
    }
    /**
     * @param message message
     */
    public NotInAcademicProbationException(String message) {
        super(message);   
    }
}    
