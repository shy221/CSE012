import student.*;
/**
 * this class is used to create a calculator class
 * @author Shenyi Yu
 * @version Sep,3,2018 
 */
public class SimpleCalculatorTest extends TestCase {
    /**
     * @param calc
     */
    private SimpleCalculator calc;    
    /**
     * create a new CalculatorTest object
     */
    public SimpleCalculatorTest() {
        //empty constructor
    }
    /**
     * set up
     */
    public void setUp() {
        calc = new SimpleCalculator(2.0, 3.0, '+');
    }
    /**
     * test GetOperand1
     */
    public void testGetOperand1() {
        assertEquals(2.0, calc.getOperand1(), 0.01);
    }
    /**
     * test GetOperand2
     */    
    public void testGetOperand2() {
        assertEquals(3.0, calc.getOperand2(), 0.01);
    }
    /**
     * test GetOperator
     */    
    public void testGetOperator()
    {
        assertEquals('+', calc.getOperator());
    }
    /**
     * test SetProcessorSpeed
     */
    public void testSetOperand1() {
        calc.setOperand1(2.0);
        assertEquals(2.0, calc.getOperand1(), 0.01);
    }
    /**
     * test SetProcessorSpeed
     */
    public void testSetOperand2() {
        calc.setOperand2(3.0);
        assertEquals(3.0, calc.getOperand2(), 0.01);
    }
    /**
     * test SetProcessorSpeed
     */
    public void testSetOperator() {
        calc.setOperator('+');
        assertEquals('+', calc.getOperator());
    }
    /**
     * test ComputeOperation
     */
    public void testComputeOperation() {        
        calc.setOperator('+');
        assertEquals(5.0, calc.computeOperation(), 0.01);
        calc.setOperator('-');
        assertEquals(-1.0, calc.computeOperation(), 0.01);
        calc.setOperator('*');
        assertEquals(6.0, calc.computeOperation(), 0.01);
        calc.setOperator('/');
        assertEquals(0.67, calc.computeOperation(), 0.01);
    }    
}
