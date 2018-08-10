package com.pele.pmms.at;

import org.nutz.dao.QueryResult;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.adaptor.JsonAdaptor;
import org.nutz.mvc.annotation.AdaptBy;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;

import com.pele.pmms.bo.MaterialBo;
import com.pele.pmms.dao.MaterialDao;

@IocBean(name="materialAt") //AT必须使用IocBean否则无法在类里面使用Inject注入成员
@At("/material")
public class MaterialAt {

	@Inject("materialDao")
	private MaterialDao materialDao;
	
	/**
	 * 以分页方式获取物料及物料最新价格、凭证数据
	 * @param paramObj
	 *        paramObj.getMaterialCode() 根据物料编码精确查询
	 *        paramObj.getMaterialName() 根据物料名称模糊查询
	 * @return QueryResult 返回分页参数及数据集合
	 */
	@At("/list")
	@AdaptBy(type=JsonAdaptor.class)
	@Ok("json")
	public QueryResult getMaterialsOfPaging(@Param("params") MaterialBo paramObj){
		return materialDao.getMaterialsOfPaging(paramObj);
	}
}
