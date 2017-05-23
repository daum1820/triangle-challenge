package com.tradeshift.challenge.models;

import java.io.Serializable;

public class PolygonSide<T extends Number> implements Serializable{

    private T side;

    public PolygonSide(){

    }

    public PolygonSide(T side){
        this.side = side;
    }

    public T getSide() {
        return side;
    }

    public void setSide(T side) {
        this.side = side;
    }
}
