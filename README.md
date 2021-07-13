# Requirements
- Java 11+
- Maven 
- MPJ in system path - [check tutorial](http://mpj-express.org/guides.html)

 
# Building project
To build project execure maven clean install command
For Windows OS:

    mvn clean install -DskipTests -DscriptExtension=bat

For Linux OS:

    chmod -x omp4j-compile.sh

    mvn clean install -DskipTests -X -DscriptExtension=sh

# Running application
Compilation produces 2 jar files:
- Multithreading-1.1-SNAPSHOT.jar
- Multithreading-1.1-SNAPSHOT-mpj.jar

##### Base version:
Jar without `mpj` suffinx is an implementation of dictionary for:
- Sequential execution
- Multithread execution
- OMP4j execution
- RMI (RPC) execution

Run program by executing command from `target` directory:

    java -jar Multithreading-1.1-SNAPSHOT.jar

##### MPJ version:
Jar containing `mpj` suffinx is an implementation of dictionary on MPJ.
Run program by executing command.

`np 3` - thread count - 3 threads will be executed
`smok` - example word to search in dictionary

For Windows OS:

    mpjrun.bat -np 3 -jar .\Multithreading-1.1-SNAPSHOT-mpj.jar smok
    
For Linux OS:

    mpjrun.sh -np 3 -jar ./Multithreading-1.1-SNAPSHOT-mpj.jar smok
