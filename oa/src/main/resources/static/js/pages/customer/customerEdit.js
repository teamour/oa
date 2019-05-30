$(function () { 
	
	initSelectType(1, "companyType");
	initSelectType(2, "cooperationIntention");
	initSelectType(3, "isUpper");
});

function initSelectType(id, type) {
	const url = "/customer/dicNames/" + id;
	const testData = $("#form1").serialize();

	
	var typeDefult = $("#CompanyTypeValue").val();
	var coopDefult = $("#cooperationIntentionValue").val();
	var isupDefult = $("#isUpperValue").val(); //boolen type
	
	console.log("defult="+typeDefult+";"+coopDefult+";"+isupDefult);

	
	$.post(url,testData,null,"json")
	.done(function(data1,textStatus,jqXHR) {
		for (var i=0;i<data1.length;i++)
		{
			$("#" + type).append("<option value='"+i+"'>"+data1[i].detailName+"</option>");
		}
		if(id == 1){
			var  companyType = document.getElementById('companyType');
			companyType[typeDefult].selected = true;
		}
		else if(id == 2){
			var  cooperationIntention = document.getElementById('cooperationIntention');
			cooperationIntention[coopDefult].selected = true;
		}
		else if(id == 3){
			var  isUpper = document.getElementById('isUpper');
			
			if(isupDefult == "true"){
				isUpper[1].selected = true;
			}
			else{
				isUpper[0].selected = true;
			}
		}
		
		
	})
	.fail(function(jqXHR, textStatus, errorThrown ) {
		console.log("失败");
	})
	.always(function() {
		
	});
}