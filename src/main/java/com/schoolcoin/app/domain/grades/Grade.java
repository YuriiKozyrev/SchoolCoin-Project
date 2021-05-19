package com.schoolcoin.app.domain.grades;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "grades") //надо указать имя таблицы с оценками
public class Grade {
    private static final String SEQ_NAME = "grade_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;

    @Column (name = "grade_value")
    private Long value;  //значение оценки
    @Enumerated(EnumType.STRING)
    private SchoolSubject subject; // название предмета
    @Column (name = "grade_date")
    @CreationTimestamp
    private LocalDateTime date; //дата
    @Enumerated(EnumType.STRING)
    @Column (name = "grade_type")
    private GradeType type; //тип оценки: в классе, за контрольную, четвертная, годовая
    @Column (name = "has_taken")
    private boolean hasTaken; //флаг “взят”, ну т.е. по нему уже SchoolMoney начислены или нет

    private Long rate; //тариф



}
