package y2022.m6.day30.IterratorTest;


/**
 * @Author: leah_ana
 * @Date: 2022/6/28 08:58
 */

public class Main {
    public static void main(String[] args) {
        BookShelf bookShelf= new BookShelf();
        bookShelf.appendBook(new Book("Around the World in 80 Days"));
        bookShelf.appendBook(new Book("Bible"));
        bookShelf.appendBook(new Book("Cinderella"));
        bookShelf.appendBook(new Book("Daddy-Long-Legs"));
        Iterator iterator = bookShelf.iterator();

        // while 循环不依赖bookShelf实现
        //  不管BookShelf如何变化，只要BookShelf的iterator方法能正确的返回Iterator实例
        // （也就是说，返回的Iterator类的实例没有问题，hasNext和next方法都可以正常工作），
        //  即使不对while循环做任何修改，代码都能正常工作
        while (iterator.hasNext()){
            Book book = (Book) iterator.next();
            System.out.println(book.getName());
        }

        // 不要使用具体类来编程，要优先使用抽象类和接口来编程
    }
}
