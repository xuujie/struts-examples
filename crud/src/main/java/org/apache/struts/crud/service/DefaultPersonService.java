package org.apache.struts.crud.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts.crud.PersonController;
import org.apache.struts.crud.dao.MemoryPersonDao;
import org.apache.struts.crud.dao.MemoryPersonSupportDao;
import org.apache.struts.crud.dao.PersonDao;
import org.apache.struts.crud.dao.PersonSupportDao;
import org.apache.struts.crud.model.Country;
import org.apache.struts.crud.model.Person;
import org.springframework.stereotype.Service;

/**
 * Implement Services needed to edit and save
 * a Person object's state.  
 * 
 * @author bruce phillips
 * @author antonio sanchez
 */

@Service
public class DefaultPersonService implements PersonService {
    private final PersonDao personDao;
    private final PersonSupportDao personSupportDao;
    private static final Logger LOG = LogManager.getLogger(DefaultPersonService.class.getName());

    public DefaultPersonService(PersonDao personDao, PersonSupportDao personSupportDao) {
        this.personDao = personDao;
        this.personSupportDao = personSupportDao;
    }

    @Override
    public Person getPerson(Integer id) {
        return personDao.getPerson(id);
    }

    @Override
    public Person[] getAllPersons() {
        LOG.info("get all persons");
        return personDao.getAllPersons();
    }

    @Override
    public void updatePerson(Person personBean) {
        personDao.updatePerson(personBean);
    }

    @Override
    public void insertPerson(Person personBean) {
        personDao.insertPerson(personBean);
    }

    @Override
    public void deletePerson(Integer id) {
        personDao.deletePerson(id);
    }

    @Override
    public Country[] getCountries() {
        return personSupportDao.getCountries();
    }

    @Override
    public String[] getCarModels() {
        return personSupportDao.getCarModels();
    }

    @Override
    public String[] getSports() {
        return personSupportDao.getSports();
    }

    @Override
    public String[] getGenders() {
        return personSupportDao.getGenders();
    }
}
