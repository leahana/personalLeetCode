package y2022.m6.day29.Adapter1;

/**
 * @Author: leah_ana
 * @Date: 2022/6/29 08:28
 */

public class Banner {
    private String string;

    public Banner(String string) {
        this.string = string;
    }

    public  void showWithParen(){
        System.out.println("("+string+")");
    }
    public void showWithAster(){
        System.out.println("*"+string+"*");
    }
}
