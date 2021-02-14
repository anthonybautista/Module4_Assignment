package edu.wctc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Room implements Serializable {
    private List<Wall> wallList;

    private static final long serialVersionUID = 1L;

    public Room(double width, double length, double height) {
        Wall wall1 = new Wall(width, height);
        Wall wall2 = new Wall(width, height);
        Wall wall3 = new Wall(length, height);
        Wall wall4 = new Wall(length, height);
        this.wallList = new ArrayList<>(List.of(wall1, wall2, wall3, wall4));

    }

    public double getArea() {
        double area = 0.0;
        for (Wall wall: this.wallList) {
            area += wall.getArea();
        }
        return area;
    }

    @Override
    public String toString() {
        return "Room with area: " + this.getArea();
    }
}
