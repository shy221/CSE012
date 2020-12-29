/**
 * this class is used to create a simple calculator class
 * @author Shenyi Yu
 * @version Sep,3,2018 
 */
public class SimpleCalculator {
    private double operand1;
    private double operand2;
    private char operator;
    /**
     * create a calculator object
     * @param operand1 operand1
     * @param operand2 operand2
     * @param operator operator
     */  
    public SimpleCalculator(double operand1, double operand2, char operator) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operator = operator;
    }
    /**
     * @param operand1 operand1
     */
    public void setOperand1(double operand1) {
        this.operand1 = operand1;
    }
    /**
     * @param operand2 operand2
     */
    public void setOperand2(double operand2) {
        this.operand2 = operand2;
    }
    /**
     * @param operator operator
     */
    public void setOperator(char operator) {
        this.operator = operator;
    }
    /**
     * @return operand1
     */
    public double getOperand1() {
        return this.operand1;
    }
    /**
     * @return operand2
     */
    public double getOperand2() {
        return this.operand2;
    }
    /**
     * @return getProcessorSpeed
     */
    public char getOperator() {
        return this.operator;
    }
    /**
     * @return ComputeOperation
     */
    public double computeOperation() {
        double computeOperation = 0;
        if (operator == '+') {
            computeOperation = operand1 + operand2;
        }
        else if (operator == '*') {
            computeOperation = operand1 * operand2;
        }
        else if (operator == '-') {
            computeOperation = operand1 - operand2;
        }
        else if (operator == '/') {
            computeOperation = operand1 / operand2;
        }
        else {
            return 999.9;
        }
        return computeOperation;
    }
}
