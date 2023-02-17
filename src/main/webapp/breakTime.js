function addBreakTime() {
    var formData = {
        serving_time: $('#serving_time').val(),
        serving_date: $('#serving_date').val(),
        menu: {id: $('#menu_id').val()},
        department: [{id: $('#department_id').val()}]
    };

    $.ajax({
        url: "http://localhost:8081/scheduleweb_war_exploded/api/breakTime/addBreak",
        type: "POST",
        data: JSON.stringify(formData),
        contentType: "application/json",
        success: function(data) {
            alert("Breaktime added successfully");
        },
        error: function(xhr, status, error) {
            alert("Error adding breaktime: " + error);
        }
    });

}
