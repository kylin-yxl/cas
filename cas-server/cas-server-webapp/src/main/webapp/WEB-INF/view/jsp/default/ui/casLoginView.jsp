<%@ page contentType="text/html; charset=UTF-8" %>
<jsp:directive.include file="includes/top.jsp" />
	<div class="login-wrap">
		<div class="loginbox">
	        <form:form method="post" id="form" cssClass="fm-v" style="vertical-align: c;" commandName="${commandName}" htmlEscape="true">
	        	<div  class="control-group normal_text">
					<h3>伯乐物流信息科技平台</h3>
				</div>
	            <div class="login_box_row">
	                <c:if test="${not empty sessionScope.openIdLocalId}">
	                    <strong>${sessionScope.openIdLocalId}</strong>
	                    <input type="hidden" id="username" name="username" value="${sessionScope.openIdLocalId}"/>
	                </c:if>
	
	                <c:if test="${empty sessionScope.openIdLocalId}">
	                    <spring:message code="screen.welcome.label.netid.accesskey" var="userNameAccessKey" />
	                    <form:input cssClass="required form-control" cssErrorClass="error" name="username" id="username" size="20" tabindex="1" accesskey="${userNameAccessKey}" path="username" autocomplete="false" htmlEscape="true"  placeholder="请输入用户名"  />
	                </c:if>
	            </div>
	            <div class="login_box_row">
	                <spring:message code="screen.welcome.label.password.accesskey" var="passwordAccessKey" />
	                <form:password cssClass="required form-control" cssErrorClass="error" name="password" id="password" size="20" tabindex="2" path="password"  accesskey="${passwordAccessKey}" htmlEscape="true" autocomplete="off"  placeholder="请输入密码"  />
	            </div>
	            <c:if test="${errorNum>=3}">
 	            <div class="login_box_row">
	                <form:input cssClass="required imgverifycode form-control" cssErrorClass="error required form-control" id="imgverifycode" name="imgverifycode" path="imgverifycode" size="20" tabindex="3" htmlEscape="true" autocomplete="off" placeholder="输入验证码" />
	                <img id="codeImg" src="<%=path %>/captchacode" onclick="refreshcaptchacode()" title="看不清？点击更换另一个。"/>
	            </div> 
	            </c:if>
	            <div class="login_box_row login_box_button">
	                <input type="hidden" name="lt" value="${loginTicket}" />
	                <input type="hidden" name="execution" value="${flowExecutionKey}" />
	                <input type="hidden" name="_eventId" value="submit" />
	                <input class="btn-submit" name="submit" accesskey="l" value="登录" tabindex="6" type="submit" />
	               	<div style="width:350px"> <a href="https://www.baidu.com/">账号激活/忘记密码</a></div>
	            </div>
	            <div class="login_box_row" style="height: 40px;">
	                <div id="msgErrors" class="msg-errors"><form:errors path="*" element="div" /></div>
	            </div>
	        </form:form>
	    </div>
    </div>
	<div class="header"></div>
	<ul id="jump">
		<li style="height:49px;"><a id="top" href="#top">
			<div id="EWM" style="width: 110px;height: 110px;">
				<img src="images/weixin.png"/>
			</div></a>
		</li>
		<li style="height:49px"><a href="http://www.jumstc.com" target="_blank"><span>首页</span><i id="top_dinggou"></i></a></li>
		<li style="height:49px"><a href="http://www.jumstc.com/zsjm_xssq_1150" target="_blank"><span>招商加盟</span><i id="top_kefu"></i></a></li>
		<li style="height:49px"><a href="http://www.jumstc.com" target="_blank"><span>相关政策</span><i id="top_fenxiang"></i></a></li>
	</ul>
<script>
var _ContextPath = '<%=path %>';
$("#top").hover(function(){
	$("#EWM").show();	
},function(){
	$("#EWM").hide();	
})
$(function(){
	$("#jump").css({"bottom":($(window).height() - $(".header").height() * 2) / 2});
	$(".login-wrap").height($(window).height() - $(".header").height() * 2 );
	$(".loginbox").css({"padding-top":($(window).height() - $(".header").height() * 2 - 438) / 2});
	changeBody();
	$(window).resize(function() {
		$("#jump").css({"bottom":($(window).height() - $(".header").height() * 2) / 2});
		$(".login-wrap").height($(window).height() - $(".header").height() * 2 );
		$(".loginbox").css({"padding-top":($(window).height() - $(".header").height() * 2 - 438) / 2});
		changeBody();
	});
})
function changeBody(){
	if($(window).height() < 640){
		$("body").css({"overflow":"scroll"});
	} else {
		$("body").css({"overflow":"hidden"});
	}
}

$("#username").blur(function(){
    if(!$(this).val())
      $("#msgErrors").html("提示：请输入用户名");
});
$("#password").blur(function(){
    if(!$(this).val())
      $("#msgErrors").html("提示：请输入密码");
});
/* $("#imgverifycode").blur(function(){
    if(!$(this).val())
      $("#msgErrors").html("提示：请输入认证码");
}); */
//提交
$(".btn-submit").click(function(){
	var username = $("#username").val();
	if(!username){
        $("#msgErrors").html("提示：请输入用户名");
        return false;
    }
	var password = $("#password").val();
    if(!password){
        $("#msgErrors").html("提示：请输入密码");
        return false;
    }
	var imgverifycode = $("#imgverifycode").val();
/*     if(!imgverifycode){
        $("#msgErrors").html("提示：请输入认证码");
        return false;
    } */
    $("#to-recover").html("登陆中...")
    $("form").submit();
});
//通过回车登录
document.onkeydown = function(e) {
	e = e || event;
	if (e.keyCode === 13) {
		$(".btn-submit").click();
	}
};
//刷新认证码
function refreshcaptchacode() {
	$("#codeImg").attr("src", _ContextPath + "/captchacode?" + Math.random());
}
</script>
<jsp:directive.include file="includes/bottom.jsp" />
