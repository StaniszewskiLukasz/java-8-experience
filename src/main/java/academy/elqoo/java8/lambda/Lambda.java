package academy.elqoo.java8.lambda;


import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Lambda {

    public static List<String> filter(List<String> strings, Predicate<String> condition) {
        //Interfejs Predicate przyjmuje jakiś warunek możemy określić na jakiej typie/klasie ten warunek bedzie sprawdzany
        return strings.stream().filter(condition).collect(Collectors.toList());
    }

    public static void processWithinTransaction(Runnable runnable) {
        Transaction transaction = new Transaction();
        transaction.start();
        transaction.stop();
        runnable.run();
        //Runnable ma podejmowć jakieś działąnie, na jakimś obiekcie taki ma kontrakt
    }

    public static String create() {
        StringCreator creator = new StringCreator() {
            @Override
            public String stringMaker() {
                return "Nowy";
            }
        };
        return creator.stringMaker();
        //to jest rozwiązanie moje z moim interfejsem
    }

    public static String createDifferently(Supplier<String> supplier) {
        return supplier.get();
        //Interfejs Suplaier odbiera jakiś obiekt danego typu i zwraca go w takim samym typie
        //to jest rozwiązanie z wykorzystaniem istniejących intrefejsów,
        //krótsze i z lambdą w wywołaniu
    }

    public static Integer getStringLength(String s, Function<String, Integer> function) {
        return function.apply(s);
        //metoda przymuje Stringa którego ma policzyć i interfejs funkcyjny Function
        //dlaczego tutaj wykorzystujemy Interfejs
        //ponieważ ten interfejs jest narzędziem które przyjmuje obiekt jednego typu
        //i oddaje obiekt innego typu zgodnie z naszą implemenatcją, my podaliśmy że chcemy
        //przetworzyć Stringa i otrzymać Integera, gdyby na górze zmienić Integer na Double to
        //metoda aplly podkreśliłaby się na czerwono oczywiście
        //dlaczego przy wywołaniu metody podalismy klasę String i jej metodę?
        //przy wywołaniu podajemy co będziemy obrabiać i co będzie wynikiem tej obróbki
        //zgodnie z naszą implementacją wynikiem ma być Integer
    }

    public static int multiply(int a, int b, BinaryOperator<Integer> operator) {
        //można też zastosować IntBinaryOperator ten interfejs też odbiera dwa inty i zwraca jeden
        //w wywołaniu podajemy jakie działąnie ma być zastosowane na elementach przekazanych do interefejsu
        //oraz ile i jakie elementy/obiekty do interfejsu przkazujemy
        return operator.apply(a,b);
    }

    public static List<String> sortStrings(List<String> strings, Comparator<String>comparator) {
        strings.sort(comparator);
        //tu przekazane stringi i interface  łaczymy metodą sort i zwracamy wynik
        //metodę sort wywołujemy tym razem na liście a nie na instancji interfejsu!!!
        return strings;
    }

}
