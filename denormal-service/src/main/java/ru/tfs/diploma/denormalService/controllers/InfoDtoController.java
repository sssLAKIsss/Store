package ru.tfs.diploma.denormalService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tfs.diploma.denormalService.dto.InfoDto;
import ru.tfs.diploma.denormalService.services.infoServices.InfoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/info")
public class InfoDtoController {

    private InfoService infoService;

    @Autowired
    public InfoDtoController(InfoService infoService) {
        this.infoService = infoService;
    }

    @GetMapping("/findAll")
    public List<InfoDto> findAll() {
        return infoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<InfoDto> findById(@PathVariable Long id) {
        return infoService.findById(id);
    }

    @GetMapping("/loadToInMemory")
    public void loadInfoDtoToInMemoryDB() {
        infoService.saveAllClientsInMemory();
    }

    @GetMapping("/clearAllInMemory")
    public void clearAllInfoDtoFromInMemoryDB() {
        infoService.clearAllClientsInMemory();
    }
}
