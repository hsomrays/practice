import React, { useState, useEffect } from 'react';
import { getArtist, updateArtist } from '../../services/ArtistService';

const UpdateArtistDialogComponent = ({ artistId, onClose }) => {
  const [name, setName] = useState('');
  const [age, setAge] = useState('');
  const [artistName, setArtistName] = useState('');
  const [recordingstudios, setRecordingStudios] = useState('');

  const [errors, setErrors] = useState({
    name: '',
    age: '',
    artistName: ''
  });

  useEffect(() => {
    
    if(artistId){
        getArtist(artistId).then((response) => {
            setName(response.data.name);
            setAge(response.data.age);
            setArtistName(response.data.artistName);
            setRecordingStudios(response.data.recordingstudios);
        }).catch(error => {
            console.error(error);
        })
    }

  }, [artistId]);

  function saveArtist(e) {
    e.preventDefault();

    if (validateForm()) {
      const updatedArtist = {
        id: artistId,
        name,
        age,
        artistName,
        recordingstudios
      };
      console.log(updatedArtist);
      
      updateArtist(artistId, updatedArtist)
        .then((response) => {
          console.log(response.data);
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

    if (!name.trim()) {
      errorsCopy.name = 'Name is required';
      valid = false;
    } else {
      errorsCopy.name = '';
    }

    if (!age) {
      errorsCopy.age = 'Age is required';
      valid = false;
    } else {
      errorsCopy.age = '';
    }

    if (!artistName.trim()) {
      errorsCopy.artistName = 'Artists Name is required';
      valid = false;
    } else {
      errorsCopy.artistName = '';
    }

    setErrors(errorsCopy);

    return valid;
  }

  return (
    <div className="modal" style={{ display: 'block' }}>
      <div className="modal-dialog">
        <div className="modal-content">
          <div className="modal-header text-center">
            <h5 className="modal-title">Update Artist</h5>
          </div>
          <div className="modal-body">
            <form onSubmit={saveArtist}>
              <div className="form-group">
                <label htmlFor="name">Name</label>
                <input
                  type="text"
                  className="form-control"
                  id="name"
                  value={name}
                  onChange={(e) => setName(e.target.value)}
                  required
                />
                {errors.name && <div className="text-danger">{errors.name}</div>}
              </div>
              <div className="form-group">
                <label htmlFor="age">Age</label>
                <input
                  type="number"
                  className="form-control"
                  id="age"
                  value={age}
                  onChange={(e) => setAge(e.target.value)}
                  required
                />
                {errors.age && <div className="text-danger">{errors.age}</div>}
              </div>
              <div className="form-group">
                <label htmlFor="artistName">Artist Name</label>
                <input
                  type="text"
                  className="form-control"
                  id="artistName"
                  value={artistName}
                  onChange={(e) => setArtistName(e.target.value)}
                  required
                />
                {errors.artistName && (
                  <div className="text-danger">{errors.artistName}</div>
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

export default UpdateArtistDialogComponent;