package com.userBeans;

import java.io.Serializable;
import java.sql.Date;

public class LibraryBeans 
{
		//for user_details
		private int uid;
		private int aid;
		private int lid;
		
		
		private String fname;
		private String lname;
		private String gmail;
		private String password;
		private String type;
		
		//for book_allot
		private String book_taken_date;
		private String book_return_date;
		
		//for book_info
		private int bookid;
		private String bookName;
		private String bookAuthor;
		private int edition;
		private int nOfBooks;
		private String section;
		
		public int getLid() {
			return lid;
		}
		public void setLid(int lid) {
			this.lid = lid;
		}
		public int getUid() {
			return uid;
		}
		public void setUid(int uid) {
			this.uid = uid;
		}
		public int getAid() {
			return aid;
		}
		public void setAid(int aid) {
			this.aid = aid;
		}
		public String getFname() {
			return fname;
		}
		public void setFname(String fname) {
			this.fname = fname;
		}
		public String getLname() {
			return lname;
		}
		public void setLname(String lname) {
			this.lname = lname;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getBook_taken_date() {
			return book_taken_date;
		}
		public String getGmail() {
			return gmail;
		}
		public void setGmail(String gmail) {
			this.gmail = gmail;
		}
		public void setBook_taken_date(String book_taken_date) {
			this.book_taken_date = book_taken_date;
		}
		public String getBook_return_date() {
			return book_return_date;
		}
		public void setBook_return_date(String book_return_date) {
			this.book_return_date = book_return_date;
		}
		public int getBookid() {
			return bookid;
		}
		public void setBookid(int bookid) {
			this.bookid = bookid;
		}
		public String getBookName() {
			return bookName;
		}
		public void setBookName(String bookName) {
			this.bookName = bookName;
		}
		public String getBookAuthor() {
			return bookAuthor;
		}
		public void setBookAuthor(String bookAuthor) {
			this.bookAuthor = bookAuthor;
		}
		public int getEdition() {
			return edition;
		}
		public void setEdition(int edition) {
			this.edition = edition;
		}
		public int getnOfBooks() {
			return nOfBooks;
		}
		public void setnOfBooks(int nOfBooks) {
			this.nOfBooks = nOfBooks;
		}
		public String getSection() {
			return section;
		}
		public void setSection(String section) {
			this.section = section;
		}

	}
