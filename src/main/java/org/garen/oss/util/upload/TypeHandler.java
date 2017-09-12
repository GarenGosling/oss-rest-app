package org.garen.oss.util.upload;

import org.garen.oss.file.type.FileType;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 类型帮助类
 *
 * @author Garen Gosling
 * @create 2017-09-13 00:04
 * @since v1.0
 */
public class TypeHandler {







    public static Integer isFileType(FileType value) {
        Integer type = 7;// 其他
        // 图片
        FileType[] pics = { FileType.JPEG, FileType.PNG, FileType.GIF, FileType.TIFF, FileType.BMP, FileType.DWG, FileType.PSD };

        FileType[] docs = { FileType.RTF, FileType.XML, FileType.HTML, FileType.CSS, FileType.JS, FileType.EML, FileType.DBX, FileType.PST, FileType.XLS_DOC, FileType.XLSX_DOCX, FileType.VSD,
                FileType.MDB, FileType.WPS, FileType.WPD, FileType.EPS, FileType.PDF, FileType.QDF, FileType.PWL, FileType.ZIP, FileType.RAR, FileType.JSP, FileType.JAVA, FileType.CLASS,
                FileType.JAR, FileType.MF, FileType.EXE, FileType.CHM };

        FileType[] videos = { FileType.AVI, FileType.RAM, FileType.RM, FileType.MPG, FileType.MOV, FileType.ASF, FileType.MP4, FileType.FLV, FileType.MID };

        FileType[] tottents = { FileType.TORRENT };

        FileType[] audios = { FileType.WAV, FileType.MP3 };

        FileType[] others = {};

        // 图片
        for (FileType fileType : pics) {
            if (fileType.equals(value)) {
                type = 1;
            }
        }
        // 文档
        for (FileType fileType : docs) {
            if (fileType.equals(value)) {
                type = 2;
            }
        }
        // 视频
        for (FileType fileType : videos) {
            if (fileType.equals(value)) {
                type = 3;
            }
        }
        // 种子
        for (FileType fileType : tottents) {
            if (fileType.equals(value)) {
                type = 4;
            }
        }
        // 音乐
        for (FileType fileType : audios) {
            if (fileType.equals(value)) {
                type = 5;
            }
        }
        return type;
    }

    public static void main(String args[]) throws Exception {
        // System.out.println(FileTypeJudge.getType(new FileInputStream("")));
        for (FileType type : FileType.values()) {
            System.out.print(type + "\t");
        }
    }
}
