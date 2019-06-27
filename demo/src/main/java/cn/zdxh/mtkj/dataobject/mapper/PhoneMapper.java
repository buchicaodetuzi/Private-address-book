package cn.zdxh.mtkj.dataobject.mapper;

import cn.zdxh.mtkj.dataobject.Person;
import cn.zdxh.mtkj.dataobject.Phone;

import java.util.List;

/**
 * @author JJ
 * @date 2019/6/26 - 19:28
 */
public interface PhoneMapper {

    /*将电话列表插入数据库*/
    Integer insertPhone(String ph_num);

    /*根据电话查询到ph_id*/
    Integer selectPhoneId(String ph_num);

    /*根据电话号删除phone数据*/
    Integer deletePhone(String ph_num);
}
