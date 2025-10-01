import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilterDivisibleByFive {
    public static void main(String[] args) {
        // Step 1: Create an ArrayList with the specified integers
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(4);
        numbers.add(5);
        numbers.add(20);
        numbers.add(30);
        numbers.add(6);

        // Step 2: Use Streams to filter numbers divisible by 5
        List<Integer> divisibleByFive = numbers.stream()
                .filter(num -> num % 5 == 0) // Filter condition
                .collect(Collectors.toList()); // Collect results into a List

        // Step 3: Print the filtered numbers
        System.out.println("Numbers divisible by 5: " + divisibleByFive);
    }
}
