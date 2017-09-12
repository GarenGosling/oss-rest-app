package org.garen.oss.util.upload;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * 获取上传文件的Md5
 *
 * @author Garen Gosling
 * @create 2017-09-12 23:14
 * @since v1.0
 */
public class UploadHandler {
    /**
     * 上传文件的MD5值
     *
     * @param multipartFile
     * @return
     * @throws IOException
     */
    public static String getMd5(MultipartFile multipartFile) throws IOException {
        return getInputStreamMd5(multipartFile.getInputStream());
    }

    /**
     * 输入流的MD5值
     *
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static String getInputStreamMd5(InputStream inputStream) throws IOException {
        return DigestUtils.md5Hex(inputStream);
    }

    /**
     * 上传文件的大小
     *
     * @param multipartFile
     * @return
     */
    public static long getFileSize(MultipartFile multipartFile){
        return multipartFile.getSize();
    }

    /**
     * 上传文件的原名
     *
     * @param multipartFile
     * @return
     */
    public static String getOldName(MultipartFile multipartFile){
        return multipartFile.getOriginalFilename();
    }


}
