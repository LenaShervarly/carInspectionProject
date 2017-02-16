package se.kth.carInspection.integration;
/**
 * Write a description of class Vehicle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vehicle
{
    private String licenseNumber;

    /**
     * Constructor for objects of class Vehicle
     */
    public Vehicle(String licenseNumber)
    {
        this.licenseNumber = licenseNumber;
    }

    /**
     *
     */
    public String getLicenseNumber()
    {
        return licenseNumber;
    }
}
