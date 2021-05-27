package com.schoolcoin.app.service;

import com.schoolcoin.app.dao.GradeRepository;
import com.schoolcoin.app.dto.GradeDto;
import com.schoolcoin.app.mapper.GradeMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService{

    private final GradeMapper mapper = GradeMapper.MAPPER;

    private final GradeRepository gradeRepository;

    public GradeServiceImpl(GradeRepository gradeRepository){
        this.gradeRepository = gradeRepository;
    }

    @Override
    public List<GradeDto> getAll(){
        return mapper.fromGradeList(gradeRepository.findAll());
    }
}
