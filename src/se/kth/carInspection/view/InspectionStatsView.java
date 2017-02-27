/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.carInspection.view;

import se.kth.carInspection.model.InspectionResultCollection;
import se.kth.carInspection.model.InspectionResultObserver;

/**
 * Represents the display, that shows all the results of inspections made or provided
 * @author Lena Shervarly
 */
public class InspectionStatsView implements InspectionResultObserver{
      
    @Override
    public void newInspectionResultCollection(InspectionResultCollection results){
        System.out.println(results.prepareResulsForTheScreen());
    }
}
