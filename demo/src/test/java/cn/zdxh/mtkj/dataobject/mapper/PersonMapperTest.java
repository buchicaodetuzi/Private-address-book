package cn.zdxh.mtkj.dataobject.mapper;

import cn.zdxh.mtkj.dataobject.Person;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;

import static org.junit.Assert.*;

/**
 * @author JJ
 * @date 2019/6/26 - 9:47
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonMapperTest {

    @Autowired
    private PersonMapper mapper;

    @Test
    public void selectPersonById() {
        Person person = mapper.selectPersonById(1);
        System.out.println(person.toString());
        Assert.assertNotNull(person);
    }

    @Test
    public void selectPhoneListByPersonId(){
        List<String> phoneList = mapper.selectPhoneListByPersonId(1);
        System.out.println(phoneList.get(0));
        System.out.println(phoneList.get(1));
        Assert.assertNotEquals(0,phoneList.size());
    }

    @Test
    public void selectPersonByPersonName(){
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

    }
}