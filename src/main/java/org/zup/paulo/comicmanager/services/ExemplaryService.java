package org.zup.paulo.comicmanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zup.paulo.comicmanager.domain.Comic;
import org.zup.paulo.comicmanager.domain.Exemplary;
import org.zup.paulo.comicmanager.domain.User;
import org.zup.paulo.comicmanager.domain.builders.UserBuilder;
import org.zup.paulo.comicmanager.exceptions.ExemplaryNotFoundException;
import org.zup.paulo.comicmanager.repositories.ComicRepository;
import org.zup.paulo.comicmanager.repositories.UserRepository;
import org.zup.paulo.comicmanager.repositories.interfacesJPA.ExemplaryRepositoryJPA;
import org.zup.paulo.comicmanager.representations.ComicRequest;
import org.zup.paulo.comicmanager.services.interfaces.ExemplaryServiceAPI;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExemplaryService implements ExemplaryServiceAPI {

    @Autowired
    private ExemplaryRepositoryJPA repositoryJPA;

    @Autowired
    private ComicRepository comicRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MarvelService serviceMarvel;

    @Transactional
    public Exemplary cadastra(ComicRequest comicRequest) {

        try {
            User user = userRepository.findById(comicRequest.getUserId());

            Comic comic = comicRepository.findById(comicRequest.getComicId());

            if (comic == null) {
                comic = serviceMarvel.findComic(comicRequest.getComicId());
                comicRepository.save(comic);
            }

            Exemplary exemplary = new Exemplary(comic, user);

            repositoryJPA.save(exemplary);
            return exemplary;

        }catch (Exception ex){
            throw new ExemplaryNotFoundException(String.format("Erro ao tentar criar um exemplar "));
        }

    }

        @Transactional(readOnly = true)
    public List<Comic> getByUser(Long userId){

        List<Exemplary> exemplaries = repositoryJPA.findByUser(new UserBuilder().id(userId).build());

        return exemplaries.stream().map(e -> e.getComic()).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Exemplary get(Long id){

        try {
            Exemplary exemplary = repositoryJPA.findById(id).get();
            return exemplary;
        } catch (Exception ex) {
            throw new ExemplaryNotFoundException(String.format("Exemplar não existe com esse id: %s ", id));
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Exemplary> findAll() {

        return repositoryJPA.findAll();
    }

    @Override
    @Transactional(readOnly = false)
    public Exemplary create(Exemplary exemplary) {

        return repositoryJPA.save(exemplary);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(Exemplary exemplary) {
        repositoryJPA.save(exemplary);
    }

    @Override
    @Transactional(readOnly = false)
    public void remove(Long id) {
        repositoryJPA.deleteById(id);
    }

 }
