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
public class Box extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bid")
    private Long bid;

    @Column(name = "name", length = 50, nullable = false)
    private String name;
    
    @Column(name = "event_start_date", nullable = false)
    private LocalDateTime eventStartDate;
    
    @Column(name = "event_end_date", nullable = false)
    private LocalDateTime eventEndDate;

    @Column(name = "upload_date")
    private LocalDateTime uploadDate;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "boom_date")
    private LocalDateTime boomDate;

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
    
}