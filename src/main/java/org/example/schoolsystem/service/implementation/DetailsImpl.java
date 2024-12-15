package org.example.schoolsystem.service.implementation;

import java.util.List;
import java.util.Optional;
import lombok.extern.log4j.Log4j2;
import org.example.schoolsystem.entity.Details;
import org.example.schoolsystem.repository.DetailRepository;
import org.example.schoolsystem.service.DetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

@Log4j2
@Configuration
public class DetailsImpl implements DetailsService {

  @Autowired
  private DetailRepository detailRepository;

  @Override
  public Details getDetails(final Long id) {
    log.info("Get user details by id: {}", id);
    Optional<Details> user = detailRepository.findById(id);
    return user.orElse(null);
  }


  @Override
  public List<Details> getAllDetails() {
    log.info("Get all details");
    Optional<List<Details>> detailsList = Optional.of(detailRepository.findAll());
    return detailsList.orElse(null);
  }

}
