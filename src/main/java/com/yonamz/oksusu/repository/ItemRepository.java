package com.yonamz.oksusu.repository;

import com.yonamz.oksusu.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {


}

