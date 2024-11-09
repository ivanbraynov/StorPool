import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.storpool.countingtask.TestDataPreparation;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestDataPreparationTest {
    private TestDataPreparation testDataPreparation;
    private Path tempFile;

    @BeforeEach
    public void setUp() throws IOException {
        testDataPreparation = new TestDataPreparation();
        tempFile = Files.createTempFile("testDataFile", ".dat");
    }

    @AfterEach
    public void tearDown() throws IOException {
        Files.deleteIfExists(tempFile);
    }

    @Test
    public void testCreateDataFile() {
        int numberOfValues = 10;
        testDataPreparation.createDataFile(numberOfValues, tempFile.toString());
        File file = tempFile.toFile();
        assertTrue(file.exists(), "Data file should be created.");
        assertTrue(file.length() > 0, "Data file should contain data.");
    }

    @Test
    public void testGetValuesFromFile() {
        int numberOfValues = 10;
        testDataPreparation.createDataFile(numberOfValues, tempFile.toString());
        List<Long> values = testDataPreparation.getValuesFromFile(tempFile.toString());
        assertEquals(numberOfValues, values.size(),
                "The number of values read from file should match the number written.");
    }

    @Test
    public void testGetValuesFromFileEmptyFile() throws IOException {
        Files.write(tempFile, new byte[0]);
        List<Long> values = testDataPreparation.getValuesFromFile(tempFile.toString());
        assertTrue(values.isEmpty(), "Values list should be empty for an empty file.");
    }
}
