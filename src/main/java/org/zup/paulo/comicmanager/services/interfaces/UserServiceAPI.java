package org.zup.paulo.comicmanager.services.interfaces;

import org.zup.paulo.comicmanager.domain.User;

import java.util.List;

public interface UserServiceAPI {

    public User get(Long id);

    public List<User> findAll();

    public User create(User user);

    public void update(User user);

    public void remove(Long id);
}
