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
				//如果项目编码不为空则设置为精确查询条件
				cnd.and("project_code","=",paramObj.getProjectCode());
			}
			if(CommonUtil.isNotEmptyString(paramObj.getProjectName())){
				//如果项目名称不为空则设置为模糊查询条件
				cnd.and("project_name","like","%" + paramObj.getProjectName() + "%");
			}
		}
		resultList = daoTemplate.query(TbProject.class, cnd);
		return resultList;
	}
	/**
	 * 新增项目
	 * @param paramObj
	 * @return
	 */
	public int addProject(TbProject paramObj){
		int result = 0;
		if(paramObj != null 
				&& CommonUtil.isNotEmptyString(paramObj.getProjectCode()) 
				&& CommonUtil.isNotEmptyString(paramObj.getProjectName())){
			//根据项目编码获取项目数量
			int count = daoTemplate.count(TbProject.class,Cnd.where("project_code","=",paramObj.getProjectCode()));
			if(count < 1){
				//如果项目编码不存在则插入项目数据
				daoTemplate.insert(paramObj);
				result = 1;
			}
		}
		return result;
	}
	
	/**
	 * 插入项目数据
	 * @param paramObj
	 */
	private void insertProject(TbProject paramObj){
		daoTemplate.insert(paramObj);
	}
	
}
