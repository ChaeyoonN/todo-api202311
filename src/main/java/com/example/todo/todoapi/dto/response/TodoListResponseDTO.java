package com.example.todo.todoapi.dto.response;

import lombok.*;

import java.util.List;

@Setter @Getter
@ToString @EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoListResponseDTO {

    private String error; // 에러 발생 시 에러 메세지를 담을 필드
    private List<TodoDetailResponseDTO> todos;

}









