//declaration for my target HTML element
var parentDiv = document.getElementById("example");

//make an array in JS
//indexing of arrays in JS is the same as java (0, 1, 2, etc)
const dbzCharacters = ["Goku", "Vegeta", "Piccolo", "Krillan", "Yamcha"];

//access an element within my array
//make a new HTMLElement and attach it to my webpage
let element = document.createElement('h3');
element.innerHTML = `Accessing an element from array: ${dbzCharacters[1]}`;
parentDiv.append(element);

//append a horizonal line to my webpage
var elem = document.createElement("hr");
parentDiv.append(elem);

//iterate through my array
let header = document.createElement('h2');
header.innerHTML = "Full DBZ Character List: ";
parentDiv.append(header);

let container = document.createElement('div');

//for loop
// for (let index = 0; index < dbzCharacters.length; index++) {
//     const character = dbzCharacters[index];
//     var placeholder = document.createElement('p');
//     placeholder.innerHTML = character;
//     container.append(placeholder);
// }

//foreach loop
//look similar to a functional interface in Java because it uses a lamdba expression to execute
dbzCharacters.forEach( element => {
    let placeholder = document.createElement('span');
    //no need for access to the index number when using foreach loop
    placeholder.innerHTML = `${element}    `;
    container.append(placeholder);
});

//forin, forof loop
//for collections or objects in JS, you would prefer to use these
for (const char in dbzCharacters) {
    if (Object.hasOwnProperty.call(dbzCharacters, char)) {
        const person = dbzCharacters[char];
        let placeholder = document.createElement('h5');
        //no need for access to the index number when using foreach loop
        placeholder.innerHTML = `${person}    `;
        container.append(placeholder);
    }
}

parentDiv.append(container);