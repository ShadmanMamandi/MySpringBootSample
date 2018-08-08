package com.grading.gradingStudentSystem;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImp {

    @Autowired
    private  UserRepository userRepository;

    private static List<UserEntity> todos = new ArrayList<UserEntity>();

    private static int todoCount = 3;

    /*static {

        todos.add(new UserEntity( "shiva", "mamandi", 1,1,1,1,1));
        System.out.println(todos.size());

        todos.add(new UserEntity( "farshid", "rad", 2,2,2,2,2));
        System.out.println(todos.size());
        System.out.println(todos);
    }*/


    public List<UserEntity> getAllUsers() {
        List<UserEntity> list = new ArrayList<>();
        userRepository.findAll().forEach(e -> list.add(e));
        return list;

    }


    public UserEntity getUserById(int id) {
        UserEntity userEntity = userRepository.findById(id);
        return userEntity;
    }



    public UserEntity addUser(UserEntity userEntity) {
        userRepository.save(userEntity);

           return userEntity;
    }


    public void updateUser(UserEntity userEntity) {
        userRepository.findById(userEntity.getId());
        userRepository.save(userEntity);

    }



    public void deleteUser(int id) {
        userRepository.deleteById(id);

    }
}
