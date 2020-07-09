package study.Strem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
/**
 * @创建人 guoyf
 * @创建时间 2020/5/27
 * @描述
 */
public class StremTest {
    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(10);
//        list.add(6);
//        list.add(7);
//        list.add(5);
//        list = list.stream().filter(v -> v >6).collect(Collectors.toList());
//        System.out.println(list);
        String str = "Hello Java. Java is a language.";
        System.out.println(str.replace("Java.", "c++"));//打印 Hello c++ Java is a language.
        System.out.println(str.replaceAll("Java.", "c++"));//打印 Hello c++ c++is a language.
    }
    Object object = new Object();
}
