package cn.zdxh.mtkj.VO;

import lombok.Data;

/**
 * @author JJ
 * @date 2019/6/26 - 13:09
 */
@Data
public class ResultVO<T> {
    /*错误码*/
    private Integer code;

    /*提示信息*/
    private String msg;

    /*具体内容*/
    private T data;
}
