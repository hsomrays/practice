import axios from "axios";

const API_BASE_URL = 'http://localhost:8080/api/artists';

export const artistList = () => axios.get(API_BASE_URL);

export const createArtist = (artist) => axios.post(API_BASE_URL, artist);

export const getArtist = (artistId) => axios.get(API_BASE_URL + '/' + artistId);

export const updateArtist = (artistId, artist) => axios.put(API_BASE_URL + '/' + artistId, artist);

export const deleteArtist = (artistId) => axios.delete(API_BASE_URL + '/' + artistId);