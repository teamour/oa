BF={
	initGrid: function () {
		var url = document.location.toString();
   		 $("#jqGrid").jqGrid({
	             url:  url,
	             mtype: "Post",
	             datatype: "json",
	             colNames:["id", "学习内容", "开始日期", "学习时间", "负责人", "学会内容", "效果评价"],
	             colModel: [
	                 { label: 'employeeStudyId', name: 'employeeStudyId',hidden:true, width: 75 },
	                 { label: 'studyContent', name: 'studyContent', width: 300 },
	                 { label: 'beginDate', name: 'beginDate', width: 100,
					formatter : 'date', formatoptions: { srcformat : 'Y-m-d H:i:s', newformat :'ShortDate'}},
	                 { label: 'studyTime', name: 'studyTime', width: 80 },
	                 { label: 'handler', name: 'handler', width: 80 },
	                 { label: 'learnCotent', name: 'learnCotent', width: 350 },
	                 { label: 'evaluation', name: 'evaluation', width: 80 }
	             ],
	             width: "100%",
	             height: "100%",
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
	            	 repeatitems:false }

	         });
	},
	modifyData:function(){
		var selData = $("#jqGrid").getRowData();
		// 要判断是否有选择，且只选中一行数据
		var rowId=$("#jqGrid").jqGrid('getGridParam','selrow');
		var ids_t = $("#jqGrid").jqGrid("getGridParam","selarrrow");
		console.log(ids_t.length);
		if(ids_t.length == 1){
			window.location.href = ctxPath+"epst/editepst/"+selData[rowId-1].employeeStudyId;
		}
		else{
			layui.use('layer', function(){
	 			  var layer = layui.layer;
	 			 layer.msg('仅且只能选中一行数据进行修改');
	 			});  
		}
		
	},
	deleteData:function(){
		   var selData = $("#jqGrid").getRowData();
		   var ids_t = $("#jqGrid").jqGrid("getGridParam","selarrrow");
		   var ids = new Array();
		   var len = ids_t.length;
		   var a;
		   for(var i=0;i<len;i++){
			   a = ids_t[i]
			   ids[i] = selData[a-1].employeeStudyId;
		   }
		   if(!confirm("您确认删除吗"))return;
		   //1.定义请求的url
		   var url="http://localhost:8080/epst/deleteByIds";
		   //2.定义请求的参数
		   if(ids.length==0){
			   alert("请选择");
			   return;
		   }
		   var params={"ids":ids.toString()};//ids=1,2,3,4
		   //3.执行异步删除操作
		   $.post(url,params,function(result){})
		   .always(function() {
				window.location.reload();
			});
		   //刷新
//		   console.log("刷新前");
//		   $("#jqGrid").jqGrid().trigger("reloadGrid");
//		   console.log("刷新后");
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