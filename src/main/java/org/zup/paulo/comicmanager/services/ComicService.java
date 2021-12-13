package org.zup.paulo.comicmanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zup.paulo.comicmanager.domain.Comic;
import org.zup.paulo.comicmanager.exceptions.ComicNotFoundException;
import org.zup.paulo.comicmanager.repositories.ExemplaryRepository;
import org.zup.paulo.comicmanager.repositories.interfacesJPA.ComicRepositoryJPA;
import org.zup.paulo.comicmanager.services.interfaces.ComicServiceAPI;

import java.util.List;

@Service
public class ComicService implements ComicServiceAPI {

    @Autowired
    private ComicRepositoryJPA repositoryJPA;

    @Autowired
    private MarvelService serviceMarvel;

    @Autowired
    private ExemplaryRepository examplaryRepository;

    @Transactional(readOnly = true)
    public Comic get(Long id){

        try {
            Comic comic = repositoryJPA.findById(id).get();
            return comic;
        } catch (Exception ex) {
            throw new ComicNotFoundException(String.format("Quadrinho não existe com esse id: %s ", id));
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Comic> findAll() {

        return repositoryJPA.findAll();
    }

    @Override
    @Transactional
    public Comic create(Comic comic) {
        return repositoryJPA.save(comic);
    }

    @Transactional
    public Comic createMarvel(Comic comic) {

        Comic comicM = serviceMarvel.findComic(comic.getComicId());

        return repositoryJPA.save(comicM);
    }


    @Override
    @Transactional
    public void update(Comic comic) {
        repositoryJPA.save(comic);
    }

    @Override
    @Transactional
    public void remove(Long id) {
        repositoryJPA.deleteById(id);
    }

}


