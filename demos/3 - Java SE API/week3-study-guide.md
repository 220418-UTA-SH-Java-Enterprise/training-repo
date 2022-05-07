# Week 3: Java SE API's and Multithreading
## Threads
1. What is multi-threading?
    + Handling multiple threads / paths of execution in your program.

2. In what ways can you create a thread?
   + By extending the Thread Class or by implementing the `Runnable` Interface. You must call Thread's `.start()` method to start it as a new thread of execution.

3. Lifecycle of a thread
    + When created, in NEW state.
    + When `.start()` is called, it goes to RUNNABLE state.
    + When `.run()` is called, goes to RUNNING state.
    + If `.sleep()` or `.wait()` is called, will go to WAITING.
    + If dependent on another thread to release a lock, it will go to BLOCKED state.
    + When finished executing, will be in DEAD state and cannot be restarted.

4. What is deadlock?
    + When two or more threads are waiting on locks held by the others, such that no thread can execute

5. What is synchronized keyword?
    + Only allowing one thread access to the method or variable at a time - enforces thread-safety

6. Explain the [Producer/Consumer Problem](https://www.geeksforgeeks.org/producer-consumer-solution-using-threads-java/).

7. What does `.wait()` do to a thread? `.notify()`? [Resource](https://www.baeldung.com/java-wait-notify)

8. Why is Thread Pooling important? What about JDBC pooling?

9. What is the Executor Service Design Pattern? How does it apply to running tasks with threads? [Resource](https://www.baeldung.com/java-executor-service-tutorial)

<br>

## Advanced Java
- What are lambdas and why are they useful in Java?

- What is a **functional interface**? Name a few included in the JRE:
  - Predicate - `test()`
  - Consumer - `accept()`
  - Supplier - `get()`

- What is an Anonymous Class? Can you give an example of when we've used one?

- Can a class be `static`? 
  - Great resource on this [here](https://www.javatpoint.com/why-we-use-static-class-in-java) :point_left:

- What is the difference between the `Comparator` and `Comparable` Interface?
  - Very clear resource [here](https://www.geeksforgeeks.org/comparable-vs-comparator-in-java/) :point_left:

<br>

## Collections (review)
- Describe the `Iterable` interface. [Resource](https://www.geeksforgeeks.org/iterable-interface-in-java/)
  - Root Interface of the Java Collections API

- What is an `iterator()`?
  - You can iterate the elements of a Java Iterable (an object of a class that implements `Iterable interface`) by obtaining a Java Iterator from it by calling the Iterable `iterator()` method. 

<br>

```java
List<String> list = new ArrayList><();

list.add("one");
list.add("two");
list.add("three");

Iterator<String> iterator = list.iterator();

while(iterator.hasNext()) {
    String element = iterator.next();
    System.out.println( element );
}
```

<br>

- What is the **time complexity (Big O notation)** of insertion from an ArrayList?
  - Big O Notation of **search from an ArrayList**?
  - Big O notation of **search from a LinkedList**?
  - Big O Notation of **search, insert & delete from a Hashmap**?

- What's the difference between TreeMap and HashMap?

<br>

## Reflection
- What is Reflection? What package does it come from in the JRE?

- What is Introspection?

- What does it mean to modify beahvior at runtime?

- What is a Dynamic Proxy? Invocation Handler?

## DS & A
- What is a depth-first/breadth-first search algorithm? How would one look like in your Java code? 
- How does each algorithm do in performance in an application? 
- What is the time/space complexity of each searching algorithm?
[Resource for Depth-first vs Breadth-first](https://www.geeksforgeeks.org/difference-between-bfs-and-dfs/)
- What is a binary search? [Resource](https://www.geeksforgeeks.org/binary-search/)
- What are enums? [Resource](https://www.geeksforgeeks.org/enum-in-java/)

## Misc.
- Be able to describe each of these technologies and how to use them:
  - JaCoCo
    - How to run a JaCoCo report? (run `mvn test` in the root project directory in the terminal)
    - What kind of metrics do you get from a generated JaCoCo report?
  - Postman
    - What can you use it for?

- Know these Linux commands to do the following (also know basic syntax for each):
    - How to examine the contents of a website from the terminal
    - How to find the relative path to any given directory or file 
    - How to find the absolute path to any given directory or file