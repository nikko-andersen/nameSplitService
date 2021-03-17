<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Name Parser Service</title>
    <link href="styles.css" rel="stylesheet">
</head>
<body>
<div class="withBorder">
    <h2> Information page for name parser service</h2>
    <p> Below there are a few examples of how to use this service.</p>
    <p> The service returns JSON data. Click on one of the links to see an example. </p>
    <p> If you want to split one name into first and last name use /parseName with the parameter "name". </p>
    <a href="parseName?name=Nikolaj Andersen">parseName?name=Nikolaj Andersen</a>
    <br/>
    <a href="parseName?name=Kristensen, P. H.">parseName?name=Kristensen, P. H.</a>
    <br/>
    <p> If you want to split multiple names use /parseNames.</p>
    <a href="parseNames?name=H-C Jensen, Peter Hans Kristensen, John Doe">parseNames?name=H-C Jensen, Peter Hans
        Kristensen, John Doe</a>
    <br/>
</div>

</body>
</html>

