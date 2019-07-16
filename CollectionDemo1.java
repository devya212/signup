package coll;

import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class CollectionDemo1 {

	public static void main(String[] args) {
	List list=new ArrayList();
	list.add("hello");
	list.add("hi");
	list.add(12);
	Student s1 = new Student(1,"devyani");
	list.add(s1.toString());
	System.out.println(list);
		/*ArrayList<Student> list=new ArrayList<>();
		list.add(new Student(1,"devyani"));
		list.add(new Student(2,"priya"));*/
	/*for(int i=0;i<2;i++)
	{
		Student student=list.get(i);
		System.out.println(student.studentId+"\t"+student.studentName);
	}*/
		/*Iterator iterator=list.iterator();
		while(iterator.hasNext())
		{
			Student student=(Student)iterator.next();
			System.out.println(student.studentId+"\t"+student.studentName);
			
			
		}*/
	
	
	

	}

}
