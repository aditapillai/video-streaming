package com.personal.projects.videostreaming.controllers;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class ApplicationController {
    @GetMapping("video/{fileName}")
    public void streamVideoFile(@PathVariable String fileName , HttpServletResponse response) throws IOException {
        response.setContentType("video/mp4");
        ClassPathResource file = new ClassPathResource(fileName);
        IOUtils.copy(file.getInputStream(), response.getOutputStream());
    }
}
