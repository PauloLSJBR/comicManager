package org.zup.paulo.comicmanager.services.interfaces;

import org.zup.paulo.comicmanager.domain.Comic;
import org.zup.paulo.comicmanager.domain.representations.ComicRequest;
import org.zup.paulo.comicmanager.domain.representations.ComicUpdate;

import java.util.List;

public interface ComicServiceAPI {

    public Comic get(Long id);

    public List<Comic> findAll();

    public Comic create(Comic comic);

    public void update(ComicUpdate comicUpdate);

    public void remove(Long id);

    public Comic createMarvel(ComicRequest comicRequest);
}
