package com.drive.flash.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "user")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)  // 자동으로 생성일자 저장
public class User {
    @Id
    @Column(name = "uid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column(name = "email", nullable = true, length = 50)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    // User 엔티티 생성
    public User(String username, String email, String password) {
        this.name = username;
        this.email = email;
        this.password = password;
    }
}
