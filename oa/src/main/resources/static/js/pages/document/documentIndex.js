/**
 * 
 */

BF={
	initGrid: function () {
		 $("#jqGrid").jqGrid({
			 url : document.location.toString(),
			 mtype: "Post",
             datatype: "json",
             colNames:["id", "客户公司名", "客户地址", "客户负责人", "自社名","付款期限"],
             colModel: [
                 { label: 'invoiceDocumentId', name: 'invoiceDocumentId', width: 75 },
                 { label: 'customerName', name: 'customerName', width: 150 },
                 { label: 'customerAddress', name: 'customerAddress', width: 350 },
                 { label: 'customerCharge', name: 'customerCharge', width: 150 },
                 { label: 'companyName', name: 'companyName', width: 150 },
                 { label: 'payDeadline', name: 'payDeadline', width: 150 }
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
		 $("#jqGrid").jqGrid({
			 //发注书内容
		 });
	},
   modifyIvoice:function(){
	   var selData = $("#jqGrid").getRowData();
		// 要判断是否有选择，且只选中一行数据
		var rowId=$("#jqGrid").jqGrid('getGridParam','selrow');
		var ids_t = $("#jqGrid").jqGrid("getGridParam","selarrrow");
		console.log(ids_t.length);
		if(ids_t.length == 1){
		window.location.href = ctxPath+"document/editinvoice/"+selData[rowId-1].invoiceDocumentId;
		}
		else{
			layui.use('layer', function(){
	 			  var layer = layui.layer;
	 			 layer.msg('仅且只能选中一行数据进行修改');
	 			});  
		}
   },
   createIvoice:function(){
	   var selData = $("#jqGrid").getRowData();
		// 要判断是否有选择，且只选中一行数据
		var rowId=$("#jqGrid").jqGrid('getGridParam','selrow');
		window.location.href = ctxPath+"document/createinvoice/"+selData[rowId-1].invoiceDocumentId;
   },
   deleteIvoice: function(){
	   var selData = $("#jqGrid").getRowData();
	   var ids_t = $("#jqGrid").jqGrid("getGridParam","selarrrow");
	   var ids = new Array();
	   var len = ids_t.length;
	   var a;
	   for(var i=0;i<len;i++){
		   a = ids_t[i]
		   ids[i] = selData[a-1].invoiceDocumentId;
	   }
	   if(!confirm("您确认删除吗"))return;
	   //1.定义请求的url
	   var url="http://localhost:8080/document/deleteInvoiceByIds";
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
   }
   
	
}

$(function () { 
	
    BF.initGrid();
});