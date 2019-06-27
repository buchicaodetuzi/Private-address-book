package cn.zdxh.mtkj.service;

import cn.zdxh.mtkj.dataobject.Person;
import cn.zdxh.mtkj.dataobject.Person_Phone;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author JJ
 * @date 2019/6/26 - 11:16
 */

public interface PersonService {
    /*根据personId查询到个人信息*/
    Person findPersonById(Integer personId);

    /*根据姓名查询到个人信息*/
    Person findPersonByName(String personName);

    /*查询所以联系人信息列表*/
    List<Person> findAll();

    /*插入联系人信息*/
    Integer insertPerson(Person person);

    /*更新联系人信息*/
    Integer updatePerson(Person person);

    /*删除联系人*/
    Integer deletePerson(Person person);
}
