package smt.reflec;

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
    private String price;
    private int num;
}
