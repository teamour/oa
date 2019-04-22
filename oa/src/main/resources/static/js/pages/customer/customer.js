BF={
	initGrid: function () {
   		 $("#jqGrid").jqGrid({
	             url:  ctxPath +'customer/list',
	             mtype: "POST",
	             datatype: "json",
	             colNames:["Id", "公司名", "公司地址", "网址", "联系渠道"],
	             colModel: [
	                 { label: 'customerId', name: 'customerId', key: true,hidden:true, width: 75 },
	                 { label: 'customerName', name: 'customerName', width: 150 },
	                 { label: 'address', name: 'address', width: 150 },
	                 { label: 'website', name: 'website', width: 150 },
	                 { label: 'contactChannel', name: 'contactChannel', width: 150 },
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
	             jsonReader:{ repeatitems:false },
            	 loadonce: true,
//            	 sortname:'customerId',
//            	 sortorder: "asc",
//         		 caption: "员工记录"
	         });

	},
	detailedData:function(){
		var rowId=$("#jqGrid").jqGrid('getGridParam','selrow');
		
		// 如果没有选择跳过
		if(rowId==null){
			return;
		}
		
		window.location.href = ctxPath+"customer/detailed/"+rowId;
	},
	modifyData:function(){
		var rowId=$("#jqGrid").jqGrid('getGridParam','selrow');
		
		// 如果没有选择跳过
		if(rowId==null){
			return;
		}
		
		window.location.href = ctxPath+"customer/edit/"+rowId;
	},
	deleteData:function(){
		confirm("确定要删除该信息吗?");
		
		var rowId=$("#jqGrid").jqGrid('getGridParam','selrow');
		
		// 如果没有选择跳过
		if(rowId==null){
			return;
		}
		
		window.location.href = ctxPath+"customer/delete/"+rowId;
	},
	searchData: function (){
		$("#jqGrid").setGridParam({
            page: 1,
            postData: { title :$("#title").val() }
        }).trigger('reloadGrid');
   }
}
    
$(function () { 
    BF.initGrid();
});