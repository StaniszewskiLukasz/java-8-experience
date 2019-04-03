package academy.elqoo.java8.defaultmethods;

import org.junit.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class DefaultMethodsTest {

    @Test
    public void shouldMoveShape() {
        Shape shape = new Rectangle();
        // implement a default move method without changing the Rectangle class
        shape.move(10, 10);
        assertThat(10, equalTo(shape.getXPos()));
        assertThat(10, equalTo(shape.getYPos()));
        //metoda move jest wywołana na obiekcie shape klasy Rectangle więc nie może ta metoda być static
        //ponieważ nie jest static nie ma ciała i musi je mieć i być zaimplementowana w AbstractShape
        //można zmienić wartości xPos na static i wtedy każda zmiana wartości xPos na kazdym nowym obiekcie
        //zmieni wartość xPos i test będzie zielony
        //ale następne zadanie będzie czerwone bo każdy obiekt będzie zmieniał wartość tego jednego xPos i yPos
        //dlatego metoda move musi odwoływać się do this.xPos a nie xPos na obiekcie otworzonym w metodie
        //DONE
    }

    @Test
    public void shouldMoveXposWith10() {
        Rectangle rectangle = new Rectangle();
        Triangle triangle = new Triangle();
        List<AbstractShape> shapes = asList(rectangle, triangle);
        // write a static method on shape that add 10 to each xPos of a shape
        Shape.moveXPosWith10(shapes);
        assertThat(10, equalTo(rectangle.getXPos()));
        assertThat(10, equalTo(triangle.getXPos()));
        //DONE
    }

    @Test(expected = NotImplementedException.class)
    public void shouldThrowNotImplementedException() {
        // add an optional method to the shape method
        Triangle triangle = new Triangle();
        triangle.notImplementedMethod();
        //metoda jest otworzona jako domyślna bez ciała w shape, i zaimplementowana w AbstractShape i rzuca
        //powinna mieć ciało w shape tak jest lepiej
        //wyjątkiem throw new NotImplementedException();
        //DONE
    }

    @Test
    public void shouldReturnNameForTriangle() {
        Shape shape = new Triangle();
//        assertThat("fill in right name here", equalTo(shape.getName())); tak było poczatkowo
        assertThat("Triangle", equalTo(shape.getName()));
        //zmieniłem stringa oczekiwanego
        //DONE
    }

    @Test
    public void shouldReturnNameForRectangle() {
        Shape shape = new Rectangle();
        assertThat("Abstract Shape", equalTo(shape.getName()));
        //tutaj warto zwrócić uwagę na Rectanglu-Shape wywołujemy getName z klasy Shape (te klasy są połączone bo
        //Rectangle dziedzicz po AbstratShape a AbstractShape implementuje interfejs Shape własnie) a getName w Shape
        //zwraca"" w Rectangle nie ma tej metody zaimplementownej(nadpisanej) jest ona w AbstrctShape a tam jest
        //właśnie "AbstractShape" i stąd ta odpowiedź. Ale co ważne wywołujemy na shape ale ponieważ konstruktorem
        //jest rectangle to tam szukamy odpowiedź o nazwę i znajdujemy ją u mamy w AbstractShape.
        //DONE
    }

    @Test
    public void shouldProvideName() {
        // make rectangle implement NamedObject
        NamedObject namedObject = new Rectangle();
        assertThat("Abstract Shape", equalTo(namedObject.getName()));
        //to samo co wyżej wywołujesz na interfejsie NamedObject a metoda getName tak naprawdę daje odpowiedź z
        //Rectangle bo taki jest konstruktor i odpowiedź z klasy AbstractShape
//DONE
    }
}
