<#import  "parts/common.ftl" as c>

<@c.page>
   <h2 class="text-center" style="color:#007bff">${userChannel.username}</h2>
    <div class="ml-4" style="font-size: xx-large">${type}</div>
    <ul>
        <#list users as user>
            <li class="list-group-item" style="column-width: 100px">
                <a href="/user-messages/${user.id}">${user.getUsername()}</a>
            </li>
        </#list>
    </ul>
</@c.page>