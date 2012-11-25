package org.hackermongo.gameofkrowns.access.domain.game;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.hackermongo.gameofkrowns.access.domain.Player;

@Entity
@Table(name = "INFLUENCES")
@Inheritance(strategy=InheritanceType.JOINED)
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name="influence")
public class Influence {
	
	@Id
	@GeneratedValue(generator = "INFLUENCE_SEQUENCE")
    @SequenceGenerator(name = "INFLUENCE_SEQUENCE", sequenceName = "INFLUENCE_SEQUENCE")
	@Column(name="INFLUENCEID")
	@XmlAttribute(name="influenceid", required=true)
    private Long influenceid;
	
	@OneToOne(mappedBy="game")
	private County county;
		
	@Column(name="INFLUENCING_PLAYER_ID")
	private Player player;
		
	@Column(name="AMOUNT")
	private BigDecimal amount;

	public Long getInfluenceid() {
		return influenceid;
	}

	public void setInfluenceid(Long influenceid) {
		this.influenceid = influenceid;
	}

	public County getCounty() {
		return county;
	}

	public void setCounty(County county) {
		this.county = county;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}
