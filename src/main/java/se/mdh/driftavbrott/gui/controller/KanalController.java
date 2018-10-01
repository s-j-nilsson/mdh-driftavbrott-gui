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
import se.mdh.driftavbrott.gui.model.Kanal;
import se.mdh.driftavbrott.gui.persistence.KanalRepository;

@Controller
@RequestMapping(value = "/kanaler")
public class KanalController {

  private final KanalRepository kanalRepository;

  @Autowired
  public KanalController(KanalRepository kanalRepository) {
    this.kanalRepository = kanalRepository;
  }

  @GetMapping("/list")
  public String product(Model model) {
    model.addAttribute("kanaler", kanalRepository.findAll());
    return "kanaler/kanaler";
  }

  @GetMapping("/create")
  public String create(Kanal kanal, Model model) {
    model.addAttribute("kanal", kanal);
    return "kanaler/create";
  }

  @PostMapping("/create")
  public String create(@Valid Kanal kanal, BindingResult bindingResult) {
    if(bindingResult.hasErrors()) {
      return "kanaler/create";
    } else {
      kanalRepository.save(kanal);
      return "redirect:/kanaler/list";
    }
  }

  @GetMapping("/show/{id}")
  public String show(@PathVariable String id, Model model) {
    model.addAttribute("kanal", kanalRepository.findOne(id));
    return "kanaler/show";
  }

  @PostMapping("/delete")
  public String delete(@RequestParam String id) {
    Kanal kanal = kanalRepository.findOne(id);
    kanalRepository.delete(kanal);

    return "redirect:/kanaler/list";
  }

  @GetMapping("/edit/{id}")
  public String edit(@PathVariable String id, Model model) {
    model.addAttribute("kanal", kanalRepository.findOne(id));
    return "kanaler/edit";
  }

  @PostMapping("/update")
  public String update(@Valid Kanal kanal, BindingResult bindingResult) {
    if(bindingResult.hasErrors()) {
      return "kanaler/edit/"+ kanal.getId();
    } else {
      kanalRepository.save(kanal);
      return "redirect:/kanaler/list";
    }
  }
}
