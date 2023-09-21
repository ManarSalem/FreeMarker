package com.example.freemarker_poc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class MessageTemplate {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String content;// "hello ${param1}, you purchase ${param2}" or "your age is ${param1} and your name is ${param2}"
    private String param1;
    private String param2;// represent anything
}
