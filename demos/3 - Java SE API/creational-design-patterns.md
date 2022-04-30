# Creational Design Patterns
- Creational design patterns are concerned with the way of creating objects. These design patterns are used when a decision must be made at the time of instantiation of a class (i.e. creating an object of a class).

> Everyone knows an object is created by using new keyword in Java, but that's not the only way to make new objects.

- Examples of creational design patterns:
    1. POJO design pattern
    2. Singleton design pattern
    3. Factory design pattern

## Factory Design Pattern
### Overview
> Factory pattern is one of the most used design patterns in Java. 

- It is a creational design pattern that allows us to create objects without exposing the creation logic (i.e. the details of the classes) to the end-user.

- In the factory design pattern, we refer to newly created objects using a common interface or abstract class.

- Basic Implementation:
![Example Factory D.P. Diagram](https://media.geeksforgeeks.org/wp-content/uploads/20200427212325/Class-Diagram-12.png)

### Factory Design Pattern Advantages
1. Factory design pattern provides approach to code for interface rather than implementation.

2. Factory pattern removes the instantiation of actual implementation classes from client code. Factory pattern makes our code more robust, less coupled and easy to extend. For example, we can easily change PC class implementation because client program is unaware of this.

3. Factory pattern provides abstraction between implementation and client classes through inheritance.

### References:
- [GeekForGeeks Article on the Factory Design Pattern](https://www.geeksforgeeks.org/factory-method-design-pattern-in-java/)

## Singleton Design Pattern
### Overview
> The Singleton Design Pattern is a creational design pattern that provides a single point of access to other parts of your application.

- This design pattern involves a single class which is responsible to create an object while making sure that only single object gets created. This class provides a way to access its only object which can be accessed directly without need to instantiate the object of the class.

### Singleton Design Pattern Advantages
- For best practices for applying the Singleton pattern, check out this article: [Singleton Pattern Best Practices in Java Code](https://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples)

### References
- [Singletons in Java](https://www.baeldung.com/java-singleton)

## Common QC Questions
- What is a creational design pattern?
- List some creational design patterns. Explain what each do.
- When would you use ___ design pattern?
- What advantage does each design pattern pose? What problem do each resolve in your Java applications?