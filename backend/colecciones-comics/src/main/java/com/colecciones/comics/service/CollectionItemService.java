package com.colecciones.comics.service;

import com.colecciones.comics.model.CollectionItem;
import com.colecciones.comics.model.CollectionStatus;
import com.colecciones.comics.repository.CollectionItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionItemService {

    private final CollectionItemRepository collectionItemRepository;

    @Autowired
    public CollectionItemService(CollectionItemRepository collectionItemRepository) {
        this.collectionItemRepository = collectionItemRepository;
    }

    public List<CollectionItem> getAllItemsByCollector(Long collectorId) {
        return collectionItemRepository.findByCollectorId(collectorId);
    }

    public List<CollectionItem> getItemsByStatus(Long collectorId, CollectionStatus status) {
        return collectionItemRepository.findByCollectorIdAndStatus(collectorId, status);
    }

    public CollectionItem saveItem(CollectionItem item) {
        return collectionItemRepository.save(item);
    }

    public void deleteItem(Long collectorId, Long editionId) {
        collectionItemRepository.deleteByCollectorIdAndEditionId(collectorId, editionId);
    }
}