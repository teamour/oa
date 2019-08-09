BF={
	initGrid: function () {
   		 $("#mailRecordDetail").jqGrid({
	             url:  ctxPath +'OUR002/sendmailrecord',
	             mtype: "POST",
	             datatype: "json",
	             colNames:["mailingId", "发送状态", "开始时间", "结束时间","发送人Email", "邮件标题"],
	             colModel: [
	                 { label: 'mailingId', name: 'mailingId', key: true,hidden:true, width: 75 },
	                 { label: 'mailStats', name: 'mailStats', width: 50 },
	                 { label: 'beginTime', name: 'beginTime', width: 180 },
	                 { label: 'endTime', name: 'endTime', width: 180 },
	                 { label: 'mailingAimSummary', name: 'mailingAimSummary', width: 200 },
	                 { label: 'mailingTempleteContent', name: 'mailingTempleteContent', width: 300},
	             ],
	             width: "100%",
	             height: "100%",
	             'loadError' : function (xhr, status, error){
	                 alert(error);
	             },
	             rownumber:true,
	             viewrecords: true, 
	             pager: '#mailRecordDetailPager',
	             rowNum: 10,
	             rowList: [5, 10, 50, 100, 500],
	             multiselect: true,
	             jsonReader:{ repeatitems:false },
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
//    BF.initGrid();
});