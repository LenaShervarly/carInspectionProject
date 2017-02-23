/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.carInspection.model;

/**
 * An interfase reseiving information regarding the results of inspections made
 * @author Lena Shervarly
 */
public interface InspectionResultObserver {
    
    /**
     * Invoked when a new collection of inspection results was created or updated
     * @param results the collection of inspection results that was created or updated
     */
    void newInspectionResultCollection(InspectionResultCollection results);
    
}
