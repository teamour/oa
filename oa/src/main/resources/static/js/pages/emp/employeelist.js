BF={
		initGrid: function () {
	   		 $("#jqGrid").jqGrid({
		             url:  ctxPath +'emp/list',
		             mtype: "POST",
		             datatype: "json",
		             colNames:["Id", "标题", "创建时间", "内容"],
		             colModel: [
		                 { input: 'employeeId', name: 'employeeId',hidden:true, width: 75 },
		                 { label: 'employeeName', name: 'employeeName', width: 150 },
		                 { label: 'createTime', name: 'createTime', width: 150,
						formatter : 'date', formatoptions: { srcformat : 'Y-m-d H:i:s', newformat :'ShortDate'}},
		                 { label: 'age', name: 'age', width: 150 }
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
		             jsonReader:{  repeatitems:false },
	            	 loadonce:true,
	            	 sortname:'employeeId',
	            	 sortorder: "asc",
	         		 caption: "员工记录"
		             
		         });

		},
		modifyData:function(){
			var selData = $("#jqGrid").getRowData();
			// 要判断是否有选择，且只选中一行数据
			
			
			window.location.href = ctxPath+"emp/"+selData[0].employeeId;
		},
		searchData: function (){
			$("#jqGrid").setGridParam({
	            page: 1,
	            postData: { title :$("#title").val() }
	        }).trigger('reloadGrid');
	   },
	   deleteByIds:function(){
		   debugger
		   var ids = $("#jqGrid").jqGrid("getGridParam","selarrrow");
		   
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
		   $.post(url,params,function(result){});
		   
		   
	   }
}
    
$(function () { 
    BF.initGrid();
});