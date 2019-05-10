package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Singer;

public interface SingerDAO extends JpaRepository<Singer, Long> {
}
