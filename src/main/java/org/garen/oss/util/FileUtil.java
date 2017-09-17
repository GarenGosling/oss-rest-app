package org.garen.oss.util;

import java.io.File;

/**
 * 文件工具类
 *
 * @author Garen Gosling
 * @create 2017-09-16 03:22
 * @since v1.0
 */
public class FileUtil {

    /**
     * 目录不存在，则创建
     * @param path
     */
    public static void mkdir(String path){
        File dir = new File(path);
        if(!dir.exists()){
            dir.mkdir();
        }
    }

    /**
     * 删除文件
     * @param file
     */
    public static void deleteFile(File file){
        if(file.exists()){
            file.delete();
        }
    }
}
