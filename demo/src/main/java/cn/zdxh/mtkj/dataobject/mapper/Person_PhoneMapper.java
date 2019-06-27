package cn.zdxh.mtkj.dataobject.mapper;

import cn.zdxh.mtkj.dataobject.Person_Phone;

/**
 * @author JJ
 * @date 2019/6/26 - 21:13
 */
public interface Person_PhoneMapper {
    /*将插入一个person_phone对象*/
    Integer insertPersonPhone(Person_Phone person_phone);

    /*删除person_id为per_id的数据*/
    Integer deletePersonPhoneByper_id(Integer per_id);
}
