CREATE TABLE public.album
(
    id bigint NOT NULL,
    title character varying(255) COLLATE pg_catalog."default",
    release_date date,
    genre character varying(255) COLLATE pg_catalog."default",
    artist_id bigint,
    CONSTRAINT album_pkey PRIMARY KEY (id),
    CONSTRAINT album_artist_id_fkey FOREIGN KEY (artist_id)
        REFERENCES public.artist (id) MATCH SIMPLE
)

CREATE TABLE public.artist
(
    id integer NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    age integer,
    artist_name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT artist_pkey PRIMARY KEY (id),
    CONSTRAINT check_age CHECK (age >= 18)
)

CREATE TABLE IF NOT EXISTS public.producer
(
    id integer NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    work_experience integer,
    company character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT producer_pkey PRIMARY KEY (id)
)

CREATE TABLE public.producer_recording_studio
(
    id integer NOT NULL,
    producer_id integer,
    recording_studio_id integer,
    CONSTRAINT producer_recording_studio_pkey PRIMARY KEY (id),
    CONSTRAINT producer_recording_studio_producer_id_fkey FOREIGN KEY (producer_id)
        REFERENCES public.producer (id) MATCH SIMPLE
    CONSTRAINT producer_recording_studio_recording_studio_id_fkey FOREIGN KEY (recording_studio_id)
        REFERENCES public.recording_studio (id) MATCH SIMPLE
)

CREATE TABLE public.producer_song
(
    id integer NOT NULL,
    song_id integer,
    producer_id integer,
    CONSTRAINT producer_song_pkey PRIMARY KEY (id),
    CONSTRAINT producer_song_producer_id_fkey FOREIGN KEY (producer_id)
        REFERENCES public.producer (id) MATCH SIMPLE
    CONSTRAINT producer_song_song_id_fkey FOREIGN KEY (song_id)
        REFERENCES public.song (id) MATCH SIMPLE
)

CREATE TABLE public.recording_engineer
(
    id integer NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    work_experience integer,
    rating integer,
    CONSTRAINT recording_engineer_pkey PRIMARY KEY (id),
    CONSTRAINT check_rating CHECK (rating >= 1 AND rating <= 10)
)

CREATE TABLE public.recording_studio
(
    id integer NOT NULL,
    studio_name character varying(255) COLLATE pg_catalog."default",
    location character varying(255) COLLATE pg_catalog."default",
    number_of_employees integer,
    recording_engineer_id integer,
    CONSTRAINT recording_studio_pkey PRIMARY KEY (id),
    CONSTRAINT recording_studio_recording_engineer_id_fkey FOREIGN KEY (recording_engineer_id)
        REFERENCES public.recording_engineer (id) MATCH SIMPLE
)

CREATE TABLE public.song
(
    id integer NOT NULL,
    title character varying(255) COLLATE pg_catalog."default",
    release_date date,
    artist_id integer,
    duration time without time zone,
    CONSTRAINT song_pkey PRIMARY KEY (id),
    CONSTRAINT song_artist_id_fkey FOREIGN KEY (artist_id)
        REFERENCES public.artist (id) MATCH SIMPLE
)