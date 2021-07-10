package com.itcrazy.alanmall.tomcat.manager;

import com.itcrazy.alanmall.tomcat.dto.ClassRoomDto;

import java.util.List;

/**
 * @Auther: mathyoung
 * @description:
 */
public interface TomcatTest {
    String tomcatTest(Integer i);

    void classRoom(List<ClassRoomDto> classRoomDtos, ClassRoomDto classRoomDto);

    Integer count();
}
