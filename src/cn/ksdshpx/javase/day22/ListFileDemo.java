package cn.ksdshpx.javase.day22;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/12/16
 * Time: 15:15
 * Description:获取文件夹下的所有文件以及过滤
 */
public class ListFileDemo {
    public static void main(String[] args) {
        //listFile_1();
        //listFile_2();
        //listFile_3();
        listFile_4();
    }

    private static void listFile_4() {
        File file = new File("d:\\");
        File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return !pathname.isHidden();
            }
        });
        for (File f : files) {
            System.out.println(f);
        }
    }

    private static void listFile_3() {
        File file = new File("d:\\");
        File[] files = file.listFiles();
        for (File f : files) {
            System.out.println(f);
        }
    }

    private static void listFile_2() {
        File file = new File("d:\\");
        String[] fileNames = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".java");
            }
        });
        for (String fileName : fileNames) {
            System.out.println(fileName);
        }
    }

    private static void listFile_1() {
        File file = new File("d:\\");
        String[] fileNames = file.list();
        for (String fileName : fileNames) {
            System.out.println(fileName);
        }
    }
}
