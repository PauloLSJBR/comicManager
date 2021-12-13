package org.zup.paulo.comicsmanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zup.paulo.comicsmanager.domain.Comic;
import org.zup.paulo.comicsmanager.domain.Exemplary;
import org.zup.paulo.comicsmanager.domain.User;
import org.zup.paulo.comicsmanager.representations.ComicRequest;
import org.zup.paulo.comicsmanager.services.ComicService;
import org.zup.paulo.comicsmanager.services.ExemplaryService;

import java.util.List;

@RestController
@RequestMapping("/comics")
@CrossOrigin
public class ComicController {

    @Autowired
    private ComicService service;

    @Autowired
    private ExemplaryService exemplaryService;

    @GetMapping
    public @ResponseBody
    HttpEntity<Object> findAll() {

        List<Comic> comics = service.findAll();

        if(comics.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(comics);
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody
    HttpEntity<Comic> get(@PathVariable(name = "id") Long id) {

        Comic comic = service.get(id);
        return ResponseEntity.ok(comic);
    }

    @PostMapping
    public @ResponseBody
    HttpEntity<Object> create(@RequestBody ComicRequest comicRequest) {

        Exemplary exemplary = exemplaryService.cadastra(comicRequest);
        return ResponseEntity.ok(exemplary);
    }

    @PutMapping(value = "/{comicId}")
    public @ResponseBody
    HttpEntity<Object> update(@PathVariable(name = "comicId") Long comicId,
                              @RequestBody Comic comic) {

        comic.setComicId(comicId);
        service.update(comic);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{comicId}")
    public @ResponseBody
    HttpEntity<User> remove(@PathVariable(name = "comicId") Long comicId) {

        service.remove(comicId);
        return ResponseEntity.ok().build();
    }

}
