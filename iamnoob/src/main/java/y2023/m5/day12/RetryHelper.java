package y2023.m5.day12;

/**
 * @Author: LeahAna
 * @Date: 2023/5/12 09:27
 * @Desc:
 */

public class RetryHelper {

    public static <T> T retry(RetryFunction<T> function, int retryCount, long retryInterval) throws Exception {
        Exception lastException = null;
        while (retryCount > 0) {
            try {
                return function.apply();
            } catch (Exception e) {
                lastException = e;
                retryCount--;
                if (retryCount == 0) {
                    throw lastException;

                } else {
                    Thread.sleep(retryInterval);
                }
            }
        }
        throw new RuntimeException("retry failed");
    }

}
