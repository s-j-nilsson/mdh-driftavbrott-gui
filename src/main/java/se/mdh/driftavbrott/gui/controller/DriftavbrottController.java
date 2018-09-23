package se.mdh.driftavbrott.gui.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se.mdh.driftavbrott.gui.model.Driftavbrott;
import se.mdh.driftavbrott.gui.persistence.DriftavbrottRepository;
import se.mdh.driftavbrott.gui.persistence.KanalRepository;
import se.mdh.driftavbrott.gui.persistence.AnledningRepository;

@Controller
public class DriftavbrottController {

  @Autowired
  private DriftavbrottRepository driftavbrottRepository;

  @Autowired
  private AnledningRepository anledningRepository;

  @Autowired
  private KanalRepository kanalRepository;

  @GetMapping("/list")
  public String product(Model model) {
    model.addAttribute("driftavbrott", driftavbrottRepository.findAll());
    return "list";
  }

  @GetMapping("/create")
  public String create(Driftavbrott driftavbrott, Model model) {
    model.addAttribute("driftavbrott", driftavbrott);
    model.addAttribute("kanaler", kanalRepository.findAll());
    model.addAttribute("anledningar", anledningRepository.findAll());
    return "create";
  }

  @PostMapping("/create")
  public String create(@Valid Driftavbrott driftavbrott, BindingResult bindingResult) {
    if(bindingResult.hasErrors()) {
      return "create";
    } else {
      driftavbrottRepository.save(driftavbrott);
      return "redirect:/list";
    }
  }

  @GetMapping("/show/{id}")
  public String show(@PathVariable String id, Model model) {
    model.addAttribute("driftavbrott", driftavbrottRepository.findOne(id));
    return "show";
  }

  @PostMapping("/delete")
  public String delete(@RequestParam String id) {
    Driftavbrott driftavbrott = driftavbrottRepository.findOne(id);
    driftavbrottRepository.delete(driftavbrott);

    return "redirect:/list";
  }

  @GetMapping("/edit/{id}")
  public String edit(@PathVariable String id, Model model) {
    model.addAttribute("driftavbrott", driftavbrottRepository.findOne(id));
    model.addAttribute("kanaler", kanalRepository.findAll());
    model.addAttribute("anledningar", anledningRepository.findAll());
    return "edit";
  }

  @PostMapping("/update")
  public String update(@Valid Driftavbrott driftavbrott, BindingResult bindingResult) {
    if(bindingResult.hasErrors()) {
      return "edit/"+ driftavbrott.getId();
    } else {
      driftavbrottRepository.save(driftavbrott);
      return "redirect:/list";
    }
  }
}
