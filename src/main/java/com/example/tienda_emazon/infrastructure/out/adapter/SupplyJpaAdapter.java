package com.example.tienda_emazon.infrastructure.out.adapter;

import com.example.tienda_emazon.domain.model.SupplyModel;
import com.example.tienda_emazon.domain.spi.ISupplyPersistencePort;
import com.example.tienda_emazon.infrastructure.out.entity.SupplyEntity;
import com.example.tienda_emazon.infrastructure.out.mapper.SupplyEntityMapper;
import com.example.tienda_emazon.infrastructure.out.respository.SupplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

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
}
