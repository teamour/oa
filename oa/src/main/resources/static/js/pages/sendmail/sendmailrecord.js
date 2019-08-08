BF={
	initGrid: function () {
   		 $("#mailRecord").jqGrid({
	             url:  ctxPath +'OUR002/sendmailrecord',
	             mtype: "POST",
	             datatype: "json",
	             colNames:["mailingId", "发送状态", "开始时间", "结束时间","发送人Email", "邮件标题"],
	             colModel: [
	                 { label: 'mailingId', name: 'mailingId', key: true,hidden:true, width: 75 },
	                 { label: 'mailStats', name: 'mailStats', width: 50 },
	                 { label: 'beginTime', name: 'beginTime', width: 180 },
	                 { label: 'endTime', name: 'endTime', width: 180 },
	                 { label: 'mailingAimSummary', name: 'mailingAimSummary', width: 200 },
	                 { label: 'mailingTempleteContent', name: 'mailingTempleteContent', width: 300},
	             ],
	             width: "100%",
	             height: "100%",
	             'loadError' : function (xhr, status, error){
	                 alert(error);
	             },
	             rownumber:true,
	             viewrecords: true, 
	             pager: '#mailRecordPager',
	             rowNum: 10,
	             rowList: [5, 10, 50, 100, 500],
	             multiselect: true,
	             jsonReader:{ repeatitems:false },
	         });
	},
	detailedData:function(){
		var rowId=$("#mailRecord").jqGrid('getGridParam','selrow');
		// 如果没有选择跳过
		if(rowId==null){
			alert("请先选择要查看的项");
			return;
		}
		
		window.location.href = ctxPath+"customer/detailed/"+rowId;
	},
	deleteData:function(){
		var rows=$("#jqGrid").jqGrid('getGridParam','selarrrow');
		
		// 如果没有选择跳过
		if(rows.length==0){
			alert("请先选择要删除的项");
			return;
		}
		
		if(!confirm("您确认删除吗"))
			return;
		
		var url="http://localhost:8080/customer/delete";
		var params={"rows":rows.toString()};
		
		$.post(url,params,function(result){})
			.done(function(data,textStatus,jqXHR) {
			   
			})
			.fail(function(jqXHR, textStatus, errorThrown ) {
				alert("请求失败");
			})
			.always(function() {
				window.location.reload();
			});
	},
	searchData: function (){
		$("#jqGrid").setGridParam({
            page: 1,
            postData: { customerName :$("#title").val() }
        }).trigger('reloadGrid');
   }
}
    
$(function () { 
    BF.initGrid();
});