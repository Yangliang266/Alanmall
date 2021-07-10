package com.itcrazy.alanmall.tomcat.service;

import com.itcrazy.alanmall.tomcat.dal.entitys.ClassRoom;
import com.itcrazy.alanmall.tomcat.dal.entitys.Tomcat;
import com.itcrazy.alanmall.tomcat.dal.persistence.ClassRoomMapper;
import com.itcrazy.alanmall.tomcat.dal.persistence.TomcatMapper;
import com.itcrazy.alanmall.tomcat.dto.ClassRoomDto;
import com.itcrazy.alanmall.tomcat.manager.TomcatTest;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Auther: mathyoung
 * @description:
 */
@DubboService
public class TomcatServiceImp implements TomcatTest {
    @Autowired
    TomcatMapper tomcatMapper;

    @Autowired
    ClassRoomMapper classRoomMapper;

    @Override
//    @Cacheable(cacheNames = "tomcatTest", key = "#id")
    public String tomcatTest(Integer id) {
        System.out.println("数据库");
        Tomcat tomcat = tomcatMapper.selectByPrimaryKey(id);

        return tomcat.getNum().toString();
    }

    @Override
    public void classRoom(List<ClassRoomDto> classRoomDtos, ClassRoomDto classRoomDto) {
//        List<ClassRoom> list = classRoomMapper.selectAll();

        Integer count = classRoomMapper.countClassNum();

        classRoomMapper.updateClass(classRoomDtos);

//        List<ClassRoom> classAll = classRoomMapper.getClassAll();
//
//        List<ClassRoom> list = classRoomMapper.getStuByClassId();
//        classRoomMapper.insertClassOne(classRoomDto);

//        classRoomMapper.insertClass(classRoomDtos);

//        System.out.println(list);
    }

    @Override
    public Integer count() {
        Integer count = classRoomMapper.countClassNum();
        return count;
    }

}
