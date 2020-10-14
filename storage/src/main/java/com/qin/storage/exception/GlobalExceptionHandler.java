package com.qin.storage.exception;

import com.qin.common.domain.Result;
import com.qin.common.enums.ResultCodeEnum;
import com.qin.common.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collection;

/**
 * @author qinch
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理表单参数验证异常
     * @param ex
     * @return
     */
    @ExceptionHandler(value = BindException.class)
    public Result handleBindException(BindException ex) {
        Collection<FieldError> errors = ex.getBindingResult().getFieldErrors();
        LOGGER.error("handleBindException", ex);
        return new Result(ResultCodeEnum.INVALID_PARAM.getCode(),null, errors.iterator().next().getDefaultMessage());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result handleBindException(MethodArgumentNotValidException ex) {
        LOGGER.error("handleBindException", ex);
        return new Result(ResultCodeEnum.INVALID_PARAM.getCode(),null, ex.getBindingResult().getFieldError().getDefaultMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    public Result exceptionHandler(Exception ex){
        LOGGER.error(ex.getMessage(), ex);
        return Result.error("系统发生错误");
    }

    @ExceptionHandler(value = BusinessException.class)
    public Result businessExceptionHandler(BusinessException e){
        LOGGER.error("error code:{},error msg:{}",e.getCode(), e.getMsg());
        return new Result(e.getCode(), null, e.getMsg());
    }
}
