//Introduction to JS async/await
/*
    - Starting from Zero: The Life before Promises

    In the past when we wanted to deal with asynchronous operations, you had to use callback functions.
    When you nest multiple callback functions, the code becomes very difficult to maintain. This issue is known as "callback hell".

    Suppose you want to perform 3 async ops in your JS code:
    1. Select a user from a database
    2. Get services of the user (i.e. we are checking what internet services the user has used)
    3. Calculate the service cost based on the services that the user has used
*/

//get my user
function getUser(userId, callback){
    console.log("Get user from the database");

    setTimeout(() => {
        callback({
            userId: userId,
            username: "John"
        })
    }, 1000); //first in line in the callback quene
}

//get the services
function getServices(user, callback){
    console.log(`Get services of ${user.username} from the API`);

    setTimeout(() => {
        callback(['Email', 'VPN', 'CDN'])
    }, 2 * 1000);
}

//get the service cost
function getServiceCost(services, callback){
    console.log(`Calculate service costs of ${services}`);

    setTimeout(() => {
        callback(services.length * 100);
    }, 3 * 1000);
}

//nested services to get the final cost that the user owes for services borrowed
getUser(104, (user) => {
    //the 2nd parameter is a function passed as an argument in this function (callback function)

    getServices(user, (services) => { //implementing callback as the 2nd param for getServices method
        getServiceCost(services, (cost) => {
            console.log(`The service cost is ${cost}`)
        });
    });
});