package se.mdh.driftavbrott.gui.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se.mdh.driftavbrott.gui.model.Anledning;
import se.mdh.driftavbrott.gui.persistence.AnledningRepository;

@Controller
@RequestMapping(value = "/anledningar")
public class AnledningController {

  private final AnledningRepository anledningRepository;

  @Autowired
  public AnledningController(AnledningRepository anledningRepository) {
    this.anledningRepository = anledningRepository;
  }

  @GetMapping("/list")
  public String product(Model model) {
    model.addAttribute("anledningar", anledningRepository.findAll());
    return "anledningar/list";
  }

  @GetMapping("/create")
  public String create(Anledning anledning, Model model) {
    model.addAttribute("anledning", anledning);
    return "anledningar/create";
  }

  @PostMapping("/create")
  public String create(@Valid Anledning anledning, BindingResult bindingResult) {
    if(bindingResult.hasErrors()) {
      return "anledningar/create";
    } else {
      anledningRepository.save(anledning);
      return "redirect:/anledningar/list";
    }
  }

  @GetMapping("/show/{id}")
  public String show(@PathVariable String id, Model model) {
    model.addAttribute("anledning", anledningRepository.findOne(id));
    return "anledningar/show";
  }

  @PostMapping("/delete")
  public String delete(@RequestParam String id) {
    Anledning anledning = anledningRepository.findOne(id);
    anledningRepository.delete(anledning);

    return "redirect:/anledningar/list";
  }

  @GetMapping("/edit/{id}")
  public String edit(@PathVariable String id, Model model) {
    model.addAttribute("anledning", anledningRepository.findOne(id));
    return "anledningar/edit";
  }

  @PostMapping("/update")
  public String update(@Valid Anledning anledning, BindingResult bindingResult) {
    if(bindingResult.hasErrors()) {
      return "anledningar/edit/"+ anledning.getId();
    } else {
      anledningRepository.save(anledning);
      return "redirect:/anledningar/list";
    }
  }
}
