package com.pele.pmms.dao.tbo;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

import com.pele.pmms.Constant;
/**
 * 数据表 tb_project 项目
 *  Column // 表示该对象属性可以映射到数据库里作为一个字段
 *  name 表示该字段可以用来标识此对象，或者是字符型主键，或者是唯一性约束
 * @author beili
 *
 */
@Table("tb_project")
public class TbProject {
	/** 项目编码 */
	@Name
	@Column("project_code")
    private String projectCode ;
	
    /** 项目名称 */
	@Column("project_name")
    private String projectName ;
	
    /** 状态  默认值:有效(Y)*/
	@Column("state")
    private String state = Constant.TbColumn.STATE_VALID;
	
	

    /** 项目编码 */
    public String getProjectCode(){
        return this.projectCode;
    }
    /** 项目编码 */
    public void setProjectCode(String projectCode){
        this.projectCode = projectCode;
    }
    /** 项目名称 */
    public String getProjectName(){
        return this.projectName;
    }
    /** 项目名称 */
    public void setProjectName(String projectName){
        this.projectName = projectName;
    }
    /** 状态 */
    public String getState(){
        return this.state;
    }
    /** 状态 */
    public void setState(String state){
        this.state = state;
    }
}
