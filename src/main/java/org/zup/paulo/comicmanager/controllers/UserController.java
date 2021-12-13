package org.zup.paulo.comicsmanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zup.paulo.comicsmanager.domain.User;
import org.zup.paulo.comicsmanager.representations.ComicResult;
import org.zup.paulo.comicsmanager.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/{id}/comics")
    public @ResponseBody
    HttpEntity<Object> find(@PathVariable(name = "id") Long userId) {

        List<ComicResult> comicResults = service.findComics(userId);

        if(comicResults.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(comicResults);
    }

    @GetMapping
    public @ResponseBody
    HttpEntity<Object> findAll() {

        List<User> users = service.findAll();

        if(users.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(users);
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody
    HttpEntity<User> get(@PathVariable(name = "id") Long id) {

        User user = service.get(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public @ResponseBody
    HttpEntity<User> create(@RequestBody User user) {

        User userN = service.create(user);
        return ResponseEntity.ok(userN);
    }

    @PutMapping(value = "/{id}")
    public @ResponseBody
    HttpEntity<Object> update(@PathVariable(name = "id") Long id,
                             @RequestBody User user) {

        user.setId(id);
        service.update(user);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{id}")
    public @ResponseBody
    HttpEntity<User> remove(@PathVariable(name = "id") Long id) {

        service.remove(id);
        return ResponseEntity.ok().build();
    }

}
