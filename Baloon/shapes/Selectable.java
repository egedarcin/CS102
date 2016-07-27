/*
 * @Author: Ege Darcin
 * 24.03.2016
 * Lab04b
 * Version 1.1
 */
package shapes;

import shapes.Shape;

public interface Selectable {
    public Shape contains(int var1, int var2);

    public boolean isSelected();

    public void setSelected(boolean var1);
}

