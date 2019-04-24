BF={
	initGrid: function () {
   		 $("#jqGrid").jqGrid({
	             url:  ctxPath +'hr/itSuitableLogin',
	             mtype: "POST",
	             datatype: "json",
	             colNames:["Id", "面试人员编号", "姓名", "考试分数"],
	             colModel: [
	                 { label: 'visaHandleId', name: 'visaHandleId', key: true,hidden:true, width: 75 },
	                 { label: 'interviewer.interviewerCode', name: 'interviewer.interviewerCode', width: 150 },
	                 { label: 'interviewer.interviewerName', name: 'interviewer.interviewerName', width: 150 },
	                 { label: 'testScore', name: 'testScore', width: 150 }
	             ],
	             width: "800",
	             height: "400",
	             'loadError' : function (xhr, status, error){
	                 alert(error);
	             },
	             rownumber:true,
	             viewrecords: true, 
	             pager: '#jqGridPager',
	             rowNum: 10,
	             rowList: [5, 10, 50, 100, 500],
	             multiselect: false,
	             jsonReader:{ repeatitems:false }
	         });
	}
	
}
    
$(function() { 
    BF.initGrid();
});