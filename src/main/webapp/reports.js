// getQuarterReport function
function getQuarterReport() {
    $.ajax({
        url: "http://localhost:8081/scheduleweb_war_exploded/api/reports/quarter",
        type: "GET",
        success: function(response) {
            response.sort(function(a, b) {
                return new Date(a.serving_date) - new Date(b.serving_date);
            });
            var reportData = document.getElementById('report-data');
            reportData.innerHTML = '';
            var ul = document.createElement('ul');
            response.forEach(function(item) {
                var li = document.createElement('li');
                li.innerHTML = 'ID: ' + item.id + ', Serving Time: ' + item.serving_time + ', Serving Date: ' + item.serving_date;
                ul.appendChild(li);
            });
            reportData.appendChild(ul);
        },
        error: function(xhr, status, error) {
            console.log("Error: " + error); // handle error
        }
    });
}

// getHalfYearReport function
function getHalfYearReport() {
    $.ajax({
        url: "http://localhost:8081/scheduleweb_war_exploded/api/reports/halfYear",
        type: "GET",
        success: function(response) {
            response.sort(function(a, b) {
                return new Date(a.serving_date) - new Date(b.serving_date);
            });
            var reportData = document.getElementById('report-data');
            reportData.innerHTML = '';
            var ul = document.createElement('ul');
            response.forEach(function(item) {
                var li = document.createElement('li');
                li.innerHTML = 'ID: ' + item.id + ', Serving Time: ' + item.serving_time + ', Serving Date: ' + item.serving_date;
                ul.appendChild(li);
            });
            reportData.appendChild(ul);
        },
        error: function(xhr, status, error) {
            console.log("Error: " + error); // handle error
        }
    });
}

// getYearReport function
function getYearReport() {
    $.ajax({
        url: "http://localhost:8081/scheduleweb_war_exploded/api/reports/year",
        type: "GET",
        success: function(response) {
            response.sort(function(a, b) {
                return new Date(a.serving_date) - new Date(b.serving_date);
            });
            var reportData = document.getElementById('report-data');
            reportData.innerHTML = '';
            var ul = document.createElement('ul');
            response.forEach(function(item) {
                var li = document.createElement('li');
                li.innerHTML = 'ID: ' + item.id + ', Serving Time: ' + item.serving_time + ', Serving Date: ' + item.serving_date;
                ul.appendChild(li);
            });
            reportData.appendChild(ul);
        },
        error: function(xhr, status, error) {
            console.log("Error: " + error); // handle error
        }
    });
}

$(document).ready(function() {
    // Attach a click event to the button with ID quarter-btn
    $("#quarter-btn").click(getQuarterReport);

    // Attach a click event to the button with ID halfYear-btn
    $("#halfYear-btn").click(getHalfYearReport);

    // Attach a click event to the button with ID year-btn
    $("#year-btn").click(getYearReport);
});
