var count = 'bananas';
//count = 6; compile time error due to static typing on this variable
var apples: string = 'granny smith'; //full initialization and declaration of our variable

//var list: string[] = ['sleep', 'text', 'eat'];
var list: any[] = ['sleep', 'text', 'eat'];
//any type allows us to have flexible of typing with any given variable, class, or interface

if(list.length <= 3){
    list[0] = 5;
}

var newString = list[0];

newString = 'bob';

console.log(newString);

console.log(list);

/** TS is STATICALLY typed! You can't reassign a variable of different type once it is initialized */
//Enums allows us to make constants in JS
//enums will look very funky in js
//old way of doing enums in js
const ColorRed = 0;
const ColorBlue = 1;
const ColorGreen = 2;

//newer way of doing enums in ts
enum Colors {'Red', 'Blue', 'Green'}; //way easier to keep organized

console.log(Colors.Red);

//Enums are useful where we want to set a list/grouping of named constants in our applications
//This will make it easier to document intentions of state of events throughout our app runtime
//ex. in video games, devs would normally track when the game is IN_PLAY, PAUSED, STARTED, or GAME_OVER
//used in logical statements (if blocks and switch cases)