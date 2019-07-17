package fileio;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class FileUpload {
	List<Student> list=new ArrayList<>();
	static String filePath;
	public void readFile()
	{
		FileReader reader;
		int i=0;
		try {
			reader = new FileReader(filePath);
			BufferedReader bufferReader=new BufferedReader(reader);
			String line=bufferReader.readLine();
			while(line!=null)
			{
				/*System.out.println(line);*/
				String arr[]=line.split(" ");
		          Student s1=new Student();
		        list.add(s1);
				s1.setStudentid(Integer.parseInt(arr[0]));
				s1.setStudentName(arr[1]);
				s1.setMarks(Integer.parseInt(arr[2]));	
				i++;
				line=bufferReader.readLine();			
			}
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void display()
	{
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i).getStudentid()+"\t"+list.get(i).getStudentName()+"\t"+list.get(i).getMarks());
		}
	}


	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		filePath=scanner.next();
		FileUpload f=new FileUpload();
		f.readFile();
		f.display();
		

	}

}
