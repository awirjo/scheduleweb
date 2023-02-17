function addBreakTime() {
    var formData = {
        serving_time: $('#serving_time').val(),
        serving_date: $('#serving_date').val(),
        menu: {id: $('#menu_id').val()},
        department: [{id: $('#department_id').val()}]
    };

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/scheduleweb/api/breakTime/addBreak",
        data: JSON.stringify(formData),
        dataType: 'json',
        success: function (data) {
            alert("Breaktime successfully added.");
            window.location.href = "/scheduleweb/breaktime.html";
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert("Error adding breaktime: " + jqXHR.responseText);
        }
    });
}
