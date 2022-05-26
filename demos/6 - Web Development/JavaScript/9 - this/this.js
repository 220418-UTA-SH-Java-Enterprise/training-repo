/*
    What is THIS?

    In JS, the 'this' keyword refers to the object that it belongs to.

    - By itself, this refers to the global object
    - In a function, this still refers the global object
    - In a method (in JS, a method is a function that belongs to an object), this refers to the owner object
    - In strict mode (Strict mode makes some bad coding practices return errors by placing your JS code in a more restricted variant of itself), this (in a function) returns undefined
*/

//set our JS code to strict mode
'use strict';

//console.log(this); //when we call the global object, since we are outside of a browser, it just calls an empty obj {}

function foo(){
    console.log(this); //return undefined in strict mode - not strict mode will return the global object (window)
}

//foo();

//x = 'hi'; //NOTE: declaring a variable like this is equivalent to declaring it with var in non-strict mode
//console.log(x); //in strict mode, this will return an error because it's bad practice to declare your variables like the way we did x

//make an object literal
//NOTE: an object literal is NOT JSON
//JSON is similar but not exactly the same in terms of formatting because its keys are strings as well as its values
const person = {
    firstName: 'John',
    lastName: 'Doe',
    id: 1234,
    fullName: function(){ //this is a method because it's a function that is set as a property of an object
        return `${this.firstName} ${this.lastName}`;
    }
};

console.log(person.fullName()); //non-strict mode return John Doe, and even in strict mode we still get the fullName because this refers the owner obj

this.cat = 'Finn'; //here we are setting a property to the global object
console.log(this.cat); //non-strict = Finn, strict = Finn