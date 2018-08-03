package com.pele.pmms.dao;

import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.IocBean;

import com.pele.pmms.dao.tbo.TbProject;
import com.pele.pmms.util.CommonUtil;

/**
 * 项目
 * @author beili
 *
 */
@IocBean(name = "projectDao")
public class ProjectDao extends BasicsDao {

	/**
	 * 查询项目
	 *  paramObj.ProjectCode 根据项目编码精确查询
	 *  paramObj.ProjectName 根据项目名称查询(可支持模糊查询)
	 * @param paramObj
	 * @return
	 */
	public List<TbProject> getProjects(TbProject paramObj){
		List<TbProject> resultList = null;
		Cnd cnd = Cnd.where("1", "=", 1);
		if(paramObj != null){
			if(CommonUtil.isNotEmptyString(paramObj.getProjectCode())){
				cnd.and("project_code","=",paramObj.getProjectCode());
			}
			if(CommonUtil.isNotEmptyString(paramObj.getProjectName())){
				cnd.and("project_name","like","%" + paramObj.getProjectName() + "%");
			}
		}
		resultList = daoTemplate.query(TbProject.class, cnd);
		return resultList;
	}
}
