import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileHandlingDemo3 {
	Student student[]=new Student[4];
	
	
	public void readFile()
	{
		FileReader reader;
		int i=0;
		try {
			reader = new FileReader("D:\\abc\\File2.txt");
			BufferedReader bufferReader=new BufferedReader(reader);
			String line=bufferReader.readLine();
			while(line!=null)
			{
				System.out.println(line);
				String arr[]=line.split(" ");
				student[i]=new Student();
				student[i].setStudentid(Integer.parseInt(arr[0]));
				student[i].setStudentName(arr[1]);
				student[i].setMarks(Integer.parseInt(arr[2]));	
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
		for(int i=0;i<4;i++)
		{
		student[i].display();
		}
	}

	public static void main(String[] args) {
		FileHandlingDemo3 f=new FileHandlingDemo3();
		f.readFile();
		f.display();

	}

}

