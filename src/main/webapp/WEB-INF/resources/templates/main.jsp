<%@page contentType="text/html" pageEncoding="utf-8"%>

<!DOCTYPE html>

<html data-ng-app="quotepad">

    <head>
        <base href="${system.path}">
        <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
        <title>Quote Pad</title>
        <link rel="stylesheet" type="text/css" href="resources/styles/general.css"/>
    </head>

    <body data-ng-controller="controller">

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

        <script type="text/javascript" src="resources/scripts/utility/system/external/angular.js"></script>
        <script type="text/javascript" src="resources/scripts/application/main.js"></script>
        <!--
            <script type="text/javascript" src="resources/scripts/utility/system/external/require.js"></script>
            <script type="text/javascript" src="resources/scripts/configuration.js"></script>
        -->
    </body>
</html>
