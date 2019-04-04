package academy.elqoo.java8.defaultmethods;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public interface Shape {

   /* static void moveXPosWith10(Collection<Shape> shapes){
        shapes.forEach(shape -> shape.setXPos(shape.getXPos()+10));
    }*///ich rozwiązanie ze strony

    static void moveXPosWith10(List<AbstractShape> shapes) {
        for (AbstractShape shape : shapes) {
            shape.setXPos(shape.getXPos()+10);
        }
    }

    int getXPos();

    int getYPos();

    void setXPos(int xPOs);

    void setYPos(int yPos);

    default String getName(){

        return "";
    }

    default void move(int xPos, int yPos){
        setXPos(xPos);
        setYPos(yPos);
    }

    void notImplementedMethod();
}
