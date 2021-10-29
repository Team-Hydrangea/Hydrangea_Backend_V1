package com.su.hydrangea.domain.user.repository;

import com.su.hydrangea.domain.user.entity.Bookmark;
import org.springframework.data.repository.CrudRepository;

public interface BookmarkRepository extends CrudRepository<Bookmark, Long> {
}
