package org.storpool.jsonanalysis;

import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DecompressionService {
    private static final Logger logger = LoggerFactory.getLogger(DecompressionService.class);

    public File decompressFile(File compressedFile, String decompressedPath) throws IOException {
        File decompressedFile = new File(decompressedPath);
        logger.info("Starting file {} decompression in {}",compressedFile.toPath(), decompressedPath);

        try (FileInputStream fis = new FileInputStream(compressedFile);
             BZip2CompressorInputStream bzIn = new BZip2CompressorInputStream(fis);
             FileOutputStream fos = new FileOutputStream(decompressedFile)) {

            final byte[] buffer = new byte[1024];
            int n;
            while (-1 != (n = bzIn.read(buffer))) {
                fos.write(buffer, 0, n);
            }
        }

        logger.info("File decompressed successfully to {}", decompressedPath);
        return decompressedFile;
    }
}