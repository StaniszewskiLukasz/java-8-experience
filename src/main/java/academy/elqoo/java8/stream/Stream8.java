package academy.elqoo.java8.stream;


import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Stream8 {

    public static List<String> mapToUpperCase(List<String> strings){
      /*  List<String> result = new ArrayList<>();
       result = strings.stream()
                .map(e->e.toUpperCase())
                .collect(Collectors.toList());
        return result;*/ //tak zrobiłem a można krócej
        return strings.stream()
                .map(String::toUpperCase)
                .collect(toList());
    }

    public static List<Integer> returnSquareRoot(List<Integer> numbers){
        return numbers.stream().map(Math::sqrt).map(Double::intValue).collect(toList());
        //mapuję wyciągająć pierwiastek, to mapowanie zwraca double
        // więć z doubli mapujemy na inty i wrzucamy do listy
    }

    public static List<Integer> getAgeFromUsers(List<User> user){
        return user.stream().map(User::getAge).collect(toList());
    }

    public static List<User> getLimitedUserList(List<User> users, int limit){
        return users.stream().limit(limit).collect(toList());
        //tutaj nie mapujemy bo tylko chcemy skrócić istniejącą listę do dwóch indeksów więc bierzemy
        //listę i limitujemy do dwóch
    }

    public static Integer countUsersOlderThen25(List<User> users){
        Long count = users.stream().filter(e -> e.getAge() > 25).count();
        return count.intValue();
//        return new Long(users.stream().filter(e->e.getAge()>25).count()).intValue();
    }

    public static List<Integer> getDistinctAges(List<User> users){
        return users.stream().map(User::getAge).distinct().collect(Collectors.toList());
        //mamy listę Userów przerobić na listę integer z wiekiem userow niepowtarzającym się
    }

    public static Integer sum(List<Integer> integers){
        return integers.stream().reduce(0,Math::addExact);
    }

    public static List<Integer> skip(List<Integer> integers, Integer toSkip){
       return integers.stream().skip(toSkip).collect(Collectors.toList());
    }

    public static List<String> getFirstNames(List<String> names){
        //co tu ię dzieje pod spodem???
       return names.stream().map(e->e.split(" ")).map(e->e[0]).collect(Collectors.toList());
       //tu mamy z imion i nazwisk wrzuconych do listy pobrać do drugiej listy same imiona
        // najpierw dzielimy po białym znaku i wrzucamy każdy z indeksem 0 do nowej listy
    }

    public static List<String> getDistinctLetters(List<String> names){
        //co tu ię dzieje pod spodem???
        return names.stream()
                .map(e->e.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
    }

    public static String separateNamesByComma(List<User> users){
//        return users.stream()
//                .map(User::getName)
//                .toString(); zrobienie tak i stworzenie toStringa w User nie dało efektów
        //zwracało miejsce w pamięci
    return users.stream()
            .map(User::getName)
            .collect(Collectors.joining(", "));
    }

    public static double getAverageAge(List<User> users){
        return users.stream().mapToInt(User::getAge).average().orElse(0);
    }

    public static Integer getMaxAge(List<User> users){
        return users.stream()
                .map(User::getAge).max(Comparator.comparing(Function.identity()))
                .orElse(0);
    }

    public static Integer getMinAge(List<User> users) {
        return users.stream()
                .map(User::getAge)
                .min(Comparator.comparing(Function.identity()))
                .orElse(0);
    }

    public static Map<Boolean, List<User>> partionUsersByGender(List<User> users){
        return users.stream().collect(partitioningBy(User::isMale));
        //tworzymy mapę
        //co tu się odpier...???!!! Magia!!!
    }

    public static Map<Integer, List<User>> groupByAge(List<User> users){
        return users.stream().collect(groupingBy(User::getAge));
        //tworzymy mapę
        //z tego co rozumiem groupingBy zawsze zwraca mapę <coś-Lista <czegoś>>
    }

    public static Map<Boolean, Map<Integer, List<User>>> groupByGenderAndAge(List<User> users){
      return users.stream().collect(groupingBy(User::isMale,groupingBy(User::getAge)));
    }

    public static Map<Boolean, Long> countGender(List<User> users){
        throw new NotImplementedException();
    }

    public static boolean anyMatch(List<User> users, int age){
        throw new NotImplementedException();
    }

    public static boolean noneMatch(List<User> users, int age){
        throw new NotImplementedException();
    }

    public static Optional<User> findAny(List<User> users, String name){
        throw new NotImplementedException();
    }

    public static List<User> sortByAge(List<User> users){
        throw new NotImplementedException();
    }

    public static Stream<Integer> getBoxedStream(IntStream stream){
        throw new NotImplementedException();
    }

    public static List<Integer> generateFirst10PrimeNumbers(){
        throw new NotImplementedException();
    }

    public static boolean isPrime(int number) {
        return IntStream.rangeClosed(2, number/2).noneMatch(i -> number%i == 0);
    }

    public static List<Integer> generate10RandomNumbers(){
        throw new NotImplementedException();
    }

    public static User findOldest(List<User> users){
        throw new NotImplementedException();
    }

    public static int sumAge(List<User> users){
        throw new NotImplementedException();
    }

    public static IntSummaryStatistics ageSummaryStatistics(List<User> users){
        throw new NotImplementedException();
    }

}
