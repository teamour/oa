
function initSelectType(id, type) {
	var defultId = $("#companyIdValue").val();
	console.log(defultId);
	const url = "/emp/dicNames/"+id;
	const testData = $("#form1").serialize();

	$.post(url,testData,null,"json")
	.done(function(data1,textStatus,jqXHR) {
		$("#" + type).append("<option value='0'>defult</option>");
		for (var i=0;i<data1.length;i++)
		{
			var x=i+1;
			$("#" + type).append("<option value='"+x+"'>"+data1[i].detailName+"</option>");
		}
		var  company = document.getElementById('companyId');
		company[defultId].selected = true;//选中
	})
	.fail(function(jqXHR, textStatus, errorThrown ) {
		console.log("失败");
	})
	.always(function() {
		
	});
}
$(function () { 
	 initSelectType(20, "companyId");
});