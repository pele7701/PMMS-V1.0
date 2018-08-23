package com.pele.pmms.at;

import java.io.File;
import java.util.List;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.AdaptBy;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.upload.UploadAdaptor;

import com.pele.pmms.dao.MaterialDao;
import com.pele.pmms.dao.ProjectDao;
import com.pele.pmms.dao.ProjectMaterialDao;
import com.pele.pmms.dao.tbo.TbMaterial;
import com.pele.pmms.dao.tbo.TbProject;
import com.pele.pmms.dao.tbo.TbProjectMaterial;
import com.pele.pmms.util.CommonUtil;
import com.pele.pmms.util.ReadExcelUtil;

@IocBean(name="importAt") //AT必须使用IocBean否则无法在类里面使用Inject注入成员
@At("/inExcel")
public class ImportAt {
	
	private final static String IMPORT_SUCCESS = "文件上传成功！";
	private final static String IMPORT_FAIL = "文件上传失败！";
	
	private final static String IMPORT_TYPE_PROJECT_MATERIAL = "PM";//项目物料导入文件类型
	private final static String IMPORT_TYPE_MATERIAL_PRICE = "PRICE";//物料价格导入文件类型
	
	private final static int PROJECT_MATERIAL_EXCEL_COLUMN_SIZE = 8;//项目物料Excel有效数据列数
	private final static int MATERIAL_PRICE_EXCEL_COLUMN_SIZE = 5;//物料价格Excel有效数据列数

	@Inject("projectDao")
	private ProjectDao projectDao;
	
	@Inject("materialDao")
	private MaterialDao materialDao;
	
	@Inject("projectMaterialDao")
	private ProjectMaterialDao projectMaterialDao;
	
	/**
	 * 从Excel导入项目物料数据
	 * @param file
	 * @return
	 */
	@At("/excel2DB")
	@AdaptBy(type = UploadAdaptor.class, args = { "${app.root}/import" })
	@Ok("raw")
	public String excel2DB(@Param("file") File file,@Param("type") String type){
		String result = IMPORT_FAIL;
		try {
			//根据type选择处理文件业务方法
			if(IMPORT_TYPE_PROJECT_MATERIAL.equals(type)){
				//读取项目物料文件，并将数据入库
				result = projectMaterial2DB(file);
			}else if(IMPORT_TYPE_MATERIAL_PRICE.equals(type)){
				//物料价格文件，并将数据入库
				result = price2DB(file);
			}
		} catch (Exception e) {
			result = e.getMessage();
		}finally {
			try {
				if(file != null){
					file.delete();
				}
			} catch (Exception e2) {
			}
		}
		return result;
	}
	
	/**
	 * 读取项目物料文件，并将数据入库
	 * @param file
	 * @return
	 * @throws Exception
	 */
	private String projectMaterial2DB(File file) throws Exception{
		String result = "";
		List<String[]> pmDataList = ReadExcelUtil.excelContent2Obj(file, PROJECT_MATERIAL_EXCEL_COLUMN_SIZE);//从Excel读取数据
		if(CommonUtil.isNotEmptyCollection(pmDataList)){
			//将读取到的数据插入数据库
			for(String[] array:pmDataList){
				if(array != null && array.length == PROJECT_MATERIAL_EXCEL_COLUMN_SIZE){
					//项目数据入库
					TbProject project = new TbProject(array[2],array[1]);
					projectDao.addProject(project);
					//物料数据入库
					TbMaterial material = new TbMaterial(array[3],array[4],array[6],array[5]);
					materialDao.addMaterial(material);
					//项目物料数据入库
					TbProjectMaterial projectMaterial = new TbProjectMaterial(array[2],array[3],array[7]);
					projectMaterialDao.addProjectMateral(projectMaterial);
				}
			}
		}
		result = IMPORT_SUCCESS;
		return result;
	}
	
	/**
	 * 物料价格文件，并将数据入库
	 * @param file
	 * @return
	 * @throws Exception
	 */
	private String price2DB(File file) throws Exception{
		String result = "";
		List<String[]> pmDataList = ReadExcelUtil.excelContent2Obj(file, MATERIAL_PRICE_EXCEL_COLUMN_SIZE);//从Excel读取数据
		if(CommonUtil.isNotEmptyCollection(pmDataList)){
			//将读取到的数据插入数据库
			for(String[] array:pmDataList){
				if(array != null && array.length == MATERIAL_PRICE_EXCEL_COLUMN_SIZE){
					
				}
			}
		}
		result = IMPORT_SUCCESS;
		return result;
	}
	
	
}
