import api from './api';

export const getAllCollections = () => api.get('/collections');
export const getCollectionById = (id) => api.get(`/collections/${id}`);
export const createCollection = (collection) => api.post('/collections', collection);
export const updateCollection = (id, collection) => api.put(`/collections/${id}`, collection);
export const deleteCollection = (id) => api.delete(`/collections/${id}`);