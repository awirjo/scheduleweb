function populateBreaktimeTable(breaktimes) {
    var table = document.getElementById("breaktime-table").getElementsByTagName("tbody")[0];
    for (var i = 0; i < breaktimes.length; i++) {
        var breaktime = breaktimes[i];
        var row = table.insertRow(i);

        var idCell = row.insertCell(0);
        idCell.innerHTML = breaktime.id;

        var servingTimeCell = row.insertCell(1);
        servingTimeCell.innerHTML = breaktime.serving_time;

        var servingDateCell = row.insertCell(2);
        servingDateCell.innerHTML = breaktime.serving_date;

        // Add a new column for the delete button
        var deleteCell = row.insertCell(3);
        var deleteButton = document.createElement("button");
        deleteButton.innerHTML = "Delete";
        deleteButton.onclick = function() {
            deleteBreaktime(breaktime.id);
        };
        deleteCell.appendChild(deleteButton);
    }
}

function getBreaktimes() {
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "http://localhost:8081/scheduleweb_war_exploded/api/breakTime/breakList");
    xhr.onload = function () {
        if (xhr.status == 200) {
            var breaktimes = JSON.parse(xhr.responseText);
            populateBreaktimeTable(breaktimes);
        } else {
            alert("Error loading breaktimes");
        }
    };
    xhr.send();
}

getBreaktimes();

function submitBreaktimeForm() {
    var form = document.getElementById("breaktime-form");
    var servingDate = document.getElementById("serving-date").value;
    var servingTime = document.getElementById("serving-time").value;
    var menu = document.getElementById("menu-id").value;
    var department = [document.getElementById("department-ids").value];

    var xhr = new XMLHttpRequest();
    xhr.open("POST", "http://localhost:8081/scheduleweb_war_exploded/api/breakTime/addBreak");
    xhr.setRequestHeader("Content-Type", "application/json");

    xhr.onload = function () {
        if (xhr.status == 200) {
            alert("Breaktime added successfully!");
            form.reset();
        } else {
            alert("Error adding breaktime");
        }
    };

    var data = JSON.stringify({
        serving_date: servingDate,
        serving_time: servingTime,
        menu: {
            id: menu
        },
        department: department.map(id => {return {id: id};})
    });

    xhr.send(data);
}

var form = document.getElementById("breaktime-form");
form.addEventListener("submit", function(event) {
    event.preventDefault();
    submitBreaktimeForm();
});


function deleteBreaktime(id) {
    var xhr = new XMLHttpRequest();
    xhr.open("DELETE", "http://localhost:8081/scheduleweb_war_exploded/api/breakTime/remove");
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.onload = function() {
        if (xhr.status === 200 || xhr.status === 204) {
            alert("Breaktime deleted successfully!");
            location.reload();
        } else {
            alert("Error deleting breaktime");
        }
    };
    xhr.send(JSON.stringify(id));
}


