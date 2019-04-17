function myFunction(){
	x=document.getElementById("demo");  // 找到元素
	x.innerHTML="Hello JavaScript!";    // 改变内容
}

//监听提交
$("button").on("click", function(){
	alert("点击了按钮");
	myFunction();
});