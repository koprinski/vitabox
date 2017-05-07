# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table attraction (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  visit_count               varchar(255),
  working_time              varchar(255),
  synopsis                  varchar(255),
  main_picture_url          varchar(255),
  constraint pk_attraction primary key (id))
;

create table caption (
  caption_url               varchar(255),
  caption_lang              varchar(255))
;

create table comment (
  id                        bigint auto_increment not null,
  comment_text              varchar(255),
  comment_votes             integer,
  comment_author            varchar(255),
  constraint pk_comment primary key (id))
;

create table genres (
  id                        bigint auto_increment not null,
  genres_name               varchar(255),
  constraint pk_genres primary key (id))
;

create table movie (
  id                        bigint auto_increment not null,
  title                     varchar(255),
  poster                    varchar(255),
  imdb_rating               varchar(255),
  votes                     float,
  featured                  tinyint(1) default 0,
  view_count                bigint,
  synopsis                  varchar(255),
  trailer_url               varchar(255),
  rel_date                  varchar(255),
  is_in_upcoming_list       tinyint(1) default 0,
  is_in_now_playing_list    tinyint(1) default 0,
  is_in_popular_list        tinyint(1) default 0,
  is_in_top_rated_list      tinyint(1) default 0,
  tmdb_id                   bigint,
  imdb_id                   varchar(255),
  constraint pk_movie primary key (id))
;

create table music (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  magnet_url                varchar(255),
  votes                     bigint,
  synopsis                  varchar(255),
  stream_url                varchar(255),
  constraint pk_music primary key (id))
;

create table picture (
  id                        bigint auto_increment not null,
  picture_url               varchar(255),
  description               varchar(255),
  constraint pk_picture primary key (id))
;

create table radio (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  streamurl                 varchar(255),
  category                  varchar(255),
  country                   varchar(255),
  bitrate                   varchar(255),
  website                   varchar(255),
  status                    varchar(255),
  currently_playing         varchar(255),
  constraint pk_radio primary key (id))
;

create table subtitle (
  id                        bigint auto_increment not null,
  subtitle_url              varchar(255),
  subtitle_name             varchar(255),
  subtitle_lang             varchar(255),
  movie_id                  bigint,
  constraint pk_subtitle primary key (id))
;

create table tvstation (
  id                        bigint auto_increment not null,
  station_name              varchar(255),
  station_url               varchar(255),
  constraint pk_tvstation primary key (id))
;


create table movie_genres (
  movie_id                       bigint not null,
  genres_id                      bigint not null,
  constraint pk_movie_genres primary key (movie_id, genres_id))
;
alter table subtitle add constraint fk_subtitle_movie_1 foreign key (movie_id) references movie (id) on delete restrict on update restrict;
create index ix_subtitle_movie_1 on subtitle (movie_id);



alter table movie_genres add constraint fk_movie_genres_movie_01 foreign key (movie_id) references movie (id) on delete restrict on update restrict;

alter table movie_genres add constraint fk_movie_genres_genres_02 foreign key (genres_id) references genres (id) on delete restrict on update restrict;

# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table attraction;

drop table caption;

drop table comment;

drop table genres;

drop table movie_genres;

drop table movie;

drop table music;

drop table picture;

drop table radio;

drop table subtitle;

drop table tvstation;

SET FOREIGN_KEY_CHECKS=1;

