package cn.zdxh.mtkj.enums;

import lombok.Getter;

/**
 * @author JJ
 * @date 2019/6/26 - 13:15
 */
@Getter
public enum ResultEnum {
    INSERT_SUCCESS(0,"插入成功"),
    PARAM_ERROR(1,"参数不正确"),
    PERSON_NOT_EXIST(2,"查不到该联系人"),
    UPDATE_SUCCESS(3,"更新成功"),
    UPDATE_FAIL(4,"更新失败"),
    DELETE_SUCCESS(5,"删除成功"),
    Delete_FAIL(6,"删除失败"),
    INSERT_FAIL(7,"插入失败")
    ;


    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
