package com.example.boundary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.control.SongsAndSingersController;
import com.example.entity.Singer;
import com.example.entity.Song;
import com.example.exception.NotValidParameterException;

import java.util.List;

@RestController
@RequestMapping("/rest/")
public class RESTSongsAndSingers {

    @Autowired
    private SongsAndSingersController songsAndSingersController;

    @RequestMapping(method = RequestMethod.POST, path = "song")
    public ResponseEntity<?> createSong(@RequestBody Song song) {
    	System.out.println("received");
        Song newSong = songsAndSingersController.addSong(song);
        return new ResponseEntity<>(newSong, HttpStatus.CREATED);
    }


    @RequestMapping(method = RequestMethod.POST, path = "singer")
    public ResponseEntity<?> createSinger(@RequestBody Singer singer) {
        Singer newSinger = null;
        try {
            newSinger = songsAndSingersController.addSinger(singer);
        } catch (NotValidParameterException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(newSinger, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, path = "singer")
    public ResponseEntity<?> getSingers() {
        List<Singer> singers = songsAndSingersController.getSingers();
        return new ResponseEntity<>(singers, singers.size() > 0 ? HttpStatus.FOUND : HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "song/{idSong}/singer/{idSinger}")
    public ResponseEntity<?> updateSinger(@PathVariable Long idSong, @PathVariable Long idSinger) {
        Song song = null;
        try {
            song = songsAndSingersController.updateSinger(idSong, idSinger);
        } catch (NotValidParameterException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(song, HttpStatus.ACCEPTED);
    }

}
