package org.zup.paulo.comicmanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zup.paulo.comicmanager.domain.Comic;
import org.zup.paulo.comicmanager.domain.representations.ComicRequest;
import org.zup.paulo.comicmanager.domain.representations.ComicUpdate;
import org.zup.paulo.comicmanager.exceptions.ComicNotFoundException;
import org.zup.paulo.comicmanager.repositories.ComicRepository;
import org.zup.paulo.comicmanager.repositories.ExemplaryRepository;
import org.zup.paulo.comicmanager.services.interfaces.ComicServiceAPI;

import java.util.List;

@Service
public class ComicService implements ComicServiceAPI {

    @Autowired
    private ComicRepository comicRepository;

    @Autowired
    private MarvelService serviceMarvel;

    @Autowired
    private ExemplaryRepository examplaryRepository;

    @Override
    @Transactional(readOnly = true)
    public Comic get(Long id){
        try {
            Comic comic = comicRepository.get(id);
            return comic;
        } catch (Exception ex) {
            throw new ComicNotFoundException(String.format("Quadrinho não existe com esse id: %s ", id));
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Comic> findAll() {

        return comicRepository.findAll();
    }

    @Override
    @Transactional
    public Comic create(Comic comic) {

        return comicRepository.save(comic);
    }

    @Override
    @Transactional
    public Comic createMarvel(ComicRequest comicRequest) {

        Comic comic = comicRepository.findById(comicRequest.getComicId());

        if (comic == null) {
            comic = serviceMarvel.findComic(comicRequest.getComicId());
            comic = comicRepository.save(comic);
        }

        return comic;
    }

    @Override
    @Transactional
    public void update(ComicUpdate comicUpdate) {

        if(comicRepository.findById(comicUpdate.getComicId()) == null) {
            throw new ComicNotFoundException(String.format("Quadrinho com comicID = %s não existe", comicUpdate.getComicId()));
        }
        comicRepository.save(new Comic(comicUpdate));
    }

    @Override
    @Transactional
    public void remove(Long id) {
        comicRepository.deleteById(id);
    }

}


