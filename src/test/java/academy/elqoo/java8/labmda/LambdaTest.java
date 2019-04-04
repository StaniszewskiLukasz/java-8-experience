package academy.elqoo.java8.labmda;

import academy.elqoo.java8.lambda.Lambda;
import academy.elqoo.java8.lambda.StringLengthCounting;
import academy.elqoo.java8.lambda.TransactionLambda;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class LambdaTest {

    @Test
    public void removeStringsWithMoreThanThreeCharacters() {
        //Predicate
        List<String> input = asList("This", "is", "java", "8");
        input = Lambda.filter(input, s -> s.length() < 3);
        assertThat(input, contains("is", "8"));
        //DONE
    }

    @Test
    public void shouldBeExecutedWitingATransaction() {
        //Runnable
        TransactionLambda lambda = new TransactionLambda();
        Lambda.processWithinTransaction(lambda);
        assertTrue(lambda.isConsumed());
        //wywołujemy na obiekcie TransactionLambda z klasy TransactionLambda, która implementuje interfejs Runnable
        // metodę z klasy Lambda która przyjmuje jako parametr interfejs Runnable choć go klasa nie implementuje
        //i ten obiekt zostanie dzięki interfejsowi Runnable i metodzi z Lambda podany działaniu innej metody z klasy
        //TransactionLambda która była wywołana w trzeciej kolejności. Takie potrójne wywołanie metod na jednym obiekcie
        //spychologia
        //DONE
    }

    @Test
    public void shouldCreateAString() {
        String bigString = Lambda.create();
        System.out.println(bigString);
        assertTrue(bigString.length() > 0);
        //DONE
    }

    @Test//to jest kopia metody powyżej
    public void shouldCreateAStringDifferently() {
        //Supplier
        String bigString = Lambda.createDifferently(() -> "Hello");
        System.out.println(bigString);
        assertTrue(bigString.length() > 0);
        //DONE
    }

    @Test
    public void extractStringSize() {
        //Function on od razu deklaruje co przyjuje i co zwraca
        String myString = "This is great";
        int length = Lambda.getStringLength(myString, String::length);
        assertTrue(length == 13);
        //DONE
    }

    @Test
    public void multiply() {
        //BinryOperator lub IntBinaryOperator
        int a = 5;
        int b = 6;
        int result = Lambda.multiply(a, b, (integer, nextInteger) -> a * b);
        assertTrue(result == 30);
    }

    @Test
    public void shouldSortStrings() throws Exception {
        //Comparator
        List<String> input = Arrays.asList("C", "F", "A", "D", "B", "E");
        List<String> result = Lambda.sortStrings(input, Comparator.comparing(e->e));
        //Comparator to też interface funkcyjny, nadaje się także do sortowania
        //tu w metodzie jak wyżej przekazujemy listę stringów i na interfajsie wywołujemy sortowanie
        assertThat(result, is(equalTo(Arrays.asList("A", "B", "C", "D", "E", "F"))));
    }


}
