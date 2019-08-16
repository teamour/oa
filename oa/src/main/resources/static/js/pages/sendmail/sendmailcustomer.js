var sendEmailInit=false;
SMCP={
	initGrid: function () {
		var rows=$("#mailRecord").jqGrid('getGridParam','selarrrow');
		var url=ctxPath + "OUR003/senderNameList";
		var params={"rows":11};
		
		$.post(url,params,function(result){})
			.done(function(data,textStatus,jqXHR) {
				for (var i=0;i<data.length;i++)
				{
					$("#sendername").append("<option value='"+data[i].senderId+"'>"+data[i].senderName+"</option>");
				}
			})
			.fail(function(jqXHR, textStatus, errorThrown ) {
				alert("删除发生异常");
			})
			.always(function() {
			});
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
		                { label: 'customerName', name: 'customerName', width: 130 },
		                { label: 'salesEmail', name: 'salesEmail', width: 130 },
		                { label: 'salesStaff', name: 'salesStaff', width: 50 },
		                { label: 'proposal1Email', name: 'proposal1Email', width: 130 },
		                { label: 'proposal1Handler', name: 'proposal1Handler', width: 70 },
		                { label: 'proposal2Email', name: 'proposal2Email', width: 130 },
		                { label: 'proposal2Handler', name: 'proposal2Handler', width: 70 },
		                { label: 'proposal3Email', name: 'proposal3Email', width: 130 },
		                { label: 'proposal3Handler', name: 'proposal3Handler', width: 70 }
	            ],
	            width: "100%",
	            height: "100%",
	            'loadError' : function (xhr, status, error){
	                alert(error);
	            },
	            rownumber:true,
	            viewrecords: true, 
	            pager: '#mailCustomerPager',
	            rowNum: 1000000,
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
	   if(ids.length==0){
			alert("请先选择要发送的的项...");
			return;
		}
	   var title = $('#emailtitle').val();
	   if(title.length==0) {
		   alert("邮件标题不能为空...");
		   return; 
	   }
	   var context = $('#emailcontext').val();
	   if(context.length==0) {
		   alert("邮件内容不能为空...");
		   return;  
	   }
	   var emailfile = $('#emailfile').val();
	   if(emailfile.length == 0) {
		   if(!confirm("附件内容为空，确认继续发送吗？"))
				return;
	   }
	   $("#customerids").val(ids);
	   $("#emailsend").submit();
   }
}
    
$(function () {
	SMCP.initGrid();
});