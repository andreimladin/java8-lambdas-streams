package ro.iteahome.java.optional;

import java.util.Arrays;
import java.util.Optional;

public class OptionalSamples {

    private static void map() {
        Optional<String> filteredA = findInOurBigDatabase();
        filteredA
                .map(String::toUpperCase)
//                .filter(name -> "Vasile".equals(name))
//                .map(Integer::valueOf)
                //.map(name -> name.toUpperCase())
                .ifPresent(System.out::println);
//                .ifPresent(name -> System.out.println(name));
    }
//
//    private static Integer convertStringToInt(String intString) {
//        return Integer.valueOf(intString);
//    }

    private static void get() {
        Optional<String> filteredA = findInOurBigDatabase();
//        filteredA = filteredA.filter(name -> "Vasile".equals(name));
//        filteredA.get();

        if (filteredA.isPresent()) {
            System.out.println(filteredA.get());
        }
    }

    private static void orElse() {
        Optional<String> filteredA = findInOurBigDatabase();
        System.out.println(filteredA.filter(name -> "Vasile".equals(name)).orElse("No Name"));
    }

    private static void orElseThrow() {
        Optional<String> filteredA = findInOurBigDatabase();
        System.out.println(filteredA.filter(name -> "Vasile".equals(name)).orElseThrow(IllegalStateException::new));
    }

    private static Optional<String> findInOurBigDatabase() {
        return Arrays.asList("Andrei", "Ana", "Cristina", "Bogdan", "Mihai").stream()
                .filter(name -> name.startsWith("A"))
                .findFirst();
    }

    public static void main(String[] args) {
//        map();
//        get();
//        orElse();
        orElseThrow();
    }


}
