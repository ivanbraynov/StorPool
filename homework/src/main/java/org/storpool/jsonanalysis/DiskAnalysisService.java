package org.storpool.jsonanalysis;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.storpool.jsonanalysis.pojo.Disk;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiskAnalysisService {

    public Map<String, Integer> analyzeDrives(File jsonFile) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Disk> disks;

        try (FileInputStream fis = new FileInputStream(jsonFile)) {
            disks = mapper.readValue(fis, new TypeReference<>() {
            });
        }

        Map<String, Integer> modelCounts = new HashMap<>();
        for (Disk disk : disks) {
            modelCounts.merge(disk.getModel(), 1, Integer::sum);
        }

        return modelCounts;
    }
}
