//To avoid the callback hell, ES6 introduced promises
//this allowed us to write asynchronous code in a more managable way

//Definition: A promise is an object that MAY produce a single value at some point in the future,
//either as resolved or rejected (rejected due to some network error)
//In other words, we are able to execute our promises without it halting the main program flow

//A promise may be in 1 of 3 possible states:
//1. Fulfilled
//2. Rejected
//3. Pending

function getUser(userId){
    return new Promise((resolve, reject) => {
        console.log('Get user from database');

        setTimeout(() => {
            resolve({
                userId: userId,
                username: 'John'
            });
        }, 1000);
    });
}

function getServices(user){
    return new Promise((resolve, reject) => {
        console.log(`Get services of ${user.username} from the API`);

        setTimeout(() => {
            resolve(['Email', 'VPN', 'CDN']);
        }, 2 * 1000);
    });
}

function getServiceCost(services, callback){
    return new Promise((resolve, reject) => {
        console.log(`Calculate service costs of ${services}`);

        setTimeout(() => {
            resolve(services.length * 100);
        }, 3 * 1000);
    });
}

//instead of messy nesting from before, we can just chain our method calls
getUser(103).then(getServices).then(getServiceCost).then(console.log);

//Overall, promises are the ideal choice for handling async operations as they can provide better error handling than callbacks and events and allow for more modular/readable code;