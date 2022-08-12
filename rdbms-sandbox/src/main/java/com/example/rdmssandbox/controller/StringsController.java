package com.example.rdmssandbox.controller;

import com.example.rdmssandbox.entity.Strings;
import com.example.rdmssandbox.service.StringsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/strings")
public class StringsController {

    private final StringsService stringsService;

    public StringsController(StringsService stringsService) {
        this.stringsService = stringsService;
    }


    @PostMapping("")
    public Strings createStrings(@RequestBody Strings strings) {
        return stringsService.createStrings(strings);
    }

    @GetMapping("")
    public List<Strings> getAllStrings() {
        return stringsService.getStrings();
    }

    @GetMapping("/{id}")
    public Strings getStrings(@PathVariable String id) {
        return stringsService.getStrings(id);
    }


    @DeleteMapping("/{id}")
    public String removeStrings(@PathVariable String id) {
        return stringsService.removeStrings(id);
    }

    @PutMapping("")
    public Strings getStrings(@RequestBody Strings strings) {
        return stringsService.updateStrings(strings);
    }

}
