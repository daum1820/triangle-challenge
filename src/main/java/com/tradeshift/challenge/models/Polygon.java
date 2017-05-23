package com.tradeshift.challenge.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Polygon<T extends Number> implements Serializable{

    protected List<PolygonSide<T>> sides;

    public List<PolygonSide<T>> getSides() {
        if(this.sides == null){
            this.sides = new ArrayList<>();
        }
        return this.sides;
    }
}
