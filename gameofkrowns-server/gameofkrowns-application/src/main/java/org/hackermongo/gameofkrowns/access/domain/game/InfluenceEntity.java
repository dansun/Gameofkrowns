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

import org.hackermongo.gameofkrowns.access.domain.PlayerEntity;

@Entity
@Table(name = "INFLUENCES")
@Inheritance(strategy=InheritanceType.JOINED)
public class InfluenceEntity implements Influence<PlayerEntity, CountyEntity>{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "INFLUENCE_SEQUENCE")
    @SequenceGenerator(name = "INFLUENCE_SEQUENCE", sequenceName = "INFLUENCE_SEQUENCE")
	@Column(name="INFLUENCEID")
    private Long influenceid;
	
	@OneToOne(mappedBy="game")
	private CountyEntity county;
		
	@Column(name="INFLUENCING_PLAYER_ID")
	private PlayerEntity player;
		
	@Column(name="AMOUNT")
	private BigDecimal amount;

	public Long getInfluenceid() {
		return influenceid;
	}

	public void setInfluenceid(Long influenceid) {
		this.influenceid = influenceid;
	}

	public CountyEntity getCounty() {
		return county;
	}

	public void setCounty(CountyEntity county) {
		this.county = county;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public PlayerEntity getPlayer() {
		return player;
	}

	public void setPlayer(PlayerEntity player) {
		this.player = player;
	}

}
