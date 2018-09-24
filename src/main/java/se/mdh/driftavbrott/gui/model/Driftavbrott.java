package se.mdh.driftavbrott.gui.model;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document(collection = "driftavbrott")
public class Driftavbrott {

	@Id
	private String id;

	@NotNull
	@Size(min=1, max=30, message = "Fältet måste ha ett värde")
	private String kanal;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate startDatum;

	@DateTimeFormat(pattern="HH:mm")
	private LocalTime startTid;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate slutDatum;

	@DateTimeFormat(pattern="HH:mm")
	private LocalTime slutTid;

	@Size(min=1, max=30, message = "Fältet måste ha ett värde")
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

	public LocalDate getStartDatum() {
		return startDatum;
	}

	public void setStartDatum(LocalDate startDatum) {
		this.startDatum = startDatum;
	}

	public LocalTime getStartTid() {
		return startTid;
	}

	public void setStartTid(LocalTime startTid) {
		this.startTid = startTid;
	}

	public LocalDate getSlutDatum() {
		return slutDatum;
	}

	public void setSlutDatum(LocalDate slutDatum) {
		this.slutDatum = slutDatum;
	}

	public LocalTime getSlutTid() {
		return slutTid;
	}

	public void setSlutTid(LocalTime slutTid) {
		this.slutTid = slutTid;
	}

	public String getAnledning() {
		return anledning;
	}

	public void setAnledning(String anledning) {
		this.anledning = anledning;
	}

	@Override
	public String toString() {
		return "Driftavbrott [id=" + id + ", kanal=" + kanal
				+ ", startDatum=" + startDatum
				+ ", startTid=" + startTid
				+ ", slutDatum=" + slutDatum
				+ ", slutTid=" + slutTid
				+ ", anledning=" + anledning
				+ "]";
	}

}
