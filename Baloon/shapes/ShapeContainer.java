/*
 * @Author: Ege Darcin
 * 24.03.2016
 * Lab03a
 * Version 1.1
 */
package shapes;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import shapes.Selectable;
import shapes.Shape;

public class ShapeContainer
implements Serializable,
Iterable {
    ArrayList<Shape> shapes = new ArrayList();

    public void add(Shape s) {
        if (s instanceof Selectable) {
            this.shapes.add(s);
        } else {
            System.out.println("Error NOT ADDED!");
        }
    }

    public String toString() {
        String s = "ShapeContainer [\n";
        for (int i = 0; i < this.shapes.size(); ++i) {
            s = s + "\t" + this.shapes.get(i).toString() + "\n";
        }
        return s + "] ";
    }

    public double getArea() {
        double totalArea = 0.0;
        for (int i = 0; i < this.shapes.size(); ++i) {
            totalArea += this.shapes.get(i).getArea();
        }
        return totalArea;
    }

    public Iterator<Shape> iterator() {
        return this.shapes.iterator();
    }

    public int size() {
        return this.shapes.size();
    }

    public Shape contains(int x, int y) {
        for (Shape shape : this.shapes) {
            Shape s = ((Selectable)((Object)shape)).contains(x, y);
            if (s == null) continue;
            return s;
        }
        return null;
    }

    public void removeSelected() {
        for (int i = 0; i < this.shapes.size(); ++i) {
            if (!((Selectable)((Object)this.shapes.get(i))).isSelected()) continue;
            this.shapes.remove(i);
            --i;
        }
    }

    public int selectAllAt(int x, int y) {
        int count = 0;
        for (Shape shape : this.shapes) {
            Shape s = ((Selectable)((Object)shape)).contains(x, y);
            if (s == null) continue;
            ((Selectable)((Object)s)).setSelected(true);
            ++count;
        }
        return count;
    }
}

