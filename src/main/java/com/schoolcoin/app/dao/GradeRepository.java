package com.schoolcoin.app.dao;

import com.schoolcoin.app.domain.grades.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade, Long> {
}
