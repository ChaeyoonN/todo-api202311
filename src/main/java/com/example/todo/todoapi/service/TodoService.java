package com.example.todo.todoapi.service;

import com.example.todo.todoapi.dto.request.TodoCreateRequestDTO;
import com.example.todo.todoapi.dto.response.TodoDetailResponseDTO;
import com.example.todo.todoapi.dto.response.TodoListResponseDTO;
import com.example.todo.todoapi.entity.Todo;
import com.example.todo.todoapi.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoListResponseDTO create(final TodoCreateRequestDTO requestDTO)
            throws RuntimeException {

        todoRepository.save(requestDTO.toEntity()); // 등록
        log.info("할 일 저장 완료! 제목: {}", requestDTO.getTitle());

        return retrieve(); // 조회 (메서드화: ctrl+alt+m)


    }

    public TodoListResponseDTO retrieve() {
        List<Todo> entityList = todoRepository.findAll(); // 조회
        // Todo->TodoDetailResponseDTO로 변환해야
        List<TodoDetailResponseDTO> dtoList = entityList.stream()
                .map(todo -> new TodoDetailResponseDTO((todo)))
                .collect(Collectors.toList());

        return TodoListResponseDTO.builder()
                .todos(dtoList).build();
    }


}
