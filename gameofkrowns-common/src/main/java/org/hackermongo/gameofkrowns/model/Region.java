package org.hackermongo.gameofkrowns.model;

import java.util.ArrayList;

public class Region {
	private int id;
	private String name;
	private ArrayList<Integer> opinion;
	private int population;
	
	public Region(int i,int p,String n,Player f, ArrayList<Integer> o) {
		id = i; //Serverside keeps track of these ids
		name = n; //Serverside keeps track of these names
		opinion = o;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Integer> getOpinion() {
		return opinion;
	}
	
	public int getPopulation() {
		return population;
	}
	
	public void setOpinion(ArrayList<Integer> o) {
		opinion = o;
	}
}