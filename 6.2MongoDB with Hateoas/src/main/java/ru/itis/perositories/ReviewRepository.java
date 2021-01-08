package ru.itis.perositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.itis.models.Review;

public interface ReviewRepository extends MongoRepository<Review, String> {
}
