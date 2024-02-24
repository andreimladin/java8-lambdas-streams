package ro.iteahome.java.streams;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamSamples {

    private static void createIterate() {
        Stream.iterate(40, n -> n + 2).limit(20).forEach(System.out::println);
//        Stream.iterate(40, n -> n + 2).limit(20).forEach(new CustomConsumer());
        //.forEach(name -> System.out.println(name))
    }

    private static class CustomConsumer implements Consumer<Integer> {

        @Override
        public void accept(Integer number) {
            System.out.println(number);
        }
    }
    private static void accept(Integer number) {
        System.out.println(number);
    }

    private static void createPattern() {
        Pattern.compile(", ").splitAsStream("a, b, c").forEach(System.out::println);
    }

    private static Stream<String> createCollectionStream() {
        List<String> names = new ArrayList<>();
        names.add("Andrei");
        names.add("Ana");
        names.add("Cristina");
        names.add("Bogdan");
        names.add("Mihai");

        return names.stream();
    }

    private static Stream<String> createArrayStream() {
        String[] names = new String[] {"Andrei", "Ana", "Cristina", "Bogdan", "Mihai"};
        return Arrays.stream(names);
    }

    private static void interimLimit() {
        createCollectionStream()
                .limit(2)
                .forEach(System.out::println);
        //.forEach(name -> System.out.println(name));
    }

    private static void interimSorted() {
        createArrayStream()
                .sorted()
                .forEach(System.out::println);
        //.forEach(name -> System.out.println(name));
    }

    private static void interimDistinct() {
        Arrays.asList("Andrei", "Andrei", "Cristina", "Bogdan", "Mihai").stream()
                .distinct()
                .forEach(System.out::println);
        //.forEach(name -> System.out.println(name));
    }

    private static void interimFilter() {
        Arrays.asList("Andrei", "Ana", "Cristina", "Bogdan", "Mihai").stream()
                .filter(name -> name.startsWith("A"))
//                .filter((name) -> { return name.startsWith("A");})
                .forEach(System.out::println);
        //.forEach(name -> System.out.println(name));
    }

    private static void interimMap() {
        Arrays.asList("Andrei", "Ana", "Cristina", "Bogdan", "Mihai").stream()
                .map(StreamSamples::reverse)
//                .map(name -> reverse(name))
                .forEach(System.out::println);
        //.forEach(name -> System.out.println(name));
    }

    private static void interimFlatMap() {
        Arrays.asList(
                Arrays.asList("Andrei"),
                Arrays.asList("Ana", "Cristina"),
                Arrays.asList("Bogdan", "Mihai")
                ).stream()
//                .flatMap(Collection::stream)
//                .flatMap(list -> list.stream())
                .forEach(System.out::println);
        //.forEach(name -> System.out.println(name));
    }


    private static String reverse(String sToReverse) {
        StringBuilder bReverse = new StringBuilder();
        char[] aToReverse = sToReverse.toCharArray();
        for (int i=aToReverse.length-1; i >= 0 ; i--) {
            bReverse.append(aToReverse[i]);
        }

        return bReverse.toString();
    }

    private static void interimMultiple() {
        Arrays.asList("Andrei", "Ana", "Cristina", "Bogdan", "Mihai").stream()
                .filter(name -> name.startsWith("A"))
                .map(String::toLowerCase)
//                .map(name -> name.toLowerCase())
                .forEach(System.out::println);
        //.forEach(name -> System.out.println(name));
    }

    private static void finalForEach() {
        // already present in all the other samples
    }

    private static void finalCollect() {
        List<String> filteredLowered = Arrays.asList("Andrei", "Ana", "Cristina", "Bogdan", "Mihai").stream()
                .filter(name -> {
                    System.out.println("Filter: " + name);
                    return name.startsWith("A");
                })
                .map(name -> {
                    System.out.println("Map: " + name);
                    return name.toLowerCase();
                } )
//                .map(String::toLowerCase)
                .collect(Collectors.toList());

        filteredLowered.forEach(System.out::println);
    }

    private static void finalReduce() {
        Optional<String> filteredA = Arrays.asList("Andrei", "Ana", "Cristina", "Bogdan", "Mihai").stream()
                .filter(name -> name.startsWith("A"))
                .reduce((a,b) -> a + b);
        filteredA.ifPresent(System.out::println);
    }

    private static void finalFindFirst() {
        Optional<String> filteredA = Arrays.asList("Andrei", "Ana", "Cristina", "Bogdan", "Mihai").stream()
                .filter(name -> name.startsWith("A"))
                .findFirst();
        filteredA.ifPresent(System.out::println);
    }

    private static void finalFindParallel() {

        List<String> sNumbers = Stream.iterate(0, n -> n + 1).limit(1000000)
                .map(no -> "S" + no).parallel().collect(Collectors.toList());
        Optional<String> filteredA = sNumbers.parallelStream()
//        Optional<String> filteredA = Arrays.asList("Andrei", "Ana", "Cristina", "Bogdan", "Mihai").parallelStream()
                .filter(sNo -> sNo.contains("2"))
                .findAny();
        filteredA.ifPresent(System.out::println);
    }

    private static void sample1() {
        // Create a list of strings
        List < String > colors = Arrays.asList("Red", "Green", "Blue", "Orange", "Black");

        // Specify the word to search for
        String searchColor = "Orange";

        boolean checkCond = colors.stream()
                .anyMatch(s -> searchColor.equals(s));
        System.out.println(checkCond);
    }


    public static void main(String[] args) {
//        createIterate();
//        createPattern();
//        interimLimit();
//        interimSorted();
//        interimDistinct();
//        interimFilter();
//        interimMap();
//        interimFlatMap();
//        interimMultiple();
//        finalCollect();
//        finalReduce();
//        finalFindFirst();
//        finalFindParallel();
        sample1();
    }
}
