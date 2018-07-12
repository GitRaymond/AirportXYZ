function getAirports() {

}


const apiBase = "http://localhost:8085/api/";

function getAirportFleet(apiBase, airportId, apiEnd) {
    const api = apiBase + "airports/" + airportId +"/" + apiEnd;
    // api = String(api);
    $.get(api, function(data) {
        if (data){
            console.log(data);
            const elementId = "#dataTable" + airportId;
            const dataTable = $(elementId);
            dataTable.DataTable().clear();
            dataTable.DataTable().rows.add(data.airport);
            dataTable.DataTable().columns.adjust().draw();
            dataTable.dataTable().api().ajax.reload();
        }
    });
}
getAirportFleet(apiBase,1,"fleets");

// getAirportFleet(apiBase,1,"");