var count = 'bananas';
//count = 6; compile time error due to static typing on this variable
var apples = 'granny smith'; //full initialization and declaration of our variable
//var list: string[] = ['sleep', 'text', 'eat'];
var list = ['sleep', 'text', 'eat'];
//any type allows us to have flexible of typing with any given variable, class, or interface
if (list.length <= 3) {
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
var ColorRed = 0;
var ColorBlue = 1;
var ColorGreen = 2;
//newer way of doing enums in js
var Colors;
(function (Colors) {
    Colors[Colors["Red"] = 0] = "Red";
    Colors[Colors["Blue"] = 1] = "Blue";
    Colors[Colors["Green"] = 2] = "Green";
})(Colors || (Colors = {}));
;
console.log(Colors.Red);
