package com.drive.flashbox.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.ArrayList;
import java.util.List;

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

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    // 사용자 입장에서의 박스 리스트 (1:N)
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Box> boxes = new ArrayList<>();

    // 사용자 입장에서의 사진 리스트 (1:N)
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Picture> pictures = new ArrayList<>();

    // 사용자 - 박스 중간 테이블 매핑 (1:N)
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<BoxUser> boxUsers = new ArrayList<>();

    @Builder
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // 편의 메서드
    public void addBox(Box box) {
        this.boxes.add(box);
    }

    public void addPicture(Picture picture) {
        this.pictures.add(picture);
    }

    public void addBoxUser(BoxUser boxUser) {
        this.boxUsers.add(boxUser);
    }
}
