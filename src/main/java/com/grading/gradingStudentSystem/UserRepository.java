package com.grading.gradingStudentSystem;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository

public interface UserRepository extends CrudRepository<UserEntity, Integer> {


    List<UserEntity> findByFirstNameAndLastName(String firstName, String lastName);
    UserEntity findById(int id);


}
