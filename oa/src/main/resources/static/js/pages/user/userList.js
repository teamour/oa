BF={
		initGrid: function () {
	   		 $("#jqGrid").jqGrid({
		             url:  ctxPath +'user/list',
		             mtype: "POST",
		             datatype: "json",
		             colNames:["Id","用户名", "用户邮箱", "密码","创建时间"],
		             colModel: [
		            	 { label: 'userId', name: 'userId',hidden:true, width: 75 },
		                 { label: 'userName', name: 'userName'},
		                 { label: 'email', name: 'email', width: 150 },
		                 { label: 'userPwd', name: 'userPwd', width: 150 },
		                 { label: 'createTime', name: 'createTime', width: 150,
								formatter : 'date', formatoptions: { srcformat : 'Y-m-d H:i:s', newformat :'ShortDate'}}		
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
		}
}
    
$(function () { 
    BF.initGrid();
});