package cn.zdxh.mtkj.dataobject.dao;


import cn.zdxh.mtkj.dataobject.mapper.PhoneMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author JJ
 * @date 2019/6/26 - 19:38
 */
@Component
public class PhoneDao {

    @Autowired
    private PhoneMapper mapper;

    public Integer insertPhone(String ph_num){
        return mapper.insertPhone(ph_num);
    }

    public Integer selectPhoneId(String ph_num){
        return mapper.selectPhoneId(ph_num);
    }

    public Integer deletePhone(String ph_num){
        return mapper.deletePhone(ph_num);
    }
}
