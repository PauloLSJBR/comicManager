package org.zup.paulo.comicmanager.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zup.paulo.comicmanager.domain.Exemplary;
import org.zup.paulo.comicmanager.domain.User;
import org.zup.paulo.comicmanager.repositories.interfacesJPA.ExemplaryRepositoryJPA;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Repository
public class ExemplaryRepository {

    @Autowired
    private ExemplaryRepositoryJPA repositoryJPA;

    @Autowired
    private DataSource dataSource;

    public List<Exemplary> findAll() {
        return repositoryJPA.findAll();
    }

    public List<Exemplary> findByUser(User user){ return repositoryJPA.findByUser(user);}

    public Exemplary save(Exemplary exemplary) {
        return repositoryJPA.save(exemplary);
    }

    public void deleteById(Long id) {
        repositoryJPA.deleteById(id);
    }

}
