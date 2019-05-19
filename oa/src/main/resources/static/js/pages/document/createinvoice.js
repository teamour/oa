function initSelectType(id, type) {
	const url = "/emp/dicNames/"+id;
	const testData = $("#form1").serialize();

	$.post(url,testData,null,"json")
	.done(function(data1,textStatus,jqXHR) {
		for (var i=0;i<data1.length;i++)
		{
			var x=i+1;
			$("#" + type).append("<option value='"+x+"'>"+data1[i].detailName+"</option>");
		}
	})
	.fail(function(jqXHR, textStatus, errorThrown ) {
		console.log("失败");
	})
	.always(function() {
		
	});
}
$(function () { 
	 initSelectType(21, "template");
});