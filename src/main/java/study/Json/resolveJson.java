package study.Json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * @创建人 guoyf
 * @创建时间 2020/6/2
 * @描述
 */
public class resolveJson {
    public static void main(String[] args) {
        String modelJson = "{\n" +
                "\t\"objects\": [{\n" +
                "\t\t\t\"bimId\": \"9774663d-1917-4974-b8fd-ec37adeb1255-0012a4bd\",\n" +
                "\t\t\t\"type\": \"FireArea\",\n" +
                "\t\t\t\"uid\": \"aa28f81c46f141a991e94b7ff5be815a\",\n" +
                "\t\t\t\"properties\": {\n" +
                "\t\t\t\t\"FH-A-048\": 0,\n" +
                "\t\t\t\t\"FH-A-053\": 0.0,\n" +
                "\t\t\t\t\"FH-A-054\": 0.0,\n" +
                "\t\t\t\t\"FH-A-055\": 0.0,\n" +
                "\t\t\t\t\"FH-A-021\": 195.423,\n" +
                "\t\t\t\t\"FH-A-100\": [],\n" +
                "\t\t\t\t\"FH-A-029\": \"地上\",\n" +
                "\t\t\t\t\"FH-A-030\": false,\n" +
                "\t\t\t\t\"FH-A-018\": \"教学建筑\",\n" +
                "\t\t\t\t\"FH-A-017\": \"教学区\",\n" +
                "\t\t\t\t\"FH-A-020\": \"一般建筑\",\n" +
                "\t\t\t\t\"FH-A-024\": 0,\n" +
                "\t\t\t\t\"FH-A-025\": 0,\n" +
                "\t\t\t\t\"FH-A-042\": false,\n" +
                "\t\t\t\t\"FH-A-001\": \"\",\n" +
                "\t\t\t\t\"FH-A-027\": 1,\n" +
                "\t\t\t\t\"13\": \"一级\",\n" +
                "\t\t\t\t\"FH-A-012\": \"一类高层\",\n" +
                "\t\t\t\t\"FH-A-008\": \"一级\",\n" +
                "\t\t\t\t\"FH-A-011错误\": 2,\n" +
                "\t\t\t\t\"FH-A-023\": false,\n" +
                "\t\t\t\t\"FH-A-015\": true,\n" +
                "\t\t\t\t\"FH-A-006\": 0.0\n" +
                "\t\t\t}\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"bimId\": \"9c3c6779-9898-4e56-a101-8bc84566c2bc-0012c375\",\n" +
                "\t\t\t\"type\": \"Element\",\n" +
                "\t\t\t\"uid\": \"0d068ec1d3864a6a90e8fad7621e7b53\",\n" +
                "\t\t\t\"properties\": {}\n" +
                "\t\t}\n" +
                "\t],\n" +
                "\t\"relationships\": [{\n" +
                "\t\t\t\"isDirection\": false,\n" +
                "\t\t\t\"base\": [\n" +
                "\t\t\t\t\"6676b315593e456d8bf83de86eec2608\",\"88888888888888888888888\"\n" +
                "\t\t\t],\n" +
                "\t\t\t\"relation\": [\n" +
                "\t\t\t\t\"0d068ec1d3864a6a90e8fad7621e7b53\"\n" +
                "\t\t\t],\n" +
                "\t\t\t\"type\": \"FH-A-024\",\n" +
                "\t\t\t\"uid\": \"b7e12611c4704610b93fd268eb364cb9\",\n" +
                "\t\t\t\"properties\": {}\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"isDirection\": false,\n" +
                "\t\t\t\"base\": [\n" +
                "\t\t\t\t\"1fec0e7081114bef88ebeda17bcef472\"\n" +
                "\t\t\t],\n" +
                "\t\t\t\"relation\": [\n" +
                "\t\t\t\t\"b72fe969193a4b21a6f75009a5195a6d\"\n" +
                "\t\t\t],\n" +
                "\t\t\t\"type\": \"FH-A-024\",\n" +
                "\t\t\t\"uid\": \"5b9514dc748e4516a1eb613732bccdb6\",\n" +
                "\t\t\t\"properties\": {}\n" +
                "\t\t}\n" +
                "\t]\n" +
                "}";
        JSONObject jsonObject = JSONObject.parseObject(modelJson);
        JSONArray objects = jsonObject.getJSONArray("objects");
        JSONArray relationships = jsonObject.getJSONArray("relationships");

        List<Component> components = new ArrayList<>();
        List<Relation> relations = new ArrayList<>();
//        String model_id = UUID.randomUUID().toString;
        for (int i = 0; i < objects.size(); i++) {
            JSONObject subObject = objects.getJSONObject(i);
            Component component = new Component();
            component.setBimId(subObject.getString("bimId"));
            component.setType(subObject.getString("type"));
            component.setUid(subObject.getString("uid"));
            component.setProperties(subObject.getString("properties"));
//            component.setModel_id(model_id);
            components.add(component);
        }
        for (int i = 0; i < relationships.size(); i++) {
            JSONObject subObject = relationships.getJSONObject(i);
            JSONArray base = subObject.getJSONArray("base");
            for (int j = 0; j < base.size(); j++) {
                Relation relation = new Relation();
                relation.setType(subObject.getString("type"));
                relation.setUid(subObject.getString("uid"));
                relation.setIsDirectional(subObject.getBoolean("isDirection"));
                relation.setBase(base.get(j).toString());
                relation.setRelation(subObject.getString("relation"));
                relation.setProperties(subObject.getString("properties"));
//                relation.setModel_id(model_id);
                relations.add(relation);
            }
        }

        System.out.println(components.size()+"   "+components);
        System.out.println(relations.size()+"   "+relations);
    }
}
