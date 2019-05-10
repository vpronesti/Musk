package com.example.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Singer;
import com.example.entity.Song;

import java.util.List;

public interface SongDAO extends JpaRepository<Song, Long> {
    List<Song> findByTitle(String title);
    List<Song> findBySinger(Singer singer);
}
