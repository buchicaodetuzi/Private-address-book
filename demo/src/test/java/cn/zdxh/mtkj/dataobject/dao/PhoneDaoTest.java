package cn.zdxh.mtkj.dataobject.dao;

import cn.zdxh.mtkj.dataobject.Phone;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author JJ
 * @date 2019/6/26 - 19:40
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PhoneDaoTest {

    @Autowired
    PhoneDao phoneDao;

    @Test
    public void insertPhone() {
        long result = phoneDao.insertPhone("18200964181");
        System.out.println(result);
        Assert.assertNotEquals(0,result);
    }

    @Test
    public void selectPhoneId(){
        long result = phoneDao.selectPhoneId("13250401685");
        System.out.println(result);
        Assert.assertNotEquals(0,result);

    }

    @Test
    public void deletePhone(){
        long result = phoneDao.deletePhone("13669518911");
        Assert.assertNotEquals(0,result);
    }
}