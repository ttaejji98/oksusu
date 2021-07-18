package com.yonamz.oksusu.repository;

import com.yonamz.oksusu.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ItemRepository extends JpaRepository<Item, Long> {

    @Modifying
    @Query("update Item i set i.cnt = i.cnt + 1 where i.item_no = :item_no")
    int updateCount(@Param("item_no") Long item_no);

}

