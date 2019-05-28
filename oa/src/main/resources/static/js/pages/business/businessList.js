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
    	debugger
        var searchFeild = $("#searchFeild").val().toString();
    	var searchValue = $("#searchValue").val();
        if( !searchFeild || !searchFeild.trim()){
            return;
        }
        $("#jqGrid").setGridParam({
            page: 1,
            postData: {searchValue :searchValue, searchFeild:searchFeild}
        }).trigger('reloadGrid');
    },
    modifyData:function(){
		var selData = $("#jqGrid").getRowData();
		// 要判断是否有选择，且只选中一行数据
		//var rowId=$("#jqGrid").jqGrid('getGridParam','selrow');
    	var rowId=$('#jqGrid').jqGrid('getGridParam','selarrrow');
    	if (rowId.length==1) {
    		var id=selData[rowId-1].employeeId;
    		window.location.href = ctxPath+"business/edit/"+id;
		}
    	else{
    		alert("只能选择一行,请重新选择!!");
    		return;
    	}
		
	}
	   
}
    
$(function () { 
    BF.initGrid();
});
function changeInputFeildType(selectedValue){
	debugger
    if(selectedValue == "interviewDate"){
        $("#searchValue").prop("type","date");
    }else{
        $("#searchValue").prop("type","text");
    }
    $("#searchValue").val('');
}