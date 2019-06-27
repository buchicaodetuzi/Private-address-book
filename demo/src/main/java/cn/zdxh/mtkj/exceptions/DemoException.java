package cn.zdxh.mtkj.exceptions;

import cn.zdxh.mtkj.enums.ResultEnum;

/**
 * @author JJ
 * @date 2019/6/26 - 13:25
 */
public class DemoException extends RuntimeException {
    private Integer code;

    public DemoException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code=resultEnum.getCode();
    }

    public DemoException(Integer code,String message){
        super(message);
        this.code=code;
    }
}
