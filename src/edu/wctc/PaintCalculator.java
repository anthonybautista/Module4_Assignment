package edu.wctc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PaintCalculator implements Serializable {
    private List<Room> roomList = new ArrayList<>();

    private static final long serialVersionUID = 1L;

    public PaintCalculator() {
    }

    public void addRoom(double length, double width, double height) {
        Room room = new Room(width, length, height);
        this.roomList.add(room);
    }

    @Override
    public String toString() {
        String output = "";
        if (this.roomList.size() == 0) {
            output = "No rooms yet.";
        } else {
            for (Room room: this.roomList) {
                output = output + room.toString() + "\n";
            }
        }
        return output;
    }
}
