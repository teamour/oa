BF = {
	testinit: function() {
		const url = "http://localhost:8080/company/list";
		const testData = $("#form1").serialize();

		$.post(url,testData,null,"json")
		.done(function(jsonObj,textStatus,jqXHR) {
			$("#list").append(
					"<p>" + jsonObj + "</p>"
					);
			
			alert(jsonObj.rows);
			
			$.each(jsonObj.rows, function (index, obj) {
				
				alert(obj.companyName);
				
                $("#list").append(
                	"<tr>" +
					"<td>" + obj.companyName + "</td>" +
					"<td>" + obj.companyCode + "</td>" +
					"<td>" + obj.address + "</td>" +
					"<td>" +
						'<a href="editor/' + obj.companyId + '">編輯</a>|' +
						'<a href="detailed/' + obj.companyId + '">詳情</a>|' +
						'<a href="delete/' + obj.companyId + '">刪除</a>' +
					"</td>" +
					"</tr>"
                );
			});
		})
		.fail(function(jqXHR, textStatus, errorThrown ) {
			alert("status: " + jqXHR.status + " error: " + textStatus 
					+ " errorThrown: " + errorThrown);
		})
		.always(function() {
			// 完成後執行方法
		});
	}
}

$(function() {
	BF.testinit();
});