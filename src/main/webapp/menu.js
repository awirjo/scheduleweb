loadMenuList();

function loadMenuList() {
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            let menuDataList = JSON.parse(this.responseText);
            let menuList = ' <ul class="w3-ul w3-card-4"> ';

            menuDataList.reverse();

            for (let index = 0; index < menuDataList.length; index++) {
                menuList +=
                    ' <li class="w3-bar"> ' +

                    ' <button id= ' + menuDataList[index].id + ' onclick="editMenu(this.id)" ' +
                    ' class="w3-bar-item w3-button w3-small w3-right">Edit</button> ' +

                    ' <button id=' + menuDataList[index].id + ' onclick="removeMenu(this.id)" ' +
                    ' class="w3-bar-item w3-button w3-small w3-right">Remove</button> ' +


                    ' <img src="pics/menu.png" class="w3-bar-item w3-circle w3-hide-small" style="width:85px"> ' +
                    ' <div class="w3-bar-item"> ' +
                    ' <span> Breakfast: ' +  menuDataList[index].breakfast  + ' </span><br> ' +
                    ' <span> Lunch: ' +  menuDataList[index].lunch  + ' </span> <br>' +
                    ' <span> Dinner: ' +  menuDataList[index].dinner  + ' </span> <br>' +
                    ' <span> Specials: ' +  menuDataList[index].special_meals  + ' </span> <br>' +
                    ' <span> Description: ' +  menuDataList[index].description  + ' </span> ' +
                    ' </div> ';
            }
            menuList += "</ul>";
            document.getElementById("menuData").innerHTML = menuList;
        }
    };
    xhttp.open("GET", "http://localhost:8081/scheduleweb_war_exploded/api/menu/list", true);
    xhttp.send();
}
function addMenu(){
    let menu = {
        "breakfast" : document.getElementById("breakfast").value,
        "lunch" : document.getElementById("lunch").value,
        "dinner" : document.getElementById("dinner").value,
        "special_meals" : document.getElementById("special_meals").value,
        "description" : document.getElementById("description").value
    }
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open ("POST", "http://localhost:8081/scheduleweb_war_exploded/api/menu/add", true);
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState>3 && xmlhttp.status==200) { loadMenuList(); clearInputFields();}
    };
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(JSON.stringify(menu));
}

function updateMenu()
{
    let menu = {
        "id" : document.getElementById("menuId").value,
        "breakfast" : document.getElementById("breakfast").value,
        "lunch" : document.getElementById("lunch").value,
        "dinner" : document.getElementById("dinner").value,
        "special_meals" : document.getElementById("special_meals").value,
        "description" : document.getElementById("description").value
    }
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("PUT", "http://localhost:8081/scheduleweb_war_exploded/api/menu/update", true);
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState>3 && xmlhttp.status==200) { loadMenuList(); clearInputFields(); document.getElementById("btnSaveMenu").innerHTML = "Add Menu";}
    };
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(JSON.stringify(menu));
}

function deleteMenu(menuId)
{
    var xhttp = new XMLHttpRequest();
    xhttp.open("DELETE", "http://localhost:8081/scheduleweb_war_exploded/api/menu/remove", true);
    xhttp.onreadystatechange = function() {
        if (xhttp.readyState>3 && xhttp.status==200) { loadMenuList(); }
    };
    xhttp.setRequestHeader("Content-Type", "application/json");
    xhttp.send(JSON.stringify(menuId));
}

function getMenu(menuId)
{
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState>3 && xhttp.status==200) {
            let foundmenu = JSON.parse(this.responseText);

            document.getElementById("menuId").value = foundmenu.id;
            document.getElementById("breakfast").value = foundmenu.breakfast;
            document.getElementById("lunch").value = foundmenu.lunch;
            document.getElementById("dinner").value = foundmenu.dinner;
            document.getElementById("special_meals").value = foundmenu.special_meals;
            document.getElementById("description").value = foundmenu.description;


            document.getElementById("btnSaveMenu").innerHTML = "Update Menu";
        }
    };
    xhttp.open("POST", "http://localhost:8081/scheduleweb_war_exploded/api/menu/getMenu", true);
    xhttp.setRequestHeader("Content-Type", "application/json");
    xhttp.send(JSON.stringify(menuId));

}
function clearInputFields()
{
    document.getElementById("menuId").value = "";
    document.getElementById("breakfast").value = "";
    document.getElementById("lunch").value = "";
    document.getElementById("dinner").value = "";
    document.getElementById("special_meals").value = "";
    document.getElementById("description").value = "";
    document.getElementById("btnSaveBook").innerHTML = "Add Book";
}
function editMenu(menuId){
    getMenu(menuId)
}

function removeMenu(menuId){
    if ( confirm("Are you sure you want to delete this menu?") ) {
        deleteMenu(menuId);
    }
}

function saveMenu()
{
    if(validateForm())
    {
        const menuId = document.getElementById("menuId").value;
        if(menuId)
        {
            updateMenu()
        }
        else
        {
            addMenu()
        }
    }
}
function validateForm()
{
    let pass = true;
    let breakfast = document.getElementById("breakfast").value;
    let lunch = document.getElementById("lunch").value;
    let dinner = document.getElementById("dinner").value;

    if (breakfast == null || breakfast == "", lunch == null || lunch == "", dinner == null || dinner == "")
    {
        alert("Please fill in all the fields.");
        pass = false;
    }

    return pass;
}
