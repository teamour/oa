BF={
	initGrid: function () {
   		 $("#jqGrid").jqGrid({
	             url:  ctxPath +'announcement/list',
	             mtype: "POST",
	             datatype: "json",
	             colNames:["Id", "标题", "创建时间", "内容"],
	             colModel: [
	                 { label: 'announcementId', name: 'announcementId', key: true,hidden:true, width: 75 },
	                 { label: 'title', name: 'title', width: 150 },
	                 { label: 'createTime', name: 'createTime', width: 150,
					formatter : 'date', formatoptions: { srcformat : 'Y-m-d H:i:s', newformat :'ShortDate'}},
	                 { label: 'description', name: 'description', width: 150 }
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
		
		window.location.href = ctxPath+"announcement/"+selData[0].announcementId;
	},
	viewData:function(){
		var selData = $("#jqGrid").getRowData();
		// 要判断是否有选择，且只选中一行数据		
		window.location.href = ctxPath+"announcement/view/"+selData[0].announcementId;
	},
	searchData: function (){
		$("#jqGrid").setGridParam({
            page: 1,
            postData: { 
            	title :$("#title").val(),
            	fuzzyQuery:$("#fuzzyQuery").attr("checked")?1:0
            }
        }).trigger('reloadGrid');
   }
	
}
    
$(function () { 
    BF.initGrid();
});