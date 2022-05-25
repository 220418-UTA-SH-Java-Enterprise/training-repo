function changeBlue(){
    let parent = document.getElementById("parent-1");
    //set the color change to be delayed by 3 seconds
    setTimeout(() => {
        console.log('Please wait...');
        //apply the class bluegradient to the parent
        parent.classList.add("color-bluegradient");
    }, 3000);

    console.log("Done: The background color is now blue.");
}

//now make changeGreen function
function changeGreen(){
    let parent = document.getElementById("parent-2");
    //set the color change to be delayed by 3 seconds
    setTimeout(() => {
        console.log('Please wait...');
        //apply the class bluegradient to the parent
        parent.classList.add("color-greengradient");
    }, 3000);

    console.log("Done: The background color is now green.");
}