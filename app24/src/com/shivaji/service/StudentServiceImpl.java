package com.shivaji.service;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import com.shivaji.dao.StudentDao;
import com.shivaji.dto.Student;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;
	
	@Override
	public String addStudent(Student student) {
		String status = studentDao.add(student);
		return status;
	}

	@Override
	public Student searchStudent(String sid) {
		Student student = studentDao.search(sid);
		return student;
	}

	@Override
	public String updateStudent(Student student) {
		String status = studentDao.update(student);
		return status;
	}

	@Override
	public String deleteStudent(String sid) {
		String status = studentDao.delete(sid);
		return status;
	}

}
