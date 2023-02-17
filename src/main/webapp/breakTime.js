function saveBreakTime() {
    var menu = document.getElementById("menu").value;
    var department = document.getElementById("department-ids").value;
    var servingDate = document.getElementById("serving_date").value;
    var servingTime = document.getElementById("serving_time").value;

    var data = {
        serving_date: servingDate,
        serving_time: servingTime,
        menu: { id: menu },
        department: [{ id: department }],
    };

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "http://localhost:8081/scheduleweb_war_exploded/api/breakTime/addBreak",
        data: JSON.stringify(data),
        dataType: "json",
        success: function (data) {
            alert("Breaktime added successfully");
            $("#addBreakTimeModal").modal("hide");
            clearForm();
        },
        error: function (e) {
            alert("Error adding breaktime. Please try again.");
            console.log("ERROR : ", e);
        },
    });
    console.log(data);
}

function submitBreaktimeForm() {
    var form = document.getElementById("breaktime-form");
    var formData = new FormData(form);

    var xhr = new XMLHttpRequest();
    xhr.open("POST", "http://localhost:8081/scheduleweb_war_exploded/api/breakTime/addBreak");

    xhr.onload = function () {
        if (xhr.status == 200) {
            alert("Breaktime added successfully!");
            form.reset();
        } else {
            alert("Error adding breaktime");
        }
    };

    xhr.send(formData);
}

var form = document.getElementById("breaktime-form");
form.addEventListener("submit", function (event) {
    event.preventDefault();
    submitBreaktimeForm();
    console.log(data);
});
