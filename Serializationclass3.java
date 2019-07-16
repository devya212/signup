package SerializationDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializationclass3 {

	
	
	public void savedata(Book1 book1)
	{
		FileOutputStream fileoutputStream;
		try {
			fileoutputStream = new FileOutputStream("file4.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileoutputStream);
			objectOutputStream.writeObject(book1);
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
			FileInputStream fileInputStream = new FileInputStream("file4.txt");
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			try {
				Book1 book1 = (Book1)objectInputStream.readObject();
				System.out.println("Retrieved Details of Student Object :");
				System.out.println("Book Id :"+book1.getBookid()+"\n "+"Book Name :"+book1.getBookname()+"\n "+"Author Name :"+book1.getAuthorname());
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
		
		Serializationclass3 serializationclass3 = new Serializationclass3();
		Book1 book1 = new Book1(101,"compiler","M.K.Dutt");
		serializationclass3.savedata(book1);
		serializationclass3.readdata();

	}

}
