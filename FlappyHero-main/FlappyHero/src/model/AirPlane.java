package model;

import java.awt.Image;

public class AirPlane {
    public int x, y, width, height;
    public Image img;
    public boolean passed = false;

    public AirPlane(int boardWidth, int randomY, int pipeWidth, int pipeHeight, Image airPlaneImg) {
    }

    public void stateAirPlane(int x, int y, int width, int height, Image img) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.img = img;
    }
}
