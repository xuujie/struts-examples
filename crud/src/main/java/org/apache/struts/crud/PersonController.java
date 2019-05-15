package org.apache.struts.crud;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts.crud.model.Person;
import org.apache.struts.crud.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class PersonController {
    private static final Logger LOG = LogManager.getLogger(PersonController.class.getName());

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    /**
     * Get all persons for display in the view.
     */
    @GetMapping("/list")
    public String list(Model model) {
        Person[] persons = personService.getAllPersons();

        for (Person person : persons) {
            LOG.info("PERSON: " + person);
        }
        model.addAttribute("persons", persons);
        return "persons";
    }

    @GetMapping("/add")
    public String addPerson(Model model) {
        model.addAttribute("person", new Person());
        populate(model);
        return "editPerson";
    }

    @GetMapping("/edit/{id}")
    public String editPerson(@PathVariable int id, Model model) {
        Person person = personService.getPerson(id);
        model.addAttribute("person", person);
        populate(model);
        return "editPerson";
    }

    private void populate(Model model) {
        model.addAttribute("sports", personService.getSports());
        model.addAttribute("genders", personService.getGenders());
        model.addAttribute("countries", personService.getCountries());
        model.addAttribute("carModels", personService.getCarModels());
    }

    /**
     * Save the state of the Person object instance field.
     */
    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("person") Person person, BindingResult result, Model model) {
        
        if (result.hasErrors()) {
            populate(model);
            return "editPerson";
        }

        if (person.getPersonId() == null) {
            personService.insertPerson(person);
            LOG.info("Created new Person: " + person);
        } else {
            personService.updatePerson(person);
            LOG.info("Updated Person: " + person);
        }
        return "redirect:/list";
    }

    /**
     * Delete from Person identified by the person
     * instance field's personId value.
     */
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        personService.deletePerson(id);
        return "redirect:/list";
    }
}
