<#include "security.ftl">
<#import "pager.ftl" as p>

<@p.pager url page />

<div class="card-columns" id="message-list">
    <#list page.content as message>
        <div class="card my-3" data-id="${message.id}">
            <#if message.filename??>
                <img src="/img/${message.filename}" class="card-img-top"/>
            </#if>
            <div class="m-2">
                <span>${message.text}</span>
                <p><i>#${message.tag}</i></p>
            </div>
            <div class="card-footer text-muted">
                <a href="/user-messages/${message.author.id}">${message.authorName}</a>
                <#if message.author.id == currentUserId>
                <a class="btn btn-primary" href="/user-messages/${message.author.id}?message=${message.id}">
                    Edit
                </a>
                </#if>
            </div>
        </div>
    <#else>
        No messages
    </#list>
</div>

<#if page.getNumberOfElements() gt 5>
    <@p.pager url page />
</#if>