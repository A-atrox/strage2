package study.algorithm;

public class IntResver {
    public static void main(String[] args) {
        System.out.println(IntResver(-250));
    }
    public  static int IntResver(int x){
       String i = ""+x;
       StringBuilder stringBuilder = new StringBuilder();
       char [] x1 = i.toCharArray();
       if(x1[0]=='-'){
           stringBuilder.append('-');
       }
       for(int j = x1.length-1;j>0;j--){
            stringBuilder.append(x1[j]);
       }
        if(x1[0]!='-'){
            stringBuilder.append(x1[0]);
        }
        return Integer.parseInt(stringBuilder.toString());
    }
}
