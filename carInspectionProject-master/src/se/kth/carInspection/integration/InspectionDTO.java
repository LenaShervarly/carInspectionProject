/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.carInspection.integration;

/**
 *
 * @author Lena Shervarly
 */
public class InspectionDTO {

    private String description;
    private int cost;

    public InspectionDTO(String description, int cost) {
        this.description = description;
        this.cost = cost;
    }
    public String getDesctription() {
        return description;
    }
    public int getCost() {
        return cost;
    }
}
