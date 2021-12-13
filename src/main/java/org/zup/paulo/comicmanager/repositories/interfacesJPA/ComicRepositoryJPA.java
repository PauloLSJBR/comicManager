package org.zup.paulo.comicmanager.repositories.interfacesJPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zup.paulo.comicmanager.domain.Comic;

@Repository
public interface ComicRepositoryJPA extends JpaRepository<Comic, Long> {

}