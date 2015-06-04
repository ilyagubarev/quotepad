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

        <div data-ui-view="header"></div>
        <div data-ui-view="content"></div>
        <div data-ui-view="footer"></div>

        <!-- angular scripts -->
        <script type="text/javascript" src="resources/scripts/external/angular.js"></script>
        <script type="text/javascript" src="resources/scripts/external/angular-ui-router.js"></script>

        <!-- application scripts -->
        <script type="text/javascript" src="resources/scripts/quotepad/module.js"></script>
        <script type="text/javascript" src="resources/scripts/quotepad/routing.js"></script>
        <script type="text/javascript" src="resources/scripts/quotepad/authors/module.js"></script>
        <script type="text/javascript" src="resources/scripts/quotepad/authors/controller.js"></script>
        <script type="text/javascript" src="resources/scripts/quotepad/authors/routing.js"></script>
        <script type="text/javascript" src="resources/scripts/quotepad/quotes/module.js"></script>
        <script type="text/javascript" src="resources/scripts/quotepad/quotes/routing.js"></script>
        <script type="text/javascript" src="resources/scripts/quotepad/works/module.js"></script>
        <script type="text/javascript" src="resources/scripts/quotepad/works/routing.js"></script>
    </body>
</html>
