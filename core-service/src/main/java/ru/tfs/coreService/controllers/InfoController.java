package ru.tfs.coreService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.tfs.coreService.entities.product.Info;
import ru.tfs.coreService.services.productService.InfoService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/info")
public class InfoController {

    private final InfoService infoService;

    @Autowired
    public InfoController(InfoService infoService) {
        this.infoService = infoService;
    }

    @GetMapping("/{productId}/{languageId}")
    public List<Info> findDescription(@Valid @PathVariable Long productId, @PathVariable Long languageId) {
        return infoService.findByProductIdAndLanguageId(productId, languageId);
    }

    @GetMapping("/findAll")
    public List<Info> findAllInfos() {
        return infoService.findAllInfos();
    }

    @PostMapping(value = "/addInfo")
    public Info addInfos(@Valid  @RequestBody Info info) {
        return infoService.save(info);
    }

    @PostMapping("/addInfos")
    public List<Info> addListOfInfos(@Valid @RequestBody List<Info> infoList) {

        return infoService.saveAll(infoList);
    }

    @PutMapping("/updateInfo")
    public Info updateInfos(@Valid @RequestBody Info info) {
        return infoService.save(info);
    }

    @PutMapping("/updateCurrencies")
    public List<Info> updateListOfInfos(@Valid @RequestBody List<Info> infoList) {
        return infoService.saveAll(infoList);
    }

    @DeleteMapping("/remove/{id}")
    public String removeInfoById(@PathVariable Long id) {
        infoService.removeInfo(id);
        return "Currency removed!";
    }

    @DeleteMapping("/remove/removeAll")
    public String removeAllInfos() {
        infoService.removeAllInfos();
        return "All currencies removed!";
    }

}
