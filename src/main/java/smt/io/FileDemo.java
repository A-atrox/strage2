package smt.io;

import java.io.File;
import java.io.IOException;

/**
 * @author guoyf
 * @Date 2020/8/3
 * @describe
 */
public class FileDemo {
    /***
     * 唯一的与文件的类    关联一个文件路径，该文件可能不存在
     * 编写路径时如果经常写\\ 或者//会显得特别麻烦  所以引入了File.separator
     */
    private static File file = new File("D:"+File.separator+"demo.txt");
    static {

        if (!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
    }
    public static void main(String[] args) {
       FileDemo.createOrDeleteFile(file);
    }
    public static void createOrDeleteFile(File file){
        try {
            if(file.exists()){
                System.out.println("文件存在，执行删除操作");
                file.delete();
            }else{
                System.out.println("文件不存在执行创建");
                System.out.println(file.createNewFile());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
