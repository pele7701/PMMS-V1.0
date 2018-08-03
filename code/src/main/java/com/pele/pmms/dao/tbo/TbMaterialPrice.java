package com.pele.pmms.dao.tbo;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Prev;
import org.nutz.dao.entity.annotation.EL;
import org.nutz.dao.entity.annotation.Table;

/**
 * 数据表 tb_material_price 物料价格
 * @author beili
 *
 */
@Table("tb_material_price")
public class TbMaterialPrice {

	/** 物料价格ID */
	@Name
	@Prev(els=@EL("uuid(32)")) // 可以是 uuid() uuid(32)
	@Column("price_id")
    private String priceId ;
	
    /** 物料编码 */
	@Column("material_code")
    private String materialCode ;
	
    /** 物料价格 */
	@Column("price")
    private String price ;
	
    /** 价格凭证 */
	@Column("ticket")
    private String ticket ;
	
    /** 序号 */
	@Column("seq")
    private String seq ;

    /** 物料价格ID */
    public String getPriceId(){
        return this.priceId;
    }
    /** 物料价格ID */
    public void setPriceId(String priceId){
        this.priceId = priceId;
    }
    /** 物料编码 */
    public String getMaterialCode(){
        return this.materialCode;
    }
    /** 物料编码 */
    public void setMaterialCode(String materialCode){
        this.materialCode = materialCode;
    }
    /** 物料价格 */
    public String getPrice(){
        return this.price;
    }
    /** 物料价格 */
    public void setPrice(String price){
        this.price = price;
    }
    /** 价格凭证 */
    public String getTicket(){
        return this.ticket;
    }
    /** 价格凭证 */
    public void setTicket(String ticket){
        this.ticket = ticket;
    }
    /** 序号 */
    public String getSeq(){
        return this.seq;
    }
    /** 序号 */
    public void setSeq(String seq){
        this.seq = seq;
    }
}
