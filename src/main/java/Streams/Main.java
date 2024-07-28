package Streams;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> salaryList = new ArrayList<>();
        salaryList.add(2300);
        salaryList.add(6000);
        salaryList.add(7300);
        salaryList.add(5000);
        salaryList.add(9000);

        // filter all salary which is greater than 5000
        long result = salaryList.stream().filter((Integer sal) -> sal > 5000).count();
        System.out.println("Total number of employees with salary > 5000: " + result);

        // filter
        Stream<String> greeting = Stream.of("Hi", "Everyone", "Do", "you", "learn", "streams");
        Stream<String> filteredStream = greeting.filter((String name) -> name.length() <= 3);
        System.out.println(filteredStream.collect(Collectors.toList()));

        // map
        Stream<String> greeting1 = Stream.of("Hi", "Everyone", "Do", "you", "learn", "streams");
        Stream<String> filteredStream1 = greeting1.map((String name) -> name.toUpperCase());
        System.out.println(filteredStream1.collect(Collectors.toList()));

        // parallel stream
        // task splitting - splitter function

        List<Integer> numbers = Arrays.asList(11, 22, 33, 44, 55, 66, 77, 88, 99, 110, 32, 65, 89, 56, 65, 68, 32, 31);

        /**
         * Sequential stream processing
         */
        long sequentialProcessingStartTime = System.currentTimeMillis();

        numbers.stream().map((Integer val) -> val * val)
                .forEach((Integer val) -> System.out.print(val + " "));
        System.out.println("Sequential processing Time taken: " + (System.currentTimeMillis() - sequentialProcessingStartTime + " milliseconds"));
        System.out.println("-----------------------------");
        /**
         * Parallel stream processing
         */
        long parallelProcessingStartTime = System.currentTimeMillis();
        numbers.parallelStream().map((Integer val) -> val * val)
                .forEach((Integer val) -> System.out.print(val + " "));
        System.out.println("Parallel processing Time taken: " + (System.currentTimeMillis() - parallelProcessingStartTime + " milliseconds"));

    }
}
