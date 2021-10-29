package com.su.hydrangea.domain.user.repository;

import com.su.hydrangea.domain.user.entity.Bookmark;
import com.su.hydrangea.domain.user.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface BookmarkRepository extends CrudRepository<Bookmark, Long> {

    void deleteByLongitudeAndLatitudeAndUser(double latitude, double longtitude, User user);
}
