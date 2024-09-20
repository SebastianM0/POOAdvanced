package com.generation.classes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import com.generation.exceptions.CourseNotFoundException;
import com.generation.exceptions.StudentNotFoundException;

public class StudentService{
    HashMap<String, Course> courseList = new HashMap<>();
    HashMap<String, Student> students = new HashMap<>();
    HashMap<String, List<Course>> coursesEnrolledByStudents = new HashMap<>(); //Aqui se irán guardando los estudiantes de cada materia 

    public StudentService(){
        courseList.put( "Math", new Course( "Math", 10, "Aurelio Baldor" ) );
        courseList.put( "Physics", new Course( "Physics", 10, "Albert Einstein" ) );
        courseList.put( "Art", new Course( "Art", 10, "Pablo Picasso" ) );
        courseList.put( "History", new Course( "History", 10, "Sima Qian" ) );
        courseList.put( "Biology", new Course( "Biology", 10, "Charles Darwin" ) );
    }//Crea las listas del curso, poniendo Materia, Creditos, Profesor

   //Método para agregar estudiantes y llamarlos dentro del main.
    public void addStudent (String name, String id, int age) {
    		Student student = new Student(name,id,age);
    		students.put(id, student);
    }//Aqui se toma la info del student, y se agrega al hashmap students
    
   //----------------------------------------------
    public void enrollStudents( String courseName, String studentID )throws StudentNotFoundException,        CourseNotFoundException{
     Course course = courseList.get( courseName ); //Aqui se toma el nombre del curso
     if (!courseList.containsKey(courseName)) { //Valida si el nombre del curso existe dentro de nuestra lista de cursos
    	 	throw new CourseNotFoundException("El curso " + courseName + " no existe"); //manda el exception
     }else {
    	 	if (students.containsKey( studentID ) ){ //Valida si el ID del estudiante existe dentro del arreglo students
         coursesEnrolledByStudents.put( studentID, new ArrayList<>() ); //Si si esta todo, mete al estudiante dentro de la materia a cursar 
     }else {
    	 	throw new StudentNotFoundException("El estudiante "+ studentID + " no existe");
     }//else primera validación
     }//else segunda validación 
     coursesEnrolledByStudents.get( studentID ).add( course );
   }//enrollStudent con los throws por si no existe el estudiante o el curso
          
    public void unEnrollStudents(String courseName, String studentID) throws StudentNotFoundException, CourseNotFoundException{ 
        Course course = courseList.get( courseName ); //Se busca la info de la clase en la lista de cursos tomando el nombre 
        if (!courseList.containsKey(courseName)) { //Si no existe el curso
 	 	throw new CourseNotFoundException("El curso " + courseName + " no existe");//Exception
		}else {
			if ( coursesEnrolledByStudents.containsKey( studentID ) ){ //Si si existe el ID del estudiante, dentro de la lista de estudiantes ya dentro 
				coursesEnrolledByStudents.get( studentID ).remove( course ); //Lo quita de la lista del curso, obteniendo su ID (.get(studentID) y borrandolo del curso (.remove(course)
        }else {
        		throw new StudentNotFoundException("El estudiante "+ studentID + " no existe dentro del curso");//Si no existe el ID manda la exception 
        }//else primera validación 
		}//else segunda validación 
    }//unEnrollStudents
    
//---------------------------------------------
    public void showEnrolledStudents(String courseId){ //Muestra las personitas dentro del curso (courseId)
    	System.out.println("Lista de estudiantes inscritos en " + courseId);
    for (String studentId : coursesEnrolledByStudents.keySet()) { //foreach que no es foreach, que crea un ciclo dentro de coursesEnrolled que itera segun cuantos studentId tengo 
    List<Course> enrolledCourses =coursesEnrolledByStudents.get(studentId); //Creo una lista "enrolledCourses" donde se guardaran todos los studentId obtenidos del ciclo pasado 
     for (Course course : enrolledCourses) { //Otro ciclo donde itera dentro de enrolledCourses (donde guardamos todos los studentId) por la cantidad de cursos. 
    		        Student student = students.get(studentId); //crea un student que se le asigna el id obtenido 
    		        System.out.println(" | " + student.getName()); //se usa un getter para sacar el nombre del estudiante
    		      }//cierre del 2do ciclo
    		    }//cierre del 1er ciclo 
    		  }//showEnrolledStudents
    

    public void showAllCourses(){
    	  System.out.println("Lista de todos los cursos:");
      	  for (Course course : courseList.values()) { //ciclo dentro del courseList que itera segun cuantos course tenga dentro jiji
    	    System.out.println(" | " + course.getName() + " ->" + course.getCredits() + " créditos, profesor: " + course.getProfessorName()); //toma los datos con los getters en cada iteración de todos los cursos yippi 
    	  }//cierre del ciclo     
     }//showAllCourses
}//class StudentService





