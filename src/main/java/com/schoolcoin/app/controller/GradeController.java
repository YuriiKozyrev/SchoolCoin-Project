package com.schoolcoin.app.controller;

import com.schoolcoin.app.dto.GradeDto;
import com.schoolcoin.app.service.GradeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/grades")
public class GradeController {

    private final GradeService gradeService;

    public GradeController(GradeService gradeService){
        this.gradeService = gradeService;
    }

    @GetMapping
    public String list(Model model){
        List<GradeDto> list = gradeService.getAll();
        model.addAttribute("grades", list);
        return "grades";
    }
}
