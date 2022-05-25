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
//target our button that will trigger the event
let button = document.getElementById("btn");



button.addEventListener("click", () => {
    //do AJAX!
    //STEP 1: Create XmlHttpRequest object
    let xhr = new XMLHttpRequest();

    //STEP 1.5: Make an template for the incoming form data
    //target the form values on our page
    let form = document.getElementById("field").value;

    //STEP 2: Define the behaviors of our responses as they come back from the server
    /*
        A readyState is a property which signifies that state that the request is currently in.
        There are several states:
        0: UNSENT - opening of the request has yet to be called
        1: OPENED - open() has been called
        2: HEADERS_RECEIVED: send() has been called[aka the request has been sent], and the headers of the response as well as the status are now available.
        3: LOADING: downloading the response. Therefore, the responseText (which is a xhr property) is holding partial data.
        4: DONE: the entire operation is now complete


        Why need readyStates?
        Ofter you can implement other transitions or animations to your webpages by triggering them at given readyStates.
        ex. loading screens
    */
   xhr.onreadystatechange = function(){
       //200 status code is a OK response
       //which means that everything was processed correctly
       if(this.readyState == 4 && this.status == 200){
        let data = JSON.parse(xhr.responseText);
        console.log(data);
        renderHTML(data);
       }
   };

   //STEP 3: Open the request
   xhr.open("GET", `https://pokeapi.co/api/v2/pokemon/${form}`);

   //STEP 4: send the request
   xhr.send();
})

function renderHTML(data){
    //target the p tag that will hold the response data
    let resp = document.getElementById("input");

    //append all response data to my webpage
    resp.append("Name: " + data.name);
    resp.append(document.createElement('br'));

    resp.append("ID: " + data.id);
    resp.append(document.createElement('br'));

    let image = document.createElement('img');
    image.setAttribute("src", data.sprites.front_default);
    image.setAttribute("height", "300");
    image.setAttribute("weight", "300");
    resp.append(image);
    resp.append(document.createElement('hr'));
}