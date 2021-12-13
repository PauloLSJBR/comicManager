package org.zup.paulo.comicmanager.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zup.paulo.comicmanager.domain.Comic;
import org.zup.paulo.comicmanager.repositories.interfacesJPA.ComicRepositoryJPA;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Repository
public class ComicRepository {

    @Autowired
    private ComicRepositoryJPA repositoryJPA;

    @Autowired
    private DataSource dataSource;

    public List<Comic> findAll() {
        return repositoryJPA.findAll();
    }

    public Comic findById(Long id) {
        return repositoryJPA.findById(id).get();
    }

    public Comic save(Comic comic) {
        return repositoryJPA.save(comic);
    }

    public void deleteById(Long id) {
        repositoryJPA.deleteById(id);
    }

}
