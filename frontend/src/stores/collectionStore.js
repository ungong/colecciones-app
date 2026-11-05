import { defineStore } from 'pinia';
import {
  getAllCollections,
  getCollectionById,
  createCollection,
  updateCollection,
  deleteCollection,
} from '../services/collectionService';
import { ref } from 'vue';

export const useCollectionStore = defineStore('collection', () => {
  const collections = ref([]);
  const currentCollection = ref(null);
  const loading = ref(false);
  const error = ref(null);

  const fetchCollections = async () => {
    loading.value = true;
    error.value = null;
    try {
      const response = await getAllCollections();
      collections.value = response.data;
    } catch (err) {
      error.value = err.message || 'Error al cargar colecciones';
    } finally {
      loading.value = false;
    }
  };

  const fetchCollectionById = async (id) => {
    loading.value = true;
    error.value = null;
    try {
      const response = await getCollectionById(id);
      currentCollection.value = response.data;
    } catch (err) {
      error.value = err.message || 'Error al cargar la colección';
    } finally {
      loading.value = false;
    }
  };

  const addCollection = async (collection) => {
    loading.value = true;
    error.value = null;
    try {
      const response = await createCollection(collection);
      collections.value.push(response.data);
      return response.data;
    } catch (err) {
      error.value = err.message || 'Error al crear la colección';
      throw err;
    } finally {
      loading.value = false;
    }
  };

  const editCollection = async (id, collection) => {
    loading.value = true;
    error.value = null;
    try {
      const response = await updateCollection(id, collection);
      const index = collections.value.findIndex((c) => c.id === id);
      if (index !== -1) {
        collections.value[index] = response.data;
      }
      return response.data;
    } catch (err) {
      error.value = err.message || 'Error al actualizar la colección';
      throw err;
    } finally {
      loading.value = false;
    }
  };

  const removeCollection = async (id) => {
    loading.value = true;
    error.value =