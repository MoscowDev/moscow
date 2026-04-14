package com.api_integration.moscow.controllers;



import com.api_integration.moscow.dtos.responses.ProcessedResponse;
import com.api_integration.moscow.service.ClassificationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ClassificationController {

    private final ClassificationService service;

    public ClassificationController(ClassificationService service) {
        this.service = service;
    }

    @GetMapping("/classify")
    public ProcessedResponse classify(@RequestParam String name) {
        return service.classify(name);
    }
}