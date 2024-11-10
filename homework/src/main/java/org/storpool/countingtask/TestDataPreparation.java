package org.storpool.countingtask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestDataPreparation {
    private static final Logger logger = LoggerFactory.getLogger(TestDataPreparation.class);

    public List<Long> getValuesFromFile(String filePath) {
        List<Long> values = new ArrayList<>();
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filePath))) {
            while (dis.available() > 0) {
                int signedInt = dis.readInt();
                long unsignedInt = Integer.toUnsignedLong(signedInt);
                values.add(unsignedInt);
            }
            logger.info("Finished reading data from file.");
        } catch (IOException e) {
            logger.error("Error reading from file: {}", filePath, e);
        }
        return values;
    }

    public void createDataFile(int numberOfValues, String filePath) {
        Random random = new Random();
        try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(filePath)))) {
            for (int i = 0; i < numberOfValues; i++) {
                int unsignedIntValue = random.nextInt();
                dos.writeInt(unsignedIntValue);
            }
            logger.info("File creation completed successfully with {} values", numberOfValues);
        } catch (IOException e) {
            logger.error("Error writing to file: {}", filePath, e);
        }
    }
}