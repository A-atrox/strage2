package smt.reflect;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author guoyf
 * @Date 2020/8/10
 * @describe
 */
@Component
@Data
public class Brand {
    private String id;
    private String name;
    private String imageUrl;
    private double price;
    private int num;

    public Brand(String id,String name,String imageUrl,double price,int num){
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.price = price;
        this.num = num;
        System.out.println("执行了有参构造方法");
    }
    @Override
    public String toString() {
        return "我是一个名叫 "+name+" 的商品目前存货还有 "+num+" 价格为 "+price+" 元";
    }
}
