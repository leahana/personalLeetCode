package y2022.m7.day07.AbstractFactory.factory;

/**
 * @Author: LeahAna
 * @Date: 2022/7/7 08:35
 * @Desc: 抽象零件： 表示含有HTML 链接的类
 */

public abstract class Link  extends Item{
        protected String url;

        public Link (String caption,String url){
            super(caption);
            this.url=url;
        }
}
