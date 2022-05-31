//Interfaces in TS are an astract type that tells the compiler which property name a given object can have
//aka a way for us to have pre-compiled JS objects without worrying over implementation
// - introduced OOP into JS
//implement our interface
var user = {
    name: "Bob",
    title: "Software Engineer",
    salary: 60000,
    toDos: [34, true, "sleeping all day on the job"]
};
console.log(user);
