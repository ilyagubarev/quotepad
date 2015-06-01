<%@page contentType="text/html" pageEncoding="utf-8"%>

<!DOCTYPE html>

<html data-ng-app="quotepad">

    <head>
        <base href="${system.path}">
        <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
        <title>Quote Pad</title>
        <link rel="stylesheet" type="text/css" href="resources/styles/general.css"/>
    </head>

    <body data-ng-controller="authorController">

        <input type="button" value="Update" data-ng-click="renew()"/></br>

        <table>
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Country</th>
                </tr>
            </thead>
            <tbody>
                <tr data-ng-repeat="author in authors">
                    <td>{{author.name}}</td>
                    <td>{{author.country}}</td>
                </tr>
            </tbody>
        </table>

        <input type="text" data-ng-model="name" placeholder="Name"/><br>
        <input type="text" data-ng-model="country" placeholder="Country"/><br>
        <input type="button" value="Add" data-ng-click="add(name, country)"/>

        <script type="text/javascript" src="resources/scripts/utility/system/external/angular.js"></script>
        <script type="text/javascript" src="resources/scripts/application/main.js"></script>
    </body>
</html>
