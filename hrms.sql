-- This script was generated by a beta version of the ERD tool in pgAdmin 4.
-- Please log an issue at https://redmine.postgresql.org/projects/pgadmin4/issues/new if you find any bugs, including reproduction steps.
BEGIN;


CREATE TABLE public.candidate_for_request
(
    confirm_password character varying(255),
    id integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.candidates
(
    id integer NOT NULL,
    first_name character varying(20) NOT NULL,
    last_name character varying(20) NOT NULL,
    identity_number character varying(11) NOT NULL,
    date_of_birth integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.cities
(
    id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    city_name character varying(30) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.confirmation_codes
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    confirmation_code character varying(30) NOT NULL,
    is_confirmed boolean,
    PRIMARY KEY (id)
);

CREATE TABLE public.confirmation_of_candidate
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    candidate_id integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.confirmation_of_employer
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    employer_id integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.digital_skills
(
    id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    skill_name character varying(50),
    candidate_id integer,
    resume_id integer,
    PRIMARY KEY (id)
);

CREATE TABLE public.education
(
    id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    school_name character varying(70),
    branch character varying(50),
    start_year integer,
    end_year integer,
    graduate_status character varying(30),
    candidate_id integer,
    resume_id integer,
    PRIMARY KEY (id)
);

CREATE TABLE public.employees
(
    id integer NOT NULL,
    first_name character varying(20) NOT NULL,
    last_name character varying(20) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.employer_confirmation_by_employee
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    employer_id integer NOT NULL,
    employee_id integer,
    is_confirmed boolean,
    PRIMARY KEY (id)
);

CREATE TABLE public.employer_for_request
(
    confirm_password character varying(255),
    id integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.employers
(
    id integer NOT NULL,
    company_name character varying(200) NOT NULL,
    web_address character varying(50),
    phone_number character varying(15),
    PRIMARY KEY (id)
);

CREATE TABLE public.job_advert_activation
(
    job_act_id_ integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    employee_id integer NOT NULL,
    confirm boolean,
    confirm_date date,
    job_act_id integer NOT NULL,
    job_adv_id integer,
    PRIMARY KEY (job_act_id_)
);

CREATE TABLE public.job_adverts
(
    id integer NOT NULL,
    status boolean,
    job_description character varying(255),
    max_salary integer,
    min_salary integer,
    number_of_active_jobs integer,
    city_id integer,
    employer_id integer,
    job_title_id integer,
    created_at date,
    application_deadline date,
    work_place_id integer,
    work_type_id integer,
    is_confirm boolean,
    PRIMARY KEY (id)
);

CREATE TABLE public.job_titles
(
    id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    job_title character varying(50) NOT NULL,
    is_active boolean,
    created_at date,
    PRIMARY KEY (id)
);

CREATE TABLE public.languages
(
    id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    language_name character varying(30),
    language_level integer,
    candidate_id integer,
    resume_id integer,
    PRIMARY KEY (id)
);

CREATE TABLE public.photo
(
    id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    photo_url character varying(100),
    candidate_id integer,
    resume_id integer,
    PRIMARY KEY (id)
);

CREATE TABLE public.resumes
(
    id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    cv_name character varying(50),
    github_url character varying(100),
    linkedin_url character varying(100),
    about_me character varying(500),
    candidate_id integer,
    PRIMARY KEY (id)
);

CREATE TABLE public.users
(
    id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    email character varying(50) NOT NULL,
    password character varying(20) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.work_experience
(
    id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    company_name character varying(100),
    job_title character varying(50),
    start_year integer,
    end_year integer,
    work_status character varying,
    candidate_id integer,
    resume_id integer,
    PRIMARY KEY (id)
);

CREATE TABLE public.work_place
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    place_name character varying,
    PRIMARY KEY (id)
);

CREATE TABLE public.work_type
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    type_name character varying(30),
    PRIMARY KEY (id)
);

ALTER TABLE public.candidate_for_request
    ADD FOREIGN KEY (id)
    REFERENCES public.candidates (id)
    NOT VALID;


ALTER TABLE public.candidates
    ADD FOREIGN KEY (id)
    REFERENCES public.users (id)
    NOT VALID;


ALTER TABLE public.digital_skills
    ADD FOREIGN KEY (resume_id)
    REFERENCES public.resumes (id)
    NOT VALID;


ALTER TABLE public.education
    ADD FOREIGN KEY (resume_id)
    REFERENCES public.resumes (id)
    NOT VALID;


ALTER TABLE public.employees
    ADD FOREIGN KEY (id)
    REFERENCES public.users (id)
    NOT VALID;


ALTER TABLE public.employer_for_request
    ADD FOREIGN KEY (id)
    REFERENCES public.employers (id)
    NOT VALID;


ALTER TABLE public.employers
    ADD FOREIGN KEY (id)
    REFERENCES public.users (id)
    NOT VALID;


ALTER TABLE public.job_advert_activation
    ADD FOREIGN KEY (employee_id)
    REFERENCES public.employees (id)
    NOT VALID;


ALTER TABLE public.job_adverts
    ADD FOREIGN KEY (work_type_id)
    REFERENCES public.work_place (id)
    NOT VALID;


ALTER TABLE public.job_adverts
    ADD FOREIGN KEY (city_id)
    REFERENCES public.cities (id)
    NOT VALID;


ALTER TABLE public.job_adverts
    ADD FOREIGN KEY (employer_id)
    REFERENCES public.employers (id)
    NOT VALID;


ALTER TABLE public.job_adverts
    ADD FOREIGN KEY (job_title_id)
    REFERENCES public.job_titles (id)
    NOT VALID;


ALTER TABLE public.job_adverts
    ADD FOREIGN KEY (work_place_id)
    REFERENCES public.work_place (id)
    NOT VALID;


ALTER TABLE public.job_adverts
    ADD FOREIGN KEY (work_type_id)
    REFERENCES public.work_type (id)
    NOT VALID;


ALTER TABLE public.languages
    ADD FOREIGN KEY (resume_id)
    REFERENCES public.resumes (id)
    NOT VALID;


ALTER TABLE public.photo
    ADD FOREIGN KEY (candidate_id)
    REFERENCES public.candidates (id)
    NOT VALID;


ALTER TABLE public.photo
    ADD FOREIGN KEY (resume_id)
    REFERENCES public.resumes (id)
    NOT VALID;


ALTER TABLE public.resumes
    ADD FOREIGN KEY (candidate_id)
    REFERENCES public.candidates (id)
    NOT VALID;


ALTER TABLE public.work_experience
    ADD FOREIGN KEY (resume_id)
    REFERENCES public.resumes (id)
    NOT VALID;

END;