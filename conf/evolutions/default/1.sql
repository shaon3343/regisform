# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table peoples (
  id                        number(19) not null,
  name                      varchar2(255),
  occupation                varchar2(255),
  address                   varchar2(255),
  mobile                    varchar2(255),
  registerdate              timestamp,
  email                     varchar2(255),
  password                  varchar2(255),
  constraint pk_peoples primary key (id))
;

create sequence peoples_seq;




# --- !Downs

drop table peoples cascade constraints purge;

drop sequence peoples_seq;

