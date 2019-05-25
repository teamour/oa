BF={
    initGrid: function () {
            $("#jqGrid").jqGrid({
                    url:  ctxPath +'business/list',
                    mtype: "POST",
                    datatype: "json",
                    colNames:["Id", "姓名", "工作年数", "日语等级","技术等级","工作1","工作2","工作3"],
                    colModel: [
                        { label: 'employeeId', name: 'employeeId',hidden:true, width: 75 },
                        { label: 'employeeName', name: 'employeeName', width: 150 ,formatter:this.editLinkForEmployeeName},
                        { label: 'workingYears', name: 'workingYears', width: 150 },
                        { label: 'japaneseLevel', name: 'japaneseLevel', width: 150 },
                        { label: 'skillLevel', name: 'skillLevel', width: 150 },
                        { label: 'skill1', name: 'skill1', width: 150 },
                        { label: 'skill2', name: 'skill2', width: 150 },
                        { label: 'skill3', name: 'skill3', width: 150 }
                    ],
                    width: "100%",
                    height: "100%",
                    'loadError' : function (xhr, status, error){
                        alert(error);
                    },
                    rowNum: 10,
                    rownumber:true,
                    viewrecords: true, 
                    pager: '#jqGridPager',
                    rowList: [5, 10, 50, 100, 500],
                    multiselect: true,
                    jsonReader:{  repeatitems:false },
                    
                });

    },
    searchData: function (){
        var searchValue = $("#searchValue").val();
        var searchFeild = $("#searchFeild").val().toString();
        if(!searchValue || !searchValue.trim() || !searchFeild || !searchFeild.trim()){
            return;
        }
        ///对日期的输入值进行特殊处理，因为需要拼接导sql里进行查询，不能是有中划线类型的日期
        if(searchFeild == "interviewDate"){
            searchValue = searchValue.replace(/-/g,'/');
        }
        

        $("#jqGrid").setGridParam({
            page: 1,
            postData: {searchFeild:searchValue}
        }).trigger('reloadGrid');
    },
    modifyData:function(){
    	debugger
		var selData = $("#jqGrid").getRowData();
		// 要判断是否有选择，且只选中一行数据
		var rowId=$("#jqGrid").jqGrid('getGridParam','selrow');
		var id=selData[rowId-1].employeeId;
		window.location.href = ctxPath+"business/edit/"+id;
		
		
	}
	   
}
    
$(function () { 
    BF.initGrid();
});
