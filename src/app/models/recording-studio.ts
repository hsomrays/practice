import {Artist} from "./artist";

export class RecordingStudio {
  id?: number;
  studioName?: string;
  numberOfEmployees?: number;
  location?: string;
  artists: Artist[] = [];
}
