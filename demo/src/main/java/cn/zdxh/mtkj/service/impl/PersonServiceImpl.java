package cn.zdxh.mtkj.service.impl;

import cn.zdxh.mtkj.dataobject.Person;
import cn.zdxh.mtkj.dataobject.Person_Phone;
import cn.zdxh.mtkj.dataobject.dao.PersonDao;
import cn.zdxh.mtkj.dataobject.dao.Person_PhoneDao;
import cn.zdxh.mtkj.dataobject.dao.PhoneDao;
import cn.zdxh.mtkj.enums.ResultEnum;
import cn.zdxh.mtkj.exceptions.DemoException;
import cn.zdxh.mtkj.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JJ
 * @date 2019/6/26 - 11:43
 */
@Service
@Slf4j
@Transactional
public class PersonServiceImpl implements PersonService {


    @Autowired
    private PersonDao personDao;

    @Autowired
    private PhoneDao phoneDao;

    @Autowired
    private Person_PhoneDao person_phoneDao;

    @Override
    public Person findPersonById(Integer personId) {
        //判断personId是否为空
        if(personId == null){
            log.error("【查询联系人】参数不正确，personId="+personId);
            throw new DemoException(ResultEnum.PARAM_ERROR);
        }
        //根据personId查询到用户
        Person result = personDao.selectPersonById(personId);
        if(result ==null){
            log.error("【查询联系人】查不到该联系人，personId="+personId);
            throw new DemoException(ResultEnum.PERSON_NOT_EXIST);
        }
        //根据用户id查询到电话列表
        List<String> phoneList = personDao.selectPhoneListByPersonId(personId);
        //将phoneList加入到person对象
        result.setPhoneList(phoneList);
        //返回结果person对象
        return result;
    }

    @Override
    public Person findPersonByName(String personName) {
        //判断personName是否为空
        if(personName == null){
            log.error("【查询联系人】参数不正确，personName="+personName);
            throw new DemoException(ResultEnum.PARAM_ERROR);
        }
        //根据personName查询用户
        Person result = personDao.selectPersonByPersonName(personName);
        if(result ==null){
            log.error("【查询联系人】查不到该联系人，personName="+personName);
            throw new DemoException(ResultEnum.PERSON_NOT_EXIST);
        }
        //根据用户id查询电话列表
        List<String> phoneList = personDao.selectPhoneListByPersonId(result.getPer_id());
        //将phoneList加入到person对象
        result.setPhoneList(phoneList);
        //返回结果person对象
        return result;
    }

    @Override
    public List<Person> findAll() {
        //查找到所以联系人
        List<Person> personList = personDao.selectAll();
        for (Person person:personList) {
            //根据联系人id查找到对应的电话列表
            List<String> phoneList = personDao.selectPhoneListByPersonId(person.getPer_id());
            //将电话列表添加到对象电话列表集合
            person.setPhoneList(phoneList);
        }
        return personList;
    }

    @Override
    public Integer insertPerson(Person person) {
        //判斷名字是否为空
        if(person.getPer_name().isEmpty()){
            log.error("【添加联系人】姓名为空！");
            throw  new DemoException(ResultEnum.PARAM_ERROR);
        }
        //不为空则将联系人插入数据库
        personDao.insertPerson(person);
        //如果没有电话列表
        if(person.getPhoneList().isEmpty()){
            return ResultEnum.INSERT_SUCCESS.getCode();
        }
        //如果有电话列表
        //获取到联系人personId
        Person person1 = personDao.selectPersonByPersonName(person.getPer_name());
        Integer personId = person1.getPer_id();
        //遍历电话列表
        List<String> phoneList = person.getPhoneList();
        for (String phoneNum:phoneList) {
            //将电话插入phone库，获取到phoneId
            phoneDao.insertPhone(phoneNum);
            Integer phoneId = phoneDao.selectPhoneId(phoneNum);
            //将personId和phoneId插入到关联表person_phone
            Person_Phone person_phone = new Person_Phone();
            person_phone.setPerson_id(personId);
            person_phone.setPhone_id(phoneId);
            person_phoneDao.insertPersonPhone(person_phone);
        }
        return ResultEnum.INSERT_SUCCESS.getCode();
    }

    @Override
    public Integer updatePerson(Person person) {
        //判断personId和personName是否为空
        if(person.getPer_id() == null || person.getPer_name() == null){
            log.error("【更新联系人】名字或者personId为空，personId="+person.getPer_id()+"personName="+person.getPer_name());
            throw new DemoException(ResultEnum.PARAM_ERROR);
        }
        //根据personId判断数据库是否有对应联系人
        Person person1 = personDao.selectPersonById(person.getPer_id());
        //没有则输出日志，抛异常
        if(person1 == null){
            log.error("【更新联系人】数据库没有该联系人信息，personId="+person.getPer_id()+"personName="+person.getPer_name());
        }
        //有则更新联系人信息
        personDao.updatePerson(person);
        //判断person中phoneList是否为空
        if(person.getPhoneList() == null){
            //为空则删除person_phone表中personId为person.Id
            person_phoneDao.deletePersonPhoneByper_id(person.getPer_id());
            return ResultEnum.UPDATE_SUCCESS.getCode();
        }
        person_phoneDao.deletePersonPhoneByper_id(person.getPer_id());
        //不为空则遍历phoneList，将电话插入phone表，并查询到phoneId，将phoneId和personId插入到person_phone表中
        for (String phone:person.getPhoneList()) {
            phoneDao.insertPhone(phone);
            Integer id = phoneDao.selectPhoneId(phone);
            Person_Phone person_phone = new Person_Phone();
            person_phone.setPerson_id(person.getPer_id());
            person_phone.setPhone_id(id);
            person_phoneDao.insertPersonPhone(person_phone);
        }
        return ResultEnum.UPDATE_SUCCESS.getCode();
    }

    @Override
    public Integer deletePerson(Person person) {
        //判断personId是否为空
        if(person ==null){
            //空则输出日志，抛异常
            log.error("【删除联系人】参数不正确 personId="+person.getPer_id());
            throw new DemoException(ResultEnum.PARAM_ERROR);
        }
        //判断personId是否存在于数据库
        Person person1 = personDao.selectPersonById(person.getPer_id());
        if(person1 == null){
            //不存在则输出日志，抛异常
            log.error("【删除联系人】数据库无该联系人，personId="+person.getPer_id());
            throw new DemoException(ResultEnum.PERSON_NOT_EXIST);
        }

        //根据personId查询其电话列表
        List<String> phoneList = personDao.selectPhoneListByPersonId(person.getPer_id());
        //非空则遍历删除其电话列表
        if(phoneList.size()>0){
            for (String phone:phoneList) {
                phoneDao.deletePhone(phone);
            }
        }
        //再根据personId删除person_phone表数据
        person_phoneDao.deletePersonPhoneByper_id(person.getPer_id());
        //再根据personId删除person表数据
        personDao.deletePersonByper_id(person.getPer_id());
        return ResultEnum.DELETE_SUCCESS.getCode();
    }


}
