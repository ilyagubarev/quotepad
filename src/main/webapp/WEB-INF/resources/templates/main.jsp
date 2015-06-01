<%@page contentType="text/html" pageEncoding="utf-8"%>

<!DOCTYPE html>

<html data-ng-app="quotepad">

    <head>
        <base href="${system.path}">
        <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
        <title>Quote Pad</title>
        <link rel="stylesheet" type="text/css" href="resources/styles/general.css"/>
    </head>

    <body>

        <a ui-sref="home">Home</a><br/>
        <a ui-sref="authors">Authors</a><br/>
        <a ui-sref="works">Works</a><br/>

        <div ui-view></div>

        <script type="text/javascript" src="resources/scripts/utility/system/external/angular.js"></script>
        <script type="text/javascript" src="resources/scripts/utility/system/external/angular-ui-router.js"></script>
        <script type="text/javascript" src="resources/scripts/application/main.js"></script>
    </body>
</html>
