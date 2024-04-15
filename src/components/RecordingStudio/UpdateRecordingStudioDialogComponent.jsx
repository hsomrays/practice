import React, { useState, useEffect } from 'react';
import { getRecordingStudio, updateRecordingStudio } from '../../services/RecordingStudioService';

const UpdateRecordingStudioDialogComponent = ({ recordingStudioId, onClose }) => {
  const [studioName, setStudioName] = useState('');
  const [location, setLocation] = useState('');
  const [numberOfEmployees, setNumberOfEmployees] = useState('');
  const [artists, setArtists] = useState('');

  const [errors, setErrors] = useState({
    studioName: '',
    location: '',
    numberOfEmployees: ''
  });

  useEffect(() => {
    
    if(recordingStudioId){
        getRecordingStudio(recordingStudioId).then((response) => {
            setStudioName(response.data.studioName);
            setLocation(response.data.location);
            setNumberOfEmployees(response.data.numberOfEmployees);
            setArtists(response.data.artists);
        }).catch(error => {
            console.error(error);
        })
    }

  }, [recordingStudioId]);

  function saveRecordingStudio(e) {
    e.preventDefault();

    if (validateForm()) {
      const updatedRecordingStudio = {
        id: recordingStudioId,
        studioName,
        location,
        numberOfEmployees,
        artists
      };

      updateRecordingStudio(recordingStudioId, updatedRecordingStudio)
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

    if (!numberOfEmployees) {
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
          <div className="modal-header text-center">
            <h5 className="modal-title">Update Recording Studio</h5>
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

export default UpdateRecordingStudioDialogComponent;