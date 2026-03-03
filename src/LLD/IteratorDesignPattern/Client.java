package LLD.IteratorDesignPattern;

import java.util.Arrays;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        Book book1 = new Book(100, "Book 1");
        Book book2 = new Book(200, "Book 2");
        Book book3 = new Book(300, "Book 3");
        List<Book> bookList = Arrays.asList(new Book(100,"Science"),new Book(200 , "Maths"),new Book(400, "GK"));

        Library library = new Library(bookList);
        Iterator itr = library.createIterator();
        while(itr.hasNext()){
            Book book= (Book) itr.next();
            System.out.println(book.getName() + " : " + book.getPrice());
        }
    }
}
