import { createRouter, createWebHistory } from 'vue-router';
import HomeView from '../views/HomeView.vue';
import CollectionsView from '../views/CollectionsView.vue';
import ComicsView from '../views/ComicsView.vue';
import BooksView from '../views/BooksView.vue';
import BoardGamesView from '../views/BoardGamesView.vue';
import CollectionDetailView from '../views/CollectionDetailView.vue';

const routes = [
  { path: '/', name: 'home', component: HomeView },
  { path: '/collections', name: 'collections', component: CollectionsView },
  { path: '/collections/:id', name: 'collection-detail', component: CollectionDetailView, props: true },
  { path: '/comics', name: 'comics', component: ComicsView },
  { path: '/books', name: 'books', component: BooksView },
  { path: '/boardgames', name: 'boardgames', component: BoardGamesView },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;