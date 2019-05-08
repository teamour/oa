/**
 * 
 */

BF={
	initGrid: function () {
		 $("#jqGrid").jqGrid({
			 url : document.location.toString(),
			 mtype: "Post",
             datatype: "json",
             colNames:["id", "客户公司名", "客户地址", "客户负责人", "自社名","付款期限","单价"],
             colModel: [
                 { label: 'invoiceDocumentId', name: 'invoiceDocumentId', width: 75 },
                 { label: 'customerName', name: 'customerName', width: 150 },
                 { label: 'customerAddress', name: 'customerAddress', width: 350 },
                 { label: 'customerCharge', name: 'customerCharge', width: 150 },
                 { label: 'companyName', name: 'companyName', width: 150 },
                 { label: 'payDeadline', name: 'payDeadline', width: 150 },
                 { label: 'unitPrice', name: 'unitPrice', width: 150 }
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
	createData: function (){
		var url="http://localhost:8080/document/createTest";
		 $.post(url);
   }
	
}

$(function () { 
	
    BF.initGrid();
});