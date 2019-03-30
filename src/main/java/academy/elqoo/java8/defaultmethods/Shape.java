package academy.elqoo.java8.defaultmethods;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public interface Shape {

    static void moveXPosWith10(List<AbstractShape> shapes) {
        for (AbstractShape shape : shapes) {
            System.out.println("Wartość xPos dla obiektu przed dodaniem " + shape.getXPos());
            shape.setXPos(shape.getXPos()+10);
            System.out.println("Wartość xPos dla obiektu po dodaniu " + shape.getXPos());
        }
    }

    int getXPos();

    int getYPos();

    void setXPos(int xPOs);

    void setYPos(int yPos);

    default String getName(){

        return "";
    }

    void move(int xPosValue, int yPosValue);

    void notImplementedMethod();
}
