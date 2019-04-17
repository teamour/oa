BF={
		userLogin:function(){
			alert("hhhahah");
		}
}
layui.use(['form','layer','laypage','jquery'],function(){
   var  form = layui.form();
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		$ = layui.jquery;
		
		//监听提交
		form.on('submit(login)', function(){
			alert("cccbbbb");
			BF.userLogin();
		});
		
});