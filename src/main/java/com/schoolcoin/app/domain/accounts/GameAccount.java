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
@Table(name = "game_accounts") //надо указать имя таблицы, где хранятся игровые аккаунты
public class GameAccount {

    private static final String SEQ_NAME = "game_account_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME,allocationSize = 1)
    private Long id;
    private String name;
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(name = "game_store_name")
    private GameStoreName gameStoreName;
}
