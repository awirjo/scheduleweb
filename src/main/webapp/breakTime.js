function addBreakTime() {
    // Get form data
    const form = document.getElementById('add-break-form');
    const formData = new FormData(form);

    // Convert form data to JSON object
    const json = {};
    formData.forEach((value, key) => {
        json[key] = value;
    });

    // Send AJAX request
    const xhr = new XMLHttpRequest();
    xhr.open('POST', 'http://localhost:8081/scheduleweb_war_exploded/api/breakTime/addBreak');
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.onload = function() {
        if (xhr.status === 200) {
            alert('BreakTime added successfully!');
            form.reset();
        } else {
            alert('Error adding BreakTime.');
        }
    };
    xhr.send(JSON.stringify(json));
}
