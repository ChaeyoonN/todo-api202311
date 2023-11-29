package com.example.todo.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NoRegisteredArgumentException
        extends RuntimeException {

    // 기본 생성자 + 에러 메시지를 받는 생성자
    public NoRegisteredArgumentException(String message){
        super(message);
    }

}
