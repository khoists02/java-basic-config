package com.services.parent.repositories;

import com.services.parent.model.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface GenericRepository<T extends BaseEntity> extends JpaRepository<T, UUID>, PagingAndSortingRepository<T, UUID> {
}
