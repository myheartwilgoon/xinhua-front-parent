package com.xinhua.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xinhua.edu.entity.Course;
import com.xinhua.edu.entity.Teacher;
import com.xinhua.edu.mapper.TeacherMapper;
import com.xinhua.edu.service.CourseService;
import com.xinhua.edu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2020-10-05
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {
    @Autowired
    private CourseService courseService;
    //前台分页查询
    @Override
    public Map<String, Object> getFrontTeacherList(Page<Teacher> pageTeacher) {
        baseMapper.selectPage(pageTeacher,null);
        //从pageTeacher分页数据获取出来，放到map集合
        List<Teacher> records = pageTeacher.getRecords();//每页数据
        long total = pageTeacher.getTotal();//总记录数
        long size = pageTeacher.getSize();//每页显示记录数
        long pages = pageTeacher.getPages();//总页数
        long current = pageTeacher.getCurrent();//当前页
        boolean hasNext = pageTeacher.hasNext();//是否有下一页
        boolean hasPrevious = pageTeacher.hasPrevious();//是否有上一页

        //把分页数据放到map集合里面
        Map<String,Object> map = new HashMap<>();
        map.put("items", records);
        map.put("current", current);
        map.put("pages", pages);
        map.put("size", size);
        map.put("total", total);
        map.put("hasNext", hasNext);
        map.put("hasPrevious", hasPrevious);
         return map;
    }
    //根据讲师id查询所有课程
    @Override
    public List<Course> getCourseListByTeacherId(String id) {
               //拼接条件
        QueryWrapper<Course> wrapper = new QueryWrapper<>();
        wrapper.eq("teacher_id",id);
        List<Course> list = courseService.list(wrapper);
        return list;
    }

}
