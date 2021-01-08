package ru.itis.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.itis.models.Review;

public interface ReviewRepository extends MongoRepository<Review, String> {
}
