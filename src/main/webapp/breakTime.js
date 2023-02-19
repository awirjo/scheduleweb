function submitBreaktimeForm() {
    var form = document.getElementById("breaktime-form");
    var servingDate = document.getElementById("serving-date").value;
    var servingTime = document.getElementById("serving-time").value;
    var menu = document.getElementById("menu").value;
    var department = document.getElementById("department-ids").value;

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
        menu_id: menu,
        department_ids: [department]
    });

    xhr.send(data);
}

var form = document.getElementById("breaktime-form");
form.addEventListener("submit", function(event) {
    event.preventDefault();
    submitBreaktimeForm();
});
