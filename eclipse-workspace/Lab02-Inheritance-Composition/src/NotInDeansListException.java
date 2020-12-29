/**
 * @author Shenyi Yu
 * @version Sep,14,2018 
 */
public class NotInDeansListException extends RuntimeException {
    /**
     * 
     */
    private static final long serialVersionUID = 4029295737794150271L;
    /**
     * Create a constructor
     */
    public NotInDeansListException() {
        super();
        
    }
    /**
     * @param message (the message)
     */
    public NotInDeansListException(String message) {
        super(message);
        
    }

}