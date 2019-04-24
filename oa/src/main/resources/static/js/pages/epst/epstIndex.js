BF={
	initGrid: function () {
   		 $("#jqGrid").jqGrid({
	             url:  ctxPath +'epst/',
	             mtype: "GET",
	             datatype: "json",
	             colNames:["id","员工Id", "学习内容", "开始日期", "学习时间", "负责人", "学会内容", "效果评价"],
	             colModel: [
	                 { label: 'employeeStudyId', name: 'employeeStudyId',hidden:true, width: 75 },
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
	             jsonReader:{ 
	            	 repeatitems:false },

	         });
   		 
   		$("#jqGrid1").jqGrid({
            url:  ctxPath +'epst/employeelist',
            mtype: "GET",
            datatype: "json",
            colNames:["姓名", "总经验年数", "技术经验1", "技术经验2", "技术经验3", "日语レベル", "技术レベル"],
            colModel: [
                { label: 'employeeName',  name: 'employeeName',  width: 75 },
                { label: 'workingYears',  name: 'workingYears',  width: 80 },
                { label: 'skill1_years',  name: 'skill1_years',  width: 100 },
                { label: 'skill2_years',  name: 'skill2_years',  width: 100,},
                { label: 'skill3_years',  name: 'skill3_years',  width: 100 },
                { label: 'japaneseLevel', name: 'japaneseLevel', width: 150 },
                { label: 'skillLevel',    name: 'skillLevel',    width: 80 }
            ],
            width: "1000",
            height: "380",
            'loadError' : function (xhr, status, error){
                alert(error);
            },
            rownumber:true,
            viewrecords: true, 
            pager: '#jqGridPager1',
            rowNum: 10,
            rowList: [5, 10, 50, 100, 500],
            multiselect: true,
            jsonReader:{ 
           	 repeatitems:false },

        });
   		 
   	

	},
	modifyData:function(){
		debugger
		var selData = $("#jqGrid").getRowData();
		// 要判断是否有选择，且只选中一行数据
		var rowId=$("#jqGrid").jqGrid('getGridParam','selrow');
		window.location.href = ctxPath+"epst/editepst/"+selData[rowId-1].employeeStudyId;
		
	},
	deleteData:function(){
			debugger
		   var selData = $("#jqGrid").getRowData();
		   var ids_t = $("#jqGrid").jqGrid("getGridParam","selarrrow");
		   var ids = new Array();
		   var len = ids_t.length;
		   var a;
		   for(var i=0;i<len;i++){
			   a = ids_t[i]
			   ids[i] = selData[a-1].employeeStudyId;
		   }
		   console.log(ids);
		   //if(!confirm("您确认删除吗"))return;
		   //1.定义请求的url
		   var url="http://localhost:8080/epst/deleteByIds";
		   //2.定义请求的参数
		   if(ids.length==0){
			   alert("请选择");
			   return;
		   }
		   var params={"ids":ids.toString()};//ids=1,2,3,4
		   //3.执行异步删除操作
		   $.post(url,params,function(result){});
		   //刷新
		   $("#jqGrid").jqGrid().trigger("reloadGrid");
	},
	searchData: function (){
		$("#jqGrid").setGridParam({
            page: 1,
            postData: { employeeId :$("#title").val() }
        }).trigger('reloadGrid');
   }
	
}
    
$(function () { 
    BF.initGrid();
});