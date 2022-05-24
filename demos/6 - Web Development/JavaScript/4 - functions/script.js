//declaration of variables
var num1 = 5;
var num2 = "45";

//functions allow us to have reusable code in JS
//THERE ARE SEVERAL WAYS TO MAKE A FUNCTION:

//1. using the function keyword
function add(n1, n2){
    var sum;
    //check the datatype of a variable
    //console.log("Number one is a number: " + Number.isInteger(n1));
    //console.log("Number two is a number: " + Number.isInteger(n2));

    //type coercion = the process of automatic/implicit conversion of values from one data type to another
    //== vs ===
    // == -> equality operator -> can be used to compare values regardless of their datatypes
    //=== -> will check for value matches along with checking if they are of the same datatype
    //REMEMBER: == doesn't type check, === does type check
    if(Number.isInteger(n1) === Number.isInteger(n2)){
        sum = n1 + n2;
    }else{
        //i will need to parse the non-numbers into number values
        sum = parseInt(n1) + parseInt(n2);
    }
    return sum;
}

var results = add(num1, num2);
console.log("Result: " + results);
document.getElementById('example1').innerHTML = `Regular Function call: ${results}`;

//2. anonymous functions
//these methods do not have a method name, instead they can be invoked by using their assigned variable name
var multiply = function(n1, n2){
    return parseInt(n1) * parseInt(n2);
};

document.getElementById('example2').innerHTML = `Anonymous Function Call: ${multiply(5, 4)}`;

//3. using arrow functions
//don't have to use function keyword or give it a method name
var square = (n) => {
    return n * n;
};

document.getElementById('example3').innerHTML = `Arrow Function Call: ${square(11)}`;

//4. callback functions
//a callback function is a function passed into another function as an argument, which is then invoked inside of the outer function to complete some kind of action
//aka a method call within a method
//a. make inner function
function alertFunc(n){
    alert(`Your answer is: ${n * 2}`);
}

//b. make our outer function
function callbackFunc(number, callback){
    //c. inside of that outer function, call our inner function (doing the callback)
    callback(number);
    return number;
}

//d. invoke our outer function
document.getElementById('example4').innerHTML = `Callback Function Call: ${callbackFunc(7, alertFunc)}`;

//5. closures
//closures give you access to an outer function's scope from use of an inner function
function complexCalcFunc(n){
    var secretNumber = n + 9;

    //a. make a closure here
    function crazyMath(){
        //NOTE: here crazyMath still remembers the value of secretNumber, despite it moving scope levels
        console.log("Your secret number is: " + secretNumber);
        console.log(`Your secret math solution is: ${secretNumber * secretNumber - 1 + 14 / 8}`);
    }

    return crazyMath;
}

let chemicalX = 24;
let myMath = complexCalcFunc(chemicalX);
myMath();
document.getElementById('example5').innerHTML = `Closure Call using: ${chemicalX}`;

/* 
    Overall we can make functions in any way possible in JS.
    Functions can be called/invoked in three different ways:
    1. called in our JS code (1)
    2. automatically invoked (aka self-invoked)(2 - 5)
    3. when an event occurs within the DOM (to be seen later)
*/