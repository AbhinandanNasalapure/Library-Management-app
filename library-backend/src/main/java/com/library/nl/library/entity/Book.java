package com.library.nl.library.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="BOOK")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {
    @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID")
    public Integer id;
    @Column(name="TITLE")
    public String title;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="AUTHOR_ID")
    public Author author;

    @Column(name="PUBLISHER")
    public String publisher;
    @Column(name="EDITION")
    public String edition;
    @Column(name="ISBN")
    public String isbn;
    @Column(name="PUBLISHING_DATE")
    public Date publishingDate;

   @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    public List<Chapter> chapters;

}
