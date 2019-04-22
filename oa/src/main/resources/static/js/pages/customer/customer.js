BF={
	initGrid: function () {
		debugger;
   		 $("#jqGrid").jqGrid({
	             url:  ctxPath +'customer/list',
	             mtype: "POST",
	             datatype: "json",
	             colNames:["Id", "公司名", "公司地址", "网址", "联系渠道"],
	             colModel: [
	                 { label: 'customerId', name: 'customerId', key: true,hidden:true, width: 75 },
	                 { label: 'address', name: 'address', width: 150 },
	                 { label: 'customerName', name: 'customerName', width: 150 },
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
	             jsonReader:{ repeatitems:false }
	         });

	},
	modifyData:function(){
		var selData = $("#jqGrid").getRowData();
		// 要判断是否有选择，且只选中一行数据
		
		window.location.href = ctxPath+"customer/"+selData[0].announcementId;
	},
	searchData: function (){
		$("#jqGrid").setGridParam({
            page: 1,
            postData: { title :$("#title").val() }
        }).trigger('reloadGrid');
   }
	
}
    
$(function () { 
	debugger;
    BF.initGrid();
});