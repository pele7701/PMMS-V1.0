package com.pele.pmms.dao.tbo;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

import com.pele.pmms.Constant;

/**
 * 数据表 tb_material 物料
 * @author beili
 *
 */
@Table("tb_material")
public class TbMaterial {

	/** 物料编码 */
	@Name
	@Column("material_code")
    private String materialCode ;
	
    /** 物料名称 */
	@Column("material_name")
    private String materialName ;
	
    /** 单位 */
	@Column("material_unit")
    private String materialUnit ;
	
    /** 规格 */
	@Column("material_pi_spec")
    private String materialPiSpec ;
	
    /** 状态  默认值:有效(Y)*/
	@Column("state")
    private String state = Constant.TbColumn.STATE_VALID;

    /** 物料编码 */
    public String getMaterialCode(){
        return this.materialCode;
    }
    /** 物料编码 */
    public void setMaterialCode(String materialCode){
        this.materialCode = materialCode;
    }
    /** 物料名称 */
    public String getMaterialName(){
        return this.materialName;
    }
    /** 物料名称 */
    public void setMaterialName(String materialName){
        this.materialName = materialName;
    }
    /** 单位 */
    public String getMaterialUnit(){
        return this.materialUnit;
    }
    /** 单位 */
    public void setMaterialUnit(String materialUnit){
        this.materialUnit = materialUnit;
    }
    /** 规格 */
    public String getMaterialPiSpec(){
        return this.materialPiSpec;
    }
    /** 规格 */
    public void setMaterialPiSpec(String materialPiSpec){
        this.materialPiSpec = materialPiSpec;
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
