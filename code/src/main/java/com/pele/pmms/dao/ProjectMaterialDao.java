package com.pele.pmms.dao;

import java.util.List;

import org.nutz.dao.Sqls;
import org.nutz.dao.sql.Sql;
import org.nutz.ioc.loader.annotation.IocBean;

import com.pele.pmms.bo.ProjectMaterialBo;
import com.pele.pmms.dao.tbo.TbProjectMaterial;
import com.pele.pmms.util.CommonUtil;

/**
 * 项目物料或物料项目数据dao
 * @author beili
 *
 */
@IocBean(name = "projectMaterialDao")
public class ProjectMaterialDao extends BasicsDao{

	/**
	 * 根据项目编码和物料编码删除数据sql
	 */
	private final static String DELETE_PROJECT_MATERIAL_SQL = "delete from tb_project_material "
			+ "where project_code=@projectCode "
			+ "and material_code = @materialCode";
	/**
	 * 新增项目物料关系(每次先删除后插入)
	 * @param paramObj
	 * @return
	 */
	public int addProjectMateral(TbProjectMaterial paramObj){
		int result = 0;
		if(paramObj != null 
				&& CommonUtil.isNotEmptyString(paramObj.getProjectCode()) 
				&& CommonUtil.isNotEmptyString(paramObj.getMaterialCode())){
			//每次先删除项目物料关系再插入
			delProjectMateral(paramObj.getProjectCode(), paramObj.getMaterialCode());
			daoTemplate.insert(paramObj);
			result = 1;
		}
		return result;
	}
	/**
	 * 根据项目编码和物料编码删除项目物料数据
	 * @param paramObj
	 * @return
	 */
	public int delProjectMateral(String projectCode,String materialCode){
		int result = 0;
		if(CommonUtil.isNotEmptyString(projectCode) 
				&& CommonUtil.isNotEmptyString(materialCode)){
			Sql sql = Sqls.create(DELETE_PROJECT_MATERIAL_SQL);//创建根据项目编码和物料编码删除数据sql对象
			//设置删除数据条件(项目编码和物料编码)
			sql.params().set("projectCode", projectCode).set("materialCode", materialCode);
			daoTemplate.execute(sql);//删除项目物料关系
			result = 1;
		}
		return result;
	}
	
	public List<ProjectMaterialBo> getProjectMaterial(TbProjectMaterial paramObj){
		List<ProjectMaterialBo> resultList = null;
		return resultList;
	}
}
