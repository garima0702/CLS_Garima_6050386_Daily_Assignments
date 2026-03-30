package com.example.Assignment7.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Assignment7.entities.Trainee;
import com.example.Assignment7.services.ITraineeService;

@RestController
//@RequestMapping("/trainees")

public class TraineeController {
	
	@Autowired
	ITraineeService iTraineeService;
	
	@GetMapping("/trainees")
	public ResponseEntity<List<Trainee>> getAllTrainees() {
	    List<Trainee> list = iTraineeService.getAllTrainees();
	    return ResponseEntity.ok(list);
	}
	
	
	@GetMapping("/trainees/{id}")
	public ResponseEntity<Trainee> findByTraineeId(@PathVariable int id) {
	    Trainee t = iTraineeService.findByTraineeId(id);
	    return ResponseEntity.ok(t);
	}

    @GetMapping("/trainees/ByTraineeName")
    public ResponseEntity<Trainee> findBytraineeName(@RequestParam("name") String name) {
        Trainee trainee = iTraineeService.findByTraineeName(name);
            return ResponseEntity.ok(trainee);
        }

    @PostMapping("/trainees")
    public ResponseEntity<Trainee> addTrainee(@RequestBody Trainee trainee) {
        Trainee saved = iTraineeService.addTrainee(trainee);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping("/trainees/{id}")
    public ResponseEntity<Trainee> updateTrainee(@PathVariable int id, @RequestBody Trainee trainee) {
        iTraineeService.updateTrainee(id, trainee);
            return ResponseEntity.ok(trainee);
      
    }
    
    @DeleteMapping("/trainees/{id}")
    public ResponseEntity<String> deleteTrainee(@PathVariable int id) {
        iTraineeService.deleteTrainee(id);
        return ResponseEntity.ok("Trainee deleted successfully");
    }
}
    
	



