package com.example.tienda_emazon.infrastructure.out.adapter;

import com.example.tienda_emazon.domain.model.CategoryModel;
import com.example.tienda_emazon.domain.model.SupplyModel;
import com.example.tienda_emazon.domain.spi.ISupplyPersistencePort;
import com.example.tienda_emazon.infrastructure.out.entity.SupplyEntity;
import com.example.tienda_emazon.infrastructure.out.mapper.SupplyEntityMapper;
import com.example.tienda_emazon.infrastructure.out.respository.SupplyRepository;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Set;

@RequiredArgsConstructor
public class SupplyJpaAdapter implements ISupplyPersistencePort {

    private final SupplyRepository supplyRepository;
    private final SupplyEntityMapper supplyEntityMapper;

    @Override
    public void saveSupply(SupplyModel supplyModel) {
        supplyRepository.save(supplyEntityMapper.modelToEntity(supplyModel));
    }

    @Override
    public Page<SupplyEntity> pageSupply(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return supplyRepository.findAll(pageable);
    }

    @Override
    public SupplyModel findSupplyByName(String name) {
        return supplyEntityMapper.entityToModel
                (supplyRepository.findByName(name).orElse(null));
    }

    private Set<CategoryModel> categories;
    @PrePersist
    @PreUpdate
    private void validateCategories(){
        if (categories.size() >= 1 || categories.size() <= 3){
            throw new IllegalArgumentException("Cada articulo debe tener màximo 3 categorìas");
        }
    }
}
