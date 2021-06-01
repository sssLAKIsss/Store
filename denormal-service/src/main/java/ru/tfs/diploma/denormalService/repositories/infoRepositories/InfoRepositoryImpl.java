package ru.tfs.diploma.denormalService.repositories.infoRepositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.tfs.diploma.denormalService.dto.InfoDto;
import ru.tfs.diploma.denormalService.feignClient.Feign;
import ru.tfs.diploma.denormalService.models.Info;
import ru.tfs.diploma.denormalService.models.Language;
import ru.tfs.diploma.denormalService.repositories.languageRepositories.LanguageRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class InfoRepositoryImpl implements InfoRepository {

    private final Feign feign;
    private final LanguageRepository languageRepository;
    private List<Info> infoList;
    private List<InfoDto> infoDtoList;

    @Autowired
    public InfoRepositoryImpl(Feign feign, List<Info> infoList,
                              List<InfoDto> indoDtoList, LanguageRepository languageRepository) {
        this.feign = feign;
        this.infoList = infoList;
        this.infoDtoList = indoDtoList;
        this.languageRepository = languageRepository;
    }

    public void saveInfosInMemory() {
        infoList = feign.findAllInfos();
    }

    public void clearInfosInMemory() {
        infoList.clear();
    }

    public List<Info> findAllInfosFromInMemoryDB() {
        return infoList;
    }

    public Optional<Info> findInfoFromInMemoryDB(Long id) {
        return infoList.stream().
                filter(client -> client.getId() == id).
                findFirst();
    }

    public void saveAllInfoDto() {
        infoDtoList = infoList.stream().
                map(this::mapToDto).
                collect(Collectors.toList());
    }

    public void clearAllInfoDtoInMemory() {
        infoDtoList.clear();
    }

    public List<InfoDto> findAllInfoDto() {
        return infoDtoList;
    }

    public Optional<InfoDto> findInfoDtoById(Long id) {
        return infoDtoList.stream()
                .filter(infoDto -> infoDto.getId() == id)
                .findFirst();
    }

    private InfoDto mapToDto(Info info) {
        if (languageRepository.findAllLanguagesFromInMemoryDB().isEmpty()) {
            languageRepository.saveLanguagesInMemory();
        }
        Optional<Language> optLanguage = languageRepository.findLanguageFromInMemoryDB(info.getLanguageId());
        if (optLanguage.isEmpty()) {
            return new InfoDto(info, "null");
        }
        Language language = optLanguage.get();
        return new InfoDto(info, language.getName());
    }
}
