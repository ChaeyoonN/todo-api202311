package com.example.todo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HealthCheckController {

    /*
      - 로드 밸런서를 이용할 때, 서버의 현재 상태를 확인하기 위한 메서드를 작성하여
       응답이 제대로 리턴이 되는 지를 확인하기 위한 컨트롤러와 메서드.

      - 응답이 제대로 전달되지 않는다면 서버에 장애가 발생했다고 가정하여
       로드 밸런서가 사본 인스턴스로 요청을 전환하여 계속해서 서비스가 제공되도록 유도함.
     */

    @GetMapping("/")
    public ResponseEntity<?> healthCheck() {
        log.info("server is running.... I'm Healthy!");
        log.info("Hello World!");
        return ResponseEntity.ok().body("It's OK~!");
    }

}