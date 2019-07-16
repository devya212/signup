package SerializationDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializationclass2 {

	
	public void savedata(BookApp bookapp)
	{
		FileOutputStream fileoutputStream;
		try {
			fileoutputStream = new FileOutputStream("file3.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileoutputStream);
			objectOutputStream.writeObject(bookapp);
			System.out.println("Object Details Is Written in File");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	public void readdata()

	{
		try {
			FileInputStream fileInputStream = new FileInputStream("file3.txt");
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			try {
				BookApp bookapp = (BookApp)objectInputStream.readObject();
				System.out.println("Retrieved Details of Student Object :");
				System.out.println("Book Id :"+bookapp.getBookid()+"\n "+"Book Name :"+bookapp.getBookname()+"\n "+"Author Name :"+bookapp.getAuthorname()+" \n"+"Book App Name: "+bookapp.getBookappname()+"\n"+"Book app Id : "+bookapp.getBookappid());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Serializationclass2 serializationclass2 = new Serializationclass2();
		BookApp bookapp = new BookApp(101,"compiler","M.K.Dutt","Final",204);
		serializationclass2.savedata(bookapp);
		serializationclass2.readdata();
		
		
	}

}
