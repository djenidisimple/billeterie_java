package com.classes;

/**
 *
 * @author Djenidi
 */
public class TrainByRoute {
    private int id;
    private int routeId;
    private int trainId;
    
    public TrainByRoute(int id, int routeId, int trainId)
    {
        this.id = id;
        this.routeId = routeId;
        this.trainId = trainId;
    }
    
    public int getId() {
        return id;
    }

    public int getRouteId() {
        return routeId;
    }

    public int getTrainId() {
        return trainId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }
}
