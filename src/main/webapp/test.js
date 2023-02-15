function loadList() {
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


                    ' <img src="images/icons8-reading-48.png" class="w3-bar-item w3-circle w3-hide-small" style="width:85px"> ' +
                    ' <div class="w3-bar-item"> ' +
                    ' <span> Breakfast: ' +  menuDataList[index].breakfast  + ' </span><br> ' +
                    ' <span> Lunch: ' +  menuDataList[index].lunch  + ' </span> <br>' +
                    ' <span> Lunch: ' +  menuDataList[index].dinner  + ' </span> <br>' +
                    ' <span> Lunch: ' +  menuDataList[index].special_meals  + ' </span> <br>' +
                    ' <span> ISBN: ' +  menuDataList[index].description  + ' </span> ' +
                    ' </div> ';
            }
            menuList += "</ul>";
            document.getElementById("menuData").innerHTML = menuList;
        }
    };
    xhttp.open("GET", "http://localhost:8081/scheduleweb_war_exploded/api/menu/list", true);
    xhttp.send();
}

function loadDoc() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            let menuDataList = JSON.parse(this.responseText);
            // document.getElementById("demo").innerHTML =
            //     this.responseText;
            //
            console.log(menuDataList);
        }
    };
    xhttp.open("GET", "http://localhost:8081/scheduleweb_war_exploded/api/menu/list", true);
    xhttp.send();
}
