console.log("Script loaded")
//change theme work
let currentTheme=getTheme();
//initial -->
document.addEventListener("DOMContentLoaded",() =>{
    changeTheme();
})


//TODO:
function changeTheme(){
//set to web page
changePageTheme(currentTheme, currentTheme);



//set the listner to change the theme button
const changeThemeButton = document.querySelector("#theme_change_button");


changeThemeButton.addEventListener("click",(event)=>{
    let oldTheme=currentTheme;
    console.log("change theme button clicked");
    if (currentTheme==="dark"){
        //theme ko light
        currentTheme="light";
    }
    else{
        //theme to dark
        currentTheme="dark";
    }
    changePageTheme(currentTheme,oldTheme);

 
});
}

//set theme to localstorage
function setTheme(theme){
    localStorage.setItem("theme",theme);
}

//get theme from localstorage
function getTheme(){
    let theme=localStorage.getItem("theme");
    return theme ? theme : "light";
}

//change current page theme
function changePageTheme(theme,oldTheme){
    
    //localstorage mein update krenge
    setTheme(currentTheme);
    //remove the current theme
    document.querySelector("html").classList.remove(oldTheme);
    //set the current theme
    document.querySelector("html").classList.add(theme);

    //change text of button
    document.querySelector("#theme_change_button").querySelector("span").textContent=theme== "light" ? "Dark":"Light";
}