package ru.itis.perositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.itis.models.Skill;

public interface SkillRepository extends MongoRepository<Skill, String> {
}
