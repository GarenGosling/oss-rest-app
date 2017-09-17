package org.garen.oss.service;


import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.garen.oss.mybatis.domain.FileInfo;
import org.garen.oss.mybatis.domain.FileInfoExample;
import org.garen.oss.mybatis.service.FileInfoService;
import org.garen.oss.util.EsapiUtil;
import org.garen.oss.util.TransferUtil;
import org.garen.oss.util.date.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 文件信息业务类
 *
 * @author Garen Gosling
 * @create 2017-09-15 13:17
 * @since v1.0
 */
@Service
public class FileInfoManage extends BaseManage<Long>{
    @Autowired
    FileInfoService<FileInfo, FileInfoExample, Long> service;

    @Override
    public FileInfoService<FileInfo, FileInfoExample, Long> getService() {
        return service;
    }

    /**
     * 类型转换
     *
     * @param fileInfo
     * @return
     */
    private FileInfo transfer(org.garen.oss.swagger.model.FileInfo fileInfo){
        FileInfo dest = new FileInfo();
        TransferUtil.transfer(dest, fileInfo);
        return dest;
    }

    /**
     * 根据md5/minMd5查询
     *
     * @param md5
     * @param minMd5
     * @return
     */
    private FileInfo getByParam(String md5, String minMd5){
        FileInfoExample example = new FileInfoExample();
        FileInfoExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank(md5)){
            criteria.andMd5EqualTo(EsapiUtil.sql(md5));
        }
        if(StringUtils.isNotBlank(minMd5)){
            criteria.andMinMd5EqualTo(EsapiUtil.sql(minMd5));
        }
        List<FileInfo> fileInfos = getService().findBy(example);
        FileInfo fileInfo = null;
        if(fileInfos.size() >= 1){
            fileInfo = fileInfos.get(0);
        }
        return fileInfo;
    }

    /**
     * 分页查询之列表
     *
     * @param start
     * @param length
     * @param name
     * @param type
     * @param category
     * @param sizeBegin
     * @param sizeEnd
     * @param md5
     * @param minMd5
     * @param createTimeBegin
     * @param createTimeEnd
     * @return
     */
    private List<FileInfo> getPageList(Integer start,
                                       Integer length,
                                       String name,
                                       String type,
                                       String category,
                                       Long sizeBegin,
                                       Long sizeEnd,
                                       String md5,
                                       String minMd5,
                                       String createTimeBegin,
                                       String createTimeEnd){
        if(start == null) start = START;
        if(length == null) length = LENGTH;
        FileInfoExample example = new FileInfoExample();
        FileInfoExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank(name)){
            criteria.andNameLike("%" + EsapiUtil.sql(name) + "%");
        }
        if(StringUtils.isNotBlank(type)){
            criteria.andTypeEqualTo(EsapiUtil.sql(type));
        }
        if(StringUtils.isNotBlank(category)){
            criteria.andCategoryEqualTo(EsapiUtil.sql(category));
        }
        if(sizeBegin != null){
            criteria.andSizeGreaterThanOrEqualTo(sizeBegin);
        }
        if(sizeEnd != null){
            criteria.andSizeLessThanOrEqualTo(sizeEnd);
        }
        if(StringUtils.isNotBlank(md5)){
            criteria.andMd5EqualTo(EsapiUtil.sql(md5));
        }
        if(StringUtils.isNotBlank(minMd5)){
            criteria.andMinMd5EqualTo(EsapiUtil.sql(minMd5));
        }
        try {
            if(StringUtils.isNotBlank(createTimeBegin)){
                criteria.andCreateTimeGreaterThanOrEqualTo(DateUtil.parseTimeMin(createTimeBegin));
            }
            if(StringUtils.isNotBlank(createTimeEnd)){
                criteria.andCreateTimeLessThanOrEqualTo(DateUtil.parseTimeMax(createTimeEnd));
            }
        } catch (ParseException e) {
            e.printStackTrace();
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
    private int getPageCount(String name,
                             String type,
                             String category,
                             Long sizeBegin,
                             Long sizeEnd,
                             String md5,
                             String minMd5,
                             String createTimeBegin,
                             String createTimeEnd){
        String sql = "select count(*) count from file_info where 1=1 ";
        if(StringUtils.isNotBlank(name)){
            sql += " AND name like '%"+ EsapiUtil.sql(name) +"%'";
        }
        if(StringUtils.isNotBlank(type)){
            sql += " AND type = '"+ EsapiUtil.sql(type) +"'";
        }
        if(StringUtils.isNotBlank(category)){
            sql += " AND category = '"+ EsapiUtil.sql(category) +"'";
        }
        if(sizeBegin != null){
            sql += " AND size >= '"+ EsapiUtil.sql(sizeBegin.toString()) +"'";
        }
        if(sizeEnd != null){
            sql += " AND size <= '"+ EsapiUtil.sql(sizeEnd.toString()) +"'";
        }
        if(StringUtils.isNotBlank(md5)){
            sql += " AND md5 = '"+ EsapiUtil.sql(md5) +"'";
        }
        if(StringUtils.isNotBlank(minMd5)){
            sql += " AND min_md5 = '"+ EsapiUtil.sql(minMd5) +"'";
        }
        try {
            if(StringUtils.isNotBlank(createTimeBegin)){
                sql += " AND create_time >= '"+ DateUtil.parseTimeMinString(createTimeBegin) +"'";
            }
            if(StringUtils.isNotBlank(createTimeEnd)){
                sql += " AND create_time <= '"+ DateUtil.parseTimeMaxString(createTimeEnd) +"'";
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return getService().countBySQL(sql);
    }

    /**
     * 新增
     *
     * @param fileInfo
     * @return
     */
    public int saveFileInfo(org.garen.oss.swagger.model.FileInfo fileInfo){
        // 类型转换
        FileInfo dest = transfer(fileInfo);
        // 处理业务
        dest.setOperatorCode("0");
        dest.setOperatorName("系统");
        dest.setCreateTime(new Date());
        return create(dest);
    }

    /**
     * 新增
     *
     * @param fileInfoParam
     * @return
     */
    public FileInfo saveFileInfo2(org.garen.oss.swagger.model.FileInfo fileInfoParam){
        if(fileInfoParam == null){
            return null;
        }
        int i = saveFileInfo(fileInfoParam);
        if(i == 1){
            FileInfo fileInfo = getByMd5(fileInfoParam.getMd5());
            return fileInfo;
        }
        return null;
    }

    /**
     * 修改
     *
     * @param fileInfo
     * @return
     */
    public int updateFileInfo(org.garen.oss.swagger.model.FileInfo fileInfo){
        // 类型转换
        FileInfo dest = transfer(fileInfo);
        // 处理业务
        dest.setOperatorCode("0");
        dest.setOperatorName("系统");
        return modify(dest);
    }


    /**
     * 编码查询
     *
     * @param md5
     * @return
     */
    public FileInfo getByMd5(String md5){
        return getByParam(md5, null);
    }

    /**
     * 编码查询
     *
     * @param minMd5
     * @return
     */
    public FileInfo getByMinMd5(String minMd5){
        return getByParam(null, minMd5);
    }

    /**
     * 分页查询
     *
     * @param start
     * @param length
     * @param name
     * @return
     */
    public Map getByPage(Integer start,
                                  Integer length,
                                  String name,
                                  String type,
                                  String category,
                                  Long sizeBegin,
                                  Long sizeEnd,
                                  String md5,
                                  String minMd5,
                                  String createTimeBegin,
                                  String createTimeEnd){
        List<FileInfo> list = getPageList(start, length, name, type, category, sizeBegin, sizeEnd, md5, minMd5, createTimeBegin, createTimeEnd);
        int count = getPageCount(name, type, category, sizeBegin, sizeEnd, md5, minMd5, createTimeBegin, createTimeEnd);
        return page(list, count);
    }

}
