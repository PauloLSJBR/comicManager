package org.zup.paulo.comicmanager.repositories.interfacesJPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zup.paulo.comicmanager.domain.User;

@Repository
public interface UserRepositoryJPA extends JpaRepository<User, Long> {

    public User getById(Long id);
}
