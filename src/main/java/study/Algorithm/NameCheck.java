package study.Algorithm;

/**
 * @创建人 guoyf
 * @创建时间 2020/5/27
 * @描述
 */
//你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
//
//你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
public class NameCheck {
    /**
     * @描述
     * @参数 [name, typed]
     * @返回值 boolean
     * @创建人 guoyf
     * @创建时间 2020/5/27
     * @修改人和其它信息
     */
    // 1.核心while循环,如果字符一样则两个指针都加一,如果不一样,则长按键字符指针加1;
    //2.最后判断p1是否等于name的长度即可;
    //3.完结。
    public static boolean isLongPressedName(String name, String typed) {
        char[] c1 = name.toCharArray();
        char[] c2 = typed.toCharArray();

        int p1 = 0, p2 = 0;
        while (p1 < c1.length && p2 < c2.length) {
            if (c1[p1] == c2[p2]) {
                p1++;
                p2++;
            } else {
                if (p1 >= 1 && c2[p2] == c1[p1 - 1])
                    p2++;
                else return false;
            }
        }
        while (p2 < c2.length) {
            if (c2[p2] == c1[p1 - 1]) p2++;
            else return false;
        }

        return p1 == c1.length;
    }
}
