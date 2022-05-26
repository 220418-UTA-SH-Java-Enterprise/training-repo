//target my button
const button = document.getElementById("btn");

//add an eventlistener to my button
button.addEventListener('click', async() => {
    //target the input field that holds my id value
    var id = document.getElementById("field");

    //do http request and send to server
    try {
        const raw_response = await fetch(`https://pokeapi.co/api/v2/pokemon/${id.value}`); //returns a Promise

        //check for a successful response
        if(!raw_response.ok){
            throw new Error(raw_response.status);
        }

        const json_data = await raw_response.json();

        console.log(json_data);

        //append the response data to my webpage
        //target the input area where this data is going to 
        var input = document.getElementById("input");

        var name = document.createElement('h2');
        name.innerHTML = `Name: ${json_data.name}`;
        input.append(name);

        var b = document.createElement('br');
        input.append(b);

        var id = document.createElement('h3');
        id.innerHTML = `ID: ${json_data.id}`;
        input.append(id);

        input.append(b);

        var image = document.createElement('img');
        image.setAttribute("src", json_data.sprites.front_default);
        image.setAttribute("height", "300");
        image.setAttribute("width", "300");
        input.append(image);

        input.append(b);

        var line = document.createElement('hr');
        input.append(line);
    } catch (error) {
        //this catch block is for network errors
        console.log(error);
    }
});