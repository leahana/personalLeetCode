package y2022.m6.day29.Adapter2;

import y2022.m6.day29.Adapter1.Banner;

/**
 * @Author: leah_ana
 * @Date: 2022/6/29 12:45
 * @Desc:
 */

public class PrintBanner extends  Print{
    private Banner banner;

    public PrintBanner(Banner banner) {
        this.banner =banner ;
    }
    public void printWeak(){
        banner.showWithParen();
    }

    @Override
    public void printStrong() {
        banner.showWithAster();
    }
}
