package com.personal.projects.videostreaming.controllers;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.MediaTypeFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {
    @GetMapping("video/{fileName}")
    public ResponseEntity<Resource> streamVideoFile(@PathVariable String fileName) {
        Resource file = new ClassPathResource(fileName);
        return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT)
                             .contentType(MediaTypeFactory.getMediaType(file)
                                                          .orElse(MediaType.APPLICATION_OCTET_STREAM))
                             .body(file);
    }
}
