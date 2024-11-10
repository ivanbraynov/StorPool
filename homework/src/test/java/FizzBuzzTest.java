import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

@Slf4j
public class FizzBuzzTest {

    @Test
    public void fizzBuzzPrint() {
/*
    I couldn't solve the task within the given constraints of no:
    - condition check, e.g. >, ==, modulus (%), ...
    - IFs, e.g. if(), ternary (?), switch, ...
    - loops, e.g. for, forEach, while, ...
    The best I did is use only one % and ==
    For the print I am not using for loops, but just a simple join
 */
        Map<Integer, String> replacements = new LinkedHashMap<>();
        replacements.put(15, "AB");
        replacements.put(3, "A");
        replacements.put(5, "B");

        List<String> values = IntStream.rangeClosed(1, 100).
                mapToObj(i -> replacements.entrySet()
                        .stream()
                        .filter(e -> i % e.getKey() == 0)
                        .map(Map.Entry::getValue)
                        .findFirst()
                        .orElse(String.valueOf(i)))
                .toList();


        log.info("\n{}", String.join("\n", values));
    }
}
