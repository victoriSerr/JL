package ru.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.models.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long> {
}
