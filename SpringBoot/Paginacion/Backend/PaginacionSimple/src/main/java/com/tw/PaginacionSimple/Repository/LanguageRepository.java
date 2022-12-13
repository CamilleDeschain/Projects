package com.tw.PaginacionSimple.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tw.PaginacionSimple.Entity.Languages;

@Repository
public interface LanguageRepository extends JpaRepository<Languages, Long>{

}
