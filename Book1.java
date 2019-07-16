package SerializationDemo;

import java.io.Serializable;

public class Book1 implements Serializable{

	private int Bookid;
	private String Bookname;
	private String Authorname;
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
	public Book1(int bookid, String bookname, String authorname) {
	
		Bookid = bookid;
		Bookname = bookname;
		Authorname = authorname;
	}
	
	
	
}

class BookApp1 extends Book1 
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
	public BookApp1(int bookid, String bookname, String authorname, String bookappname, int bookappid) {
		super(bookid, bookname, authorname);
		Bookappname = bookappname;
		Bookappid = bookappid;
	}
	
	
	
}
