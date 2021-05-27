package com.schoolcoin.app.mapper;

import com.schoolcoin.app.domain.grades.Grade;
import com.schoolcoin.app.dto.GradeDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface GradeMapper {
    GradeMapper MAPPER = Mappers.getMapper(GradeMapper.class);

    Grade toGrade(GradeDto dto);
    @InheritInverseConfiguration
    GradeDto fromGrade(Grade grade);

    List<Grade> toGradeList(List<GradeDto> gradeDtos);
    List<GradeDto> fromGradeList(List<Grade> grades);
}
