package com.github.data;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by hang on 16/4/24.
 */
public interface UrlDAO extends JpaRepository<UrlDO,Long> {
    UrlDO findById(Long id);
    Page<UrlDO> findByUrl(String url, Pageable pageable);
}
