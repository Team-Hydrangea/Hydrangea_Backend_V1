package com.su.hydrangea.domain.user.repository;

import com.su.hydrangea.domain.user.entity.Bookmark;
import com.su.hydrangea.domain.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookmarkRepository extends CrudRepository<Bookmark, Long> {

    Boolean existsByUserIdAndLongitudeAndLatitude(long user_id, Double longitude, Double latitude);
    void deleteByLongitudeAndLatitudeAndUser(Double longitude, Double latitude, User user);
    Page<Bookmark> findByUserId(long user_id, Pageable pageable);
    Boolean existsByUserId(long user_id);

}
