package top.syhan.vlog.test;

import java.io.File;

/**
 * @program: vlog-api
 * @description:
 * @author: SYH
 * @create: 2022-04-23 20:26
 **/
public class Test {
    public static void main(String[] args) {
        search("D:/test/");
    }

    public static void search(String path) {
        File dir = new File(path);
        File[] subFiles = dir.listFiles();
        if (null != subFiles) {
            for (File subFile : subFiles) {
                String fileName = subFile.getName();
                if (subFile.isFile()) {
                    if ((fileName.endsWith(".jpg") || fileName.endsWith(".png"))) {
                        System.out.println(subFile.getName());
                    }
                }
            }
        }
    }
}
