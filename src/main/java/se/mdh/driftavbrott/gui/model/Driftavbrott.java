package se.mdh.driftavbrott.gui.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "driftavbrott")
public class Driftavbrott {

	@Id
	private String id;

	private String kanal;
	private String start;
	private String slut;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getKanal() {
		return kanal;
	}

	public void setKanal(String kanal) {
		this.kanal = kanal;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getSlut() {
		return slut;
	}

	public void setSlut(String slut) {
		this.slut = slut;
	}

	@Override
	public String toString() {
		return "Driftavbrott [id=" + id + ", kanal=" + kanal + ", start=" + start
				+ ", slut=" + slut
				+ "]";
	}

}
