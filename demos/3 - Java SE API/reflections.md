## Reflections API
- What is Reflection API?
  - The first component of the Reflection API is the mechanism used to fetch information about a class. This mechanism is built into the class named Class. The special class Class is the universal type for the meta information that describes objects within the Java system. Class loaders in the Java system return objects of type Class. Up until now the three most interesting methods in this class were:
  - `.forName()`, which would load a class of a given name, using the current class loader
  - `.getName()`, which would return the name of the class as a String object,which was useful for identifying object references by their class name
  - `.newInstance()`, which would invoke the null constructor on the class (if it exists) and return you an object instance of that class of object
  - To these three useful methods the Reflection API adds some additional methods to class Class. These are as follows:
    - `getConstructor`, `getConstructors`, `getDeclaredConstructor`
    - `getMethod`, `getMethods`, `getDeclaredMethods`
    - `getField`, `getFields`, `getDeclaredFields`
    - `getSuperclass`
    - `getInterfaces`
    - `getDeclaredClasses`
  - To know more about Reflections, be sure to review the `HelloReflections` demo.
