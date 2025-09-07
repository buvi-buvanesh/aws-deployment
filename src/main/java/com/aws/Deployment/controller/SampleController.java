package com.aws.Deployment.controller;

import com.aws.Deployment.model.Sample;
import com.aws.Deployment.repository.SampleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("findby/{id}")
    public ResponseEntity<Sample> getSpecificUser(@PathVariable Long id) {
        return sampleRepository.findById(id)
                .map(ResponseEntity::ok)                     // If found → 200 OK + body
                .orElseGet(() -> ResponseEntity.notFound().build()); // If not found → 404
    }


    @GetMapping("/feature")
    public ResponseEntity<String> getFeature(){
        return ResponseEntity.ok("featured Branch");
    }
}
