package com.pele.pmms.at;

import java.util.List;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.adaptor.JsonAdaptor;
import org.nutz.mvc.annotation.AdaptBy;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;

import com.pele.pmms.dao.ProjectDao;
import com.pele.pmms.dao.tbo.TbProject;
@IocBean(name="projectAt") //AT必须使用IocBean否则无法在类里面使用Inject注入成员
@At("/project")
public class ProjectAt {

	@Inject("projectDao")
	private ProjectDao projectDao;
	
	/**
	 * URL:PMMS/project/list
	 * 获取项目数据列表，可根据项目编码(精确)或项目名称(模糊)检索
	 * @param paramObj
	 * @return
	 */
	@At("/list")
	@AdaptBy(type=JsonAdaptor.class)
	@Ok("json")
	public List<TbProject> getProjects(@Param("params") TbProject paramObj){
		return projectDao.getProjects(paramObj);
	}
	
}
