var sendEmailInit=false;
SMCP={
	initGrid: function () {
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
		
	},
	searchData: function (){
		if(!sendEmailInit){
			sendEmailInit=true;
			$("#mailCustomer").jqGrid({
				 	 url:  ctxPath +'OUR001/list',
				 	 mtype: "POST",
				 	 datatype: "json",
				 	 colNames:["Id", "公司名", "营业邮箱", "营业担当", "提案用邮箱1", "提案用担当1", "提案用邮箱2", "提案用担当2","提案用邮箱3", "提案用担当3"],
				 	 colModel: [
		                { label: 'customerId', name: 'customerId', key: true,hidden:true, width: 5 },
		                { label: 'customerName', name: 'customerName', width: 140 },
		                { label: 'salesEmail', name: 'salesEmail', width: 150 },
		                { label: 'salesStaff', name: 'salesStaff', width: 50 },
		                { label: 'proposal1Email', name: 'proposal1Email', width: 150 },
		                { label: 'proposal1Handler', name: 'proposal1Handler', width: 40 },
		                { label: 'proposal2Email', name: 'proposal2Email', width: 150 },
		                { label: 'proposal2Handler', name: 'proposal2Handler', width: 40 },
		                { label: 'proposal3Email', name: 'proposal3Email', width: 150 },
		                { label: 'proposal3Handler', name: 'proposal3Handler', width: 40 }
	            ],
	            width: "100%",
	            height: "100%",
	            'loadError' : function (xhr, status, error){
	                alert(error);
	            },
	            rownumber:true,
	            viewrecords: true, 
	            pager: '#mailCustomerPager',
	            rowNum: 10,
	            rowList: [5, 10, 50, 100, 500],
	            multiselect: true,
	            jsonReader:{ repeatitems:false },
	            postData: {
	    			companyType: $("#customer").val(),
	    			cooperationIntention: $("#cooperation").val(),
	    			sendMailType: $("#sendMailType").val()
	    		}
	        });
		}else{
			var param={	
					page: 1,
					postData: {
						companyType: $("#customer").val(),
						cooperationIntention: $("#cooperation").val(),
						sendMailType: $("#sendMailType").val()
					}
			};
			$("#mailCustomer").setGridParam(param).trigger('reloadGrid');
	   
		}
   },
   saveData:function(){
	   var ids=$('#mailCustomer').jqGrid("getGridParam", "selarrrow");
	   $("#customerids").val(ids);
	   $("#emailsend").submit();
   }
}

    
$(function () { 
	SMCP.initGrid();
});