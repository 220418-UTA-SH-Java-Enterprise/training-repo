class ClassMates{
    //JS classes give us the ability to implement OOP in JS
    //were introduced in ES6
    //So we can make constructors and functions that can be used in other parts of our JS code

    constructor(name, age, course){
        this.name = name;
        this.age = age;
        this.course = course;
    }

    displayInfo(){
        return `${this.name} is ${this.age} years old and is studying ${this.course}`;
    }
}

//using my class here
let classmate = new ClassMates("Bob Smith", 19, "Economics");

console.log(classmate.displayInfo());
/*
Why use JS classes?
- offer an improved means for creating object templates
- replace the previous means of using constructor functions for object
- makes our code more manageable and reusable in other parts of our JS code
*/

//how we convert our class data into JSON and back
//JSON object in JS gives us access to two methods:
//1. stringify (will convert any JS objects into JSON strings)
//2. parse (will turn any JSON string into a JS object)

//show the object
console.log(classmate);

//turn object into JSON
console.log(JSON.stringify(classmate));
var json = JSON.stringify(classmate);

//turn this JSON string back into a JS object
console.log(JSON.parse(json));