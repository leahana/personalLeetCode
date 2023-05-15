package y2023.m5.day12;

public interface RetryFunction<T> {
    T apply() throws Exception;
}
