package com.example.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.SingerDAO;
import com.example.dao.SongDAO;
import com.example.entity.Singer;
import com.example.entity.Song;
import com.example.exception.NotValidParameterException;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.List;

@Service // annota il controller del MVC
public class SongsAndSingersController {

    @Autowired // DI
    SongDAO songDAO;

    @Autowired // DI
    SingerDAO singerDAO;

    public Singer addSinger(Singer singer) 
    		throws NotValidParameterException {
        if (singer == null) {
            throw new NotValidParameterException();
        }
        return singerDAO.save(singer);
    }

    public Song addSong(Song song) {
        return songDAO.save(song);
    }

    public List<Singer> getSingers() {
        return singerDAO.findAll();
    }

    @Transactional // le interazioni con il DB avvengono all'interno di una transazione
    public Song updateSinger(@NotNull Long idSong, 
    		@NotNull Long idSinger) 
    		throws NotValidParameterException {
        Song song = songDAO.getOne(idSong);
        if (song != null) {
            Singer singer = singerDAO.getOne(idSinger);
            if (singer != null) {
                song.updateSinger(singer);
                songDAO.save(song);
                singer.addSong(song);
                singerDAO.save(singer);
                return song;
            }
        }
        throw new NotValidParameterException();
    }

}
