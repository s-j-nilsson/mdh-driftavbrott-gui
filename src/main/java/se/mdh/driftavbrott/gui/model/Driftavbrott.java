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

	@NotNull(message = "Fältet måste ha ett värde")
	private Kanal kanal;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate startDatum;

	@DateTimeFormat(pattern="HH:mm")
	private LocalTime startTid;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate slutDatum;

	@DateTimeFormat(pattern="HH:mm")
	private LocalTime slutTid;

	@NotNull(message = "Fältet måste ha ett värde")
	private Anledning anledning;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Kanal getKanal() {
		return kanal;
	}

	public void setKanal(Kanal kanal) {
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

	public Anledning getAnledning() {
		return anledning;
	}

	public void setAnledning(Anledning anledning) {
		this.anledning = anledning;
	}

	@Override
	public String toString() {
		return "Driftavbrott [id=" + id + ", kanal=" + kanal.getNamn()
				+ ", startDatum=" + startDatum
				+ ", startTid=" + startTid
				+ ", slutDatum=" + slutDatum
				+ ", slutTid=" + slutTid
				+ ", anledning=" + anledning.getNamn()
				+ "]";
	}

}
