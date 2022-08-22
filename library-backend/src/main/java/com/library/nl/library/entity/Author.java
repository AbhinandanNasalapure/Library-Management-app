package com.library.nl.library.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "AUTHOR")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Author {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID")
    public Integer id;
    @Column(name = "GIVEN_NAME")
    public String givenName;
    @Column(name = "SURNAME")
    public String surName;
    @Column(name = "DATE_OF_BIRTH")
    public String dateOfBirth;
    @Column(name = "BIO")
    public String bio;

    //public Book book
}
