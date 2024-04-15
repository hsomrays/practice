import React, { useEffect, useState } from 'react';
import { artistList, deleteArtist } from '../../services/ArtistService';
import AddArtistDialogComponent from './AddArtistDialogComponent';
import ModalComponent from '../ModalComponent';
import UpdateArtistDialogComponent from './UpdateArtistDialogComponent';

const ArtistComponent = () => {
  const [artists, setArtists] = useState([]);
  const [showModal, setShowModal] = useState(false);
  const [selectedArtistId, setSelectedArtistId] = useState(null);

  useEffect(() => {
    fetchArtists();
  }, []);

  function fetchArtists() {
    artistList()
      .then((response) => {
        setArtists(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }

  function addArtist() {
    setShowModal(true);
  }

  function updateArtist(id) {
    setSelectedArtistId(id);
    setShowModal(true);
  }

  function delArtist(id) {
    deleteArtist(id)
        .then((response) => {
          fetchArtists();
          onClose();
        })
        .catch((error) => {
          console.error(error);
        });
  }

  function closeModal() {
    setShowModal(false);
    setSelectedArtistId(null);
    fetchArtists();
  }

  return (
    <div className="container">
      <h2 className="text-center">Artist List</h2>
      <button type="button" className="btn btn-primary" onClick={addArtist}>
        Add Artist
      </button>

      {showModal && (
        <ModalComponent onClose={closeModal} title={selectedArtistId ? 'Edit Artist' : 'Add Artist'}>
          {selectedArtistId ? (
            <UpdateArtistDialogComponent artistId={selectedArtistId} onClose={closeModal} />
          ) : (
            <AddArtistDialogComponent onClose={closeModal} />
          )}
        </ModalComponent>
      )}

      <table className="table table-stripped">
        <thead>
          <tr>
            <th>Name</th>
            <th>Age</th>
            <th>Artist Name</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {artists.map((artist) => (
            <tr key={artist.id}>
              <td>{artist.name}</td>
              <td>{artist.age}</td>
              <td>{artist.artistName}</td>
              <td>
                <button className="btn btn-info"  onClick={() => updateArtist(artist.id)} >
                  Edit
                </button>
                <button className="btn btn-danger " onClick={() => delArtist(artist.id)}>
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

export default ArtistComponent;