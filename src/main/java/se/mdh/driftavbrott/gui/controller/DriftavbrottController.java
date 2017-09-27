package se.mdh.driftavbrott.gui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se.mdh.driftavbrott.gui.model.Driftavbrott;
import se.mdh.driftavbrott.gui.persistence.DriftavbrottRepository;

@Controller
public class DriftavbrottController {

  @Autowired
  private DriftavbrottRepository driftavbrottRepository;

  @RequestMapping("/driftavbrott")
  public String product(Model model) {
    model.addAttribute("driftavbrott", driftavbrottRepository.findAll());
    return "driftavbrott";
  }

  @RequestMapping("/create")
  public String create(Model model) {
    return "create";
  }

  @RequestMapping("/save")
  public String save(@RequestParam String kanal, @RequestParam String start, @RequestParam String slut) {
    Driftavbrott driftavbrott = new Driftavbrott();
    driftavbrott.setKanal(kanal);
    driftavbrott.setStart(start);
    driftavbrott.setSlut(slut);
    driftavbrottRepository.save(driftavbrott);

    return "redirect:/show/" + driftavbrott.getId();
  }

  @RequestMapping("/show/{id}")
  public String show(@PathVariable String id, Model model) {
    model.addAttribute("driftavbrott", driftavbrottRepository.findOne(id));
    return "show";
  }

  @RequestMapping("/delete")
  public String delete(@RequestParam String id) {
    Driftavbrott driftavbrott = driftavbrottRepository.findOne(id);
    driftavbrottRepository.delete(driftavbrott);

    return "redirect:/product";
  }

  @RequestMapping("/edit/{id}")
  public String edit(@PathVariable String id, Model model) {
    model.addAttribute("driftavbrott", driftavbrottRepository.findOne(id));
    return "edit";
  }

  @RequestMapping("/update")
  public String update(@RequestParam String id, @RequestParam String kanal, @RequestParam String start, @RequestParam String slut) {
    Driftavbrott driftavbrott = driftavbrottRepository.findOne(id);
    driftavbrott.setKanal(kanal);
    driftavbrott.setStart(start);
    driftavbrott.setSlut(slut);
    driftavbrottRepository.save(driftavbrott);

    return "redirect:/show/" + driftavbrott.getId();
  }

}
