BF={
	initGrid: function () {
   		 $("#jqGrid").jqGrid({
	             url:  ctxPath +'hr/visaLogin',
	             mtype: "POST",
	             datatype: "json",
	             colNames:["Id", "面试人员编号", "材料准备情况", "邮寄情况"],
	             colModel: [
	                 { label: 'visaHandleId', name: 'visaHandleId', key: true,hidden:true, width: 75 },
	                 { label: 'interviewer.interviewerCode', name: 'interviewer.interviewerCode', width: 150 },
	                 { label: 'materialPrepareSituation', name: 'materialPrepareSituation', width: 150, 
	                	 formatter:function(cellvalue, options, rowObject){
	                		 if(cellvalue==0){
	                			 return "未准备";
	                		 }else if(cellvalue==1){
	                			 return "准备中";
	                		 }else if(cellvalue==2){
	                			 return "准备完毕";
	                		 }
	                	 }
	                 },
	                 { label: 'mailingSituation', name: 'mailingSituation', width: 150 ,
	                	 formatter:function(cellvalue, options, rowObject){
	                		 if(0==cellvalue){
	                			 return "未邮寄";
	                		 }else if(cellvalue==1){
	                			 return "邮寄中";
	                		 }else if(cellvalue==2){
	                			 return "已收到";
	                		 }
	                	 }
	                 }
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