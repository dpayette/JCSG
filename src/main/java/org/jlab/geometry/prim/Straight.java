/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jlab.geometry.prim;

import eu.mihosoft.vrl.v3d.Transform;
import eu.mihosoft.vrl.v3d.Vector3d;

/**
 *
 * @author kenjo
 */
public abstract class Straight {

    protected final Vector3d origin, end;
    private Line3d innerLine;
    
    public Straight(Vector3d origin, Vector3d end) {
        this.origin = origin.clone();
        this.end = end.clone();
    }
    
    protected Straight(Straight line){
        this.origin = line.origin;
        this.end = line.end;
    }

    public Vector3d origin() {
        return origin;
    }

    public Vector3d end() {
        return end;
    }

    public Vector3d diff() {
        return end.minus(origin);
    }

    public abstract boolean contains(double parametricT);

    public Straight toLine() {
        if (innerLine == null) {
            innerLine = new Line3d(this);
        }
        return innerLine;
    }
    
    protected void transform(Transform trans){
        trans.transform(origin);
        trans.transform(end);
    }
    
    @Override
    public String toString(){
        return "Straight line from "+origin+" to "+end;
    }
}
