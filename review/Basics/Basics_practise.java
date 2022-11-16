package Basics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Predicate;

public class Basics_practise {
    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
//        System.out.println(a);

//        int [] arr = {100,200,300,400};
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }

//        Student student = new Student(20,"张朝证");
//        System.out.println(student.age);
//
//        char[] chs = {'a', 'b', 'c'};
//        String s2 = new String(chs);
//        System.out.println("s2:" + s2);

//        String a = "张朝证";
//        String b = "张朝证  ";
//        System.out.println(a.equals(b));

//        Random a = new Random();
//        System.out.println(a.nextInt(1222));

//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//        for (int i = 0; i < s.length(); i++) {
//            char a = s.charAt(i);
//            System.out.println(a);
//        }
//        StringBuilder sb = new StringBuilder("abc");
//        sb.append("def");
//        System.out.println(sb.reverse());
//        String ss = sb.toString();
//        System.out.println(ss);

//        ArrayList<String> s= new ArrayList<String>();
//        s.add("a");
//        s.add("b");
//        s.remove(0);
//        System.out.println(s.get(0));
//        Studeng_son ss = new Studeng_son(20,"abc");
//        ss.show();
//        jumping s = new Studeng_son(20,"abc");
//        s.jumping();
//        s.show();

//        abstract_class a  = new abstract_test();
//        a.show();

//        Studeng_son ss = new Studeng_son(20,"abc");
//        ss.jumping();
//        String s = "1000";
//        String s2= "张朝证";
//        Integer i = Integer.valueOf(200);
//        System.out.println(i);

//        int number = 100;
////        String s= String.valueOf(number);
////        int a = Integer.parseInt(s);
////        System.out.println(a);
//        File file = new File("E:\\java\\敲\\文本.txt");
//        System.out.println(file.createNewFile());
//        System.out.println(file.getName());
//        System.out.println(file.getPath());


//        File file = new File("E:\\java\\敲\\文件夹");
//        getfile(file);

//        FileOutputStream fileOutputStream = new FileOutputStream("E:\\java\\敲\\文件夹\\文本1.txt");
//        fileOutputStream.write(222);
//        fileOutputStream.close();

//        byte [] b = "abcde".getBytes(StandardCharsets.UTF_8);
//        FileOutputStream fileOutputStream = new FileOutputStream("E:\\java\\敲\\文件夹\\文本1.txt");
//        fileOutputStream.write(b);
//        fileOutputStream.write(b,1,3);
//        fileOutputStream.close();
//        FileInputStream fi = new FileInputStream("E:\\java\\敲\\文件夹\\文本1.txt");
//        int len;
//        while ((len = fi.read())!=-1){
//            System.out.println((char) len);
//        }
//        fi.close();

//        FileInputStream fi = new FileInputStream(new File("E:\\java\\敲\\文件夹\\文件夹1\\u=2103238786,3085821699&fm=253&fmt=auto&app=138&f=JPEG.webp"));
//        FileOutputStream fo = new FileOutputStream(new File("E:\\java\\敲\\文件夹\\文件夹2\\cat.jpg"));
//        byte[] by = new byte[1024];
//        int len;
//        while ((len = fi.read(by))!=-1){
//            fo.write(by,0,len);
//        }
//        fi.close();
//        fo.close();

        boolean b1 = checkString("helloworld", s -> s.length() > 8);
        System.out.println(b1);

    }


    private static boolean checkString(String s, Predicate<String> pre) {
        return pre.test(s);
    }
}
//    private static void getfile(File file) {
//        if(file!=null){
//            File[] files = file.listFiles();
//            for (File f: files){
//                if(f.isDirectory()){
//                    getfile(f);
//                }else {
//                    System.out.println(f.getName());
//                }
//            }
//        }
//    }
//}
