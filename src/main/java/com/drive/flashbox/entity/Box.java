package com.drive.flashbox.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "box")
public class Box {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bid")
    private Long bid;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "upload_date")
    private LocalDateTime uploadDate;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "deleted_date")
    private LocalDateTime deletedDate;

    // Box를 만든(혹은 소유한) User
    @ManyToOne
    @JoinColumn(name = "uid", nullable = false)
    private User user;

    // 박스에 등록된 사진들 (1:N)
    @OneToMany(mappedBy = "box", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Picture> pictures = new ArrayList<>();

    // 박스 - 사용자 중간 테이블 매핑 (1:N)
    @OneToMany(mappedBy = "box", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<BoxUser> boxUsers = new ArrayList<>();

    @Builder
    public Box(String name,
               LocalDateTime uploadDate,
               LocalDateTime createdDate,
               LocalDateTime deletedDate,
               User user) {
        this.name = name;
        this.uploadDate = uploadDate;
        this.createdDate = createdDate;
        this.deletedDate = deletedDate;
        this.user = user;
    }

    // 편의 메서드
    public void addPicture(Picture picture) {
        this.pictures.add(picture);
    }

    public void addBoxUser(BoxUser boxUser) {
        this.boxUsers.add(boxUser);
    }
}