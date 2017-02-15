$("#items_pic").change(function() {
	alert("--");
	var objUrl = getObjectURL(this.files[0]);
	if (objUrl) {
		$("#img0").attr("src", objUrl);
	}
});
//建立一個可存取到該file的url  
function getObjectURL(file) {
	var url = null;
	// 下面函数执行的效果是一样的，只是需要针对不同的浏览器执行不同的 js 函数而已  
	if (window.createObjectURL != undefined) { // basic  
		url = window.createObjectURL(file);
	} else if (window.URL != undefined) { // mozilla(firefox)  
		url = window.URL.createObjectURL(file);
	} else if (window.webkitURL != undefined) { // webkit or chrome  
		url = window.webkitURL.createObjectURL(file);
	}
	return url;
}