/**
 * 
 */

BF={
	initGrid: function () {},
	createData: function (){
		var url="http://localhost:8080/document/createTest";
		 $.post(url);
   }
	
}

$(function () { 
	
    BF.initGrid();
});