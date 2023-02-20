package com.abin.demo.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author: 啊斌
 * @Data:2023/2/8 19:18
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class HandleException extends RuntimeException{

    private String msg;
    private int code = 500;

    public HandleException(String msg){
        super(msg);
        this.msg = msg;
    }
    public HandleException(String msg,Throwable e){
        super(msg);
        this.msg = msg;
    }
    public HandleException(String msg,int code){
        super(msg);
        this.msg = msg;
        this.code = code;
    }
    public HandleException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }


}
