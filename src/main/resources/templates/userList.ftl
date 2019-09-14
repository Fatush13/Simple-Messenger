<#import "parts/common.ftl" as c>

<@c.page>

<table class="table table-bordered table-striped table-hover">
    <thead>
    <tr>
        <th class="text-center" colspan="6"><font size="5">List of users</font></th>
    </tr>
    <tr>
        <th>Name&nbsp;</th>
        <th>&nbsp;Role</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <#list users as user>
        <tr>
            <td>${user.username}</td>
            <td><#list user.roles as role>${role}<#sep>, </#list></td>
            <td><a href="/user/${user.id}"><p style="text-decoration: underline"><b>edit</b></p></a> </td>
        </tr>
    </#list>
    </tbody>
</table>
</@c.page>