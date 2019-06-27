package cn.zdxh.mtkj.dataobject.dao;

import cn.zdxh.mtkj.dataobject.Person;
import cn.zdxh.mtkj.dataobject.mapper.PersonMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author JJ
 * @date 2019/6/26 - 16:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonDaoTest {

    @Autowired
    private PersonMapper mapper;

    @Test
    public void selectPersonById() {
        Person person = mapper.selectPersonById(1);
        System.out.println(person.toString());
        Assert.assertNotNull(person);
    }

    @Test
    public void selectPhoneListByPersonId() {
        List<String> phoneList = mapper.selectPhoneListByPersonId(1);
        System.out.println(phoneList.get(0));
        System.out.println(phoneList.get(1));
        Assert.assertNotEquals(0,phoneList.size());
    }

    @Test
    public void selectPersonByPersonName() {
        Person person = mapper.selectPersonByPersonName("冰冰");
        System.out.println(person.toString());
        Assert.assertNotNull(person);
    }

    @Test
    public void selectAll() {
        List<Person> personList = mapper.selectAll();
        Assert.assertNotEquals(0,personList.size());
    }

    @Test
    public void insertPerson(){
        Person person = new Person();
        person.setPer_name("锦荣");
        person.setPer_email("12345678@qq.com");
        person.setPer_sex("男");
        person.setPer_address("广东惠州");
        long result = mapper.insertPerson(person);
        System.out.println(result);
        Assert.assertNotEquals(0,result);
    }

    @Test
    public void updatePerson(){
        Person person = new Person();
        person.setPer_id(1);
        person.setPer_name("杨杨");
        person.setPer_sex("女");
        person.setPer_email("96330909@qq.com");
        person.setPer_address("1011宿舍");
        long result = mapper.updatePerson(person);
        Assert.assertNotEquals(0,result);
    }

    @Test
    public void deletePersonByper_id(){
        long result = mapper.deletePersonByper_id(69);
        Assert.assertNotEquals(0,result);
    }
}