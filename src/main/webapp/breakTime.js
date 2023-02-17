function addBreakTime() {
    document.getElementById("breaktime-form").addEventListener("submit", function (event) {
        event.preventDefault();
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                alert("BreakTime added successfully!");
            }
        };
        xhttp.open("POST", "http://localhost:8081/scheduleweb_war_exploded/api/breakTime/addBreak", true);
        xhttp.setRequestHeader("Content-Type", "application/json");
        var breakTime = {
            "serving_time": document.getElementById("serving_time").value,
            "serving_date": document.getElementById("serving_date").value,
            "menu": {"id": document.getElementById("menu").value},
            "department": [{"id": document.getElementById("department").value}]
        };
        xhttp.send(JSON.stringify(breakTime));
    });


}
