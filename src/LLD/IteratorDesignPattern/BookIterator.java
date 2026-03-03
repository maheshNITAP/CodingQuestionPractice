package LLD.IteratorDesignPattern;

import java.util.List;

public class BookIterator implements Iterator{
    List<Book> book;
    private int index=0;

    public BookIterator(List<Book> books){
        this.book = books;
    }

    @Override
    public boolean hasNext(){
        return index<book.size();
    }

    @Override
    public Object next(){
        if(this.hasNext())
            return book.get(index++);
        return null;
    }
}
