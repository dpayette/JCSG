/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jlab.detector.volume;

import eu.mihosoft.vrl.v3d.Vector3d;
import org.jlab.detector.units.SystemOfUnits.Length;
import org.jlab.geometry.prim.Box;
import org.jlab.geometry.prim.Line3d;

/**
 *
 * @author kenjo
 */
public class G4Box extends Geant4Basic {
    public G4Box(String name, double sizex, double sizey, double sizez) {
        super(new Box(sizex, sizey, sizez));
        setName(name);
        setType("Box");
        setDimensions(Length.value(sizex), Length.value(sizey), Length.value(sizez));
    }
    
    public double getXHalfLength() {
        return volumeDimensions.get(0).value;
    }

    public double getYHalfLength() {
        return volumeDimensions.get(1).value;
    }

    public double getZHalfLength() {
        return volumeDimensions.get(2).value;
    }
    
    public Line3d getLineX(){
        Line3d xline = new Line3d(new Vector3d(-getXHalfLength(),0,0), new Vector3d(getXHalfLength(),0,0));
        return xline.transformed(getGlobalTransform());
    }
           
    
    public Line3d getLineY(){
        Line3d yline = new Line3d(new Vector3d(0,-getYHalfLength(),0), new Vector3d(0,getYHalfLength(),0));
        return yline.transformed(getGlobalTransform());
    }
           
    
    public Line3d getLineZ(){
        Line3d zline = new Line3d(new Vector3d(0,0,-getZHalfLength()), new Vector3d(0,0,getZHalfLength()));
        return zline.transformed(getGlobalTransform());
    }
           
}
