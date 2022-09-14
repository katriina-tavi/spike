package org.song.spike.sso.config.exception;

import lombok.extern.slf4j.Slf4j;
import org.song.spike.sso.dto.Result;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @description: 统一异常处理
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {



    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result<String> handleException(Exception ex, HttpServletResponse response) {
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return Result.setErrorMsg(ex.getMessage());
    }

    /**
     * API异常调用
     * @return
     */
//    @ResponseBody
//    @ExceptionHandler(ApiException.class)
//    public Result<String> serviceValidException(ApiException ex, HttpServletResponse response) {
//        return Result.setErrorMsg(ex.getMessage());
//    }

    /**
     * Valid Controller异常处理
     * @param e 异常体
     * @return
     */
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<String> controllerValidException(MethodArgumentNotValidException e, HttpServletResponse response){
        return Result.setErrorMsg(Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage());
    }

    /**
     * Valid Service异常处理
     * @param e 异常体
     * @return
     */
//    @ResponseBody
//    @ExceptionHandler(ConstraintViolationException.class)
//    public Result<String> serviceValidException(ConstraintViolationException e, HttpServletResponse response) {
//        // 迭代取第一个异常信息返回
//        return Result.setErrorMsg(e.getConstraintViolations().iterator().next().getMessage());
//    }

    /**
     * 参数校验异常
     */
    @ResponseBody
    @ExceptionHandler(IllegalArgumentException.class)
    public Result<String> illegalArgumentException(IllegalArgumentException ex, HttpServletResponse response) {
        return Result.setErrorMsg(ex.getMessage());
    }
}
