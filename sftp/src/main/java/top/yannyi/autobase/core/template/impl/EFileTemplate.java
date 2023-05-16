package top.yannyi.autobase.core.template.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import top.yannyi.autobase.efileparse.efile.ETable;
import top.yannyi.autobase.efileparse.efile.impl.DefaultEFileParse;
import top.yannyi.autobase.efileparse.util.BeanUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: LeahAna
 * @Date: 2023/3/23 16:04
 * @Desc: E文件解析生成操作模版
 */

@Slf4j
public class EFileTemplate {

    @Value("${auto-template-base.fileReadEncode}")
    private String FILE_READ_ENCODE;


    private final DefaultEFileParse parse = new DefaultEFileParse();

    /**
     * 读取文件context
     *
     * @param filepath 文件根目录
     * @return 文件context
     */
    public String readFileContext(String filepath) {
        String context = "";
        try (FileInputStream fis = new FileInputStream(filepath)) {
            int length = fis.available();
            if (length > 0) {
                byte[] data = new byte[length];
                fis.read(data, 0, length);
                context = new String(data, FILE_READ_ENCODE);
                log.info("读取文件配置文件：{},字符类型：{}", filepath, FILE_READ_ENCODE);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return context;
    }


    /**
     * Writer生成文件
     */
    public boolean writeFile(String context, String localPath, String filename) {
        boolean flag = true;
        if (context == null || localPath == null || filename == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }
        File dir = new File(localPath);
        if (!dir.exists() || !dir.isDirectory() || !dir.canWrite()) {
            throw new RuntimeException("没有读写权限或文件路径不存在：localPath：" + localPath);
        }
        String fullFilename = localPath + File.separator + filename;
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(fullFilename))) {
            pw.write(context);
            pw.flush();
        } catch (IOException e) {
            flag = false;
            log.error("IOException:{}", e.getMessage());
        }
        return flag;
    }


    /**
     * 将路径文件转换为ETable对象
     *
     * @param fullFilePath 文件根目录
     * @return 改文件解析成的ETable对象
     */
    public List<ETable> parseToETable(String fullFilePath) {
        List<ETable> eTables = new ArrayList<>();
        try {
            eTables = parse.parseEFile(new File(fullFilePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return eTables;
    }

    /**
     * 将ETable转换成 对象集合/参考单列/多列
     *
     * @param eTable 解析对象
     * @return 解析后的对象
     */
    public List<Object> parseBean(ETable eTable) {
        List<Object> objects = new ArrayList<>();
        try {
            objects = BeanUtils.parseBean(eTable);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return objects;
    }

    /**
     * 把文件转换成Map: k:解析类 class， v:解析ETable对象
     *
     * @param fullFilePath 文件根目录
     * @return 文件解析后大的对象
     */
    public Map<Class<?>, Object> parseToResultMap(String fullFilePath) {
        Map<Class<?>, Object> resultMap = new HashMap<>();
        List<ETable> eTables = parseToETable(fullFilePath);
        for (ETable eTable : eTables) {
            resultMap.put(eTable.getaClass(), parseBean(eTable));
        }
        return resultMap;
    }


    public File readFile(String filePath) {
        return new File(filePath);
    }
}
