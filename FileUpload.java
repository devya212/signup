package fileio;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	public void writeDb()
	{
		Connection con=null;
		ResultSet rs=null;
		PreparedStatement ps=null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
			for(int i=0;i<list.size();i++)
			{
			ps=con.prepareStatement("insert into student001 values(?,?,?)");
			ps.setInt(1,list.get(i).getStudentid());
			ps.setString(2,list.get(i).getStudentName());
			ps.setInt(3,list.get(i).getMarks());
			ps.executeUpdate();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		filePath=scanner.next();
		FileUpload f=new FileUpload();
		f.readFile();
		f.display();
		f.writeDb();
		

	}

}

