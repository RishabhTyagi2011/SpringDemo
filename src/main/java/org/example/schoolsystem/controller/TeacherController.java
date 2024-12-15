package org.example.schoolsystem.controller;

import java.util.List;
import org.example.schoolsystem.entity.Details;
import org.example.schoolsystem.service.DetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("hasRole('TEACHER')")
@RequestMapping("/teacher")
public class TeacherController {

  @Autowired
  private DetailsService detailsService;

  @GetMapping("/{id}")
  public ResponseEntity<Details> getStudentData(@PathVariable Long id) {
    return new ResponseEntity<>(this.detailsService.getDetails(id), HttpStatus.OK);
  }

  @GetMapping("/data")
  public ResponseEntity<List<Details>> getAllData() {
    return new ResponseEntity<>(this.detailsService.getAllDetails(), HttpStatus.OK);
  }
}




