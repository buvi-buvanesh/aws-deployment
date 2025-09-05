package com.aws.Deployment.controller;

import com.aws.Deployment.model.Sample;
import com.aws.Deployment.repository.SampleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class SampleController {

    private final SampleRepository sampleRepository;

    public SampleController(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }

    @PostMapping("/add")
    public ResponseEntity<Sample> addUser(@RequestBody Sample sample){
        Sample result= sampleRepository.save(sample);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Sample>> getAllUser(){
        return ResponseEntity.ok(sampleRepository.findAll());
    }
}
