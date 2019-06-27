package cn.zdxh.mtkj.dataobject.dao;

import cn.zdxh.mtkj.dataobject.Person_Phone;
import cn.zdxh.mtkj.dataobject.mapper.Person_PhoneMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author JJ
 * @date 2019/6/26 - 21:31
 */
@Component
public class Person_PhoneDao {
    @Autowired
    private Person_PhoneMapper mapper;

    public Integer insertPersonPhone(Person_Phone person_phone){
        return mapper.insertPersonPhone(person_phone);
    }

    public Integer deletePersonPhoneByper_id(Integer per_id){
        return mapper.deletePersonPhoneByper_id(per_id);
    }
}
