/*BF={
		userLogin:function(){
			debugger
			  var params={
						 email:$("#usernameId").val(),
						 userPwd:$("#passwordId").val()
					  }
					  var url="http://localhost:8080/user/login";
					  console.log("params",params);
					  $.post(url,params,function(result){
						  if(result.state==1){
							//跳转到indexUI对应的页面
							  location.href="http://localhost:8080/user/home";
						  }
						  return false;//防止刷新时重复提交
					  })
						 
		}
}
layui.use(['form','layer','laypage','jquery'],function(){
   var  form = layui.form;
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		$ = layui.jquery;
		
		//监听提交
		form.on('submit(login)', function(){
		    BF.userLogin();
		 });
		
});*/