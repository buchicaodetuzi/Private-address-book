package cn.zdxh.mtkj.controller;

import cn.zdxh.mtkj.VO.ResultVO;
import cn.zdxh.mtkj.dataobject.Person;
import cn.zdxh.mtkj.enums.ResultEnum;
import cn.zdxh.mtkj.service.PersonService;
import cn.zdxh.mtkj.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author JJ
 * @date 2019/6/26 - 13:57
 */
@RestController
@RequestMapping("/person")
public class controller {


    @Autowired
    private PersonService personService;

    /*通过personId查找联系人*/
    @GetMapping("/queryById")
    public ResultVO<Person> findPersonById(@RequestParam("personId")Integer personId){
        Person person = personService.findPersonById(personId);
        return ResultVOUtil.success(person);
    }
    /*通过名字查找联系人*/
    @GetMapping("/quertByName")
    public ResultVO<Person> findPersonByName(@RequestParam("personName")String personName){
        Person person = personService.findPersonByName(personName);
        return ResultVOUtil.success(person);
    }
    /*获取联系人列表*/
    @GetMapping("/list")
    public ResultVO<List<Person>> findAll(){
        List<Person> personList = personService.findAll();
        return ResultVOUtil.success(personList);
    }

    /*----------------*/
    /*插入联系人*/
    @PostMapping("/insert")
    public ResultVO insert(@RequestBody Person person){
        Integer result = personService.insertPerson(person);
        if(result == ResultEnum.INSERT_SUCCESS.getCode()){
            return ResultVOUtil.success(null);
        }
        return ResultVOUtil.error(ResultEnum.INSERT_FAIL.getCode(),ResultEnum.INSERT_FAIL.getMessage());
    }


    /*更新联系人*/
    @PostMapping("/update")
    public ResultVO update(@RequestBody Person person){
        Integer result = personService.updatePerson(person);
        if(result == ResultEnum.UPDATE_SUCCESS.getCode()){
            return ResultVOUtil.success(null);
        }
        return ResultVOUtil.error(ResultEnum.UPDATE_FAIL.getCode(),ResultEnum.UPDATE_FAIL.getMessage());
    }

    /*删除联系人*/
    @PostMapping("/delete")
    public ResultVO delete(@RequestBody Person person){
        Integer result = personService.deletePerson(person);
        if(result == ResultEnum.DELETE_SUCCESS.getCode()){
            return ResultVOUtil.success(null);
        }
        return ResultVOUtil.error(ResultEnum.Delete_FAIL.getCode(),ResultEnum.Delete_FAIL.getMessage());
    }






}
