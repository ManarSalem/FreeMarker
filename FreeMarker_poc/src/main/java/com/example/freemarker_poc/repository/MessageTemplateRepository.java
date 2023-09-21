package com.example.freemarker_poc.repository;

import com.example.freemarker_poc.entity.MessageTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageTemplateRepository extends JpaRepository<MessageTemplate,Integer> {
}
