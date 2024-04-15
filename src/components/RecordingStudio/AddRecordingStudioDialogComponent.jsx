import React, { useState } from 'react';
import { createRecordingStudio } from '../../services/RecordingStudioService';

const AddRecordingStudioDialogComponent = ({ onClose }) => {
  const [studioName, setStudioName] = useState('');
  const [location, setLocation] = useState('');
  const [numberOfEmployees, setNumberOfEmployees] = useState('');

  const [errors, setErrors] = useState({
    studioName: '',
    location: '',
    numberOfEmployees: ''
  });

  function saveRecordingStudio(e) {
    e.preventDefault();
    
    if (validateForm()) {
      const recordingStudio = { studioName, location, numberOfEmployees };

      createRecordingStudio(recordingStudio)
        .then((response) => {
          onClose();
        })
        .catch((error) => {
          console.error(error);
        });
    }
  }

  function validateForm() {
    let valid = true;
    const errorsCopy = { ...errors };

    if (!studioName.trim()) {
      errorsCopy.studioName = 'Studio Name is required';
      valid = false;
    } else {
      errorsCopy.studioName = '';
    }

    if (!location.trim()) {
      errorsCopy.location = 'Location is required';
      valid = false;
    } else {
      errorsCopy.location = '';
    }

    if (!numberOfEmployees.trim()) {
      errorsCopy.numberOfEmployees = 'Number of employees is required';
      valid = false;
    } else {
      errorsCopy.numberOfEmployees = '';
    }

    setErrors(errorsCopy);

    return valid;
  }

  return (
    <div className="modal" style={{ display: 'block' }}>
      <div className="modal-dialog">
        <div className="modal-content">
          <div className="modal-header">
            <h5 className="modal-title text">Add Recording Studio</h5>
          </div>
          <div className="modal-body">
            <form onSubmit={saveRecordingStudio}>
              <div className="form-group">
                <label htmlFor="studioName">Studio Name</label>
                <input
                  type="text"
                  className="form-control"
                  id="studioName"
                  value={studioName}
                  onChange={(e) => setStudioName(e.target.value)}
                  required
                />
                {errors.studioName && <div className="text-danger">{errors.studioName}</div>}
              </div>
              <div className="form-group">
                <label htmlFor="location">Location</label>
                <input
                  type="text"
                  className="form-control"
                  id="location"
                  value={location}
                  onChange={(e) => setLocation(e.target.value)}
                  required
                />
                {errors.location && <div className="text-danger">{errors.location}</div>}
              </div>
              <div className="form-group">
                <label htmlFor="numberOfEmployees">Number Of Employees</label>
                <input
                  type="number"
                  className="form-control"
                  id="numberOfEmployees"
                  value={numberOfEmployees}
                  onChange={(e) => setNumberOfEmployees(e.target.value)}
                  required
                />
                {errors.numberOfEmployees && (
                  <div className="text-danger">{errors.numberOfEmployees}</div>
                )}
              </div>
              <div className='text-center'>
              <button type="submit" className="btn btn-primary">
                Save
              </button>
              <button type="button" className="btn btn-secondary" onClick={onClose}>
              Close
            </button>
            </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
};

export default AddRecordingStudioDialogComponent;