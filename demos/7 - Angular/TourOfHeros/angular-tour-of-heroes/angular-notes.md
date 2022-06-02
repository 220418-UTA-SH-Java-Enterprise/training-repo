# Angular Notes
- What are the differences between directives and decorators?
    - Directive changes the appearence/behavior or the layout of the DOM (Document Object Model)
    - Syntax: `*[directiveName]="[directive value or logic]"`
    - Three types of directives:
        - Structural directive:
            - change the DOM layour by adding or removing DOM elements
            - `ngIf`, `ngFor`, `ngSwitch`
        - Attribute directives
            - change the appearence or behavior of a particular element, component, or another directive
            - `ngClass`, `ngStyle`
            - we can also build our own directives as attribute directives:
                example:
                The @Input decorator is another example of how we can create our own attribute directive
                    - This decorator will mark a class field as an input property and supply configuration metadata
                    - This input property will then bound to a DOM property within the template
        - Components
            - treated as directives because of the fact that they always have a template and only one component can be instantiated per an element in a template
            - subset of directives
    - Decorators:
        - These are similar in syntax and purpose when compared to annotations in Java. BUT THEY ARE NOT THE SAME!
        - will denote any given class field, class, or module in Angular with configuration metadata that the Angular framework will understand
        - Examples: @Component, @NgModule, @Service, etc.