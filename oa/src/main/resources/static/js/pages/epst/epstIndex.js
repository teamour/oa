BF={
	initGrid: function () {
   		 $("#jqGrid").jqGrid({
	             url:  ctxPath +'epst/',
	             mtype: "POST",
	             datatype: "json",
	             colNames:["id","员工Id", "学习内容", "开始日期", "学习时间", "负责人", "学会内容", "效果评价"],
	             colModel: [
	                 { label: 'employeeStudyId', name: 'employeeStudyId', key: true,hidden:true, width: 75 },
	                 { label: 'employeeId', name: 'employeeId', width: 80 },
	                 { label: 'studyContent', name: 'studyContent', width: 100 },
	                 { label: 'beginDate', name: 'beginDate', width: 100,
					formatter : 'date', formatoptions: { srcformat : 'Y-m-d H:i:s', newformat :'ShortDate'}},
	                 { label: 'studyTime', name: 'studyTime', width: 80 },
	                 { label: 'handler', name: 'handler', width: 80 },
	                 { label: 'learnCotent', name: 'learnCotent', width: 150 },
	                 { label: 'evaluation', name: 'evaluation', width: 80 }
	             ],
	             width: "1000",
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
		var rowId=$("#gridSimeiteisiGyoumu").jqGrid('getGridParam','selrow');
		window.location.href = ctxPath+"epst/addepst"+selData[0].employeeStudyId;
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