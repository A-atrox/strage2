package smt.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author guoyf
 * @Date 2020/8/5
 * @describe
 */
public class ReflecDemo {
    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("smt.reflect.Brand");
            Constructor[] constructors = clazz.getConstructors();
            for (Constructor c:constructors){
                System.out.println(c.getName());
            }
            Method [] methods= clazz.getDeclaredMethods();
            for(Method m:methods){
                System.out.println(m);
            }
            Field[] fields  = clazz.getDeclaredFields();
            for(Field f:fields){
                System.out.println(f);
            }
            Constructor c = clazz.getDeclaredConstructor(String.class,String.class,String.class,double.class,int.class);
            Brand b1 = (Brand) c.newInstance("NO.1","小米","/url/image",1.0,10);
            System.out.println(b1.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
