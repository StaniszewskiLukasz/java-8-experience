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
        return strings.stream().filter(condition).collect(Collectors.toList());
    }

    public static void processWithinTransaction(Runnable runnable) {
        Transaction transaction = new Transaction();
        transaction.start();
        transaction.stop();
        runnable.run();//to robi robotę w drugim teście
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
        //to jest rozwiązanie z wykorzystaniem istniejących intrefejsów,
        //krótsze i z lambdą w wywołaniu
    }

    public static Integer getStringLength(String s, Function<String, Integer> function) {
        return function.apply(s);
        //metoda przymuje Stringa którego ma policzyć i interfejs funkcyjny Function
        //dlaczego tutaj wykorzystujemy Interfejs
        //skoro przy wywołaniu metody podlismy kasę String i jej metodę?
    }

    public static int multiply(int a, int b, BinaryOperator<Integer> operator) {
        return operator.apply(a,b);
    }

    public static List<String> sortStrings(List<String> strings, Comparator<String>comparator) {
        strings.sort(comparator);
        //tu przekazane stringi i interface  łaczymy metodą sort i zwracamy wynik
        return strings;
    }

}
