package com.itcrazy.alanmall.tomcat.controller;

import com.itcrazy.alanmall.tomcat.dto.ClassRoomDto;
import com.itcrazy.alanmall.tomcat.manager.TomcatTest;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: mathyoung
 * @description:
 */
@RequestMapping("/tomcat")
@RestController
public class TomcatController {
    @DubboReference
    TomcatTest tomcatTest;


    @RequestMapping("/test/{id}")
    public String test(@PathVariable Integer id, HttpServletRequest request) {

        return tomcatTest.tomcatTest(id);
    }

    @RequestMapping("/test/classroom")
    public String testClassRoom() {
        List<ClassRoomDto> list = new ArrayList<ClassRoomDto>();
        ClassRoomDto classRoomDto = new ClassRoomDto();
        ClassRoomDto classRoomDto1 = new ClassRoomDto();
        classRoomDto.setClassName("chinese");
        classRoomDto.setStuNum(6);
        classRoomDto1.setClassName("music");
        classRoomDto1.setStuNum(7);
        list.add(classRoomDto);
        list.add(classRoomDto1);

        ClassRoomDto classRoomDto2 = new ClassRoomDto();
        classRoomDto2.setClassName("huihua");
        classRoomDto2.setStuNum(8);


        List<ClassRoomDto> list1 = new ArrayList<ClassRoomDto>();
        ClassRoomDto classRoomDto3 = new ClassRoomDto();
        ClassRoomDto classRoomDto4 = new ClassRoomDto();
        classRoomDto3.setClassId(1);
        classRoomDto3.setClassName("p1");
        classRoomDto3.setStuNum(55);
        classRoomDto4.setClassId(2);
        classRoomDto4.setClassName("p2");
        classRoomDto4.setStuNum(66);
        list1.add(classRoomDto3);
        list1.add(classRoomDto4);

        tomcatTest.classRoom(list1, classRoomDto2);

//        System.out.println(tomcatTest.count());
        return "success";
    }
}
