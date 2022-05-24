//1. declare some variable of each type
var num = 10;
var str = "10 is my favorite number";
var bool = false;
var nullData = null;
var undefinedData = "";

//symbols allow us to create "hidden" properties of an object, that no other part of code can accidentally
//access or overwrite.
var id = Symbol("id");
var Person = {
    firstName: "John",
    lastName: "Jacobs",
    toDos: ["eat", "sleep", "work", "exercise"],
    sayHi: (fname) => {
        //this is an example of string interpolation
        return `Hello ${fname}!`;
    },
    [id]: 12376
};

//2. Display each within their labelled spans
let numEx = document.getElementById("num-ex");
let strEx = document.getElementById("str-ex");
let boolEx = document.getElementById("bool-ex");
let nullEx = document.getElementById("null-ex");
let undEx = document.getElementById("und-ex");
let objEx = document.getElementById("obj-ex");
let symEx = document.getElementById("sym-ex");

//target the inner HTML
numEx.innerHTML = num;
strEx.innerHTML = str;
//boolEx.innerHTML = bool;

//with any conditional statement, variables can either be truthy (valid value associated with it) or it can be falsey (false, 0, -0, "", null, undefined, NaN - not a number)
//truthy = true, "hi", " ", 19, anything that has any value
console.log(bool);
if(bool){
    boolEx.innerHTML = "I am a true value";
}else{
    boolEx.innerHTML = "I am a false value";
}

if(!nullData){
    nullEx.innerHTML = "no value is home for this variable";
}

if(!undefinedData){
    undEx.innerHTML = "Sorry, I was declared but not defined";
}

//show the object as a string
//objEx.innerHTML = Person;
//to show objects in JS, we must convert them in JSON strings
//you can access keys within your JS object through the use of dot notation
objEx.innerHTML = `${JSON.stringify(Person)}, sayHi(): "${Person.sayHi(Person.firstName)}"`;

//with symbols you have to use [] to access the hidden keys in JS objects
symEx.innerHTML = Person[id];