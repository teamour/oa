BF={
	initGrid: function () {
   		 $("#jqGrid").jqGrid({
	             url:  ctxPath +'customer/list',
	             mtype: "POST",
	             datatype: "json",
	             colNames:["Id", "公司名", "资本金(円)","社员数","公司性质", "营业担当", "营业电话", "提案用邮箱1", "提案用担当1","合作意向","主要业务","代表取缔"],
	             colModel: [
	                 { label: 'customerId', name: 'customerId', key: true,hidden:true, width: 75 },
	                 { label: 'customerName', name: 'customerName', width: 150 },
	                 { label: 'registeredCapital', name: 'registeredCapital', width: 100 },
	                 { label: 'employeeNumber', name: 'employeeNumber', width: 50 },
	                 { label: 'companyType', name: 'companyType', width: 80, formatter:'select',editoptions:{value:"0:日本公司;1:中国公司;"}},
	                 { label: 'salesStaff', name: 'salesStaff', width: 50 },
	                 { label: 'salesTelephone', name: 'salesTelephone', width: 80 },
	                 { label: 'proposal1Email', name: 'proposal1Email', width: 200 },
	                 { label: 'proposal1Handler', name: 'proposal1Handler', width: 70 },
	                 { label: 'cooperationIntention', name: 'cooperationIntention', width: 50 ,formatter:'select',editoptions:{value:"0:无;1:低;2:中;3:高;4:合作过;5:合作中;"}},
	                 { label: 'mainBusiness', name: 'mainBusiness', width: 80 },
	                 { label: 'ceo', name: 'ceo', width: 50 },
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
	             jsonReader:{ repeatitems:false },
	         });
	},
	detailedData:function(){
		var rowId=$("#jqGrid").jqGrid('getGridParam','selrow');
		
		// 如果没有选择跳过
		if(rowId==null){
			alert("请先选择要查看的项");
			return;
		}
		
		window.location.href = ctxPath+"customer/detailed/"+rowId;
	},
	modifyData:function(){
		var rowId=$("#jqGrid").jqGrid('getGridParam','selrow');
		// 如果没有选择跳过
		if(rowId==null){
			alert("请先选择要修改的项");
			return;
		}
		
		window.location.href = ctxPath+"customer/edit/"+rowId;
	},
	deleteData:function(){
		var rows=$("#jqGrid").jqGrid('getGridParam','selarrrow');
		
		// 如果没有选择跳过
		if(rows.length==0){
			alert("请先选择要删除的项");
			return;
		}
		
		if(!confirm("您确认删除吗"))
			return;
		
		var url=ctxPath + "customer/delete";
		var params={"rows":rows.toString()};
		
		$.post(url,params,function(result){})
			.done(function(data,textStatus,jqXHR) {
			   
			})
			.fail(function(jqXHR, textStatus, errorThrown ) {
				alert("请求失败");
			})
			.always(function() {
				window.location.reload();
			});
	},
	searchData: function (){
		$("#jqGrid").setGridParam({
            page: 1,
            postData: { customerName :$("#title").val() }
        }).trigger('reloadGrid');
   }
}
    
$(function () { 
    BF.initGrid();
});