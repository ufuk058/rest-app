package com.rest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
public class ResponseWrapper{

    private boolean success;
    private String message;
    private Integer code;
    private Object data;

    public ResponseWrapper(String message, Object data){
        this.message=message;
        this.data=data;
        this.code= HttpStatus.OK.value();
        this.success=true;
    }

    public ResponseWrapper(String message){
        this.message=message;
        this.code= HttpStatus.OK.value();
        this.success=true;
    }

    public ResponseWrapper(String message, Integer code){
        this.message=message;
        this.code= code;
        this.success=true;
    }


}
