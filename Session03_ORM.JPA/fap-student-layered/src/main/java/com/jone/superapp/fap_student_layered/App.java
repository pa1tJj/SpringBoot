package com.jone.superapp.fap_student_layered;

import com.jone.superapp.fap_student_layered.entity.Student;
import com.jone.superapp.fap_student_layered.service.StudentService;

/**
 * Hello world!
 *
 */
public class App 
{
	
    public static void main( String[] args )
    {
        StudentService studentService = new StudentService();
        Student binh = new Student("SE3", "Lê Bình", 2003, 8.7);
        Student mai = new Student("SE4", "Nguyễn Mai", 2004, 8.7);
        Student ba = new Student("SE5", "Bảo An", 2004, 8.7);
        Student chuc = new Student("SE6", "Trần Chúc", 2003, 8.7);
        studentService.updateStudent(binh);
    }
}
