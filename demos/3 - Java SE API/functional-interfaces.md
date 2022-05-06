# Functional Interfaces
* What is a functional interface?
- Remember: an interface is a special kind of class that cannot be instantiated. It is used to help to abstract from specific classes and emphasize the functionality for a subclass that implements it (binding that class to a "contract" of behavior).
- An functional interface is an interface whose implementation can be treated with lambda expressions
    - This type of interface is known for using a single abstract methods (SAM)
    - Note: They can also have default methods, but mostly commonly will have abstract methods
    - In implementation of these interfaces, we can do so by using lambda expressions in the method bodies of subclasses
- Any type of functional interface: 
    - is defined in the *java.util.function* package 
    - allows implemenation of functional programming
    - improves manageability of code

* So what is a lambda expression?
    - A lambda expression is a short block of code which takes in parameters and returns a value.
    - Lambda expressions are similar to methods, but they do not need a name and they can be implemented right in the body of a method:
    - Basic syntax:
    ```java
        //for one parameter expressions:
        parameter -> expression
        //for multiple parameter expressions:
        (parameter1, parameter2) -> expression
    ```
    - Note that lambda expressions can take on the form of *anonymous functions* or *anonymous classes*.
* Fun facts: 
    - The return type of a Lambda function (introduced in JDK 1.8) is a also functional interface.
    - We can also see some prefined functional interfaces in use in *Java Streams*:
    <br>
    ![Stream Pipeline with F.I. types](https://www.oracle.com/ocom/groups/public/@otn/documents/digitalasset/2179048.jpg)
    <br>

* There are some predefined functional interfaces in Java like Predicate, consumer, supplier etc. 
* Types of Functional Interfaces:
    * Supplier interfaces
        - represents a function which *doesn't take in any argument but produces a value* of type T (T = any type of result)
        - has its functional method called get()
        - Example:
        ```java
        //in the the functional interface:
        @FunctionalInterface
        public interface Supplier<T>{
            T get();
        }
        /*-----------------------*/
        //in the main class:
        import java.time.LocalDateTime;
        import java.util.function.Supplier;
        public class Example{
            public static void main(String[] args){
                //creating a supplier object
                //here we are providing implementation for the get() method to get the current time & date
                Supplier<LocalDateTime> supplier = () -> LocalDateTime.now();

                //print the result to console
                System.out.println(supplier.get());
            }
        }
        ```
        - For more examples about Suppliers, look [here](https://mkyong.com/java8/java-8-supplier-examples/).
    * Consumer interfaces
        - represents a function which *takes in one argument and don’t return any value*
        - has its functional methods called accept() and andThen()
        - Example:
        ```java
        import java.util.ArrayList;
        import java.util.LinkedList;
        import java.util.List;
        import java.util.function.Consumer;

        public class Example{
            public static void main(String[] args){
                //consumer to display a double value
                Consumer<Double> display = a -> System.out.println(a);

                //using accept() method
                display.accept(5.99);

                System.out.println("----------------------");

                // Consumer to multiply 5 to every integer of a list
                Consumer<List<Integer> > modify = list ->
                {
                    for (int i = 0; i < list.size(); i++)
                        list.set(i, 5 * list.get(i));
                };
        
                // Consumer to display a list of integers
                Consumer<List<Integer> > dispList = list -> 
                    list.stream().forEach(a -> System.out.print(a + " "));
        
                List<Integer> list = new ArrayList<Integer>();
                list.add(2);
                list.add(1);
                list.add(3);
        
                // using addThen()
                modify.andThen(dispList).accept(list);
            }
        }
        ```
        - For more examples about Consumers, look [here](https://www.javatpoint.com/java-consumer-interface).
    * Predicate interfaces:
        - accepts an argument and returns a boolean
        - allows chaining
        - makes it easier to unit test them separately
        - includes:
            - isEqual()
            - and()
            - negate()
            - or()
            - test()
        - Example:
        ```java
        import java.util.function.Predicate;

        public class Example{
            public static void main(String[] args){
                //creating a predicate
                Predicate<Integer> greaterThanTwenty = i -> (i > 20);
                Predicate<Integer> lowerThanFifty = i -> (i < 50>);

                //calling our predicate
                System.out.println(greaterThanTwenty.test(17));

                //example of predicate chaining
                boolean result = greaterThanTwenty.and(lowerThanFifty).test(35);
                System.out.println(result);
            }
        }
        ```
        - For more examples about Predicates, look [here](https://www.geeksforgeeks.org/java-8-predicate-with-examples/).
    * Function interfaces
        - represents a function which *takes in one argument **and** produces a result*
        - has the following functional methods:
            - apply()
            - andThen()
            - compose()
            - identify()
        - See examples [here](https://www.geeksforgeeks.org/function-interface-in-java-with-examples/)