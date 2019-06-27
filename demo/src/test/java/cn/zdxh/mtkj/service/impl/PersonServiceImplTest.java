package cn.zdxh.mtkj.service.impl;

import cn.zdxh.mtkj.dataobject.Person;
import cn.zdxh.mtkj.dataobject.dao.PersonDao;
import cn.zdxh.mtkj.dataobject.mapper.PersonMapper;
import cn.zdxh.mtkj.enums.ResultEnum;
import cn.zdxh.mtkj.service.PersonService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author JJ
 * @date 2019/6/26 - 11:52
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonServiceImplTest {

    @Autowired
    private PersonServiceImpl personService;

    @Test
    public void findPersonById() {
        Person person = personService.findPersonById(59);
        System.out.println(person.toString());
        Assert.assertNotNull(person);
    }

    @Test
    public void findPersonByName() {
        Person person = personService.findPersonByName("聚威");
        System.out.println(person.toString());
        Assert.assertNotNull(person);
    }

    @Test
    public void findAll(){
        List<Person> personList = personService.findAll();
        Assert.assertNotEquals(0,personList.size());
    }

    @Test
    public void insertPerson(){
        Person person = new Person();
        person.setPer_name("聚威");
        person.setPer_sex("男");
        person.setPer_email("11223344@qq.com");
        person.setPer_address("广州白云区");
        List<String> phoneList = new ArrayList<String>();
        phoneList.add("13669518911");
        phoneList.add("15917769069");
        person.setPhoneList(phoneList);
        long result = personService.insertPerson(person);
        Assert.assertEquals(0,result);
    }

    @Test
    public void updatePerson(){
        Person person = new Person();
        person.setPer_id(59);
        person.setPer_name("聚威");
        person.setPer_sex("男");
        person.setPer_email("11223344@qq.com");
        person.setPer_address("广州白云区");
//        List<String> phoneList = new ArrayList<String>();
//        phoneList.add("13669518888");
//        phoneList.add("15917718888");
//        person.setPhoneList(phoneList);
        Integer result = personService.updatePerson(person);
        Assert.assertNotNull(result);
    }

    @Test
    public void deletePerson(){
        Person person = new Person();
        person.setPer_id(75);
        long result = personService.deletePerson(person);
        Assert.assertNotEquals(0,result);
    }
}