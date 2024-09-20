package com.generation;
import com.generation.classes.Student;
import com.generation.classes.StudentService;
import com.generation.exceptions.*;

public class Main {

    public static void main(String[] args) throws CourseNotFoundException, StudentNotFoundException {
	    StudentService studentService = new StudentService();
	    //TODO refactor this code to use encapsulation inside studentsService
//        studentService.students.put( "1030", new Student( "Carlos", "1030", 31 ) );
//        studentService.students.put( "1040", new Student( "Ian", "1020", 28 ) );
//        studentService.students.put( "1050", new Student( "Elise", "1020", 26 ) );
//        studentService.students.put( "1020", new Student( "Santiago", "1020", 33 ) );
	    
	    
        //Se muestran todos los cursos
        studentService.showAllCourses();
        
	    //Agregar estudiantes a nuestro arreglo students
	    studentService.addStudent("Carlos", "1030", 31);
	    studentService.addStudent("Ian", "1040", 28);
	    studentService.addStudent("Elise", "1050", 26);
	    studentService.addStudent("Santiago", "1020", 33);

	    //Inscribir a los estudiantes dentro del curso Math
        try {
			studentService.enrollStudents( "Math1", "1020" );
		} catch (StudentNotFoundException | CourseNotFoundException e) {
				System.out.println(e.getMessage());
		}
        try {
			studentService.enrollStudents( "Math", "1030" );
		} catch (StudentNotFoundException | CourseNotFoundException e) {
			System.out.println(e.getMessage());
		}
        try {
			studentService.enrollStudents( "History", "1040" );
		} catch (StudentNotFoundException | CourseNotFoundException e) {
			System.out.println(e.getMessage());
		}
        try {
			studentService.enrollStudents( "History", "1050" );
		} catch (StudentNotFoundException | CourseNotFoundException e) {
			System.out.println(e.getMessage());
		}

        //Muestra los estudiantes inscritos en math
        studentService.showEnrolledStudents("Math");
        
        //Se elimina a una persona
        try {
			studentService.unEnrollStudents("Math", "1020");
		} catch (StudentNotFoundException | CourseNotFoundException e) {
			System.out.println(e.getMessage());
		}
        
        //Se vuelven a mostrar los estudiantes inscritos
        studentService.showEnrolledStudents("Math");        
        studentService.showEnrolledStudents("History");
        
        

    }
}