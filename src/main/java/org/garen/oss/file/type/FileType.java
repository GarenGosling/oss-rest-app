package org.garen.oss.file.type;

/**
 * 类型枚举
 *
 * @author Garen Gosling
 * @create 2017-09-13 00:26
 * @since v1.0
 */
public enum FileType {
    /**
     * JEPG.
     */
    JPEG("jpg", "FFD8FF"),

    /**
     * PNG.
     */
    PNG("png", "89504E47"),

    /**
     * GIF.
     */
    GIF("gif", "47494638"),

    /**
     * TIFF.
     */
    TIFF("tiff", "49492A00"),

    /**
     * Windows Bitmap.
     */
    BMP("bmp", "424D"),

    /**
     * CAD.
     */
    DWG("cad", "41433130"),

    /**
     * Adobe Photoshop.
     */
    PSD("psd", "38425053"),

    /**
     * Rich Text Format.
     */
    RTF("rtf", "7B5C727466"),

    /**
     * XML.
     */
    XML("xml", "3C3F786D6C"),

    /**
     * HTML.
     */
    HTML("html", "68746D6C3E"),
    /**
     * CSS.
     */
    CSS("css", "48544D4C207B0D0A0942"),
    /**
     * JS.
     */
    JS("js", "696B2E71623D696B2E71"),
    /**
     * Email [thorough only].
     */
    EML("email", "44656C69766572792D646174653A"),

    /**
     * Outlook Express.
     */
    DBX("dbx", "CFAD12FEC5FD746F"),

    /**
     * Outlook (pst).
     */
    PST("pst", "2142444E"),

    /**
     * MS Word/Excel.
     */
    XLS_DOC("xls_doc", "D0CF11E0"),
    XLSX_DOCX("xlsx_docx", "504B030414000600080000002100"),
    /**
     * Visio
     */
    VSD("vsd", "d0cf11e0a1b11ae10000"),
    /**
     * MS Access.
     */
    MDB("mdb", "5374616E64617264204A"),
    /**
     * WPS文字wps、表格et、演示dps都是一样的
     */
    WPS("wps", "d0cf11e0a1b11ae10000"),
    /**
     * torrent
     */
    TORRENT("torrent", "6431303A637265617465"),
    /**
     * WordPerfect.
     */
    WPD("wpd", "FF575043"),

    /**
     * Postscript.
     */
    EPS("eps", "252150532D41646F6265"),

    /**
     * Adobe Acrobat.
     */
    PDF("pdf", "255044462D312E"),

    /**
     * Quicken.
     */
    QDF("qdf", "AC9EBD8F"),

    /**
     * Windows Password.
     */
    PWL("pwl", "E3828596"),

    /**
     * ZIP Archive.
     */
    ZIP("zip", "504B0304"),

    /**
     * RAR Archive.
     */
    RAR("rar", "52617221"),
    /**
     * JSP Archive.
     */
    JSP("jsp", "3C2540207061676520"),
    /**
     * JAVA Archive.
     */
    JAVA("java", "7061636B61676520"),
    /**
     * CLASS Archive.
     */
    CLASS("class", "CAFEBABE0000002E00"),
    /**
     * JAR Archive.
     */
    JAR("jar", "504B03040A000000"),
    /**
     * MF Archive.
     */
    MF("mf", "4D616E69666573742D56"),
    /**
     *EXE Archive.
     */
    EXE("exe", "4D5A9000030000000400"),
    /**
     *CHM Archive.
     */
    CHM("chm", "49545346030000006000"),
    INI("ini", "235468697320636F6E66"),
    SQL("sql", "494E5345525420494E54"),
    BAT("bat", "406563686F206f66660D"),
    GZ("gz", "1F8B0800000000000000"),
    PROPERTIES("properties", "6C6F67346A2E726F6F74"),
    MXP("mxp", "04000000010000001300"),
    /**
     * Wave.
     */
    WAV("wav", "57415645"),

    /**
     * AVI.
     */
    AVI("avi", "41564920"),

    /**
     * Real Audio.
     */
    RAM("ram", "2E7261FD"),

    /**
     * Real Media.
     */
    RM("rm", "2E524D46"),

    /**
     * MPEG (mpg).
     */
    MPG("mpg", "000001BA"),

    /**
     * Quicktime.
     */
    MOV("mov", "6D6F6F76"),

    /**
     * Windows Media.
     */
    ASF("asf", "3026B2758E66CF11"),

    /**
     * MIDI.
     */
    MID("mid", "4D546864"),
    /**
     * MP4.
     */
    MP4("mp4", "00000020667479706d70"),
    /**
     * MP3.
     */
    MP3("mp3", "49443303000000002176"),
    /**
     * FLV.
     */
    FLV("flv", "464C5601050000000900");

    private String key;
    private String value;

    private FileType(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey(){
        return key;
    }

    public String getValue(){
        return value;
    }

    private static boolean validateKey(String key){
        if(key == null || "".equals(key)){
            return false;
        }
        return true;
    }

    public static String getValueByKey(String key) {
        if(validateKey(key)){
            return getFileTypeByKey(key).getValue();
        }
        return null;
    }

    public static FileType getFileTypeByKey(String key){
        if(validateKey(key)){
            for (FileType fileType : FileType.values()) {
                if (fileType.getKey().equals(key)) {
                    return fileType;
                }
            }
        }
        return null;
    }

}
