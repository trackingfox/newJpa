package com.JPA.csv2db;

import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.JPA.dataModel.Student;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

public class StudentToDb {

	// name,rollno,department,result,cgpa
	// @Test
	public List<Student> csvToclass() {
		// create a hashmap of colmn header to class attribute

		Map<String, String> mapper = new HashMap<String, String>();

		mapper.put("name", "Name");
		mapper.put("rollno", "RollNo");
		mapper.put("department", "Department");
		mapper.put("result", "Result");
		mapper.put("cgpa", "Pointer");

		// HeaderColumnNameTranslateMappingStrategy
		// for Student class
		HeaderColumnNameTranslateMappingStrategy<Student> strategy = new HeaderColumnNameTranslateMappingStrategy<Student>();
		strategy.setType(Student.class);
		strategy.setColumnMapping(mapper);

		// csvReader
		CSVReader csvReader = null;
		try {
			csvReader = new CSVReader(new FileReader(
					"D:\\Workspace\\TopicsOfjava\\src\\main\\java\\com\\corejava\\csv\\StudentData.csv"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		// csv to bean
		CsvToBean csvBean = new CsvToBean();

		// call the parse method
		List<Student> stulist = csvBean.parse(strategy, csvReader);
//			 System.out.println(stu);
//		for (Student stu1 : stu) {
//			 System.out.println(stu1);
//
//		}

		return stulist;
	}

	@Test
	public void importTodb() {

//		SessionFactory sessionFactory = null;
//		// configures settings from hibernate.cfg.xml
//		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
//
//		try {
//			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
//		} catch (Exception ex) {
//			System.out.println(ex.toString()); // If error display in console
//			StandardServiceRegistryBuilder.destroy(registry);
//		}
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//		List<Student> studentlist = this.csvToclass();
//		studentlist.forEach(x -> session.save(x));
//		session.getTransaction().commit();
//		session.close();

		// use persistence.xml configuration

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("newJpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		List<Student> studentlist = this.csvToclass();
		studentlist.forEach(x -> em.persist(x));
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}

//	@Test
//public void StudentTransaction() {
//	List<Student> studentlist = csvToclass();
//	// Get student with exact match name "rohini"
//	Optional<Student> a = studentlist.stream().filter(x -> x.getName().equals("rohini")).findFirst();
////	a.ifPresent(System.out::println);
////	a.ifPresent(x -> System.out.println(x));
//
//	// Get student with matching roll "21"
//	Optional<Student> b = studentlist.stream().filter(x -> x.getRollNo().equals("21")).findFirst();
////	b.ifPresent(System.out::println);
//
//	// Get all student having department "cse"
//	List<Student> cseStudent = studentlist.stream().filter(x -> x.getDepartment().equals("cse"))
//			.collect(Collectors.toList());
////	for (Student student : cseStudent) {
////		System.out.println(student);
////	}
//
//	// Get all student having department "cse" and "ee"
//	List<Student> cseEEStudent = studentlist.stream()
//			.filter(x -> (x.getDepartment().equals("cse") || x.getDepartment().equals("ee")))
//			.collect(Collectors.toList());
////	for (Student student : cseEEStudent) {
////		System.out.println(student);
////	}
//
//	// Create a List<Student> from the List<TempStudent>
//
//	// Convert List<Student> to List<String> of student names
//	List<String> studNames = studentlist.stream().map(x -> x.getName()).collect(Collectors.toList());
////	for (String str : studNames) {
////		System.out.println(str);
////	}
//
//	// Convert List<students> to String
//	String studNames1 = studentlist.stream().map(x -> x.getName()).collect(Collectors.joining(","));
//
//	// Change the case of List<String>
//	List<String> studNames2 = studentlist.stream().map(x -> {
//		char[] chars = x.getName().toCharArray();
//		for (int i = 0; i < chars.length; i++) {
//			char c = chars[i];
//			if (Character.isUpperCase(c))
//				chars[i] = Character.toLowerCase(c);
//			else if (Character.isLowerCase(c))
//				chars[i] = Character.toUpperCase(c);
//		}
//		return new String(chars);
//	}).collect(Collectors.toList());
//
//	for (String st : studNames2) {
//		System.out.println(st);
//	}
//	// Sort List<String>
//	List<String> studNames3 = studentlist.stream().map(x -> x.getName()).sorted().peek(System.out::println)
//			.collect(Collectors.toList());
////	for (String str3 : studNames3) {
////		System.out.println(str3);
////	}
//	// Conditionally apply Filter condition, say if flag is enabled then
//
//}
