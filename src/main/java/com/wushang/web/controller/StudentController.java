package com.wushang.web.controller;

import com.wushang.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName StudentController
 * @Description TODO
 * @Author wushang
 * @Date 2019-09-10 14:40
 */

@Controller
@RequestMapping("stu")
public class StudentController {

	@RequestMapping("list")
	public String list(Model model){
		model.addAttribute("username","wushang");
		model.addAttribute("age","11");
		List<Student> list = new ArrayList<>();
		list.add(new Student(1001,"zhangsan","男"));
		list.add(new Student(1002,"lisi","男"));
		list.add(new Student(1003,"wangwu","男"));
		model.addAttribute("list",list);

		return "stu/list";//返回模板页面
	}
}
