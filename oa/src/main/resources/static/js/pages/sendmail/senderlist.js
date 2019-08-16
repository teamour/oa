BF={
	initGrid: function () {
   		 $("#sender").jqGrid({
	             url:  ctxPath +'OUR003/senderList',
	             mtype: "POST",
	             datatype: "json",
	             colNames:["Id", "发件人邮箱","邮箱秘钥", "发件人姓名"],
	             colModel: [
	                 { label: 'senderId', name: 'senderId', key: true,hidden:true, width: 75 },
	                 { label: 'senderMailAddress', name: 'senderMailAddress', width: 350},
	                 { label: 'senderMailPassword', name: 'senderMailPassword', width: 200 },
	                 { label: 'senderName', name: 'senderName', width: 150 }
	             ],
	             width: "100%",
	             height: "100%",
	             'loadError' : function (xhr, status, error){
	                 alert(error);
	             },
	             rownumber:true,
	             viewrecords: true, 
	             pager: '#senderPager',
	             rowNum: 10,
	             rowList: [5, 10, 50, 100, 500],
	             multiselect: true,
	             jsonReader:{ repeatitems:false },
	         });
	},
	deleteData:function(){
		var rows=$("#sender").jqGrid('getGridParam','selarrrow');
		
		// 如果没有选择跳过
		if(rows.length==0){
			alert("请先选择要删除的项");
			return;
		}
		
		if(!confirm("您确认删除吗"))
			return;
		
		var url=ctxPath + "OUR003/deleteSender";
		var params={"rows":rows.toString()};
		
		$.post(url,params,function(result){})
			.done(function(data,textStatus,jqXHR) {
			   
			})
			.fail(function(jqXHR, textStatus, errorThrown ) {
				alert("删除发生异常");
			})
			.always(function() {
				window.location.reload();
			});
	},
	searchData: function (){
		$("#sender").setGridParam({
            page: 1,
            postData: {}
        }).trigger('reloadGrid');
   }
}
    
$(function () { 
    BF.initGrid();
});