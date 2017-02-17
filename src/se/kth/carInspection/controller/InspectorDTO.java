package se.kth.carInspection.controller;
/**
 * InspectorDTO is a class that gets the name of the inspector and the company
 * 
 * @author valentina
 * @version 0.1 2017/02/14
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

    /**
     * Accessor method for the name
     * @return name Returns the name of the inspector
     */
    public String getName()
    {
        return name;
    }

    /**
     * Accessor method for the company
     * @return inspectionCompany Returns the name of the company
     */
    public String getInspectionCompany()
    {
        return inspectionCompany;
    }
}
