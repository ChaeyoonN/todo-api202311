package com.example.todo.todoapi.repository;

import com.example.todo.todoapi.entity.Todo;
import com.example.todo.userapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, String> {

    // 특정 회원의 할 일 목록 리턴
    // SELECT * FROM tbl_todo WHERE t.user =: user_id = ?
    @Query("SELECT t FROM Todo t WHERE t.user = :user")
    List<Todo> findAllByUser(@Param("user") User user);

    // 회원이 작성한 일정의 개수를 리턴
    @Query("SELECT COUNT(*) FROM Todo t WHERE t.user = :user")
    int countByUser(@Param("user") User user);


}
