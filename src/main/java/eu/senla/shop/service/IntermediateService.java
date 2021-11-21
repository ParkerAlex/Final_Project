package eu.senla.shop.service;

import eu.senla.shop.api.mapper.IIntermediateMapper;
import eu.senla.shop.api.repository.IIntermediateRepository;
import eu.senla.shop.api.services.IIntermediateService;
import eu.senla.shop.dto.IntermediateDTO;
import eu.senla.shop.model.Intermediate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class IntermediateService implements IIntermediateService {

    @Autowired
    private IIntermediateRepository intermediateRepository;

    @Override
    public IntermediateDTO save(IntermediateDTO intermediateDTO) {
        log.info("BEGINNING METHOD save({})", intermediateDTO);
        Intermediate intermediates = intermediateRepository.save(IIntermediateMapper.INSTANCE.toIntermediate(intermediateDTO));
        return IIntermediateMapper.INSTANCE.toDTO(intermediates);
    }

    @Override
    public IntermediateDTO findById(Long intermediateId) {
        log.info("BEGINNING METHOD findById({})", intermediateId);
        Intermediate intermediates = intermediateRepository.getById(intermediateId);
        return IIntermediateMapper.INSTANCE.toDTO(intermediates);
    }

    @Override
    public List<IntermediateDTO> findAll() {
        log.info("BEGINNING METHOD findAll()");
        return intermediateRepository.findAll().stream().map(IIntermediateMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long intermediateId) {
        log.info("BEGINNING METHOD deleteById({})", intermediateId);
        intermediateRepository.deleteById(intermediateId);
    }

    @Override
    public void deleteAll() {
        log.info("BEGINNING METHOD deleteAll()");
        intermediateRepository.deleteAll();
    }

    @Override
    public void delete(IntermediateDTO intermediateDTO) {
        log.info("BEGINNING METHOD delete({})", intermediateDTO.toString());
        intermediateRepository.delete(IIntermediateMapper.INSTANCE.toIntermediate(intermediateDTO));
    }
}
