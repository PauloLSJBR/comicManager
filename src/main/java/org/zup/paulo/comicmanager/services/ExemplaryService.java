package org.zup.paulo.comicsmanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zup.paulo.comicsmanager.domain.Comic;
import org.zup.paulo.comicsmanager.domain.Exemplary;
import org.zup.paulo.comicsmanager.domain.User;
import org.zup.paulo.comicsmanager.domain.builders.UserBuilder;
import org.zup.paulo.comicsmanager.exceptions.ExemplaryNotFoundException;
import org.zup.paulo.comicsmanager.repositories.interfacesJPA.ComicRepositoryJPA;
import org.zup.paulo.comicsmanager.repositories.interfacesJPA.ExemplaryRepositoryJPA;
import org.zup.paulo.comicsmanager.repositories.interfacesJPA.UserRepositoryJPA;
import org.zup.paulo.comicsmanager.representations.ComicRequest;
import org.zup.paulo.comicsmanager.services.interfaces.ExemplaryServiceAPI;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExemplaryService implements ExemplaryServiceAPI {

    @Autowired
    private ExemplaryRepositoryJPA repository;

    @Autowired
    private ComicRepositoryJPA comicRepository;

    @Autowired
    private UserRepositoryJPA userRpository;

    @Autowired
    private MarvelService serviceMarvel;


    @Transactional
    public Exemplary cadastra(ComicRequest comicRequest) {

        User user = userRpository.getById(comicRequest.getUserId());

        Comic comic = comicRepository.getById(comicRequest.getComicId());

        if(comic == null) {
            comic = serviceMarvel.findComic(comicRequest.getComicId());

        }

        Exemplary exemplary = new Exemplary();

        exemplary.setComic(comic);
        exemplary.setUser(user);
        repository.save(exemplary);

        return exemplary;
    }

        @Transactional(readOnly = true)
    public List<Comic> getByUser(Long userId){

        List<Exemplary> exemplaries = repository.findByUser(new UserBuilder().id(userId).build());

        return exemplaries.stream().map(e -> e.getComic()).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Exemplary get(Long id){

        try {
            Exemplary exemplary = repository.findById(id).get();
            return exemplary;
        } catch (Exception ex) {
            throw new ExemplaryNotFoundException(String.format("Exemplar não existe com esse id: %s ", id));
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Exemplary> findAll() {

        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = false)
    public Exemplary create(Exemplary exemplary) {

        return repository.save(exemplary);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(Exemplary exemplary) {
        repository.save(exemplary);
    }

    @Override
    @Transactional(readOnly = false)
    public void remove(Long id) {
        repository.deleteById(id);
    }

 }
