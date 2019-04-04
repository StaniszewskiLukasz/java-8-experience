package academy.elqoo.java8.optional;

import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class OptionalTest {

    @Test
    public void shouldCreateEmptyOptional(){
        //pokazuje że pusty Optional na metodzie isPresent zwróci wynik negatywny
//        Optional<String> optional = new Optional<>();//tak nie można ciekawe czemu???
        Optional<String> optional1 = Optional.empty();// create empty optional
        //tu był null, wiedziałem, że optional nie może być nullem, ale próbowałem coś zrobić na instancji
        //a trzeba było wywołać metodę na klasie
        assertThat(optional1.isPresent(),equalTo(false));
        //DONE
    }

    @Test
    public void shouldReturnBookName(){
        //jak wyciągnąć coć z Optionala i wrzucić np. do Stringa
        Optional<Book> book = Optional8.getBook();
        String bookName = book.get().getName();// ja zrobiłem tak i tak jest czytelniej
        String bookName1 = book.map(Book::getName).orElse("");//oni podali takie rozwiązanie
        assertThat(bookName,equalTo("Experience Java 8"));
        //DONE
    }

    @Test
    public void shouldReturnBookAuthor(){
        Optional<Book> book = Optional8.getBookWithAuthor();
        //String authorName = book.get().getAuthor(); tak być nie może bo to zwraca Optionala a ma być String
        String authorName1 = book.get().getAuthor().orElse("");
        //ale można tak bo orElse zwróci Stringa, tylko że metoda get bez wcześniejszego sprawdzenia isPresent
        //może zwrócić NullPointera czy cś w pobliżu:)
        String authorName = book.flatMap(Book::getAuthor).orElse("");
        //tutaj musi być flatMap chyba dlatego że ten book ma nie tylko autora ale także i nazwę i trzeba
        //te dane pominąć a metoda map dopominłaby się o wyświetlenie także nazwy, później referencja do metody
        System.out.println(authorName);
        assertThat(authorName,equalTo("Stijn De Mulder"));
        assertThat(authorName1,equalTo("Stijn De Mulder"));
        //DONE
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldThrowNoElementException(){
        Optional<Book> book = Optional.empty();
        //wystarczy powyżej zmienić na Optional.empty ta metoda jeśli nie wykryję elementu rzuci tym wyjątkiem
        System.out.println(book.get().getAuthor());
//DONE
    }

    @Test(expected = MyCustomException.class)
    public void shouldThrowOptionalEmptyException() throws MyCustomException{
        //trzeba dopisać throws dlatego że to nasz wyjątek a nie z klasy Optional
        Optional<Book> book = Optional8.getBook();
        book.get().getAuthor().orElseThrow(MyCustomException::new); // getAuthor.or.....
        //tutaj trzeba dołożyć metodę znajdz autor lub rzuć wyjątkiem i wpisać wyjątek ale też w deklaracji
        //metody dopisać o jaki wyjątek chodzi.
    }

}
