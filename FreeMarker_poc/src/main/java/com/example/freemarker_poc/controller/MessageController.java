package com.example.freemarker_poc.controller;

import com.example.freemarker_poc.entity.MessageTemplate;
import com.example.freemarker_poc.repository.MessageTemplateRepository;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/message")
@AllArgsConstructor
public class MessageController {

    Configuration config;
    Configuration config2;


MessageTemplateRepository messageRepo;


@GetMapping("/freemarker/{id}")
    public String getMsg(@PathVariable("id")Integer id) throws IOException, TemplateException {

        /// retrive any template
    Optional<MessageTemplate> returnedTemplate= messageRepo.findById(id);

    //extrct the content
    String content= returnedTemplate.get().getContent();

    //still dont know what is the purpose of config2

    Template template= new Template("hi",new StringReader(content),config2);

    StringWriter writer= new StringWriter();

    //here we need to have the name of the paramter -> ${param1} and then map it to its value(retrive it from somewhere)
    Map<String,Object> model= new HashMap<>();
    model.put("param1",returnedTemplate.get().getParam1());
    model.put("param2",returnedTemplate.get().getParam2());
    Integer age=9;
    model.put("condition",(age<0));

    //replacemnt of every ${param} to its value and put the result inside writer
    template.process(model, writer);

    return writer.toString();
    }

    @PostMapping("/add")
    public void addTemplate(@RequestBody MessageTemplate template){
        messageRepo.save(template);


    }



}
