<#import "parts/common.ftl" as c>


<@c.page>

<table class="table table-bordered table-striped table-hover" xmlns:text-decoration="http://www.w3.org/1999/xhtml">      <!--striped- razdelenie strok cvetov, hover- vydelenie vybrannoj jachejki cvetom-->
    <thead>
    <tr>
        <th class="text-center" colspan="6"><span style="font-size: large; ">List of users</span></th>
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
            <td><#list user.roles as role>${role}<#sep>, </#list></td>      <!--sep"," - separator, razdeljajuwij zapjatoj-->
            <td><a href="/user/${user.id}"><span style="text-decoration: underline"><b>edit</b></span></a></td>  <!--krasoty radi, vyvodjatsja s nizhnim podcherkivaniem-->
    </tr>
    </#list>
    </tbody>
</table>
</@c.page>
