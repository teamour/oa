BF={
	init: function () {
		initSelectType(1, "companyType");
		initSelectType(2, "cooperationIntention");
		initSelectType(3, "isUpper");
	},
}

$(function () { 
    BF.init();
    
});

function initSelectType(id, type) {
	const url = "/customer/dicNames/" + id;
	const testData = $("#form1").serialize();

	$.post(url,testData,null,"json")
	.done(function(data1,textStatus,jqXHR) {
		for (var i=0;i<data1.length;i++)
		{
			$("#" + type).append("<option value='"+i+"'>"+data1[i].detailName+"</option>");
		}
	})
	.fail(function(jqXHR, textStatus, errorThrown ) {
		console.log("失败");
	})
	.always(function() {
		
	});
}