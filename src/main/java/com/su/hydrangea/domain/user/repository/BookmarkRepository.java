package com.su.hydrangea.domain.user.repository;

import com.su.hydrangea.domain.user.entity.Bookmark;
import com.su.hydrangea.domain.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookmarkRepository extends CrudRepository<Bookmark, Long> {

    void deleteByLongitudeAndLatitudeAndUser(double latitude, double longtitude, User user);
    Page<Bookmark> findByUserId(long user_id, Pageable pageable);

}
