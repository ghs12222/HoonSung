package com.saffy.java;

public class MovieMgr {
	private Movie[] Movies = new Movie[100];
	private int index;
	
	public void add(Movie m) {
		Movies[index++] = m;
	}
	
	//전체검색
	public Movie[] search() {
		Movie[] sMovies = new Movie[100];
		int count = 0;
		for (int i = 0; i < 100; i++) {
			if(Movies[i] == null) 
				continue;
			sMovies[count++] = Movies[i];
		}
		return sMovies;
	}
	
	//포함검색
	public Movie[] search(String title) {
		Movie[] sMovies = new Movie[100];
		int count = 0;
		for (int i = 0; i < 100; i++) {
			if(Movies[i] == null) 
				continue;
			if(Movies[i].getTitle().contains(title))
				sMovies[count++] = Movies[i];
		}
		
		return sMovies;
	}
	
	public Movie[] searchDirector(String name) {
		Movie[] sMovies = new Movie[index];
		int count = 0;
		for (int i = 0; i < 100; i++) {
			if(Movies[i] == null)
				continue;
			if(Movies[i].getDirector().equals(name))
				sMovies[count++] = Movies[i];
		}
		return sMovies;
	}
	
	public Movie[] searchGenre(String gerne) {
		Movie[] sMovies = new Movie[index];
		int count = 0;
		for (int i = 0; i < 100; i++) {
			if(Movies[i] == null)
				continue;
			if(Movies[i].getGenre().equals(gerne))
				sMovies[count++] = Movies[i];
		}
		return sMovies;
	}
	
	public void delete(String title) {
		for (int i = 0; i < 100; i++) {
			if(Movies[i] == null)
				continue;
			if(Movies[i].getTitle().equals(title))
				Movies[i] = null;
		}
	}

	public int getSize() {
		int size = 0;
		for(Movie m : Movies) {
			if(m == null) 
				continue;
			size++;
		}
		return size;
	}
}
