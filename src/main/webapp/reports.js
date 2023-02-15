function loadQuarterReport() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            let orderDataList = JSON.parse(this.responseText);
            document.getElementById("reportsId").innerHTML =
                this.responseText;
            //
            // console.log(orderDataList);
        }
    };
    xhttp.open("GET", "http://localhost:8081/scheduleweb_war_exploded/api/reports/quarter", true);
    xhttp.send();
}

function loadHalfYearReport() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            let orderDataList = JSON.parse(this.responseText);
            document.getElementById("reportsId").innerHTML =
                this.responseText;
            //
            // console.log(orderDataList);
        }
    };
    xhttp.open("GET", "http://localhost:8081/scheduleweb_war_exploded/api/reports/halfYear", true);
    xhttp.send();
}

function loadYearReport() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            let orderDataList = JSON.parse(this.responseText);
            document.getElementById("reportsId").innerHTML =
                this.responseText;
            //
            // console.log(orderDataList);
        }
    };
    xhttp.open("GET", "http://localhost:8081/scheduleweb_war_exploded/api/reports/year", true);
    xhttp.send();
}

