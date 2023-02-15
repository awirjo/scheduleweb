function loadDataList() {
    let xmlHttpRequest = new XMLHttpRequest();
    xmlHttpRequest.onreadystatechange = function () {
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
                    ' <span> Dinner: ' +  menuDataList[index].dinner  + ' </span> <br>' +
                    ' <span> Specials: ' +  menuDataList[index].special_meals  + ' </span> <br>' +
                    ' <span> Description: ' +  menuDataList[index].description  + ' </span> ' +
                    ' </div> ';
            }
            menuList += "</ul>";
            document.getElementById("menuData").innerHTML = menuList;
        }
    };
    xmlHttpRequest.open("GET", "http://localhost:8081/scheduleweb_war_exploded/api/menu/list", true);
    xmlHttpRequest.send();
}
