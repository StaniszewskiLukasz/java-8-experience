package academy.elqoo.java8.stream;


import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Stream8 {

    public static List<String> mapToUpperCase(List<String> strings) {
      /*  List<String> result = new ArrayList<>();
       result = strings.stream()
                .map(e->e.toUpperCase())
                .collect(Collectors.toList());
        return result;*/ //tak zrobiłem a można krócej
        return strings.stream()
                .map(String::toUpperCase)
                .collect(toList());
    }

    public static List<Integer> returnSquareRoot(List<Integer> numbers) {
        return numbers.stream().map(Math::sqrt).map(Double::intValue).collect(toList());
        //mapuję wyciągająć pierwiastek, to mapowanie zwraca double
        // więć z doubli mapujemy na inty i wrzucamy do listy
    }

    public static List<Integer> getAgeFromUsers(List<User> user) {
        return user.stream().map(User::getAge).collect(toList());
        //dlaczego tu jest mapa a nie filtr??? Bo Map przyjmuje interfejs Function a filter Predicate.
        //Predicate wymaga podania jakiegoś warunku który jesli bedzie spełniony to zostanie odfiltrowane
        //żądanie podaj wiek to nie warunek
    }

    public static List<User> getLimitedUserList(List<User> users, int limit) {
        return users.stream().limit(limit).collect(toList());
        //tutaj nie mapujemy bo tylko chcemy skrócić istniejącą listę do dwóch indeksów więc bierzemy
        //listę i limitujemy do dwóch i wrzucamy zlimitowaną do nowej krótszej listy
    }

    public static Integer countUsersOlderThen25(List<User> users) {
        Long count = users.stream().filter(e -> e.getAge() > 25).count();
        return count.intValue();
//        musi być duży Long by skorzystać z intValue, trzeba pamiętać metodę count że istnieje
//        return new Long(users.stream().filter(e->e.getAge()>25).count()).intValue();
    }

    public static List<Integer> getDistinctAges(List<User> users) {
        return users.stream().map(User::getAge).distinct().collect(Collectors.toList());
        //mamy listę Userów przerobić na listę integer z wiekiem userow niepowtarzającym się
    }

    public static Integer sum(List<Integer> integers) {

        return integers.stream().reduce(0, Math::addExact);
    }

    public static List<Integer> skip(List<Integer> integers, Integer toSkip) {
        return integers.stream().skip(toSkip).collect(Collectors.toList());
    }

    public static List<String> getFirstNames(List<String> names) {
        //tutaj najpierw dzielimy string na dwie grupy potem wskazujemy którą grupę z jakim indeksem wrzucamy do listy
        return names.stream().map(e -> e.split(" ")).map(e -> e[0]).collect(Collectors.toList());
        //tu mamy z imion i nazwisk wrzuconych do listy pobrać do drugiej listy same imiona
        // najpierw dzielimy po białym znaku i wrzucamy każdy z indeksem 0 do nowej listy
    }

    public static List<String> getDistinctLetters(List<String> names) {
        //najpierw dzielimy każdego stringa na pojedyncze znaki, metoda split wrzuca je do tablicy każdy pod inny
        //indeks. Używamy więc metody flatMap by na klasie Arrays wywołać metodę stremowania (ponownie)
        //przeszukujemy tą tablicę po znakach wyjątkowych i wrzucamy je do listy wynikowej
        return names.stream()
                .map(e -> e.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
    }

    public static String separateNamesByComma(List<User> users) {
//        return users.stream()
//                .map(User::getName)
//                .toString(); zrobienie tak i stworzenie toStringa w User nie dało efektów
        //zwracało miejsce w pamięci
        return users.stream()
                .map(User::getName)
                .collect(Collectors.joining(", "));
        //łączymy elementy w jednego stringa dopiero na poziomie kolekcjonowania
    }

    public static double getAverageAge(List<User> users) {
        return users.stream().mapToInt(User::getAge).average().orElse(0);
    }

    public static Integer getMaxAge(List<User> users) {
        return users.stream()
                .map(User::getAge).max(Comparator.comparing(Function.identity()))
                //Function.identity zwraca zwsze to co przyjmuje parametr tego samego typu
                .orElse(0);
    }

    public static Integer getMinAge(List<User> users) {
        return users.stream()
                .map(User::getAge)
                .min(Comparator.comparing(Function.identity()))
                .orElse(0);
    }

    public static Map<Boolean, List<User>> partionUsersByGender(List<User> users) {
        return users.stream().collect(partitioningBy(User::isMale));
        //tworzymy mapę
        //co tu się odpier...???!!! Magia!!!
    }

    public static Map<Integer, List<User>> groupByAge(List<User> users) {
        return users.stream().collect(groupingBy(User::getAge));
        //tworzymy mapę
        //z tego co rozumiem groupingBy zawsze zwraca mapę <coś-Lista <czegoś>>
    }

    public static Map<Boolean, Map<Integer, List<User>>> groupByGenderAndAge(List<User> users) {
        return users.stream().collect(groupingBy(User::isMale, groupingBy(User::getAge)));
    }

    public static Map<Boolean, Long> countGender(List<User> users) {
        return users.stream().collect(groupingBy(User::isMale, counting()));
    }

    public static boolean anyMatch(List<User> users, int age) {
        return users.stream().anyMatch(user -> user.getAge() == age);
//        return users.stream().anyMatch(e -> e.getAge().equals(age));
    }

    public static boolean noneMatch(List<User> users, int age) {
        return users.stream().noneMatch(user->user.getAge()==age);
    }

    public static Optional<User> findAny(List<User> users, String name) {
        return users.stream().filter(user->user.getName().equals(name)).findAny();
        //nie można użyć samego findAny, wprawdzie zwraca Optionala ale nie przyjmie Stringa, trzeba przefiltrować
        //w poszukiwaniu danego Stringa i na koniec dać findAny by wynik był w Optional i obsłużył ewentualnego nulla
    }

    public static List<User> sortByAge(List<User> users) {
        return users.stream()
                .sorted(Comparator.comparingInt(User::getAge))
                .collect(Collectors.toList());
    }

    public static User findOldest(List<User> users) {
        return users.stream().max(Comparator.comparing(User::getAge)).get();
    }

    public static int sumAge(List<User> users) {
        return users.stream().mapToInt(User::getAge).sum();
    }

    public static IntSummaryStatistics ageSummaryStatistics(List<User> users) {
        return users.stream().mapToInt(User::getAge).summaryStatistics();
        //poprzez mapToInt i metodęSummaryStatistics zwraca od razu liczbę elementów, sumę wartości przeszukiwanego pola
        //wartość minimalną, wartość maksymalną i średnią wartości przeszukiwanego pola/zmiennej
    }

    public static Stream<Integer> getBoxedStream(IntStream stream) {
        return stream.boxed();
    }

    public static List<Integer> generateFirst10PrimeNumbers() {
        return Stream.iterate(2,i -> i+1).filter(Stream8::isPrime).limit(10).collect(toList());
    }

    public static boolean isPrime(int number) {
        return IntStream.rangeClosed(2, number / 2).noneMatch(i -> number % i == 0);
    }

    public static List<Integer> generate10RandomNumbers() {
        return Stream.generate(()/*()nawias jest chyba dlatego że metoda nasza nic nie przyjmuje
         a więc my nic nie obrabiamy żadnego obiektu tylko metodę
          która dopiero stworzy jakiś obiekt*/->new Random().nextInt()).limit(10).collect(toList());
        //mało czytelne, trudne do skonfigurowania samemu, wystarczy jeden zły nawias i całość nie działa i nie podaję
        //podpowiedzi
        //niesamowite że Streamem można też tworzyć obiekty a nie tylko je obrabiać
        //ToDo też to ponownie przerobić i poczytać o tym
    }
}
