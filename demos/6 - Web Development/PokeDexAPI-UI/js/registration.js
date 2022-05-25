/*
  AJAX stands for Asynchronous JavaScript And XML

  It allows for performing javascript actions asynchronously.
  Generally used in conjunction with http requests, as we can wait
  for the response in the background while still doing other things.

  One of the biggest advantages of JS is the responsiveness it provides
  to our webpages. We can easily respond to events on our frontend and manipulate
  the DOM using basic JS functions.

  But the magic JS does not end there. We can use JS to make asynchronous
  requests to servers. We do this with AJAX.
  We want our application to continue to be responsive, while waiting
  for the server to respond. By sending the request and receiving the
  response asynchronously, we accomplish this.

  Note that AJAX has XML in it's name, but that primarily has its origin in
  and older era, where XML was used far more frequently as a data interchange
  format. Nowadays, we primarily use JSON. There are still some places that
  use XML, but JSON is a bit more popular.
*/

// In AJAX, you send a request using the XMLHttpRequest object,
// which is built into JS
const form = document.getElementById("register");
console.log(form);
form.addEventListener('submit', (event) => {
  // stop form submission
  event.preventDefault();
  //check values in form
  //console.log(form.elements);
  let name = form.elements[0].value;
  let hometown = form.elements[1].value;
  let username = form.elements[2].value;
  let pw = form.elements[3].value;

  //Now we can start AJAX request
  //STEP 1
  // This object is used for asynchronous requests to your server. 
  let xhr = new XMLHttpRequest();

  //STEP 2
  //set up template JS object for JSON parsing
  let tempTrainer = {
    trainerName: name,
    hometown: hometown,
    username: username,
    password: pw
  };
  console.log(tempTrainer);

  /*
    A readyState is a property which signifies that state that
    the request is currently in.
    There are several states:

    0. UNSENT : open() has not yet been called
    1. OPENED : open() has been called
    2. HEADERS_RECEIVED : send() has been called, and the headers of
        the response as well as the status are now available
    3. LOADING : Downloading the response. responseText (the xhr property) holds
        partial data
    4. DONE : The entire operation is now complete
  */
  //STEP 3
    xhr.onreadystatechange = function() {
    // An HTTP status code of 200, means OK
    // This means the request was processed correctly
    // and we should have acceptable data
    // readyState == 4 means that the operation is done
    if(this.readyState == 4 && this.status == 200) {
      let data = JSON.parse(xhr.responseText);
      console.log(data); // do this just to check what we've parsed
      sessionStorage.setItem('message', xhr.responseText);
      
      //redirect user to the success page
      window.location.replace("success.html");
    }else if(this.readyState ===4 && xhr.status ===204) {
        console.log("Failed. Status Code: " + xhr.status)
        var reason = {
            code : xhr.status,
            issue : 'Failed to log in. Incorrect Username or Password.'
        };
        console.log(reason);
        sessionStorage.setItem('failMessage', JSON.stringify(reason));
        console.log(sessionStorage.getItem('failMessage'));
    }else if(this.readyState ===4 && xhr.status === 415) {
      console.log("Failed on Frontend. Status Code: " + xhr.status)
      var reason = {
          code : xhr.status,
          issue : 'METHOD NOT ALLOWED'
      };
      console.log(reason);
      sessionStorage.setItem('failMessage', JSON.stringify(reason));
      console.log(sessionStorage.getItem('failMessage'));
  }
    console.log("Processing")
  };


  //STEP 4
  //open the request
  xhr.open("POST", 'http://localhost:9001/api/trainer/register', true);
  // This URL is setup to respond with a type of application/json
  // when it receives a GET request
  // GET is an HTTP verb/method which means we will be retrieving data
  // with this request
  // We also have the url

  xhr.setRequestHeader("Content-Type", "application/json");
  xhr.setRequestHeader("Access-Control-Allow-Origin", "*");
  console.log(xhr);
  //STEP 5
  //Send the request
  xhr.send(JSON.stringify(tempTrainer));
});