BF={
		userLogin:function(){
			  var params={
						 email:$("#usernameId").val(),
						 userPwd:$("#passwordId").val()
						 [Ids:$("#passwordId").val()]
					  }
					  var url="http://localhost:8080/user/login";
					  console.log("params",params);
					  $.post(url,params,function(){
						location.href="http://localhost:8080/user/home";
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
		
});