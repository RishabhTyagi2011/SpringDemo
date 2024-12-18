package org.example.schoolsystem.controller;


import org.example.schoolsystem.entity.Details;
import org.example.schoolsystem.service.DetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@RestController
@PreAuthorize("hasAnyRole('STUDENT','TEACHER')")
@RequestMapping("/student")
public class StudentController {

  @Autowired
  private DetailsService detailsService;

  @GetMapping("/{id}")
  public ResponseEntity<Details> getStudentData(@PathVariable Long id) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String authenticatedStudentUsername = authentication.getName();
    Details studentDetails = detailsService.getDetails(id);
    if (!ObjectUtils.isEmpty(studentDetails) && !authenticatedStudentUsername.equals(
        studentDetails.getUsername())) {
      return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
    return new ResponseEntity<>(studentDetails, HttpStatus.OK);
  }
}
