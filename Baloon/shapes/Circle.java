/*
 * @Author: Ege Darcin
 * 24.03.2016
 * Lab04b
 * Version 1.1
 */
package shapes;

import shapes.Selectable;
import shapes.Shape;

public class Circle
extends Shape
implements Selectable {
    private int radius;
    boolean selected;

    public Circle() {
        this.radius = 0;
    }

    public Circle(int pRadius) {
        this.radius = pRadius;
    }

    @Override
    public double getArea() {
        return Math.pow(this.radius, 2.0) * 3.141592653589793;
    }

    @Override
    public String toString() {
        return "Circle: " + (this.selected ? "* " : "  ") + super.toString() + " " + this.radius;
    }

    public void setRadius(int pRadius) {
        this.radius = pRadius;
    }

    public int getRadius() {
        return this.radius;
    }

    @Override
    public Shape contains(int x, int y) {
        int deltaY2;
        int deltaX2 = (x - this.getX()) * (x - this.getX());
        if (deltaX2 + (deltaY2 = (y - this.getY()) * (y - this.getY())) <= this.radius * this.radius) {
            return this;
        }
        return null;
    }

    @Override
    public boolean isSelected() {
        return this.selected;
    }

    @Override
    public void setSelected(boolean state) {
        this.selected = state;
    }
}

