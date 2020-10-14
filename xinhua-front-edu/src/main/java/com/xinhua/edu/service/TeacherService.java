package com.xinhua.edu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xinhua.edu.entity.Course;
import com.xinhua.edu.entity.Teacher;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author testjava
 * @since 2020-10-05
 */
public interface TeacherService extends IService<Teacher> {
    //前台分页查询
    Map<String, Object> getFrontTeacherList(Page<Teacher> pageTeacher);
    //根据讲师id查询讲师的课程
    List<Course> getCourseListByTeacherId(String id);
}
