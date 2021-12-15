package org.zup.paulo.comicmanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zup.paulo.comicmanager.domain.Comic;
import org.zup.paulo.comicmanager.domain.Exemplary;
import org.zup.paulo.comicmanager.domain.User;
import org.zup.paulo.comicmanager.domain.representations.ComicUpdate;
import org.zup.paulo.comicmanager.domain.representations.ExemplaryRequest;
import org.zup.paulo.comicmanager.services.ComicService;
import org.zup.paulo.comicmanager.services.ExemplaryService;

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

    @GetMapping(value = "/{comicId}")
    public @ResponseBody
    HttpEntity<Comic> get(@PathVariable(name = "comicId") Long id) {

        Comic comic = service.get(id);
        return ResponseEntity.ok(comic);
    }

    @PostMapping("/exemplary")
    public @ResponseBody
    HttpEntity<Object> createExemplary(@RequestBody ExemplaryRequest exemplaryRequest) {

        Exemplary exemplary = exemplaryService.cadastra(exemplaryRequest);
        return ResponseEntity.ok(exemplary);
    }

    @PostMapping
    public @ResponseBody
    HttpEntity<Object> save(@RequestBody Comic comic) {

        comic = service.create(comic);
        return ResponseEntity.ok(comic);
    }

    @PutMapping(value = "/{comicId}")
    public @ResponseBody
    HttpEntity<Object> update(@PathVariable(name = "comicId") Long comicId,
                              @RequestBody ComicUpdate comicUpdate) {

        comicUpdate.setComicId(comicId);
        service.update(comicUpdate);
        return ResponseEntity.ok().build();
    }

}
