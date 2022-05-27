const currentUser = JSON.parse(sessionStorage.getItem('user-auth-token'));
console.log(currentUser);
window.addEventListener('load', async(event) => {
    //get token from session and check for current user is verified to be on page
    let token = currentUser.jwttoken;
    
    let verifyTemplate = {
      jwttoken: token
    };
    console.log(`HttpRequest body: ` + JSON.stringify(verifyTemplate));
    
     //do http request and send to server
     try {
      const raw_response = await fetch(`http://localhost:9001/api/trainer/verify`, {
          method: 'POST',
          headers: {
              'Content-Type': 'application/json',
              'Access-Control-Allow-Origin': '*'
          },
          body: JSON.stringify(verifyTemplate)
      });
    
      //check for a successful response
      if(!raw_response.ok){
          throw new Error(raw_response.status);
      }
    
      const json_data = await raw_response.json();
    
      console.log(json_data);
    
      //save token into a sessionStorage variable
      sessionStorage.setItem('currentUser', JSON.stringify(json_data));
      console.log(JSON.stringify(json_data));
      //set timeout to transition to the home page if user token is not null
      console.log("Success! Redirecting user to home page...")
      if(json_data !== null){
          console.log(`Successful verification for user ${json_data.username}`);
          //TODO: append username to webpage top bar
          let userHeader = document.getElementById("user-tag");
          userHeader.innerHTML =`Trainer Username: ${json_data.username}`;
          sessionStorage.setItem("trainer-username", JSON.stringify(json_data.username))
      }
    } catch (error) {
      //this catch block is for network errors
      console.log(error);
    }
});
//Get pokemon by id and send new pokemon to backend
const getOneBtn = document.getElementById("get-one");
//getOneBtn.addEventListener('click', getRandomPokemon(event));

/******************************/
function getRandomNumberBetween(min,max){
    return Math.floor(Math.random()*(max-min+1)+min);
}

async function getTrainerByUsername(){
    console.log("retrieving trainer info by username...");
    let uname = JSON.parse(sessionStorage.getItem('trainer-username'));
    console.log(uname);
    
    //do fetch request here
    try {
        const raw_response = await fetch(
          `http://localhost:9001/api/trainer/username-lookup?username=${uname}`,
          {
              headers: {
                  "Authorization": `Bearer ${currentUser.jwttoken}`
              }
          }
        ); //returns a Promise
    
        //check for a successful response
        if (!raw_response.ok) {
          throw new Error(raw_response.status);
        }
    
        const json_data = await raw_response.json();
    
        console.log(json_data);

        let trainerTemplate = {
            trainerId: json_data.trainerId,
            trainerName: json_data.trainerName,
            hometown: json_data.hometown,
            username: json_data.username,
            password: json_data.password
        };
        console.log(trainerTemplate);

        return trainerTemplate;
      } catch (error) {
        //this catch block is for network errors
        console.log(error);
        return null;
      }
}

async function addPokemon(pokemon){
    console.log(`adding pokemon to api: ${JSON.stringify(pokemon)}`);
    //do fetch request here
    try {
        const raw_response = await fetch(
          `http://localhost:9001/api/pokemon/`,
          {
              method: 'POST',
              headers: {
                  "Authorization": `Bearer ${currentUser.jwttoken}`,
                  "Content-Type": "application/json",
                  "Access-Control-Allow-Origin": "*"
              },
              body: JSON.stringify(pokemon)
          }
        ); //returns a Promise
    
        //check for a successful response
        if (!raw_response.ok) {
          throw new Error(raw_response.status);
        }
    
        const json_data = await raw_response.json();
    
        console.log(json_data);

        return json_data;
      } catch (error) {
        //this catch block is for network errors
        console.log(error);
        return null;
      }
}

async function getRandomPokemon(event) {
  console.log("getOne option selected");
  event.preventDefault();

  //generate a random number
  var id = getRandomNumberBetween(1,151);

  //do http request to pokeapi to get pokemon by id
  //do http request and send to server
  try {
    const raw_response = await fetch(
      `https://pokeapi.co/api/v2/pokemon/${id}`
    ); //returns a Promise

    //check for a successful response
    if (!raw_response.ok) {
      throw new Error(raw_response.status);
    }

    const json_data = await raw_response.json();

    console.log(json_data);

    //now I need to get the trainer by username
    const trainer = await getTrainerByUsername();

    //add pokemon to api and attach trainer to this pokemon
    console.log(json_data.types[0].type.name, json_data.types[0].type.name !== undefined);
    console.log(`More than one type: ${json_data.types.length > 1}!`);
    
    let pokemonTemplate = {
        dexid: json_data.id,
        name: json_data.name,
        type1: (json_data.types[0].type.name !== undefined) ? json_data.types[0].type.name : null,
        type2: (json_data.types.length > 1) ? json_data.types[1].type.name : null,
        ability: json_data.abilities[0].ability.name,
        move: json_data.moves[0].move.name,
        trainer: trainer
    };
    console.log(pokemonTemplate);

    //append result to webpage
    document.getElementById("api-action-title").innerHTML = "Nice catch! You got a:";

    var resultArea = document.getElementById("data");

    resultArea.innerHTML = "";

    var image = document.createElement('img');
    image.setAttribute("src", json_data.sprites.front_default);
    image.setAttribute("height", "300");
    image.setAttribute("width", "300");
    resultArea.append(image);

    var name = document.createElement("h4");
    name.innerHTML = pokemonTemplate.name.charAt(0).toUpperCase() + pokemonTemplate.name.slice(1);
    resultArea.append(name);

    //add pokemon to api
    const creationData = await addPokemon(pokemonTemplate);
    console.log(`Final result: ${JSON.stringify(creationData)}`);
  } catch (error) {
    //this catch block is for network errors
    console.log(error);
  }
}