package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity // entita' del DB
@Data // annotazione di lombok per generare automaticamente getter e setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Song {
	@Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Singer singer;


    private String title;
    private String lyrics;
    private Kind kind;
    private String language;
    private short year;

    protected Song() {
    	
    }

    public void updateSinger(Singer singer) {
        this.singer = singer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song cane = (Song) o;
        return Objects.equals(id, cane.id) &&
                Objects.equals(title, cane.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }
}
