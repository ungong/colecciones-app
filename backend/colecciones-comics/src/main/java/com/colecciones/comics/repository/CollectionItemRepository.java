package com.colecciones.comics.repository;

import com.colecciones.comics.model.CollectionItem;
import com.colecciones.comics.model.CollectionStatus;
import com.colecciones.comics.model.Edition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repositorio para gestionar los elementos de la colección de cómics.
 * Proporciona métodos para buscar, actualizar y eliminar elementos de la colección.
 */
@Repository
public interface CollectionItemRepository extends JpaRepository<CollectionItem, Long> {

    /**
     * Busca todos los elementos de la colección de un coleccionista.
     * @param collectorId ID del coleccionista.
     * @return Lista de elementos de la colección del coleccionista.
     */
    List<CollectionItem> findByCollectorId(Long collectorId);

    /**
     * Busca todos los elementos de la colección con un estado específico.
     * @param status Estado de la colección (OWNED, MISSING, WISHLIST, ORDERED).
     * @return Lista de elementos de la colección con el estado especificado.
     */
    List<CollectionItem> findByStatus(CollectionStatus status);

    /**
     * Busca todos los elementos de la colección de un coleccionista con un estado específico.
     * @param collectorId ID del coleccionista.
     * @param status Estado de la colección.
     * @return Lista de elementos de la colección del coleccionista con el estado especificado.
     */
    List<CollectionItem> findByCollectorIdAndStatus(Long collectorId, CollectionStatus status);

    /**
     * Busca un elemento de la colección por su ID de edición y coleccionista.
     * @param collectorId ID del coleccionista.
     * @param editionId ID de la edición.
     * @return Optional con el elemento de la colección si existe.
     */
    Optional<CollectionItem> findByCollectorIdAndEditionId(Long collectorId, Long editionId);

    /**
     * Busca todos los elementos de la colección por ID de edición.
     * @param editionId ID de la edición.
     * @return Lista de elementos de la colección asociados a la edición.
     */
    List<CollectionItem> findByEditionId(Long editionId);

    /**
     * Busca todos los elementos de la colección por ID de edición y estado.
     * @param editionId ID de la edición.
     * @param status Estado de la colección.
     * @return Lista de elementos de la colección asociados a la edición con el estado especificado.
     */
    List<CollectionItem> findByEditionIdAndStatus(Long editionId, CollectionStatus status);

    /**
     * Elimina todos los elementos de la colección de un coleccionista.
     * @param collectorId ID del coleccionista.
     */
    void deleteByCollectorId(Long collectorId);

    /**
     * Elimina un elemento de la colección por ID de edición y coleccionista.
     * @param collectorId ID del coleccionista.
     * @param editionId ID de la edición.
     */
    void deleteByCollectorIdAndEditionId(Long collectorId, Long editionId);

    /**
     * Cuenta el número de elementos de la colección de un coleccionista.
     * @param collectorId ID del coleccionista.
     * @return Número de elementos de la colección del coleccionista.
     */
    long countByCollectorId(Long collectorId);

    /**
     * Cuenta el número de elementos de la colección con un estado específico.
     * @param status Estado de la colección.
     * @return Número de elementos de la colección con el estado especificado.
     */
    long countByStatus(CollectionStatus status);

    /**
     * Busca todos los elementos de la colección ordenados por fecha de creación (más recientes primero).
     * @param collectorId ID del coleccionista.
     * @return Lista de elementos de la colección ordenados por fecha de creación.
     */
    List<CollectionItem> findByCollectorIdOrderByCollectionItemIdDesc(Long collectorId);
}