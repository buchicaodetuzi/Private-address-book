package cn.zdxh.mtkj.dataobject.dao;

import cn.zdxh.mtkj.dataobject.Person;
import cn.zdxh.mtkj.dataobject.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author JJ
 * @date 2019/6/26 - 11:10
 */
@Component
public class PersonDao {
    @Autowired
    private PersonMapper mapper;

    public Person selectPersonById(Integer personId){
        return mapper.selectPersonById(personId);
    }

    public List<String> selectPhoneListByPersonId(Integer personId){
        return mapper.selectPhoneListByPersonId(personId);
    }

    public Person selectPersonByPersonName(String personName){
        return mapper.selectPersonByPersonName(personName);
    }

    public List<Person> selectAll(){
        return mapper.selectAll();
    }

    public Integer insertPerson(Person person){
        return mapper.insertPerson(person);
    }

    public Integer updatePerson(Person person){
        return mapper.updatePerson(person);
    }

    public Integer deletePersonByper_id(Integer per_id){
        return mapper.deletePersonByper_id(per_id);
    }
}
