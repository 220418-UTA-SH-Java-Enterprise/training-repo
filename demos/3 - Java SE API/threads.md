# Threads
## What is a thread?
- A thread is an independent path of execution through program code
- Threads are light-weight sub-processes that share common memory space

## What are the different states of a thread?
* A thread can be in 1 of the following states:
    1. NEW - a thread that hasn't started yet
    2. RUNNABLE - the thread executing in the JVM
    3. BLOCKED - waiting for a monitor lock
    4. WAITING - waiting indeifinitely for another thread to perform a particular action
    5. TIMED_WAITING - a thread that is waiting for another thread during a certain time
    6. TERMINATED - a thread that has exited  

## How would you create your own thread?
- See the "HelloThreads" demo for notes on this

## What is deadlock?
- Answer on W3 study guide

## What is the producer/consumer problem?
- Answer on W3 study guide
- Also for practical code view of this, see the HelloThreads/producerconsumer demo code

## What is parellelism? Concurrency? How does it apply to threads?
- Resources here: 
1. [Medium article](https://medium.com/@peterlee2068/concurrency-and-parallelism-in-java-f625bc9b0ca4)
2. [HowToDoInJava.com article](https://howtodoinjava.com/java/multi-threading/concurrency-vs-parallelism/)
3. [Concurrency & Executors Tutorial](https://winterbe.com/posts/2015/04/07/java8-concurrency-tutorial-thread-executor-examples/)

## For more study points, please visit the curiculum and research those topics via Google/StackOverflow/etc. or use the W3 study guide resources.