package ru.itis.services;

import ru.itis.models.Review;

public interface ReviewService {
    Review reply(Long id);
}
