package com.example.rdmssandbox.service;


import com.example.rdmssandbox.entity.Strings;
import com.example.rdmssandbox.repository.DocumentRepository;
import com.example.rdmssandbox.repository.StringsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StringsService {

    private final DocumentRepository documentRepository;
    private final StringsRepository stringsRepository;

    public StringsService(DocumentRepository documentRepository, StringsRepository subjectRepository) {
        this.documentRepository = documentRepository;
        this.stringsRepository = subjectRepository;
    }


    public Strings createStrings(Strings string) {
        return stringsRepository.save(string);
    }

    public List<Strings> getStrings() {
        return stringsRepository.findAll();
    }

    public Strings getStrings(String id) {
        var s = stringsRepository.findById(id);
        return s.orElse(null);
    }

    public String removeStrings(String id) {
        stringsRepository.deleteById(id);
        return "deleted";
    }

    public Strings updateStrings(Strings strings) {
        return stringsRepository.save(strings);
    }

}
