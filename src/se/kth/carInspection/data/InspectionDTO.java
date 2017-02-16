package se.kth.carInspection.data;

/**
 * Contains information about one particular inspection.
 * 
 * @author Lena Shervarly
 * @version 0.1
 */
public class InspectionDTO {

    private final String description;
    private final int cost;

    /**
     * Creates a new instance representing a particular inspection.
     * 
     * @param description The full description of one particular inspection. For example "Cheking the wheels"
     * @param cost The cost of this inspection
     */
    public InspectionDTO(String description, int cost) {
        this.description = description;
        this.cost = cost;
    }
    
     /**
     * Get the description of one inspection
     * @return description of one inspection
     */
    public String getDesctription() {
        return description;
    }
    /**
     * Get the cost for providing one inspection
     * @return the cost for providing one inspection
     */
    public int getCost() {
        return cost;
    }
}
