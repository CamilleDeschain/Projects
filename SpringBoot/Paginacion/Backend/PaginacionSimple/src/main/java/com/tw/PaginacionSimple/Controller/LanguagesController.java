package com.tw.PaginacionSimple.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tw.PaginacionSimple.Entity.Languages;
import com.tw.PaginacionSimple.Service.LanguagesService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LanguagesController {
   
	
	@Autowired
    LanguagesService languagesService;

    @GetMapping("/programmingLanguages")
    public ResponseEntity<Page<Languages>> pages(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "name") String order,
            @RequestParam(defaultValue = "true") boolean asc
    ){
        Page<Languages> languages = languagesService.pages(
                PageRequest.of(page, size, Sort.by(order)));
        if(!asc)
            languages = languagesService.pages(
                    PageRequest.of(page, size, Sort.by(order).descending()));
        return new ResponseEntity<Page<Languages>>(languages, HttpStatus.OK);
    }
}
