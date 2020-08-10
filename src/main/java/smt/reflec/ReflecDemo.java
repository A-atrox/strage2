package smt.reflec;

import java.lang.reflect.Constructor;
/**
 * @author guoyf
 * @Date 2020/8/5
 * @describe
 */
public class ReflecDemo {
    public static void main(String[] args) {
        try {
            Class demo = Class.forName("Brand");
            Constructor constructor = demo.getConstructor();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
