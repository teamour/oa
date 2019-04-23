BF={
		initGrid: function () {
	   		 $("#jqGrid").jqGrid({
		             url:  ctxPath +'emp/list',
		             mtype: "POST",
		             datatype: "json",
		             colNames:["Id", "姓名", "工作年数", "日语等级","技术等级","工作1","工作2","工作3"],
		             colModel: [
		                 { label: 'employeeId', name: 'employeeId',hidden:true, width: 75 },
		                 { label: 'employeeName', name: 'employeeName', width: 150 },
		                 { label: 'createTime', name: 'createTime', width: 150,
						formatter : 'date', formatoptions: { srcformat : 'Y-m-d H:i:s', newformat :'ShortDate'}},
		                 { label: 'japaneseLevel', name: 'japaneseLevel', width: 150 },
						{ label: 'skillLevel', name: 'skillLevel', width: 150 },
						{ label: 'skill1Years', name: 'skill1Years', width: 150 },
						{ label: 'skill2Years', name: 'skill2Years', width: 150 },
						{ label: 'skill3Years', name: 'skill3Years', width: 150 }
		             ],
		             width: "1000",
		             height: "380",
		             'loadError' : function (xhr, status, error){
		                 alert(error);
		             },
		             rownumber:true,
		             viewrecords: true, 
		             pager: '#jqGridPager',
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
			debugger
			var selData = $("#jqGrid").getRowData();
			// 要判断是否有选择，且只选中一行数据
			var rowId=$("#jqGrid").jqGrid('getGridParam','selrow');
			var id=selData[rowId-1].employeeId;
			
			window.location.href = ctxPath+"emp/"+id;
		},
		searchData: function (){
			$("#jqGrid").setGridParam({
	            page: 1,
	            postData: { employeeId :$("#employeeId").val() }
	        }).trigger('reloadGrid');
	   },
	   deleteByIds:function(){
		   debugger
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
		   
	   }
}
    
$(function () { 
    BF.initGrid();
});