<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">

<@c.page>
    <h5>Hello and welcome, <#if user??>${name}<#else>guest</#if> !</h5>
    <div>Fell free to use this simple messenger of mine.</div>
</@c.page>
