package academy.elqoo.java8.defaultmethods;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class AbstractShape implements Shape {

    private int xPos = 0;

    private int yPos = 0;


   /* @Override//tej metody nie powinno tu być tylko w Shape
    public void move(int xPosValue, int yPosValue) {
        System.out.println("Wartość this.xPos przed dodaniem " + this.getXPos());
        this.setXPos(xPosValue);
        System.out.println("Wartość this.xPos po dodaniu " + this.getXPos());
        this.setYPos(yPosValue);
//        int sum = xPosValue + yPosValue;
//        System.out.println("Suma xPosValue i yPosValue " + sum);
//        System.out.println("XposValue " + xPosValue);
//        System.out.println("YposValue " + yPosValue);
        //zanim pomyślałem że rozwiązanie jest zgodne z tym co wyżej kombinowałem jak niżej
        //zanim zmieniłem pola powyżej na static kombinowałe jak poniżej, nie dawało to żadnych efektów.
        // Wszystkie x i yPos na każdym obiekcie były innymi miejscami w pamięci niż ten szukany x i yPos
        //bo są to xPos i yPos osobne dla każdego nowo utworzonego obiketu
//        Shape shape = new AbstractShape();
//        Shape shape1 = new Rectangle();
//        AbstractShape abstractShape = new AbstractShape();
//        AbstractShape abstractShape1 = new Rectangle();
//        Rectangle rectangle = new Rectangle();
//        shape.setYPos(yPosValue);
//        shape.setXPos(xPosValue);
//        System.out.println("xPos od shapeNaAbstract " + getXPos());
//        System.out.println("yPos od shapeNaAbstract " + getYPos());
//        abstractShape1.setYPos(yPosValue);
//        abstractShape1.setXPos(xPosValue);
//        System.out.println("xPos od shapeRectangle " + getXPos());
//        System.out.println("yPos od shapeRectangle " + getYPos());
//        shape1.setXPos(xPosValue);
//        shape1.setYPos(yPosValue);
//        System.out.println("xPos od shape1NaRectangle " + getXPos());
//        System.out.println("yPos od shape1NaRectangle " + getYPos());shape1.setXPos(xPosValue);
//        abstractShape.setYPos(yPosValue);
//        abstractShape.setXPos(xPosValue);
//        System.out.println("xPos od abstract " + getXPos());
//        System.out.println("yPos od abstract " + getYPos());
//        rectangle.setYPos(yPosValue);
//        rectangle.setXPos(xPosValue);
//        System.out.println("xPos od rectangle " + getXPos());
//        System.out.println("yPos od rectangle " + getYPos());
        //każde z moich powyższych działani tworzy nowy obiekt każdy z nich ma nowe miejsce w pamięci,
        //ale myślałem że każdy ustawiając wartość dla xPos czy yPos odwołuje się do tego samego pola dopóki
        //xPos i yPos nie są static każdy z tych obiektów ma swoje pole xPos i yPos
    }*/

    @Override
    public void notImplementedMethod(){
        throw new NotImplementedException();
        //ciało tej metody w rozwiązniu jest w Shape i tak jest lepiej bo interfejs górą ponad dziedziczenie a u mnie ciało
        //jest właśnie u rodzica czyli w klasie AbstractShape
    }

    @Override
    public int getXPos() {

        return xPos;
    }

    @Override
    public int getYPos() {

        return yPos;
    }

    @Override
    public void setXPos(int xPOs) {
        this.xPos = xPOs;
    }

    @Override
    public void setYPos(int yPos) {
        this.yPos = yPos;
    }

    @Override
    public String getName() {
        return "Abstract Shape";
    }
}
