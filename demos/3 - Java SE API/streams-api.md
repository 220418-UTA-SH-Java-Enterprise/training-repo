# Streams API
Introduced in Java 8, the Streams API is used to process collections of objects. 

* So what is a stream?
    - A stream is a sequence of objects that supports various methods which can be pipelined to produced the desired result.
    - It is *NOT* a collection. It takes input from the Collections, Arrays, or I/O channels.

* Streams don't change the original data structure; they only provide the result as per the pipelined methods.

* Advantages of Streams:
    - Brings functional programming to Java
        - Functional programming = the process of building software by composing pure functions, avoiding shared state, mutable data, and side-effects
        - In this case, we can avoid using flow-control statements (which makes the code harder to follow) and requires writing pure, non-randomly state-altering functions (which are less likely to be buggy).
    - Will make you write more efficient Java code
    - Makes heavy use of lambda expressions
    - ParallelStreams make it very easy to do multi-thread operations

* Breaking Down the Stream:
- A stream pipeline consists of a source, followed by zero or more intermediate operations, and a terminal operation.
<br>
![Stream Pipeline](https://1.bp.blogspot.com/-XEU2WqWiI4g/XZc3e0v8djI/AAAAAAAAAhg/WTdc1dqVwiUAmizN-abuvSNRWuYSy_UrQCEwYBhgL/s1600/Ska%25CC%2588rmavbild%2B2019-10-03%2Bkl.%2B09.42.17.png)
<br>

**Stream Source**
* Streams can be created from Collections, Lists, Sets, ints, longs, doubles, arrays, lines of a file
* Java 8 also offers the possibility to create streams out of three primitive types: int, long and double. As Stream<T> is a generic interface, and there is no way to use primitives as a type parameter with generics, three new special interfaces were created: IntStream, LongStream, DoubleStream.

* Stream operations are either intermediate or terminal.
    - **Intermediate operations** such as filter, map, or sort return a stream so we can chain multiple intermediate operations.
    - **Terminal operations** such as forEach, collect, or reduce are either void or return a non-stream result.

**Intermediate Operations**
- Zero or more intermediate operations are allowed.
- Order matters for large datasets: **filter first**, then sort or map.
- For very large datasets, use ParallelStream to enable multiple threads.
- Intermediate operations include:
    - anyMatch()
    - distinct()
    - filter()
    - findFirst()
    - flatMap()
    - map()
    - skip()
    - sorted()

**Terminal Operations**
- One terminal operation is allowed
    - forEach applies the same function to each element 
    - collect saves the elements into a collection
    - other options **reduce** the stream to a single summary element
- Terminal operations include:
    - count()
    - max()
    - min()
    - reduce()
    - summaryStatistics()

* So when should I use a stream?
- Most commonly you would use a stream to do the following steps:
    1. To avoid concurrency issues
    2. Decrease the performance demand on the JVM and local processor cores
    3. Reduce the lines of operations in the overall application as it gets bigger

* By default, any stream operation is processed sequentially (in order of usage), unless explicitly specified as parellel.
    - Parallel computing (aka parallelism) involves dividing a problem into subproblems, solving those problems simultaneously (in parallel, with each subproblem running in a separate thread), and then combining the results of the solutions to the subproblems. To find out more, click [here](https://docs.oracle.com/javase/tutorial/collections/streams/parallelism.html)
    - Sequential streams use a single thread to process the pipeline, making the outcome as a predictable order:
    ex.
    ```java
    List<Integer> listOfGrades = Arrays.asList(75, 62, 93, 54);
    listOfGrades.stream().forEach(grade ->
        System.out.println(grade + " " + Thread.currentThread().getName())
    );
    ```
    - To transform a stream from sequential to parellel:
        1. adding a *parellel* method to a sequential stream:
        ```java
        List<Integer> listOfGrades = Arrays.asList(75, 62, 93, 54);
        listOfGrades.parallel().forEach(grade ->
            System.out.println(grade + " " + Thread.currentThread().getName())
        );
        ```

        2. creating a stream using the *parellelStream* method of a collection:
        ```java
        List<Integer> listOfGrades = Arrays.asList(75, 62, 93, 54);
        listOfGrades.parallelStream().forEach(grade ->
            System.out.println(grade + " " + Thread.currentThread().getName())
        );
        ```
    - Parallel streams allows code to be executed in parellel on separate core processors, making the order of execution differ each time you run the program.
        - This is possible due to Java's join-fork framework and how it handles tasks between multiple threads.

# References:
- [Beginner's Guide to Java 8 Streams](https://javaconceptoftheday.com/java-8-streams-beginners-guide/)
- [Java Streams API](https://techblogstation.com/java/java-stream-api/)
- [When to Use a Parellel Stream](https://www.baeldung.com/java-when-to-use-parallel-stream)