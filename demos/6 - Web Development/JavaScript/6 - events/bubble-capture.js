/*
    Event = something that the browser does or the user does
    ex. onclick, onchange, onload, onmouseover, etc.

    - What is event propagation?
        - the order at which events are triggered in the DOM
*/
let parent1 = document.getElementById("parent-1");
let parent2 = document.getElementById("parent-2");
let child1 = document.getElementById("child-1");
let child2 = document.getElementById("child-2");

//create an event listener
//event listener handles events and can be used to manage the actions that occur during a given event

/*
    Bubbling vs Capturing

    - If element is clicked, it will trigger the event
    Bubbling:
    - If the parent element is clicked, then only the parent will be triggered (ex. p tag marked as parent1)
    - If the child element is clicked, then child would trigger followed by the parent
    - IRL example: air bubbling coming from the ocean floor and reaching the surface of the water

    Capturing:
    - If the parent element is clicked, then only the parent will be triggered (ex. p tag marked as parent2)
    - If the child element is clicked, then parent triggers first followed by child
    - IRL example: throwing a mousetrap down on top of a mouse that is eating cheese
*/

//example 1
//by default, eventListeners are set to bubbling
parent1.addEventListener('click', () => {
    console.log("I am the PARENT");
});

child1.addEventListener('click', () => {
    console.log("I am the CHILD");
});

//example 2
//to turn on capturing, we need to set the eventlistener to capturing=True
parent2.addEventListener('click', () => {
    console.log("I am the PARENT");
}, true);

child2.addEventListener('click', () => {
    console.log("I am the CHILD");
}, true);