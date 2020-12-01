package ru.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import ru.itis.models.Review;

import java.util.*;

@RepositoryRestResource
public interface ReviewRepository extends PagingAndSortingRepository<Review, Long> {

    @RestResource(path = "byStatus")
    List<Review> findAllByTeacher_IdAndStatusEquals(Long teacherId, Review.Status status);
}
