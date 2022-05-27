package y2022.may.day22;

/**
 * @Author: leah_ana
 * @Date: 2022/5/24 12:47
 */
import java.io.IOException;
import java.util.Arrays;
import java.util.Set;
import joinery.DataFrame;



public class Solution{
    public static void main(String[] args) {
        //创建
        DataFrame<Object> df = new DataFrame<>("name", "value");
        //添加数据
        df.append(Arrays.asList("alpha", 1));
        df.append(Arrays.asList("bravo", 2));
        //行数
        System.out.println(df.length());
        //空表判断
        System.out.println(df.isEmpty());
        //多列合并成一列进行输出
        System.out.println(df.flatten());
        //计算常用统计量
        System.out.println(df.mean().col("value"));
        System.out.println(df.median().col("value"));
        System.out.println(df.max().col("value"));
        System.out.println(df.min().col("value"));
        System.out.println(df.var().col("value"));
        // 以下演示如何获取每一格的数据
        Set<Object> indexs = df.index();
        Set<Object> columns = df.columns();
        for(Object index:indexs){
            for(Object column:columns){
                System.out.print(df.get(index, column));
                System.out.print("\t");
            }
            System.out.println();
        }
        //保存为csv文件
//        try {
//            df.writeCsv("./test.csv");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
