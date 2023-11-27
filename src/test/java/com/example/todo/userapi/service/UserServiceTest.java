package com.example.todo.userapi.service;

import com.example.todo.userapi.dto.request.UserRequestSignUpDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(false)
class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    @DisplayName("중복된 이메일로 회원가입을 시도하면 " +
            "RuntimeException이 발생해야 한다.")
    void validateEmailTest() {
        //given
        String email = "abc1234@naver.com";

        UserRequestSignUpDTO dto = UserRequestSignUpDTO.builder()
                .email(email)
                .password("asdasd")
                .userName("sjabdjasb")
                .build();
        //when
        //then
        // param1: 어떤 에러가 발생할지 에러 클래스를 적음.
        // param2: 에러가 발생하는 상황을 전달.
        assertThrows(RuntimeException.class,
                () -> userService.create(dto)
        );
    }

}