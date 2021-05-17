package com.schoolcoin.app.domain.accounts;

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
//@Table(name = "?????????") //надо указать имя таблицы, где хранятся игровые аккаунты
public class GameAccount {

    private static final String SEQ_NAME = "user_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME)
    private Long id;
    private String gameAccountName;
    private String gameAccountPassword;
    @Enumerated(EnumType.STRING)
    private GameStoreName gameStoreName;
}
