
$(document).ready(function () {
    // Counties list will be loaded using Thymeleaf (mvc)
    /*
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/counties",
        data: "json",
        contentType: "application/json",
        success: function (data) {
            //let obj = $.parseJSON(data);
            let obj = data;
            $.each(obj, function (key, value) {
                $('#county_list').append('<option value="' + value.countyCode + '">' + value.countyCode + ' - ' + value.name + '</option>');
            });
        },
        error: function (data) {
            $('#county_list').append('<option>County Unavailable</option>')
        }
    });
    */

    // county change listener
    $("#county_list").change(function () {
        let subCountyList = $('#sub_county_list');
        subCountyList.find('option').remove();
        subCountyList.append('<option>Select sub-county</option>');
        let villageList = $('#village_list');
        villageList.find('option').remove();
        villageList.append('<option>Select village</option>');

        let distId1 = $('#county_list').val();
        let inputValObj = {};
        alert(distId1);
        //inputValObj.Discode = distId1;
        inputValObj.Ctycode = distId1;
        let inputVal = JSON.stringify(inputValObj);
        alert(inputVal);
        let data = inputVal.toString();
        alert(data);

        $.ajax({
            type: "GET",
            url: "http://localhost:8080/sub-counties?countyName=" + distId1,
            contentType: "application/json",
            success: function (data) {
                $.each(data, function (key, value) {
                    $('#sub_county_list').append('<option value="' + value.subCountyCode + '">' + value.subCountyCode + ' - ' + value.name + '</option>');
                })
            },
            error: function (data) {
                $('#sub_county_list').append('<option>Sub-county Unavailable</option>');
            }
        });
    });

    // sub-county change listener
    $('#sub_county_list').change(function () {
        let villageList = $('#village_list');
        villageList.find('option').remove();
        villageList.append('<option>Select village</option>');
        let distId1 = $('#county_list').val();
        let subCountyCode = $('#sub_county_list').val();
        alert(distId1 + ", subCountyCode: " + subCountyCode);
        //let inputValObj = {};
        //inputValObj.Ctycode = distId1;
        //inputValObj.SubCtyCode = subCountyCode;
        //let inputVal = JSON.stringify(inputValObj);
        //let data = inputVal.toString();

        $.ajax({
            type: "GET",
            url: "http://localhost:8080/villages?subCountyCode=" + subCountyCode,
            contentType: "application/json",
            success: function (data) {
                $.each(data, function (key, value) {
                    $('#village_list').append('<option value="' + value.id + '">' + value.id + ' - ' + value.name + '</option>');
                });
            },
            error: function (data) {
                $('#village_list').append('<option>Village Unavailable</option>');
            }
        });
    });

})
