package com.pele.pmms.dao.tbo;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.EL;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Prev;
import org.nutz.dao.entity.annotation.Table;

/**
 * 数据表 tb_project_material 项目物料
 * @author beili
 *
 */
@Table("tb_project_material")
public class TbProjectMaterial {
	
	public TbProjectMaterial(){}
	
	public TbProjectMaterial(String projectCode, String materialCode, String quota) {
		this.projectCode = projectCode;
		this.materialCode = materialCode;
		this.quota = quota;
	}

	/** 项目物料ID */
	@Name
	@Prev(els=@EL("uuid(32)")) // 可以是 uuid() uuid(32)
	@Column("pm_id")
	protected String pmId;
	
	/** 项目编码 */
	@Column("project_code")
	protected String projectCode;
	
	/** 物料编码 */
	@Column("material_code")
	protected String materialCode;
	
	/** 配额 */
	@Column("quota")
	protected String quota;

	/** 项目物料ID */
	public String getPmId() {
		return this.pmId;
	}

	/** 项目物料ID */
	public void setPmId(String pmId) {
		this.pmId = pmId;
	}

	/** 项目编码 */
	public String getProjectCode() {
		return this.projectCode;
	}

	/** 项目编码 */
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	/** 物料编码 */
	public String getMaterialCode() {
		return this.materialCode;
	}

	/** 物料编码 */
	public void setMaterialCode(String materialCode) {
		this.materialCode = materialCode;
	}

	/** 配额 */
	public String getQuota() {
		return this.quota;
	}

	/** 配额 */
	public void setQuota(String quota) {
		this.quota = quota;
	}
}
