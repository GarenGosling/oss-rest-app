package org.garen.oss.service.validate;

import org.apache.commons.lang.StringUtils;
import org.garen.oss.swagger.model.SuccessModel;
import org.springframework.http.HttpStatus;

/**
 * 验证父类
 *
 * @author Garen Gosling
 * @create 2017-09-14 21:00
 * @since v1.0
 */
public class BaseValidate {

    /**
     * 验证失败的响应
     * @return
     */
    public SuccessModel validateFailResponse(){
        return validateFailResponse(null);
    }

    /**
     * 验证失败的响应
     *
     * @param paramText
     * @return
     */
    public SuccessModel validateFailResponse(String paramText){
        if(StringUtils.isBlank(paramText)){
            paramText = DEFAULT_PARAM_TEXT;
        }
        SuccessModel successModel = newSuccessModel();
        successModel.setMessage(emptyMsg(paramText));
        return successModel;
    }

    /**
     * 字符串：参数
     */
    private final String DEFAULT_PARAM_TEXT = "参数";

    /**
     * 字符串：不能为空
     */
    private final String NOT_EMPTY = "不能为空";

    /**
     * 获取SuccessModel对象
     * @return
     */
    private SuccessModel newSuccessModel(){
        SuccessModel successModel = new SuccessModel();
        successModel.setCode(HttpStatus.BAD_REQUEST.value());
        return successModel;
    }

    /**
     * 不能为空的提示信息拼串
     *
     * @param str
     * @return
     */
    private String emptyMsg(String str){
        return str + NOT_EMPTY;
    }
}
