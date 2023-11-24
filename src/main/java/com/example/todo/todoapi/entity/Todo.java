package com.example.todo.todoapi.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter @Setter
@ToString @EqualsAndHashCode(of = "todoId")
@NoArgsConstructor @AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_todo")
public class Todo {
    @Id // 기본키 지정
    @GeneratedValue(generator = "system-uuid" ) // 값 지정
    @GenericGenerator(name = "system-uuid", strategy = "uuid") // 커스텀한 값(uuid)
    private String todoId;

    @Column(nullable = false, length = 30)
    private String title; // 할 일

    private boolean done; // 할 일 완료 여부

    @CreationTimestamp
    private LocalDateTime createDate; // 등록 시간
}
