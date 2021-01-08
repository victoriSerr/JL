package ru.itis.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.itis.models.Skill;

public interface SkillRepository extends MongoRepository<Skill, String> {
}
