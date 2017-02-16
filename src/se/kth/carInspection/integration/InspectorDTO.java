package se.kth.carInspection.integration;
/**
 * Write a description of class InspectorDTO here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InspectorDTO
{
    private String name;
    private String inspectionCompany;

    /**
     * Constructor for objects of class InspectorDTO
     */
    public InspectorDTO(String name, String inspectionCompany)
    {
        this.name = name;
        this.inspectionCompany = inspectionCompany;
    }

    public String getName()
    {
        return name;
    }
    
    public String getInspectionCompany()
    {
        return inspectionCompany;
    }
}
