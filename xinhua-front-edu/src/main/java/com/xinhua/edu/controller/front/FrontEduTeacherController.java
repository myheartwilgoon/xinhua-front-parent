package com.xinhua.edu.controller.front;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xinhua.edu.entity.Course;
import com.xinhua.edu.entity.Teacher;
import com.xinhua.edu.service.CourseService;
import com.xinhua.edu.service.TeacherService;
import com.xinhua.onlineedu.common.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//前台讲师controller
@RestController
@RequestMapping("/eduservice/frontTeacher")
@CrossOrigin
public class FrontEduTeacherController {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private CourseService courseService;

    //1.查询讲师详情信息
    @GetMapping("{id}")
    public R getTeacherInfoCourseId(@PathVariable String id) {
        //1 根据讲师id查询讲师详情信息，返回对象
        Teacher eduTeacher = teacherService.getById(id);

        //2 查询讲师所讲的课程，返回list集合
        List<Course> courseList = teacherService.getCourseListByTeacherId(id);

        return R.ok().data("eduTeacher",eduTeacher).data("courseList",courseList);
    }
        //讲师列表的方法
    @GetMapping("{page}/{limit}")
    public R getFrontTeacherListPage(@PathVariable Long page,
                                     @PathVariable Long limit) {
        //2.实现分页查询
        Page<Teacher> pageTeacher = new Page<>(page,limit);
        //调用service的实现分页
        Map<String,Object> map = teacherService.getFrontTeacherList(pageTeacher);
        return R.ok().data(map);
    }


   //查询前8条热门课程，查询前4条名师

    @GetMapping("index")

    public R index() {

        //查询前8条热门课程

        QueryWrapper<Course> wrapper = new QueryWrapper<>();

        wrapper.orderByDesc("id");

        wrapper.last("limit 8");

        List<Course> eduList = courseService.list(wrapper);


        //查询前4条名师

        QueryWrapper<Teacher> wrapperTeacher = new QueryWrapper<>();

        wrapperTeacher.orderByDesc("id");

        wrapperTeacher.last("limit 4");

        List<Teacher> teacherList = teacherService.list(wrapperTeacher);


        return R.ok().data("eduList",eduList).data("teacherList",teacherList);

    }

}
