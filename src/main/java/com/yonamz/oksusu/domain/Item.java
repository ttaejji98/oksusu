package com.yonamz.oksusu.domain;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;



@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long item_no;

    @Column
    private String title;
    @Column
    private String writer;
    @Column
    private String content;
    @Column
    private int starting;
    @Column
    private Date deadline;

    @Builder
    public Item(Long item_no, String title, String writer, String content, int starting, Date deadline) {
        this.item_no = item_no;
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.starting = starting;
        this.deadline = deadline;
    }
}
