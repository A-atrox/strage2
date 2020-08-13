package smt.annotation;

/**
 * @author guoyf
 * @Date 2020/8/13
 * @describe
 */
public enum SexEnum{
    /***
     * 女
     */
    WOMEN(0,"女"),
    /***
     * 男
     */
    MAN(1,"男");




    private int code;
    private String despertion;

    SexEnum(int code, String despertion) {
        this.code = code;
        this.despertion = despertion;
    }
}
