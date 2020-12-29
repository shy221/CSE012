import student.*;
/**
 * this class is used to create a computer class
 * @author Shenyi Yu
 * @version Sep,3,2018 
 */
public class ComputerTest extends TestCase {
    
    /**
     * @param myComputer
     */
    private Computer myComputer;	

    /**
     * create a new ComputerTest object
     */
    public ComputerTest() {
        // empty constructor
    }
    /**
     * set up
     */
    public void setUp() {
        myComputer = new Computer("Core Duo", 2, 2.0);
    }
    /**
     * test GetProcessor
     */
    public void testGetProcessor() {
        assertEquals("Core Duo", myComputer.getProcessor());
    }
    /**
     * test GetNumCores
     */
    public void testGetNumCores() {
        assertEquals(2, myComputer.getNumCores());
    }
    /**
     * test GetProcessorSpeed
     */
    public void testGetProcessorSpeed() {
        assertEquals(2.0, myComputer.getProcessorSpeed(), 0.1);
    }
    /**
     * test SetProcessor
     */
    public void testSetProcessor() {
        myComputer.setProcessor("Core Duo");
        assertEquals("Core Duo", myComputer.getProcessor());
    }
    /**
     * test SetNumCores
     */
    public void testSetNumCores() {
        myComputer.setNumCores(2);
        assertEquals(2, myComputer.getNumCores());
    }
    /**
     * test SetProcessorSpeed
     */
    public void testSetProcessorSpeed() {
        myComputer.setProcessorSpeed(2.0);
        assertEquals(2.0, myComputer.getProcessorSpeed(), 0.1);
    }
    /**
     * test ComputePower
     */
    public void testComputePower() {        
        assertEquals(4.0, myComputer.computePower(), 0.1);
    }
    /**
     * test ToString
     */
    public void testToString() {
        assertEquals("Core Duo, 2 cores at 2.0GHz", myComputer.toString());
    }
}



	


	

