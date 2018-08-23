package com.pele.pmms.dao;

import java.util.ArrayList;
import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.QueryResult;
import org.nutz.dao.entity.Record;
import org.nutz.dao.pager.Pager;
import org.nutz.ioc.loader.annotation.IocBean;

import com.pele.pmms.Constant;
import com.pele.pmms.bo.MaterialBo;
import com.pele.pmms.dao.tbo.TbMaterial;
import com.pele.pmms.util.CommonUtil;
/**
 * 物料dao
 * @author beili
 *
 */
@IocBean(name = "materialDao")
public class MaterialDao extends BasicsDao{
	
	private final static String GET_MATERIALS_SQL = " (select t.material_code,t.material_name,t.material_pi_spec, "
													      + "t.material_unit,t1.price,t1.ticket "
			                                              + "from tb_material t  left outer join " 
													      + "(select * from tb_material_price as a "
			                                              + "where seq = (select max(b.seq) "
													      + "from tb_material_price as b "
			                                              + "where a.material_code = b.material_code )) t1 "
													      + "on t1.material_code = t.material_code where 1=1";
	
	private final static String GET_MATERIALS_COUNT_SQL = " tb_material t  left outer join " 
														    + "(select * from tb_material_price as a "
												            + "where seq = (select max(b.seq) "
														    + "from tb_material_price as b "
												            + "where a.material_code = b.material_code )) t1 "
														    + "on t1.material_code = t.material_code where 1=1";

	/**
	 * 以分页方式获取物料及物料最新价格、凭证数据
	 * @param paramObj
	 *        paramObj.getMaterialCode() 根据物料编码精确查询
	 *        paramObj.getMaterialName() 根据物料名称模糊查询
	 * @return QueryResult 返回分页参数及数据集合
	 */
	public QueryResult getMaterialsOfPaging(MaterialBo paramObj){
		List<MaterialBo> resultList = null;
		int total = 0;
		StringBuilder dataSqlStr = new StringBuilder(GET_MATERIALS_SQL);//初始化获取数据sql
		StringBuilder countSqlStr = new StringBuilder(GET_MATERIALS_COUNT_SQL);//初始化获取数量sql
		int pageNum = Constant.Dao.DEFAULT_PAGE_NUMBER;//声明分页页码参数，默认值1
		int pageRowSize = CommonUtil.getDefaulPageRowSize();//声明分页页记录数参数，并赋默认值
		if(paramObj != null){
			if(paramObj.getPagingParam() != null){
				//如果入参分页参数不为空则将入参分页参数赋值到当前变量
				pageNum = paramObj.getPagingParam().getPageNum();
				pageRowSize = paramObj.getPagingParam().getPageRowSize();
			}
			if(CommonUtil.isNotEmptyString(paramObj.getMaterialCode())){
				//如果入参中物料编码不为空则设置为查询条件(精确匹配)
				dataSqlStr.append(" and material_code = ").append(paramObj.getMaterialCode());
				countSqlStr.append(" and material_code = ").append(paramObj.getMaterialCode());
			}
			if(CommonUtil.isNotEmptyString(paramObj.getMaterialName())){
				//如果入参中物料名称不为空则设置为查询条件(模糊匹配)
				dataSqlStr.append(" and material_name like ").append("'%").append(paramObj.getMaterialName()).append("%'");
				countSqlStr.append(" and material_name like ").append("'%").append(paramObj.getMaterialName()).append("%'");
			}
		}
		/**
		 * 使用count 方法会底层会在sql前加 SELECT count(*) FROM 
		 */
		total = daoTemplate.count(countSqlStr.toString());//执行查询记录数量sql
		//设置分页对象
		Pager pager = new Pager();
		pager.setPageNumber(pageNum);
		pager.setPageSize(pageRowSize);
		if(total > 0){
			//如果存在符合条件数据则执行获取数据sql
			dataSqlStr.append(" order by t.material_code)");//获取数据时排序
			/**
			 * 使用query 方法会底层会在sql前加 SELECT * FROM 
			 */
			List<Record> recordList = daoTemplate.query(dataSqlStr.toString(), null, pager);//执行获取数据sql
			if(CommonUtil.isNotEmptyCollection(recordList)){
				//如果获取到记录集则遍历记录集将记录集数据转入数据对象集合中
				resultList = new ArrayList<MaterialBo>();
				MaterialBo materialObj = null; 
				for(Record record:recordList){
					materialObj = new MaterialBo();
					materialObj.setMaterialCode(record.getString("material_code"));
					materialObj.setMaterialName(record.getString("material_name"));
					materialObj.setMaterialUnit(record.getString("material_unit"));
					materialObj.setMaterialPiSpec(record.getString("material_pi_spec"));
					materialObj.setCurrentPrice(record.getString("price"));
					materialObj.setCurrentTicket(record.getString("ticket"));
					resultList.add(materialObj);
				}
			}
		}
		pager.setRecordCount(total);//设置记录总数
		return new QueryResult(resultList, pager);
	}
	/**
	 * 新增物料
	 * @param paramObj
	 * @return 0失败，1成功
	 */
	public int addMaterial(TbMaterial paramObj){
		int result = 0;
		if(paramObj != null 
				&& CommonUtil.isNotEmptyString(paramObj.getMaterialCode()) 
				&& CommonUtil.isNotEmptyString(paramObj.getMaterialName())){
			//根据物料编码获取物料数量，判断物料是否已经存在
			int count = daoTemplate.count(TbMaterial.class,Cnd.where("material_code","=",paramObj.getMaterialCode()));
			if(count < 1){
				//如果物料编码不存在则新增物料数据
				insertMaterial(paramObj);
				result = 1;
			}
		}
		return result;
	}
	
	private void insertMaterial(TbMaterial paramObj){
		daoTemplate.insert(paramObj);
	}
	
	
}
