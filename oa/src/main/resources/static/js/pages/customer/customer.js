BF={
	initGrid: function () {
   		 $("#jqGrid").jqGrid({
	             url:  ctxPath +'customer/list',
	             mtype: "POST",
	             datatype: "json",
	             colNames:["Id", "公司名", "公司地址", "网址", "主要业务", "联系渠道", "营业担当"],
	             colModel: [
	                 { label: 'customerId', name: 'customerId', key: true,hidden:true, width: 75 },
	                 { label: 'customerName', name: 'customerName', width: 100 },
	                 { label: 'address', name: 'address', width: 150 },
	                 { label: 'website', name: 'website', width: 80 },
	                 { label: 'mainBusiness', name: 'mainBusiness', width: 80 },
	                 { label: 'contactChannel', name: 'contactChannel', width: 80 },
	                 { label: 'salesStaff', name: 'salesStaff', width: 50 },
	             ],
	             width: "800",
	             height: "380",
	             'loadError' : function (xhr, status, error){
	                 alert(error);
	             },
	             rownumber:true,
	             viewrecords: true, 
	             pager: '#jqGridPager',
	             rowNum: 10,
	             rowList: [5, 10, 50, 100, 500],
	             multiselect: true,
	             jsonReader:{ repeatitems:false }
	         });
	},
	detailedData:function(){
		var rowId=$("#jqGrid").jqGrid('getGridParam','selrow');
		
		// 如果没有选择跳过
		if(rowId==null){
			alert("请先选择要查看的项");
			return;
		}
		
		window.location.href = ctxPath+"customer/detailed/"+rowId;
	},
	modifyData:function(){
		var rowId=$("#jqGrid").jqGrid('getGridParam','selrow');
		debugger;
		// 如果没有选择跳过
		if(rowId==null){
			alert("请先选择要修改的项");
			return;
		}
		
		window.location.href = ctxPath+"customer/edit/"+rowId;
	},
	deleteData:function(){
		var rows=$("#jqGrid").jqGrid('getGridParam','selarrrow');
		
		// 如果没有选择跳过
		if(rows.length==0){
			alert("请先选择要删除的项");
			return;
		}
		
		confirm("确定要删除吗?");
		
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