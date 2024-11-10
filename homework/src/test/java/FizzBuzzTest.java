import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.IntStream;

public class FizzBuzzTest {
    private static final Logger logger = Logger.getLogger(FizzBuzzTest.class.getName());

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
        Map<Integer, String> replacements = Map.of(
                15, "AB",
                3, "A",
                5, "B"
        );

        List<String> values = IntStream.rangeClosed(1, 100).
                mapToObj(i -> replacements.entrySet()
                        .stream()
                        .filter(e -> i % e.getKey() == 0)
                        .map(Map.Entry::getValue)
                        .findFirst()
                        .orElse(String.valueOf(i)))
                .toList();


        logger.info(String.join("\n", values));
    }
}
