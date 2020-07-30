package study.algorithm;

/**
 * @author guoyf
 * @Date 2020/7/30
 * @describe
 */
public interface IChannel<T> {
    public T pop();
    public void push(T o);
    public Integer getSize();
}
