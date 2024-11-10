package org.storpool.jsonanalysis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class DownloadService {
    private static final Logger logger = LoggerFactory.getLogger(DownloadService.class);

    public File downloadFile(String fileUrl, String destinationPath) throws IOException {
        File file = new File(destinationPath);

        if (file.exists() && file.isFile()) {
            logger.info("File already exists. Skipping download.");
            return file;
        }

        try (InputStream in = URI.create(fileUrl).toURL().openStream()) {
            Files.copy(in, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }

        logger.info("File downloaded successfully to {}", destinationPath);
        return file;
    }
}
