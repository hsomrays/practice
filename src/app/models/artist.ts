import {RecordingStudio} from "./recording-studio";

export class Artist {
  id?: number;
  name?: string;
  age?: number;
  recordingStudios: RecordingStudio[] = [];
  artistName?: string;
}
