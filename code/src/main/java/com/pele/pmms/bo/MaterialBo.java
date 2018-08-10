package com.pele.pmms.bo;

import java.util.List;

import com.pele.pmms.dao.tbo.TbMaterial;
import com.pele.pmms.dao.tbo.TbMaterialPrice;
/**
 * 物料价格业务模型
 * @author beili
 *
 */
public class MaterialBo extends TbMaterial{

	/**
	 * 当前(最新)价格
	 */
	private String currentPrice;
	/**
	 * 当前(最新)凭证
	 */
	private String currentTicket;
	
	/**
	 * 物料价格
	 */
	private List<TbMaterialPrice> prices;
	
	/**
	 * 分页参数
	 */
	private PaginationParameterPojo pagingParam;

	public String getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(String currentPrice) {
		this.currentPrice = currentPrice;
	}

	public List<TbMaterialPrice> getPrices() {
		return prices;
	}

	public void setPrices(List<TbMaterialPrice> prices) {
		this.prices = prices;
	}

	public PaginationParameterPojo getPagingParam() {
		return pagingParam;
	}

	public void setPagingParam(PaginationParameterPojo pagingParam) {
		this.pagingParam = pagingParam;
	}

	public String getCurrentTicket() {
		return currentTicket;
	}

	public void setCurrentTicket(String currentTicket) {
		this.currentTicket = currentTicket;
	}
	
}
