package com.yonamz.oksusu.domain;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "item")
public class Item extends TimeEntity{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long item_no;

    @Column(length = 100, nullable = false)
    private String title;
    @Column(length = 100, nullable = false)
    private String writer;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    @Column(length = 100, nullable = false)
    private int starting_bid;
    @Column(length = 100, nullable = false)
    private Date deadline;
    @Column(length = 100, nullable = false)
    private int cnt;

    @Builder
    public Item(Long item_no, String title, String writer, String content, int starting_bid, Date deadline, int cnt) {
        this.item_no = item_no;
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.starting_bid = starting_bid;
        this.deadline = deadline;
        this.cnt = cnt;
    }

}
