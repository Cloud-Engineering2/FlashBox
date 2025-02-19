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

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "upload_date", nullable = false)
    private LocalDateTime uploadDate;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

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
                   String imageUrl,
                   User user,
                   Box box) {
        this.name = name;
        this.uploadDate = uploadDate;
        this.imageUrl = imageUrl;
        this.user = user;
        this.box = box;
    }
}