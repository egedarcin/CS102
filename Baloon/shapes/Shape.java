/*
 * @Author: Ege Darcin
 * 24.03.2016
 * Lab04b
 * Version 1.1
 */
package shapes;

import java.io.Serializable;
import shapes.Locatable;

public abstract class Shape
implements Locatable,
Serializable {
    int x;
    int y;

    public String toString() {
        return "[" + this.getX() + "," + this.getY() + "]";
    }

    public abstract double getArea();

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

