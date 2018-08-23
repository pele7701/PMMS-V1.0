package com.pele.pmms.bo;

import java.util.List;

import com.pele.pmms.dao.tbo.TbMaterial;
import com.pele.pmms.dao.tbo.TbMaterialPrice;
/**
 * 项目物料业务POJO
 * @author beili
 *
 */
public class ProjectMaterialBo extends TbMaterial{
	/**
	 * 项目编码
	 */
	private String projectCode;
	/**
	 * 项目名称
	 */
	private String projectName;
	/**
	 * 配额
	 */
	private String quota;
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

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getQuota() {
		return quota;
	}

	public void setQuota(String quota) {
		this.quota = quota;
	}

	public String getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(String currentPrice) {
		this.currentPrice = currentPrice;
	}

	public String getCurrentTicket() {
		return currentTicket;
	}

	public void setCurrentTicket(String currentTicket) {
		this.currentTicket = currentTicket;
	}

	public List<TbMaterialPrice> getPrices() {
		return prices;
	}

	public void setPrices(List<TbMaterialPrice> prices) {
		this.prices = prices;
	}
	
}
