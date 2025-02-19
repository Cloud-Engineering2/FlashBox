package com.drive.flashbox.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "picture")
public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pid")
    private Long pid;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "upload_date")
    private LocalDateTime uploadDate;

    @Column(name = "deleted_date")
    private LocalDateTime deletedDate;

    // 사진을 올린 사용자
    @ManyToOne
    @JoinColumn(name = "uid", nullable = false)
    private User user;

    // 사진이 속한 박스
    @ManyToOne
    @JoinColumn(name = "bid", nullable = false)
    private Box box;

    @Builder
    public Picture(String name,
                   LocalDateTime uploadDate,
                   LocalDateTime deletedDate,
                   User user,
                   Box box) {
        this.name = name;
        this.uploadDate = uploadDate;
        this.deletedDate = deletedDate;
        this.user = user;
        this.box = box;
    }
}