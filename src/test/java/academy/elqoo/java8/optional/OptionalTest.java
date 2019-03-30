package academy.elqoo.java8.optional;

import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class OptionalTest {

    @Test
    public void shouldCreateEmptyOptional(){
        Optional<String> optional = Optional.empty();// create empty optional
        //tu był null, wiedziałem że optional nie może być nullem ale próbowałem coś zrobić na instancji
        //a trzeba było wywołać metodę na klasie
        assertThat(optional.isPresent(),equalTo(false));
        //DONE
    }

    @Test
    public void shouldReturnBookName(){
        Optional<Book> book = Optional8.getBook();
        String bookName = book.get().getName();// ja zrobiłem tak
        String bookName1 = book.map(Book::getName).orElse("");//oni podali takie rozwiązanie
        assertThat(bookName,equalTo("Experience Java 8"));
        //DONE
    }

    @Test
    public void shouldReturnBookAuthor(){
        Optional<Book> book = Optional8.getBookWithAuthor();
        String authorName = book.flatMap(Book::getAuthor).orElse("");
        //tutaj musi być flatMap chyba dlatego że ten book ma nie tylko autora ale także i nazwę i trzeba
        //te dane pominąć a metoda map dopominłaby się o wyświetlenie także nazwy
        System.out.println(authorName);
        assertThat(authorName,equalTo("Stijn De Mulder"));
        //DONE
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldThrowNoElementException(){
        Optional<Book> book = Optional8.getBook();
        book.get().getAuthor();
    }

    @Test(expected = MyCustomException.class)
    public void shouldThrowOptionalEmptyException(){
        Optional<Book> book = Optional8.getBook();
        book.get().getAuthor(); // getAuthor.or.....
    }

}
