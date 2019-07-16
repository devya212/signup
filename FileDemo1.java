import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileDemo1 {
	Student student[];
	long lineCount=0; 
	int l=0;
	
	
	public void readFile()
	{
		FileReader reader=null;
		BufferedReader bufferReader=null;
		int i=0;
		try {
			reader = new FileReader("D:\\abc\\File2.txt");
			bufferReader=new BufferedReader(reader);			
			String line=bufferReader.readLine();			
			/*while(line1!=null)
			{
				c=c+1;
				line1=bf.readLine();
			}*/
			Path path = Paths.get("D:\\abc\\File2.txt");
			long lineCount = Files.lines(path).count();
			l=(int)lineCount;
			
			student=new Student[l];
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
		for(int i=0;i<l;i++)
		{
		student[i].display();
		}
	}

	public static void main(String[] args) {
		FileDemo1 f=new FileDemo1();
		f.readFile();
		f.display();

	}

}