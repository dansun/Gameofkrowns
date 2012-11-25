package org.hackermongo.gameofkrowns.access.domain.game;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.hackermongo.gameofkrowns.access.domain.Game;

@Entity
@Table(name = "COUNTIES")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name="county")
public abstract class County {
	
	@Id
	@GeneratedValue(generator = "COUNTY_SEQUENCE")
    @SequenceGenerator(name = "COUNTY_SEQUENCE", sequenceName = "COUNTY_SEQUENCE")
	@Column(name="COUNTYID")
	@XmlAttribute(name="countyid", required=true)
    private Long countyid;
	
	@Enumerated(EnumType.STRING)
	@Column(name="COUNTYNAME")
	protected CountyName countyname;
	
	@OneToMany
	private Set<Influence> influences = new HashSet<Influence>();
	
	@ManyToOne
	private Game game;

	public Long getCountyid() {
		return countyid;
	}

	public void setCountyid(Long countyid) {
		this.countyid = countyid;
	}
	
	public final CountyName getCountyname() {
		return countyname;
	}
	
	public Set<Influence> getInfluences() {
		return influences;
	}

	public void setInfluences(Set<Influence> influences) {
		this.influences = influences;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	/**
	 * All counties in game.
	 * @author dansun
	 *
	 */
	public enum CountyName {
		BELKINGE("Blekinge län"),
		DALARNA("Dalarnas län"),
		GOTLAND("Gotlands län"),
		GAVLEBORG("Gävleborgs län"),
		HALLAND("Hallands län"),
		JAMTLAND("Jämtlands län"),
		JONKOPING("Jönköpings län"),
		KALMAR("Kalmar län"),
		KRONOBERG("Kronobergs län"),
		NORRBOTTEN("Norrbottens län"),
		SKANE("Skåne län"),
		STOCKHOLM("Stockholms län"),
		SODERMANLAND("Södermanlands län"),
		UPPSALA("Uppsala län"),
		VARMLAND("Värmlands län"),
		VASTERBOTTEN("Västerbottens län"),
		VASTERNORRLAND("Västernorrlands län"),
		VASTMANLAND("Västmanlands län"),
		VASTRA_GOTALAND("Västra Götalands län"),
		OREBRO("Örebro län"),
		OSTERGOTLAND("Östergötlands län");
		
		private String name;
		
		private CountyName(String name) {
			this.name = name;
		}
		
		public String getName() {
			return name;
		}
		
	}
	
}
