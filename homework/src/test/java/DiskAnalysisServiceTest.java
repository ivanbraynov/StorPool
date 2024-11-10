import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.storpool.jsonanalysis.DiskAnalysisService;
import org.storpool.jsonanalysis.pojo.Disk;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class DiskAnalysisServiceTest {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private DiskAnalysisService diskAnalysisService;
    private Path tempFile;

    @BeforeEach
    public void setUp() throws IOException {
        diskAnalysisService = new DiskAnalysisService();
        tempFile = Files.createTempFile("test_disks", ".json");

        List<Disk> disks = Arrays.asList(
                new Disk(0, "RDV2", "HD92731454"),
                new Disk(1, "DRV1", "HD78784271"),
                new Disk(2, "SSDLP2", "HD74286234"),
                new Disk(3, "SSDF1", "HD18368977"),
                new Disk(4, "RDV2", "HD23456789"),
                new Disk(5, "broken", "HD11456789")
        );

        objectMapper.writeValue(tempFile.toFile(), disks);
    }

    @Test
    public void testAnalyzeDrives() throws Exception {
        File testFile = tempFile.toFile();

        Map<String, Integer> modelCounts = diskAnalysisService.analyzeDrives(testFile);

        log.info(String.valueOf(modelCounts));

        assertEquals(5, modelCounts.size(), "Expected 5 unique models");

        assertEquals(2, modelCounts.get("RDV2"), "Expected RDV2 to appear 2 times");
        assertEquals(1, modelCounts.get("DRV1"), "Expected DRV1 to appear 1 time");
        assertEquals(1, modelCounts.get("SSDLP2"), "Expected SSDLP2 to appear 1 time");
        assertEquals(1, modelCounts.get("SSDF1"), "Expected SSDF1 to appear 1 time");
        assertEquals(1, modelCounts.get("broken"), "Expected broken to appear 1 time");
    }

    @AfterEach
    public void tearDown() throws IOException {
        Files.deleteIfExists(tempFile);
    }
}
