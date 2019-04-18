BF={
    saveData:function(data){
    	$.ajax({
    			url:"http://localhost:8080/emp/",
    			type:"post",
    			async: false,
    			data:JSON.stringify(data),
    			contentType: "application/json; charset=utf-8",  
    	        dataType: "json",
    	        success:function(data) {
    		        layer.msg("aaaaa");
    			},
    	        error:function(){
    	        	layer.msg("error!");
    	        }
    	});
    }
}
layui.use(['form','layer','laypage','jquery'],function(){
   var  form = layui.form;
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		$ = layui.jquery;
		
		//监听提交
		form.on('submit(save)', function(data){
			layer.msg("hhhh");
			BF.saveData(data);
			alert("bbbb");
		 });
		
});