package eu.senla.shop.service;

import eu.senla.shop.api.services.ICategoryService;
import eu.senla.shop.dto.CategoryDTO;
import eu.senla.shop.api.mapper.ICategoryMapper;
import eu.senla.shop.api.repository.ICategoryRepository;
import eu.senla.shop.model.Category;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public CategoryDTO save(CategoryDTO categoryDTO) {
        log.info("BEGINNING METHOD save({})", categoryDTO);
        Category categories = categoryRepository.save(ICategoryMapper.INSTANCE.toCategory(categoryDTO));
        return ICategoryMapper.INSTANCE.toDTO(categories);
    }

    @Override
    public CategoryDTO findById(Long categoryId) {
        log.info("BEGINNING METHOD findById({})", categoryId);
        Category categories = categoryRepository.getById(categoryId);
        return ICategoryMapper.INSTANCE.toDTO(categories);
    }

    @Override
    public CategoryDTO findByName(String name) {
        log.info("BEGINNING METHOD findByName({})", name);
        Category categories = categoryRepository.findByName(name);
        return ICategoryMapper.INSTANCE.toDTO(categories);
    }

    @Override
    public List<CategoryDTO> findAll() {
        log.info("BEGINNING METHOD findAll()");
        return categoryRepository.findAll().stream().map(ICategoryMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long categoryId) {
        log.info("BEGINNING METHOD deleteById({})", categoryId);
        categoryRepository.deleteById(categoryId);
    }

    @Override
    public void deleteAll() {
        log.info("BEGINNING METHOD deleteAll()");
        categoryRepository.deleteAll();
    }

    @Override
    @Transactional
    public void deleteByName(String name) {
        log.info("BEGINNING METHOD deleteByName({})", name);
        categoryRepository.deleteByName(name);
    }

    @Override
    public void delete(CategoryDTO categoryDTO) {
        log.info("BEGINNING METHOD delete({})", categoryDTO.toString());
        categoryRepository.delete(ICategoryMapper.INSTANCE.toCategory(categoryDTO));
    }
}
