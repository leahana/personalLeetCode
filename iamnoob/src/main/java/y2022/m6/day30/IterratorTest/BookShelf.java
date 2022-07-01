package y2022.m6.day30.IterratorTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: leah_ana
 * @Date: 2022/6/28 08:39
 */

public class BookShelf extends Aggregate {

    private List<Book> books;

    private int last = 0;

    public BookShelf (){
        this.books=new ArrayList<>();
    }

    public Book getBookAt(int index) {
        return books.get(index);
    }

    public void appendBook(Book book) {
        this.books.add(book);
        last++;
    }

    public int getLength() {
        return last;
    }

    @Override
    public Iterator iterator() {
        return new BookShelfIterator(this);
    }
}
