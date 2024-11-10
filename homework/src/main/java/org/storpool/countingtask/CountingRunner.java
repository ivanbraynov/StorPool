package org.storpool.countingtask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public class CountingRunner {
    private static final Logger logger = LoggerFactory.getLogger(CountingRunner.class.getName());
    private final TestDataPreparation dataPreparation;
    private final NumberAnalysis numberAnalysis;

    public CountingRunner(TestDataPreparation dataPreparation, NumberAnalysis numberAnalysis) {
        this.dataPreparation = dataPreparation;
        this.numberAnalysis = numberAnalysis;
    }

    public static void main(String[] args) {
        TestDataPreparation dataPreparation = new TestDataPreparation();
        NumberAnalysis numberAnalysis = new NumberAnalysis();
        CountingRunner runner = new CountingRunner(dataPreparation, numberAnalysis);
        runner.run();
    }

    public void run() {
        String filePath = "int-numbers.dat";
        dataPreparation.createDataFile(1_000_000_000, filePath);
        List<Long> values = dataPreparation.getValuesFromFile(filePath);
        logger.info("{} unique numbers", numberAnalysis.countDistinctNumbers(values));
        logger.info("{} numbers seen only once", numberAnalysis.countUniqueNumbers(values));
    }
}
