import React, { useEffect, useState } from 'react';
import { recordingStudioList, deleteRecordingStudio } from '../../services/RecordingStudioService';
import AddRecordingStudioDialogComponent from './AddRecordingStudioDialogComponent';
import ModalComponent from '../ModalComponent';
import UpdateRecordingStudioDialogComponent from './UpdateRecordingStudioDialogComponent';

const RecordingStudioComponent = () => {
  const [recordingStudios, setRecordingStudios] = useState([]);
  const [showModal, setShowModal] = useState(false);
  const [selectedRecordingStudioId, setSelectedRecordingStudioId] = useState(null);

  useEffect(() => {
    fetchRecordingStudios();
  }, []);

  function fetchRecordingStudios() {
    recordingStudioList()
      .then((response) => {
        setRecordingStudios(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }

  function addRecordingStudio() {
    setShowModal(true);
  }

  function updateRecordingStudio(id) {
    setSelectedRecordingStudioId(id);
    setShowModal(true);
  }

  function delRecrodingStudio(id) {
    deleteRecordingStudio(id)
        .then((response) => {
          fetchRecordingStudios();
          onClose();
        })
        .catch((error) => {
          console.error(error);
        });
  }

  function closeModal() {
    setShowModal(false);
    setSelectedRecordingStudioId(null);
    fetchRecordingStudios();
  }

  return (
    <div className="container">
      <h2 className="text-center">Recording Studios List</h2>
      <button type="button" className="btn btn-primary" onClick={addRecordingStudio}>
        Add Recording Studio
      </button>

      {showModal && (
        <ModalComponent onClose={closeModal} title={selectedRecordingStudioId ? 'Edit Recording Studio' : 'Add Recording Studio'}>
          {selectedRecordingStudioId ? (
            <UpdateRecordingStudioDialogComponent recordingStudioId={selectedRecordingStudioId} onClose={closeModal} />
          ) : (
            <AddRecordingStudioDialogComponent onClose={closeModal} />
          )}
        </ModalComponent>
      )}

      <table className="table table-stripped">
        <thead>
          <tr>
            <th>Studio Name</th>
            <th>Location</th>
            <th>Number Of Employees</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {recordingStudios.map((recordingStudio) => (
            <tr key={recordingStudio.id}>
              <td>{recordingStudio.studioName}</td>
              <td>{recordingStudio.location}</td>
              <td>{recordingStudio.numberOfEmployees}</td>
              <td>
                <button className="btn btn-info"  onClick={() => updateRecordingStudio(recordingStudio.id)} >
                  Edit
                </button>
                <button className="btn btn-danger " onClick={() => delRecrodingStudio(recordingStudio.id)}>
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default RecordingStudioComponent;