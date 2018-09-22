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
	private String anledning;

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

	public String getAnledning() {
		return anledning;
	}

	public void setAnledning(String anledning) {
		this.anledning = anledning;
	}

	@Override
	public String toString() {
		return "Driftavbrott [id=" + id + ", kanal=" + kanal + ", start=" + start
				+ ", slut=" + slut
				+ ", anledning=" + anledning
				+ "]";
	}

}
