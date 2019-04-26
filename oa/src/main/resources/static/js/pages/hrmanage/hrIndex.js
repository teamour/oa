BF={
	initGrid: function () {
   		 $("#jqGrid").jqGrid({
	             url:  ctxPath +'hr/hrIndex',
	             mtype: "POST",
	             datatype: "json",
	             colNames:["Id", "面试人员编号", "面试人员姓名", "面情结果"],
	             colModel: [
	                 { label: 'interviewerId', name: 'interviewerId', key: true,hidden:true, width: 75 },
	                 { label: 'interviewerCode', name: 'interviewerCode', width: 150 },
	                 { label: 'interviewerName', name: 'interviewerName', width: 150 },
	                 { label: 'interviewResult', name: 'interviewResult', width: 150 ,
	                	 formatter:function(cellvalue, options, rowObject){
	                		 if(0==cellvalue){
	                			 return "";
	                		 }else if(cellvalue==1){
	                			 return "不合格";
	                		 }else if(cellvalue==2){
	                			 return "合格";
	                		 }
	                	 }
	                 }
	             ],
	             width: "800",
	             height: "400",
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
	modifyData: function (){
		var rowId=$("#jqGrid").jqGrid('getGridParam','selrow');
		
		if(rowId == null || rowId == ''){
			return;
		}
		// 要判断是否有选择，且只选中一行数据
		
		window.location.href = ctxPath+"hr/interviewerInfoModify?interviewerId="+rowId;
	},
	selectData: function (){
		var rowId=$("#jqGrid").jqGrid('getGridParam','selrow');
		if(rowId == null || rowId == ''){
			return;
		}
		window.location.href = ctxPath+"hr/interviewerInfo?interviewerId="+rowId;
	},
	searchData: function (){
		if($("#searchMethod").val() == '0'){
			$("#jqGrid").setGridParam({
	            page: 1,
	            postData: { interviewerName :$("#search").val() }
	        }).trigger('reloadGrid');
		}
		if($("#searchMethod").val() == '1'){
			$("#jqGrid").setGridParam({
				page: 1,
				postData: { interview1Time :$("#search").val() }
			}).trigger('reloadGrid');
		}
		if($("#searchMethod").val() == '2'){
			$("#jqGrid").setGridParam({
				page: 1,
				postData: { interview1Handler :$("#search").val() ,interview2Handler :$("#search").val(),
					interview3Handler :$("#search").val() }
			}).trigger('reloadGrid');
		}
   }
}
    
$(function () { 
    BF.initGrid();
});