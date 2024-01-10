package com.example.todo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Getter @Setter @ToString
public class PullTest {

    private int num;

    public void testMethod() {
        System.out.println("test Method!");
    }

}