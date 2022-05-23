package com.personal.miniproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mst_member")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    @Id
    @GenericGenerator(name="memberId_generator", strategy = "uuid")
    @GeneratedValue
    private String memberId;
    private String name;
    private String address;
    private String eMail;
}
