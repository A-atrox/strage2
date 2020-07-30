package study.algorithm;

/**
 * @author guoyf
 * @Date 2020/7/30
 * @describe
 */
public class StackDemo<T> implements IChannel<T> {
    private QueueDemo<T> q1 = new QueueDemo<>();
    private QueueDemo<T> q2= new QueueDemo<>();
    @Override
    public T pop() {
        while (q1.getSize()>1){
            q2.push(q1.pop());
        }
        while (q2.getSize()>0){
            q1.push(q2.pop());
        }
        return q1.pop();
    }

    @Override
    public void push(T o) {
        q1.push(o);
    }

    @Override
    public Integer getSize() {
        return q1.getSize();
    }
}
