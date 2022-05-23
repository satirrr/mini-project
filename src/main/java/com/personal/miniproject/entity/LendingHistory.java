package com.personal.miniproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "trx_lendingHistory")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LendingHistory {
    @Id
    @GenericGenerator(name = "lendingId_uuid", strategy = "uuid")
    @GeneratedValue(generator = "lendingId_uuid")
    private String lendingId;

    @ManyToOne
    private Book book;

    @ManyToOne
    private Member member;

    @CreationTimestamp
    private LocalDateTime date;
}

