package com.example.service;

import java.util.List;

import com.example.entity.Genere;


public interface GenereService {
public Genere addGenere(Genere g);

public Genere updateGenere(Genere g);

public Genere getGenereById(Long id);

public void deleteGenere(Long id);

public List<Genere> getAllGeneres();
}
