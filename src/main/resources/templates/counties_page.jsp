<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Spring Boot App - Counties</title>

    <script type="application/javascript" src="/jquery-3.7.1.js"></script>
    <script type="application/javascript" src="/ajaxcall.js"></script>
</head>
<body>
<table border="1" cellpadding="10px" cellspacing="5px">
    <tr>
        <td>County:</td>
        <td>
            <select id="countyList" name="countyList" required>
                <option disabled selected>Select County</option>
            </select>
        </td>
    </tr>

    <tr>
        <td>Sub-county:</td>
        <td>
            <select id="subCountyList" name="subCountyList" required>
                <option disabled selected>Select Sub-County</option>
            </select>
        </td>
    </tr>

    <tr>
        <td>Village:</td>
        <td>
            <select id="villageList" name="villageList" required>
                <option disabled>Select Village</option>
            </select>
        </td>
    </tr>
</table>
</body>
</html>
