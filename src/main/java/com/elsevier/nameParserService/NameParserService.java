package com.elsevier.nameParserService;

import com.elsevier.nameParserService.model.Group;
import com.elsevier.nameParserService.model.Person;

public interface NameParserService {

    Person parseName(String name);

    Group parseNames(String names);
}
