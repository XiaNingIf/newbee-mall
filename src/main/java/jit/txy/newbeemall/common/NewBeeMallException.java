package jit.txy.newbeemall.common;

/**
 * @author 唐星宇
 * @date 2022/9/16
 **/
public class NewBeeMallException extends RuntimeException {

    public NewBeeMallException() {
    }

    public NewBeeMallException(String message) {
        super(message);
    }

    /**
     * 丢出一个异常
     *
     * @param message
     */
    public static void fail(String message) {
        throw new NewBeeMallException(message);
    }

}