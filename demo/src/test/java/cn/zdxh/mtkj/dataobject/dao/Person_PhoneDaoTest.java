package cn.zdxh.mtkj.dataobject.dao;

import cn.zdxh.mtkj.dataobject.Person_Phone;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author JJ
 * @date 2019/6/26 - 21:33
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Person_PhoneDaoTest {
    @Autowired
    Person_PhoneDao person_phoneDao;
    @Test
    public void insertPersonPhone() {
        Person_Phone person_phone = new Person_Phone();
        person_phone.setPerson_id(1);
        person_phone.setPhone_id(5);
        Integer result =  person_phoneDao.insertPersonPhone(person_phone);
        Assert.assertNotNull(result);
    }

    @Test
    public void deletePersonPhoneByper_id(){
        Integer result = person_phoneDao.deletePersonPhoneByper_id(111);
        Assert.assertNotNull(result);
    }
}