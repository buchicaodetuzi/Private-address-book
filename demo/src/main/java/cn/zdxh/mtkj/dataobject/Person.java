package cn.zdxh.mtkj.dataobject;

import lombok.Data;

import java.util.List;


/**
 * @author JJ
 * @date 2019/6/26 - 9:08
 */
@Data
public class Person {

    /*编号*/
    private Integer per_id;

    /*姓名*/
    private String per_name;

    /*性别*/
    private String per_sex;

    /*邮箱*/
    private String per_email;

    /*地址*/
    private String per_address;

    /*手机号列表*/
    private List<String> phoneList;

}
