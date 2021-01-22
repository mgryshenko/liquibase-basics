package com.mgryshenko.liquibasetest.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mgryshenko.liquibasetest.model.Message;
import com.mgryshenko.liquibasetest.repo.MessageRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class MessageController {

    private final MessageRepository repository;

    @Autowired
    public MessageController(MessageRepository repository) {
        this.repository = repository;
    }

    @PostMapping(value = "/message", produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody Message post(@RequestBody ContentDto dto) {
        return repository.save(Message.fromContent(dto.getContent()));
    }

    @GetMapping(value = "/message/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody Message get(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @GetMapping(value = "/message", produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody List<Message> getAll() {
        return repository.findAll();
    }

    @PatchMapping(value = "/message/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody Message patch(@PathVariable Long id, @RequestBody ContentDto dto) {
        Message entity = repository.findById(id).get();
        entity.setContent(dto.getContent());
        entity.setUpdated(new Date());
        return repository.save(entity);
    }

    @DeleteMapping(value = "/message/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody Message delete(@PathVariable Long id) {
        Message entity = repository.findById(id).get();
        repository.delete(entity);
        return entity;
    }
    
    @Data
    public static class ContentDto {
        @JsonProperty("content")
        private String content;
    }
}
