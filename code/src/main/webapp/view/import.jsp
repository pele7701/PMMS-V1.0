<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/common/include-common.jsp"%>
<title>Import</title>
<style type="text/css">
</style>
<script type="text/javascript">
var patt1 = new RegExp("^(.+[.])(xls|xlsx)$");
var maxFileSize = 10485760;
	$(function() {
		//导入项目物料Excel
		$("#pm-upload").click(function () {
			var file = $('#pm-file')[0].files[0];
			upload(file,"PM");
            resetFileInput($("#pm-file"));
	    });
		
		//导入物料价格Excel
		$("#price-upload").click(function () {
            var file = $('#price-file')[0].files[0];
            upload(file,"PRICE");
            resetFileInput($("#price-file"));
        });
    });
	//上传excel文件
	function upload(file,type){
		if(checkFile(file)){
			var formData = new FormData();
            formData.append('file', file);
            formData.append('type', type);
            $.ajax({
            url: "<%=request.getContextPath()%>/inExcel/excel2DB.at",
                method : 'POST',
                data : formData,
                processData : false,
                contentType : false,
                success : function(data) {
                    alert("[" + file.name + "]" + data);
                }
            });
        }
	}
    //检查文件是否存在、文件扩展名是否为excel类型、文件大小
    function checkFile(file) {
	    var checkResult = true;
	    if (file == null) {
		    alert("请选择文件！");
		    checkResult = false;
	    } else if (!patt1.test(file.name)) {
		    alert("请选择Excel文件！");
		    checkResult = false;
	    } else if (file.size > maxFileSize) {
		    alert("所选Excel文件超出上传文件大小上限！");
		    checkResult = false;
	    }
	    return checkResult;
    }
    //清空input file中的值
    function resetFileInput(file) {
	    file.after(file.clone().val(""));
	    file.remove();
    }
</script>
</head>
<body>
	<table>
		<tr>
			<td width="150px">
				<a href="../物料明细表.xls" title="项目物料清单模板">导入项目物料清单</a>
			</td>
			<td width="400px">
				<input type="file" id="pm-file">
			</td>
			<td>
				<input type="button" value="导入" id="pm-upload">
			</td>
		</tr>
		<tr>
			<td>
				<a href="../价格表.xls" title="物料价格清单模板">导入物料价格清单</a>
			</td>
			<td>
				<input type="file" id="price-file">
			</td>
			<td>
				<input type="button" value="导入" id="price-upload">
			</td>
		</tr>
	</table>
</body>
</html>