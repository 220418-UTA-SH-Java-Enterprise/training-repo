const form = document.getElementById("login-form");

form.addEventListener("submit", (event) => {
  // stop form submission
  event.preventDefault();

  //check values in form
  let uname = form.elements[0].value;
  let pw = form.elements[1].value;

  //start HTTPRequest with AJAX
  let xhr = new XMLHttpRequest();

  let loginTemplate = {
    username: uname,
    password: pw,
  };
  console.log(`HttpRequest body: ` + loginTemplate);

  xhr.onreadystatechange = function () {
    if (this.readyState == 4 && this.status == 200) {
      let data = JSON.parse(xhr.responseText);
      console.log(data); // do this just to check what we've parsed
      sessionStorage.setItem("currentUser", data);
      //redirect user to the success page
      window.location.replace("home.html");
    }else{
        console.log("Failed. Status Code: " + xhr.status)
        var reason = {
            code : xhr.status,
            issue : 'Failed to log in.',
            trace: xhr.responseText
        };
        console.log(reason);
        sessionStorage.setItem('failMessage', JSON.stringify(reason));
        console.log(sessionStorage.getItem('failMessage'));

        //redirect user to the error page
      window.location.replace("error.html");
    }
    console.log("Processing request...")
  };

  xhr.open("POST", 'http://localhost:9001/api/trainer/login', true);
  xhr.setRequestHeader("Content-Type", "application/json");
  xhr.setRequestHeader("Access-Control-Allow-Origin", "*");

  xhr.send(JSON.stringify(tempTrainer));
});
/******************************/
function togglePasswordView(){
  var x = document.getElementById("password");
  if (x.type === "password") {
    x.type = "text";
  } else {
    x.type = "password";
  }
}