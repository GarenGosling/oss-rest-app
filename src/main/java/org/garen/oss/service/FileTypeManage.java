package org.garen.oss.service;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.garen.oss.cache.FileTypesCache;
import org.garen.oss.mybatis.domain.FileType;
import org.garen.oss.mybatis.domain.FileTypeExample;
import org.garen.oss.mybatis.service.FileTypeService;
import org.garen.oss.util.EsapiUtil;
import org.garen.oss.util.TransferUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    FileTypesCache fileTypesCache;

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
     * @param fileTypeParam
     * @return
     */
    @Transactional
    public int saveFileType(org.garen.oss.swagger.model.FileType fileTypeParam){
        // 类型转换
        FileType fileType = transfer(fileTypeParam);
        // 处理业务
        fileType.setOperatorCode("0");
        fileType.setOperatorName("系统");
        fileType.setCreateTime(new Date());
        int i = create(fileType);
        // 新增缓存
        if(i == 1) fileTypesCache.saveOrUpdate(fileType);
        return i;
    }

    /**
     * 修改
     *
     * @param fileTypeParam
     * @return
     */
    @Transactional
    public int updateFileType(org.garen.oss.swagger.model.FileType fileTypeParam){
        // 类型转换
        FileType fileType = transfer(fileTypeParam);
        // 处理业务
        fileType.setOperatorCode("0");
        fileType.setOperatorName("系统");
        int i = modify(fileType);
        // 修改缓存
        if(i == 1) fileTypesCache.saveOrUpdate(fileType);
        return i;
    }

    @Transactional
    public int deleteFileType(Long id){
        FileType fileType = findById(id);
        if(fileType == null){
            return 0;
        }
        int i = removeById(id);
        if(i == 1){
            fileTypesCache.delete(fileType);
        }
        return i;
    }
    /**
     * 编码查询
     *
     * @param code
     * @return
     */
    public FileType getByCode(String code){
        return getByParam(code, null);
    }

    /**
     * 名称查询
     *
     * @param name
     * @return
     */
    public FileType getByName(String name){
        return getByParam(null, name);
    }

    /**
     * 分页查询
     *
     * @param start
     * @param length
     * @param name
     * @return
     */
    public Map getByPage(Integer start, Integer length, String name){
        List<FileType> list = getPageList(start, length, name);
        int count = getPageCount(name);
        Map page = page(list, count);
        return page(list, count);
    }

}
