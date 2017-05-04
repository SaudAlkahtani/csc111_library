public class Book {
   private int ISBN,edition;
   private String author,title,genre,publisher,refCode;

   public Book() {
	   author=title=genre=publisher=refCode=null;
	   ISBN=edition=0;
   }
   public Book(int ISBN,String author,String title,String genre,int edition,String publisher) {
	   this.ISBN = ISBN;
	   this.author=author;
	   this.title=title;
	   this.genre=genre;
	   this.edition=edition;
	   this.publisher = publisher;
   }
   public void equals(Book WWW){
	   if (this.ISBN == WWW.ISBN && this.author==WWW.author&&this.title==WWW.title &&this.genre==WWW.genre&&this.edition==WWW.edition&&this.publisher==WWW.publisher)
		   System.out.println("Are equels");
	   else 
		   System.out.println("Not equals");
   
   }
   
   public String generateReference() { 
	   refCode="";
	   refCode+= author.charAt(0);
	   refCode+=author.charAt(1);
	   refCode+= "-";
	   refCode+=genre.charAt(0);
	   refCode+=genre.charAt(1);
       return refCode.toUpperCase();
   }

   public static boolean verifyISBN(int ISBN) {
	   int n1,n2,n3,n4,n;
	   boolean result;
	   n1=(ISBN/1000);
	   n2=(ISBN/100)%10;
	   n3=(ISBN/10)%10;
	   n4=((n1*3+n2*2+n3*1)%4);
	   n=(n1*1000)+(n2*100)+(n3*10)+n4;
	   if (n ==ISBN) 
		   result=true;
	   
	   else 
		   result = false;
		   return result;
   }
   public String PrintBookInfo() {
	  String toString="";
	  toString += "Title :" + title +"\n";
	  toString+= "Author :" + author +"\n";
	  toString+= "ISBN :"+ISBN + " - Reference Code " + generateReference()+"\n";
	  toString+= "Genre :"+genre+"\n";
	  toString+= "publisher :" + publisher + "\n";
	  toString+= "edition :" +edition+" \n";
	  return toString;
   }

public int getISBN() {
	return ISBN;
}

public void setISBN(int iSBN) {
	ISBN = iSBN;
}

public int getEdition() {
	return edition;
}

public void setEdition(int edition) {
	this.edition = edition;
}

public String getAuthor() {
	return author;
}

public void setAuthor(String author) {
	this.author = author;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getGenre() {
	return genre;
}

public void setGenre(String genre) {
	this.genre = genre;
}

public String getPublisher() {
	return publisher;
}

public void setPublisher(String publisher) {
	this.publisher = publisher;
}

public String getRefCode() {
	return refCode;
}

public void setRefCode(String refCode) {
	this.refCode = refCode;
}
   
}
