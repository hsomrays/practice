import { useState } from 'react'
import './App.css'
import RecordingStudioComponent from './components/RecordingStudio/RecordingStudioListComponent'

import HeaderComponent from './components/HeaderComponent'
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import ArtistComponent from './components/Artists/ArtistListComponent'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <BrowserRouter>
        <HeaderComponent/>
        <Routes>
          <Route path='/' element = {<RecordingStudioComponent />}></Route>
          <Route path='recordingStudios' element = {<RecordingStudioComponent />}></Route>
          <Route path='artists' element = {<ArtistComponent />}></Route>
        </Routes>
      </BrowserRouter>
    </>
  )
}

export default App
