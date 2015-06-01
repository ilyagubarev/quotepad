<%@page contentType="text/html" pageEncoding="UTF-8"%>


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
