package com.yonamz.oksusu.controller;

import com.yonamz.oksusu.domain.Item;
import lombok.*;

import java.sql.Date;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ItemForm {

    private Long item_no;
    private String writer;
    private String title;
    private String content;
    private Date deadline;
    private int starting_bid;
    private int cnt;

    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public Item toEntity(){
        Item build = Item.builder()
                .item_no(item_no)
                .writer(writer)
                .title(title)
                .content(content)
                .starting_bid(starting_bid)
                .deadline(deadline)
                .cnt(cnt)
                .build();
        return build;
    }

    @Builder
    public ItemForm(Long item_no, String writer, String title, String content, Date deadline, int starting_bid, int cnt, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.item_no = item_no;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.deadline = deadline;
        this.starting_bid = starting_bid;
        this.cnt = cnt;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
