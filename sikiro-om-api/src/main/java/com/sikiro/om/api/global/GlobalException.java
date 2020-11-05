package com.sikiro.om.api.global;

import com.sikiro.om.infrastructure.base.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@SuppressWarnings({"ALL", "AlibabaClassMustHaveAuthor"})
@ControllerAdvice
@Slf4j
public class GlobalException {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseEntity<ApiResult> handle(Exception e) {
        log.error("全局异常捕获", e);
        ApiResult result = ApiResult.Error("服务器正在开小差~请稍后重试~");
        return new ResponseEntity(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity<ApiResult> handle(MethodArgumentNotValidException e) {
        StringBuilder sb = new StringBuilder(32);
        e.getBindingResult().getAllErrors().forEach(item -> {
            sb.append(item.getDefaultMessage() + "\r\n");
        });
        ApiResult result = ApiResult.Failed(sb.toString());
        return new ResponseEntity<ApiResult>(result, HttpStatus.BAD_REQUEST);
    }
}
