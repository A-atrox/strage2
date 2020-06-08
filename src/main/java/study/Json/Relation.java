package study.Json;

import lombok.Data;

import java.util.UUID;

/**
 * @创建人 guoyf
 * @创建时间 2020/6/2
 * @描述
 */
@Data
public class Relation {
    private int id;
    private String type;
    private String uid;
    private Boolean isDirectional;
    private String base;
    private String relation;
    private  String properties;
    private String model_id;
}
