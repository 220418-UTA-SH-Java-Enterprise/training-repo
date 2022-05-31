// TypeScript is a SUPER SET of JavaScript (all JS is valid TS)
/**
 * - TS is OOP -> it allows for mnore OOP features (interfaces, classes, generics)
 * - We get a TS compiler! 
 * - TS is strongly typed!
 */
function sayHi(message: string){
    return `Hi, here is your message: ${message}`;
}

console.log(sayHi("Bob was here"));

//Node is an open-source, cross-platform, JavaScript runtime environment that can run on the V8 engine and execute JS code outside of a web browser
//NPM = node package manager
/**
 * 2 Steps to run this code
 * 
 * 1. Call the typescript compiler to transpile our TS -> JS: 
 * - If you don't have the TS compiler, do this commands: 
 * 1) sudo npm install -g typescript --force
 * 2) sudo apt install node-typescript
 * 3) cd into root folder where ts file is located
 * 4) tsc main.ts
 * 
 * 2. Run the JS file  : node main.js
 */