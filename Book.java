package SerializationDemo;

import java.io.Serializable;

public class Book {
	private int Bookid;
	private String Bookname;
	private String Authorname;
	public Book()
	{
		Bookid = 101;
		Bookname = "DataStructures";
		Authorname ="ABC";
		
	}
	public Book(int bookid, String bookname, String authorname) {
		
		Bookid = bookid;
		Bookname = bookname;
		Authorname = authorname;
	}
	public int getBookid() {
		return Bookid;
	}
	public void setBookid(int bookid) {
		Bookid = bookid;
	}
	public String getBookname() {
		return Bookname;
	}
	public void setBookname(String bookname) {
		Bookname = bookname;
	}
	public String getAuthorname() {
		return Authorname;
	}
	public void setAuthorname(String authorname) {
		Authorname = authorname;
	}
	
	
	
	

}
class BookApp extends Book implements Serializable
{
	private String Bookappname;
	private int Bookappid;
	public String getBookappname() {
		return Bookappname;
	}
	public void setBookappname(String bookappname) {
		Bookappname = bookappname;
	}
	public int getBookappid() {
		return Bookappid;
	}
	public void setBookappid(int bookappid) {
		Bookappid = bookappid;
	}
	public BookApp(int bookid, String bookname, String authorname, String bookappname, int bookappid) {
		super(bookid, bookname, authorname);
		Bookappname = bookappname;
		Bookappid = bookappid;
	}
	
	
	
	
	
}
