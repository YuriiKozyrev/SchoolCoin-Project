package com.schoolcoin.app.domain.grades;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
//@Table(name = "?????????") //надо указать имя таблицы с оценками
public class Grade {
    private static final String SEQ_NAME = "user_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME)
    private Long id;
    private int value;  //значение оценки
    @Enumerated(EnumType.STRING)
    private SchoolSubject subject; // название предмета
    private String date; //дата
    @Enumerated(EnumType.STRING)
    private GradeType gradeType; //тип оценки: в классе, за контрольную, четвертная, годовая
    private boolean hasTaken; //флаг “взят”, ну т.е. по нему уже SchoolMoney начислены или нет
    private int rate; //тариф



}
