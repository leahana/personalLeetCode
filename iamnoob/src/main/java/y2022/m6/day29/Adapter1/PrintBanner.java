package y2022.m6.day29.Adapter1;

/**
 * @Author: leah_ana
 * @Date: 2022/6/29 09:00
 * @Desc: 扮演适配器角色
 */

public class PrintBanner extends Banner implements Print {

    public PrintBanner(String string) {
        super(string);
    }

    @Override
    public void printWeak() {
        showWithParen();
    }

    @Override
    public void printStrong() {
        showWithAster();
    }
}
