package org.example.schoolsystem.service;

import java.util.List;
import org.example.schoolsystem.entity.Details;
import org.springframework.stereotype.Service;

@Service
public interface DetailsService {

  Details getDetails(final Long id);

  List<Details> getAllDetails();
}
