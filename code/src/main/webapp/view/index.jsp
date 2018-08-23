<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/common/include-common.jsp"%>
<title>Project BOM Manage System</title>
<style type="text/css">
.menu-ul {
  cursor: pointer;
  line-height: 50px;
  color: #E2E2E2;
  font-family: cursive;
  font-size: 25px;
}

.menu-activity {
  color: #FFE48D;
}

.menu-idle {
  color: #E2E2E2;
}

.tab_div {
  height: 100%;
  width: 100%;
  position: absolute;
  display: none;
  background-color: #E2E2E2;
}
</style>
<script type="text/javascript">
	$(function() {
	    //菜单单击事件
	    $("#menu-ul li").click(function() {
	    	var curClass = $(this).attr("class");
	    	if('menu-activity' != curClass){
	    		//如果单击菜单不为当前选中菜单则执行
	    		$(this).siblings('li').removeClass('menu-activity');//所有同级li删除激活样式
	            $(this).addClass('menu-activity');//当前菜单加载激活样式
	            var tabTitle = $(this).html();
	            //根据菜单名称设置当前应显示tab
	            $('#tab-div').tabs('select', tabTitle);
	    	}
	    });
	    $('#tab-div').tabs({
		    //tab被选中事件
	    	onSelect : function(title, index) {
		    	//tab被选中时同时更新对应menu样式
		    	var liObj = $("#menu-ul li").eq(index);
		    	 $(liObj).siblings('li').removeClass('menu-activity');//所有同级li删除激活样式
		         $(liObj).addClass('menu-activity');//当前菜单加载激活样式
		    }
	    });
	    //页面加载初始化选中第一个菜单
	    $('#first-li').trigger("click");
    });
</script>
</head>
<body class="easyui-layout">
	<!-- top -->
	<div data-options="region:'north',border:false,split:false" style="height: 80px; background: #000000;">
		<div>
			</br>
			&nbsp;&nbsp;
			<font style="color: #FFFFFF; font-family: cursive; font-size: 35px;">项目物料管理</font>
		</div>
	</div>
	<!-- menu -->
	<div data-options="region:'west',border:false,split:false" style="width: 150px; background: #263238;">
		<div>
			<ul id="menu-ul" class="menu-ul">
				<li id="first-li">数据导入</li>
				<li>项目管理</li>
				<li>物料管理</li>
			</ul>
		</div>
	</div>
	<!-- menu page -->
	<div data-options="region:'center',border:false,split:false" style="padding: 0px; background: #E2E2E2;">
		<div id="tab-div" class="easyui-tabs" data-options="pill:true,fit:true" >
			<div title="数据导入" class="tab_div">
				<iframe src="<%=request.getContextPath()%>/view/import.jsp" frameborder="no" border="0" marginwidth="0" marginheight="0" width="100%" height="100%"></iframe>
			</div>
			<div title="项目管理" class="tab_div">
				<iframe src="<%=request.getContextPath()%>/view/project.jsp" frameborder="no" border="0" marginwidth="0" marginheight="0" width="100%" height="100%"></iframe>
			</div>
			<div title="物料管理" class="tab_div">
				<iframe src="<%=request.getContextPath()%>/view/material.jsp" frameborder="no" border="0" marginwidth="0" marginheight="0" width="100%" height="100%"></iframe>
			</div>

		</div>
	</div>
</body>
<%@ include file="/common/include-bottom.jsp"%>
</html>