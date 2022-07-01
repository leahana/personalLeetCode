package y2022.m6.day28.Iterrator;

/**
 * @Author: leah_ana
 * @Date: 2022/6/28 08:52
 */

public class BookShelfIterator implements Iterator {

    private BookShelf bookShelf;

    public int index;

    public BookShelfIterator (BookShelf bookShelf){
        this.bookShelf = bookShelf;
        this.index=0;
    }


    /**
     * 可以理解为--确认接下来是否可以调用next方法
     * @return boolean
     */

    @Override
    public boolean hasNext() {
        if (index< bookShelf.getLength()){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 返回当前指针指向的元素 并把指针推向下一个元素
     * @return 当前指针指向的对象
     */
    @Override
    public Object next() {
        Book book=bookShelf.getBookAt(index);
        index ++;
        return book;
    }
}
