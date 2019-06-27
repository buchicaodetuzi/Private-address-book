package cn.zdxh.mtkj.dataobject.mapper;

import cn.zdxh.mtkj.dataobject.Person;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

/**
 * @author JJ
 * @date 2019/6/26 - 9:18
 */
public interface PersonMapper {
    /*根据personId查询个人信息（不包含手机号列表）*/
    Person selectPersonById(Integer personId);

    /*根据personId查询手机号列表*/
    List<String> selectPhoneListByPersonId(Integer personId);

    /*根据personName查询到个人信息（不包含手机号列表）*/
    Person selectPersonByPersonName(String personName);

    /*查询所以联系下信息列表*/
    List<Person> selectAll();

    /*插入一条person数据（电话列表不插入）*/
    Integer insertPerson(Person person);

    /*修改联系人信息（不包含电话列表）*/
    Integer updatePerson(Person person);

    /*根据per_id删除联系人信息*/
    Integer deletePersonByper_id(Integer per_id);

}
