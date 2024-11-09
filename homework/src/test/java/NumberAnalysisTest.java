import org.junit.jupiter.api.Test;
import org.storpool.countingtask.NumberAnalysis;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberAnalysisTest {
    private final NumberAnalysis numberAnalysis = new NumberAnalysis();

//    а) count the unique numbers. For example:

    @Test
    public void testCountDistinctNumbers_2_distinct() {
        //0x100 0x100 0xfff 0xfff -> 2 unique numbers
        List<Long> values = Arrays.asList(1L, 1L, 2L, 2L);
        int expectedDistinctCount = 2; // Distinct values: 1, 2
        assertEquals(expectedDistinctCount, numberAnalysis.countDistinctNumbers(values),
                "Distinct count should match the expected number of unique elements.");
    }

    @Test
    public void testCountDistinctNumbers_1_distinct() {
        //0x100 0x100 0x100 0x100 -> 1 unique number
        List<Long> values = Arrays.asList(1L, 1L, 1L, 1L);
        int expectedDistinctCount = 1; // Distinct values: 1
        assertEquals(expectedDistinctCount, numberAnalysis.countDistinctNumbers(values),
                "Distinct count should match the expected number of unique elements.");
    }

    @Test
    public void testCountDistinctNumbers_3_distinct() {
        //0x100 0x100 0x800 0xfff -> 3 unique numbers
        List<Long> values = Arrays.asList(1L, 1L, 2L, 3L);
        int expectedDistinctCount = 3; // Distinct values: 1, 2, 3
        assertEquals(expectedDistinctCount, numberAnalysis.countDistinctNumbers(values),
                "Distinct count should match the expected number of unique elements.");
    }

    @Test
    public void testCountDistinctNumbersEmptyList() {
        List<Long> values = List.of();
        int expectedDistinctCount = 0;
        assertEquals(expectedDistinctCount, numberAnalysis.countDistinctNumbers(values),
                "Distinct count for an empty list should be 0.");
    }

//    b) count how many numbers are seen ONLY once. For example:

    @Test
    public void testCountUniqueNumbers_0_unique() {
        //0x100 0x100 0xfff 0xfff -> 0 numbers seen only once
        List<Long> values = Arrays.asList(1L, 1L, 2L, 2L);
        long expectedUniqueCount = 0;
        assertEquals(expectedUniqueCount, numberAnalysis.countUniqueNumbers(values),
                "Unique count should match the expected number of elements that appear only once.");
    }

    @Test
    public void testCountUniqueNumbers_0_unique_all_same() {
        //0x100 0x100 0xfff 0xfff -> 0 numbers seen only once
        List<Long> values = Arrays.asList(1L, 1L, 1L, 1L);
        long expectedUniqueCount = 0;
        assertEquals(expectedUniqueCount, numberAnalysis.countUniqueNumbers(values),
                "Unique count should match the expected number of elements that appear only once.");
    }

    @Test
    public void testCountUniqueNumbers_2_unique() {
        //0x100 0x100 0x800 0xfff -> 2 numbers seen only once
        List<Long> values = Arrays.asList(1L, 1L, 2L, 3L);
        long expectedUniqueCount = 2; // Unique values: 2, 3
        assertEquals(expectedUniqueCount, numberAnalysis.countUniqueNumbers(values),
                "Unique count should match the expected number of elements that appear only once.");
    }

    @Test
    public void testCountUniqueNumbersEmptyList() {
        List<Long> values = List.of();
        long expectedUniqueCount = 0;
        assertEquals(expectedUniqueCount, numberAnalysis.countUniqueNumbers(values),
                "Unique count for an empty list should be 0.");
    }
}
