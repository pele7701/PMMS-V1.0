package com.pele.pmms.dao.tbo;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

/**
 * 数据表 tb_project_material 项目物料
 * @author beili
 *
 */
@Table("tb_project_material")
public class TbProjectMaterial {
	/** 项目物料ID */
	@Name
	@Column("pm_id")
	private String pmId;
	
	/** 项目编码 */
	@Column("project_code")
	private String projectCode;
	
	/** 物料编码 */
	@Column("material_code")
	private String materialCode;
	
	/** 配额 */
	@Column("quota")
	private String quota;

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
