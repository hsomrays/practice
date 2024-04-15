import axios from "axios";

const API_BASE_URL = 'http://localhost:8080/api/recordingStudios';

export const recordingStudioList = () => axios.get(API_BASE_URL);

export const createRecordingStudio = (recordingStudio) => axios.post(API_BASE_URL, recordingStudio);

export const getRecordingStudio = (recordingStudioId) => axios.get(API_BASE_URL + '/' + recordingStudioId);

export const updateRecordingStudio = (recordingStudioId, recordingStudio) => axios.put(API_BASE_URL + '/' + recordingStudioId, recordingStudio);

export const deleteRecordingStudio = (recordingStudioId) => axios.delete(API_BASE_URL + '/' + recordingStudioId);
