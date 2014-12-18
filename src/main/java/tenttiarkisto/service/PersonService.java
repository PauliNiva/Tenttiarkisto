package tenttiarkisto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import tenttiarkisto.domain.Person;
import tenttiarkisto.repo.PersonRepo;

@Service
public class PersonService {

    @Autowired
    private PersonRepo personRepo;

    public Person getAuthenticatedPerson() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return personRepo.findByUsername(authentication.getName());
    }
}
