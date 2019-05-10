package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
// annotazione per jackson in modo che non serializzi robe di hibernate
public class Singer {
	@Id
    @GeneratedValue
    private Long id;
	
    private String name;
  
    @OneToMany(mappedBy = "singer")
    @JsonIgnore // annotazione per jackson, in modo che non blocchi in cicli
    private Set<Song> songs;

    protected Singer() {
    	
    }
    
    public Singer(String name) {
    	this.name = name;
    }
    
    public void addSong(Song song) {
        if (songs == null) {
            songs = new HashSet<>();
        }
        this.songs.add(song);
    }
}
