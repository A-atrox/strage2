package study.algorithm;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author guoyf
 * @Date 2020/7/30
 * @describe
 */
public class QueueDemo<T> implements IChannel<T> {
    private List<T> list = new LinkedList<T>();
    @Override
    public T pop() {
        if (list.size() == 0) {
            return null;
        } else {
            T pop = list.get(0);
            list.remove(0);
            return pop;
        }
    }

    @Override
    public void push(T o) {
        list.add(o);
    }

    @Override
    public Integer getSize() {
        return list.size();
    }
}
