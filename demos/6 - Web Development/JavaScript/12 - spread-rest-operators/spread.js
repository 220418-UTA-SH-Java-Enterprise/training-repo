/*
    Spread & Rest Operators in JS:
    - These two operators share the same syntax (...), but they behave differently depending on how they are used.
*/

//Spread operator: allows iterables like arrays or object literal properties to be expanded/added into single elements
let array = [1, 2, 3, 26, 78];
let arr2 = [-1, 0, ...array]; //spread operator "spreads" the array into a list of parameters that are then put into the result array here

console.log(arr2);


//spread example on an object literal
let hobbies = ['sleeping', 'rolling around', 'wagging tail'];
let animal = {
    name: "Fido",
    species: "Dog",
    hobbies: [...hobbies]
};

console.log(animal);