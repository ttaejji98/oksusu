package com.yonamz.oksusu.repository;

import com.yonamz.oksusu.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

}

