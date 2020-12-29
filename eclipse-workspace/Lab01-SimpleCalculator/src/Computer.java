/**
 * this class is used to create a computer class
 * 
 * @author Shenyi Yu
 * @version Sep,3,2018
 */
public class Computer {
    private String processor;
    private int numCores;
    private double processorSpeed;

    /**
     * create a computer object
     * 
     * @param processor      processor of the computer
     * @param numCores       number of cores
     * @param processorSpeed the speed of the processor of the computer
     */
    public Computer(String processor, int numCores, double processorSpeed) {
        this.processor = processor;
        this.numCores = numCores;
        this.processorSpeed = processorSpeed;
    }

    /**
     * @param processor processor
     */
    public void setProcessor(String processor) {
        this.processor = processor;
    }

    /**
     * @param numCores numCores
     */
    public void setNumCores(int numCores) {
        this.numCores = numCores;
    }

    /**
     * @param processorSpeed processorSpeed
     */
    public void setProcessorSpeed(double processorSpeed) {
        this.processorSpeed = processorSpeed;
    }

    /**
     * @return processor
     */
    public String getProcessor() {
        return this.processor;
    }

    /**
     * @return numCores
     */
    public int getNumCores() {
        return this.numCores;
    }

    /**
     * @return ProcessorSpeed
     */
    public double getProcessorSpeed() {
        return this.processorSpeed;
    }

    /**
     * @return computePower
     */
    public double computePower() {
        double computePower = this.numCores * this.processorSpeed;
        return computePower;
    }

    /**
     * @return toString
     */
    public String toString() {
        return this.processor + ", " 
                + this.numCores + " cores at " + this.processorSpeed + "GHz";
    }
}
