package com.drive.flashbox.entity;

import java.time.LocalDateTime;

import com.drive.flashbox.enums.RoleType;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Getter
@Entity
@Table(name = "boxuser")
public class BoxUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bid", nullable = false)
    private Box box;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uid", nullable = false)
    private User user;

    // 박스에 참여한 날짜를 저장
    @Column(nullable = false)
    private LocalDateTime participateDate;

    @Enumerated(EnumType.STRING) // Enum 값을 String으로 저장
    @Column(name = "role")
    private RoleType role;

    @Builder
    public BoxUser(Long id,
                   User user,
                   Box box,
                   LocalDateTime participateDate,
                   RoleType role) {
        this.id = id;
        this.user = user;
        this.box = box;
        this.participateDate = participateDate;
        this.role = role;
    }
}