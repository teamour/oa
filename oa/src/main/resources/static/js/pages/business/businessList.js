BF={
    initGrid: function () {
            $("#jqGrid").jqGrid({
                    url:  ctxPath +'businessManage/list',
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
            postData: { searchValue :searchValue, searchFeild:searchFeild}
        }).trigger('reloadGrid');
    },
    modifyData:function(){
        var selData = $("#jqGrid").getRowData();
        // 要判断是否有选择，且只选中一行数据
        var rowId=$("#jqGrid").jqGrid('getGridParam','selrow');
        var id=selData[rowId-1].employeeId;
        window.location.href = ctxPath+"emp/"+id;
    },
    queryById: function (){
        debugger
        var selData = $("#jqGrid").getRowData();
        // 要判断是否有选择，且只选中一行数据
        var rowId=$("#jqGrid").jqGrid('getGridParam','selrow');
        var id=selData[rowId-1].employeeId;
        window.location.href = ctxPath+"epst/epstIndex/"+id;
        
    },
    deleteByIds:function(){
        var selData = $("#jqGrid").getRowData();//获取行数rows
        var ids_t = $("#jqGrid").jqGrid("getGridParam","selarrrow");//获得当前页其中的那几行
        var ids = new Array();
        var len = ids_t.length;
        var a;
        for(var i=0;i<len;i++){
            a = ids_t[i]
            ids[i] = selData[a-1].employeeId;
        }
        if(!confirm("您确认删除吗"))return;
        //1.定义请求的url
        var url="http://localhost:8080/emp/deleteByIds";
        //2.定义请求的参数
        if(ids.length==0){
            alert("请选择");
            return;
        }
        var params={"ids":ids.toString()};//ids=1,2,3,4
        //3.执行异步删除操作
        $.post(url,params,function(result){
            location.href="http://localhost:8080/emp/list";
        });
    },
    detailedData:function(){
        var selData = $("#jqGrid").getRowData();
        // 要判断是否有选择，且只选中一行数据
        var rowId=$("#jqGrid").jqGrid('getGridParam','selrow');
        var id=selData[rowId-1].employeeId;
        window.location.href = ctxPath+"emp/detailed/"+id;
    },
    editLinkForEmployeeName:function(cellValue, options, rowdata, action){
        return "<a href='"+ ctxPath +"emp/detailed/ "+ rowdata.employeeId +"' style = \"color:#6795b5;\">"+ rowdata.employeeName +"</a>";
    }
	   
}
    
$(function () { 
    BF.initGrid();
});
//change Input Feild Type
function changeInputFeildType(selectedValue){
    if(selectedValue == "interviewDate"){
        $("#searchValue").prop("type","date");
    }else{
        $("#searchValue").prop("type","text");
    }
    $("#searchValue").val('');
}