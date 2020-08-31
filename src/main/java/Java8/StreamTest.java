package Java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author guoyf
 * @Date 2020/8/28
 * @describe
 */
public class StreamTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList() {{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
            add(6);
        }};
        List<String> strlist = Arrays.asList("zhangSan", "liSi", "wangWu");
        List<String> intList = Arrays.asList("1", "2", "3");
        // 使用 Steam 方式进行过滤：
        List filterList = list.stream().filter(v -> v % 2 == 0).collect(Collectors.toList());
        System.out.println(filterList);

        //构造 Stream 流的方式
        Stream stream = Stream.of("a", "b", "c");

        String[] strArray = new String[]{"a", "b", "c"};
        stream = Stream.of(strArray);
        stream = Arrays.stream(strArray);
        List<String> list2 = Arrays.asList(strArray);
        stream = list2.stream();
        /***
         * Stream 流的之间的转换
         */
        // 流转array
        Stream<String> stream2 = Stream.of("a", "b", "c");
        String[] st1 = stream2.toArray(String[]::new);
        // 转换成 Collection
        List<String> list1 = stream2.collect(Collectors.toList());
        List<String> list3 = stream2.collect(Collectors.toCollection(ArrayList::new));
        Set set1 = stream2.collect(Collectors.toSet());
        Stack stack = stream2.collect(Collectors.toCollection(Stack::new));
        // 转换成String
        String str = stream.collect(Collectors.joining()).toString();
        /***
         * Stream 流的 map 使用
         */
        // 转换大写
        List<String> list4 = strlist.stream().map(String::toUpperCase).collect(Collectors.toList());
        // 转换数据类型
        List<Integer> intList2 = intList.stream().map(Integer::valueOf).collect(Collectors.toList());
        // 获取平方
        List<Integer> list5 = Arrays.asList(new Integer[]{1, 2, 3, 4, 5});
        List<Integer> list6 = list5.stream().map(n -> n * n).collect(Collectors.toList());
        System.out.println("list6 = " + list6);

        /***
         * Stream 流的 filter 使用
         */
        List<String> list7 = Arrays.asList("张三", "李四", "王五", "xuwujing");
        String result3 = list7.stream().filter(s -> "李四".equals(s)).findAny().orElse("找不到!");
        String result4 = list7.stream().filter(s -> "李二".equals(s)).findAny().orElse("找不到!");

        System.out.println("stream 过滤之后 2:" + result3);
        System.out.println("stream 过滤之后 3:" + result4);

        //通过与 mapToInt 计算和
        List<User> lists = new ArrayList<User>();
        lists.add(new User(6, "张三"));
        lists.add(new User(2, "李四"));
        lists.add(new User(3, "王五"));
        lists.add(new User(1, "张三"));
        int sum = lists.stream().filter(user -> "张三".equals(user.getName())).mapToInt(user -> user.getId()).sum();
        System.out.println(sum);

        /***
         * Stream 流的 flatMap 使用
         */
        // 从句子中得到单词
        String sentence = "This is a big pig(^(00)^)";
        List<String> list8 = new ArrayList<>();
        list8.add(sentence);
        List<String> list9 = list8.stream().flatMap(s -> Stream.of(s.split(" "))).filter(w -> w.length() > 0).collect(Collectors.toList());
        list9.forEach(System.out::println);

        //取到前2条数据
        Random rd = new Random();
        rd.ints().limit(2).forEach(System.out::println);
        // 取到前3条数据但扔掉前2条
        rd.ints().limit(3).skip(2).forEach(System.out::println);
        // 取前三条排序
        // tip 先limit后sorted效率会更高！
        rd.ints().limit(5).sorted().forEach(System.out::println);
        // peek对每个元素执行操作并返回一个新的 Stream
        Stream.of("one", "two", "three", "four").filter(e -> e.length() > 3).peek(e -> System.out.println("转换之前: " + e))
                .map(String::toUpperCase).peek(e -> System.out.println("转换之后: " + e)).collect(Collectors.toList());

        //parallelStream 是流并行处理程序的代替方法
        /***
         * 多线程异步任务的一种实现。
         */
        long count =list5.parallelStream().filter(v->{
            System.out.println(Thread.currentThread().getName());
            return  v>3;
        }).count();
        System.out.println(count);

        // max/min
        int maxWords = list9.stream().mapToInt(String::length).max().getAsInt();
        int minWords = list9.stream().mapToInt(String::length).min().getAsInt();

        // distinct 去重
        String lines = "good good study day day up";
        List<String> list14 = new ArrayList<String>();
        list14.add(lines);
        List<String> list10 = list14.stream().flatMap(line->Stream.of(line.split("")))
                .map(String::toLowerCase).distinct().sorted().collect(Collectors.toList());
        System.out.println(list10);

    }
}

class User {
    private int id;
    private String name;

    User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
