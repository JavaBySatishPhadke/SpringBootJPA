package com.nt.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Faculty;
import com.nt.entity.Student;
import com.nt.repository.IFacultyRepository;
import com.nt.repository.IStudentRepository;

@Service
public class CollegeMgmtServiceImpl implements ICollegeMgmtService {
	@Autowired
	private  IFacultyRepository facultyRepo;
	@Autowired
	private  IStudentRepository  studentRepo;

	@Override
	public void saveDataUsingParent() {
		//prepare parent objs
		Faculty  faculty1=new Faculty("raja", "hyd");
		Faculty  faculty2=new Faculty("rajesh", "delhi");
		//prepare childs objs
		Student  stud1=new Student("anil","hyd","CBIET");
		Student  stud2=new Student("suresh","hyd","JBIET");
		Student  stud3=new Student("sagar","hyd","NBIET");
		//assign students  faculties
		faculty1.getStudentsInfo().add(stud1);
		faculty1.getStudentsInfo().add(stud2);
		faculty1.getStudentsInfo().add(stud3);
		faculty2.getStudentsInfo().add(stud1);
		faculty2.getStudentsInfo().add(stud2);
		
		//assign  faculties to students
		stud1.getFacultiesInfo().add(faculty1);
		stud1.getFacultiesInfo().add(faculty2);
		stud2.getFacultiesInfo().add(faculty1);
		stud2.getFacultiesInfo().add(faculty2);
		stud3.getFacultiesInfo().add(faculty1);
		
		//save data using parent
			facultyRepo.save(faculty1);
			facultyRepo.save(faculty2);
			System.out.println("Faculties and  the associated  students are saved");
	}//method
	
	@Override
	public void loadDataUsingParent() {
		Iterable<Faculty>  itFaculites=facultyRepo.findAll();
		itFaculites.forEach(faculty->{
			System.out.println("Parent::"+faculty);
			Set<Student> childs=faculty.getStudentsInfo();
			childs.forEach(stud->{
				System.out.println("child::"+stud);
			});
		});
		
	}
	
	@Override
	public void deleteDataUsingParent() {
		//Load Parent
		Optional<Faculty> opt=facultyRepo.findById(3);
		if(opt.isPresent()) {
			Faculty  factulty=opt.get();
			Set<Student> childs=factulty.getStudentsInfo();
			factulty.setStudentsInfo(null);
			childs.forEach(ch->{
				ch.setFacultiesInfo(null);
			});
			facultyRepo.save(factulty);
			System.out.println("Faculty is removed from certain students");
		}
		else {
			System.out.println("Faculty not found");
		}
		
	}
	
}//class
