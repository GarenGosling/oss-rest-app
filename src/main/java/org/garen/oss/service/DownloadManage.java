package org.garen.oss.service;

import org.garen.oss.cache.FileTypesCache;
import org.garen.oss.mybatis.domain.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * 下载业务类
 *
 * @author Garen Gosling
 * @create 2017-09-16 17:24
 * @since v1.0
 */
@Service
public class DownloadManage {
    @Autowired
    FileInfoManage fileInfoManage;
    @Autowired
    FileTypesCache fileTypesCache;
    @Autowired
    UploadManage uploadManage;

    /**
     * 远程下载
     *
     * @param md5
     * @param response
     */
    public void downloadRemote(String md5, HttpServletResponse response){


    }

    /**
     * 本地下载
     *
     * @param md5
     * @param response
     */
    public void downloadLocal(String md5, HttpServletResponse response) {
        try {
            FileInfo fileInfo = null;
            boolean isThumbnail = false;
            int fileSize = 0;
            if(md5.indexOf("THUMBNAIL") > -1){
                isThumbnail = true;
                fileInfo = fileInfoManage.getByMinMd5(md5);
                fileSize = Integer.parseInt(fileInfo.getMinPreview());
            }else {
                fileInfo = fileInfoManage.getByMd5(md5);
                fileSize = Integer.parseInt(fileInfo.getSize()+"");
            }

            String fileName = fileInfo.getName();
            String cacheFileFullName = uploadManage.getCacheFileFullName(fileInfo.getCategory(), fileInfo.getMd5(), fileInfo.getType());
            String cacheFileThumbnailFullName = uploadManage.getCacheFileThumbnailFullName(fileInfo.getCategory(), fileInfo.getMd5(), fileInfo.getType());
            // 以流的形式下载文件。
            String path = isThumbnail?cacheFileThumbnailFullName:cacheFileFullName;
            InputStream fis = new BufferedInputStream(new FileInputStream(path));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
                fis.close();
            // 清空response
            response.reset();
            // 设置response的Header
            response.setHeader("Content-type", "text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes(), "ISO-8859-1"));
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            response.setContentLength(fileSize);
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
