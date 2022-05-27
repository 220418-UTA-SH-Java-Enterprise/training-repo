const form = document.getElementById("login-form");

form.addEventListener("submit", async (event) => {
  // stop form submission
  event.preventDefault();

  //check values in form
  let uname = form.elements[0].value;
  let pw = form.elements[1].value;

  let loginTemplate = {
    username: uname,
    password: pw,
  };
  console.log(`HttpRequest body: ` + JSON.stringify(loginTemplate));

  //do http request and send to server
  try {
    const raw_response = await fetch(
      `http://localhost:9001/api/trainer/login`,
      {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
          "Access-Control-Allow-Origin": "*",
        },
        body: JSON.stringify(loginTemplate),
      }
    );

    //check for a successful response
    if (!raw_response.ok) {
      throw new Error(raw_response.status);
    }

    const json_data = await raw_response.json();

    console.log(json_data);

    //save token into a sessionStorage variable
    sessionStorage.setItem("user-auth-token", JSON.stringify(json_data));

    //set timeout to transition to the home page if user token is not null
    console.log("Success! Redirecting user to home page...");
    if (json_data !== null) {
      setTimeout(() => {
        console.log("redirect starting...");
        window.location.href = "../html/home.html";
      }, 1000);
    }
  } catch (error) {
    //this catch block is for network errors
    console.log(error);
  }
});


/******************************/
function togglePasswordView() {
  var x = document.getElementById("password");
  if (x.type === "password") {
    x.type = "text";
  } else {
    x.type = "password";
  }
}
