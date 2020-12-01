package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.models.Review;
import ru.itis.repository.ReviewRepository;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public Review reply(Long id) {
        Review review = reviewRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        review.reply();
        reviewRepository.save(review);
        return review;
    }
}
