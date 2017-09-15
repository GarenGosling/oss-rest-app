package org.garen.oss.service;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.garen.oss.mybatis.domain.FileType;
import org.garen.oss.mybatis.domain.FileTypeExample;
import org.garen.oss.mybatis.service.FileTypeService;
import org.garen.oss.service.validate.FileTypeManageValidate;
import org.garen.oss.swagger.model.SuccessModel;
import org.garen.oss.util.EsapiUtil;
import org.garen.oss.util.TransferUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 文件类型业务类
 *
 * @author Garen Gosling
 * @create 2017-09-14 21:00
 * @since v1.0
 */
@Service
public class FileTypeManage extends BaseManage<Long>{

    @Autowired
    FileTypeService<FileType, FileTypeExample, Long> service;
    @Autowired
    FileTypeManageValidate fileTypeManageValidate;

    @Override
    public FileTypeService<FileType, FileTypeExample, Long> getService() {
        return service;
    }

    /**
     * 类型转换
     *
     * @param fileType
     * @return
     */
    private FileType transfer(org.garen.oss.swagger.model.FileType fileType){
        FileType dest = new FileType();
        TransferUtil.transfer(dest, fileType);
        return dest;
    }

    /**
     * 根据code/name查询
     *
     * @param code
     * @param name
     * @return
     */
    private FileType getByParam(String code, String name){
        FileTypeExample example = new FileTypeExample();
        FileTypeExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank(code)){
            criteria.andCodeEqualTo(EsapiUtil.sql(code));
        }
        if(StringUtils.isNotBlank(name)){
            criteria.andNameLike("%" + EsapiUtil.sql(name) + "%");
        }
        List<FileType> fileTypes = getService().findBy(example);
        FileType fileType = null;
        if(fileTypes.size() >= 1){
            fileType = fileTypes.get(0);
        }
        return fileType;
    }

    /**
     * 分页查询之列表
     *
     * @param start
     * @param length
     * @param name
     * @return
     */
    private List<FileType> getPageList(Integer start, Integer length, String name){
        if(start == null) start = START;
        if(length == null) length = LENGTH;
        FileTypeExample example = new FileTypeExample();
        FileTypeExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank(name)){
            criteria.andNameLike("%" + EsapiUtil.sql(name) + "%");
        }
        example.setOrderByClause("id desc");
        return getService().findBy(new RowBounds(start, length), example);
    }

    /**
     * 分页查询之数量
     *
     * @param name
     * @return
     */
    private int getPageCount(String name){
        String sql = "select count(*) count from file_type where 1=1 ";
        if(StringUtils.isNotBlank(name)){
            sql += " AND name like '%"+ EsapiUtil.sql(name) +"%'";
        }
        return getService().countBySQL(sql);
    }

    /**
     * 新增
     *
     * @param fileType
     * @return
     */
    public SuccessModel saveFileType(org.garen.oss.swagger.model.FileType fileType){
        // 验证
        SuccessModel successModel = fileTypeManageValidate.saveFileTypeValidate(fileType);
        if(successModel != null){
            return successModel;
        }
        // 类型转换
        FileType dest = transfer(fileType);
        // 处理业务
        dest.setOperatorCode("0");
        dest.setOperatorName("系统");
        dest.setCreateTime(new Date());
        int i = create(dest);
        return new SuccessModel().message(SAVE_SUCCESS + i);
    }

    /**
     * 修改
     *
     * @param fileType
     * @return
     */
    public SuccessModel updateFileType(org.garen.oss.swagger.model.FileType fileType){
        // 验证
        SuccessModel successModel = fileTypeManageValidate.updateFileTypeValidate(fileType);
        if(successModel != null){
            return successModel;
        }
        // 类型转换
        FileType dest = transfer(fileType);
        // 处理业务
        dest.setOperatorCode("0");
        dest.setOperatorName("系统");
        int i = modify(dest);
        return new SuccessModel().message(UPDATE_SUCCESS + i);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    public SuccessModel deleteFileType(Long id){
        // 验证
        SuccessModel successModel = fileTypeManageValidate.idValidate(id);
        if(successModel != null){
            return successModel;
        }
        int i = removeById(id);
        return new SuccessModel().message(DELETE_SUCCESS + i);
    }

    /**
     * ID查询
     *
     * @param id
     * @return
     */
    public SuccessModel getFileType(Long id){
        // 验证
        SuccessModel successModel = fileTypeManageValidate.idValidate(id);
        if(successModel != null){
            return successModel;
        }
        FileType fileType = findById(id);
        return new SuccessModel().message(GET_SUCCESS).data(fileType);
    }

    /**
     * 查询全部
     *
     * @return
     */
    public SuccessModel getAll(){
        List<FileType> fileTypes = getService().findAll();
        return new SuccessModel().message(GET_ALL_SUCCESS).data(fileTypes);
    }

    /**
     * 编码查询
     *
     * @param code
     * @return
     */
    public SuccessModel getByCode(String code){
        // 验证
        SuccessModel successModel = fileTypeManageValidate.codeValidate(code);
        if(successModel != null){
            return successModel;
        }
        FileType fileType = getByParam(code, null);
        return new SuccessModel().message("编码" + GET_GENERAL_SUCCESS).data(fileType);
    }

    /**
     * 名称查询
     *
     * @param name
     * @return
     */
    public SuccessModel getByName(String name){
        // 验证
        SuccessModel successModel = fileTypeManageValidate.nameValidate(name);
        if(successModel != null){
            return successModel;
        }
        FileType fileType = getByParam(null, name);
        return new SuccessModel().message("名称" + GET_GENERAL_SUCCESS).data(fileType);
    }

    /**
     * 分页查询
     *
     * @param start
     * @param length
     * @param name
     * @return
     */
    public SuccessModel getByPage(Integer start, Integer length, String name){
        List<FileType> list = getPageList(start, length, name);
        int count = getPageCount(name);
        Map page = page(list, count);
        return new SuccessModel().message(GET_PAGE_SUCCESS).data(page);
    }


}
