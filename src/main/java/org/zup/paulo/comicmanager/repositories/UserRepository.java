package org.zup.paulo.comicmanager.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zup.paulo.comicmanager.domain.User;
import org.zup.paulo.comicmanager.repositories.interfacesJPA.UserRepositoryJPA;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private UserRepositoryJPA repositoryJPA;

    @Autowired
    private DataSource dataSource;

    public List<User> findAll() {
        return repositoryJPA.findAll();
    }

    public User findById(Long id) {
        return repositoryJPA.getById(id);
    }

    public User get(Long id){return repositoryJPA.findById(id).get();}

    public User save(User user) {
        return repositoryJPA.save(user);
    }

    public void deleteById(Long id) {
        repositoryJPA.deleteById(id);
    }

    public User findUserByEmailAndCpf(String email, String cpf){
        return repositoryJPA.findUserByEmailAndCpf(email, cpf);
    }
}
