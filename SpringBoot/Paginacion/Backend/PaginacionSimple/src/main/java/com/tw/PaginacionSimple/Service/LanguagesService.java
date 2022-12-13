package com.tw.PaginacionSimple.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tw.PaginacionSimple.Entity.Languages;
import com.tw.PaginacionSimple.Repository.LanguageRepository;

@Service
@Transactional
public class LanguagesService {

    @Autowired
    LanguageRepository languageRepository;

    public Page<Languages> pages(Pageable pageable){
        return languageRepository.findAll(pageable);
    }
}