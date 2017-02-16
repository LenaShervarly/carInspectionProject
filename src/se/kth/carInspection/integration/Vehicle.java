package se.kth.carInspection.integration;
/**
 * Vehicle class give information about the vehicle that has to be inspected
 * 
 * @author valentina
 * @version 0.1 2017/02/14
 */
public class Vehicle
{
    private String licenseNumber;

    /**
     * Constructor for objects of class Vehicle that initialize the license number of the class
     */
    public Vehicle(String licenseNumber)
    {
        this.licenseNumber = licenseNumber;
    }

    /**
     * Accessor method for returning the license number
     * @return licenseNumber It returns the license number
     */
    public String getRegistrationNumber()
    {
        return licenseNumber;
    }
}
