BF={
		add:function(){
			alert("click add " + $("#cpID").value);
		}

}
layui.use(['form','layer','laypage','jquery'],function(){
   var  form = layui.form();
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		$ = layui.jquery;
		
		//监听提交
		form.on('submit(testTT)', function(){
			layer.msg("hhhh");
			BF.test();
		 });
});