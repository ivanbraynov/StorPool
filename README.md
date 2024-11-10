# StorPool Homework

### Prerequisites

- **Java**: Ensure you have Java 23 installed from [HERE](https://www.oracle.com/java/technologies/downloads/)
Once installed check the version by typing in your terminal `java --version`. You should see something similar to:
$ java --version
java 23.0.1 2024-10-15
Java(TM) SE Runtime Environment (build 23.0.1+11-39)
Java HotSpot(TM) 64-Bit Server VM (build 23.0.1+11-39, mixed mode, sharing)
If you get command not found, make sure you have added JAVA_HOME env var [HOW](https://docs.oracle.com/cd/E19182-01/821-0917/inst_jdk_javahome_t/index.html)

- **Maven**: Install Maven from [HERE](https://maven.apache.org/install.html).
Once installed verify the version with:
$ mvn --version
Apache Maven 3.8.5 (3599d3414f046de2324203b78ddcf9b5e4388aa0)
Maven home: C:\Dev\apache-maven-3.8.5
Java version: 23.0.1, vendor: Oracle Corporation, runtime: C:\Program Files\Java\jdk-23
Default locale: en_US, platform encoding: UTF-8
OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"
If you get command not found, make sure you have added the bin directory of the downloade and extracted maven folder into your PATH env

### Running the Tests

1. **Clone the repository**:

   ```bash
   git clone git@github.com:ivanbraynov/StorPool.git
   ```
2. **Run tests**:

   ```bash
   cd homework (where you've cloened the repo)
   mvn clean compile
   mvn test
   ```

You should see maven building the project and running some unit tests, e.g.
```
$ mvn clean test
[INFO] Scanning for projects...
[INFO]
[INFO] -----------------------< org.storpool:homework >------------------------
[INFO] Building homework 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ homework ---
[INFO] Deleting C:\Users\Ivan\Desktop\stor-pool-hmwrk\homework\target
[INFO]
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ homework ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 1 resource
[INFO]
[INFO] --- maven-compiler-plugin:3.13.0:compile (default-compile) @ homework ---
[INFO] Recompiling the module because of changed source code.
[INFO] Compiling 9 source files with javac [debug target 23] to target\classes
[INFO]
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ homework ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory C:\Users\Ivan\Desktop\stor-pool-hmwrk\homework\src\test\resources
[INFO]
[INFO] --- maven-compiler-plugin:3.13.0:testCompile (default-testCompile) @ homework ---
[INFO] Recompiling the module because of changed dependency.
[INFO] Compiling 4 source files with javac [debug target 23] to target\test-classes
[INFO]
[INFO] --- maven-surefire-plugin:3.5.2:test (default-test) @ homework ---
[INFO] Using auto detected provider org.apache.maven.surefire.junitplatform.JUnitPlatformProvider
[INFO]
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running DiskAnalysisServiceTest
19:25:17.925 [main] INFO DiskAnalysisServiceTest -- {broken=1, SSDF1=1, RDV2=2, SSDLP2=1, DRV1=1}
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.350 s -- in DiskAnalysisServiceTest
[INFO] Running FizzBuzzTest
19:25:17.949 [main] INFO FizzBuzzTest --
...
```

2. **Homework Tasks to Tests mapping**:
   
Why I went with unit tests?

I tried creating directly some classes which could be compiled and ran, but the test data files are quite huge and I couldn't optimise it enought. They take a lot of execution time or system resources.
That's why I created unit tests which should test the logic for each task. The programs can still be executed, but the JSON file is 20gb and loading it was hard. 
Couldn't optimise it by spliting the data in chunks or using buffers to read/write and loading it into the memory so that I don't make so many I/O on my nvme or 100% cpu and memory.

- 1) Counting (distinct and unique)
`homework/src/test/java/NumberAnalysisTest.java`
- 2) FizzBuzz
`homework/src/test/java/FizzBuzzTest.java`
- 3) Analysis
`homework/src/test/java/DiskAnalysisServiceTest.java`
- 4) Reverse engineering (.txt file)
`homework/src/main/java/org/storpool/reverseeng/reveng.txt`

If you want to run specific test you can do it by giving the test name to the mvn test command, e.g.
`mvn test -Dtest=DiskAnalysisServiceTest`

If you want to run the java programs and check what is happeining you can do it by running this example:
`mvn clean compile exec:java -Dexec.mainClass=org.storpool.jsonanalysis.DisksModelCounter`

