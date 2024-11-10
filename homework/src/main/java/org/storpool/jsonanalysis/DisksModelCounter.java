package org.storpool.jsonanalysis;

import io.github.cdimascio.dotenv.Dotenv;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.storpool.enums.EnvVarsEnum;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class DisksModelCounter {
    private static final Logger logger = LoggerFactory.getLogger(DisksModelCounter.class);

    private final DownloadService downloadService = new DownloadService();
    private final DecompressionService decompressionService = new DecompressionService();
    private final DiskAnalysisService diskAnalysisService = new DiskAnalysisService();

    public static void main(String[] args) throws IOException {
        DisksModelCounter counter = new DisksModelCounter();
        counter.run();
    }

    public void run() throws IOException {
        Dotenv dotenv = Dotenv.load();
        String url = dotenv.get(EnvVarsEnum.DATA_URL.toString());
        String compressedPath = "bigf.json.bz2";
        String decompressedPath = "bigf.json";

        File downloadedFile = downloadService.downloadFile(url, compressedPath);
        File decompressedFile = decompressionService.decompressFile(downloadedFile, decompressedPath);
        Map<String, Integer> modelCounts = diskAnalysisService.analyzeDrives(decompressedFile);

        logger.info("Distinct models count: {}", modelCounts.size());
        logger.info("Model frequencies: {}", modelCounts);
    }
}
