package com.library.nl.library.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "CHAPTER")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Chapter {

    @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "START_PAGE")
    private Integer startPage;
    @Column(name = "NUMBER_OF_PAGES")
    private String numberOfPages;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
   @JsonIgnore
    private Book book;
}
