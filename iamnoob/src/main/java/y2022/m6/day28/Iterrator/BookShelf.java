package y2022.m6.day28.Iterrator;
;

/**
 * @Author: leah_ana
 * @Date: 2022/6/28 08:39
 */

public class BookShelf extends Aggregate {

    private Book[] books;

    private int last = 0;

    public BookShelf(int maxSize) {
        this.books = new Book[maxSize];
    }

    public Book getBookAt(int index) {
        return books[index];
    }

    public void appendBook(Book book) {
        this.books[last] = book;
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
