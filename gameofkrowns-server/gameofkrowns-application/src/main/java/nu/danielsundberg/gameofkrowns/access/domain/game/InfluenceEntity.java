package nu.danielsundberg.gameofkrowns.access.domain.game;

import nu.danielsundberg.gameofkrowns.access.domain.PlayerEntity;
import nu.danielsundberg.gameofkrowns.domain.game.County;
import nu.danielsundberg.gameofkrowns.domain.game.Influence;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "INFLUENCES")
@Inheritance(strategy=InheritanceType.JOINED)
public class InfluenceEntity implements Influence {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "INFLUENCE_SEQUENCE")
    @SequenceGenerator(name = "INFLUENCE_SEQUENCE", sequenceName = "INFLUENCE_SEQUENCE")
	@Column(name="INFLUENCEID")
    private Long influenceid;
	
	@ManyToOne
    @JoinColumn(name = "INFLUENCE_COUNTY_ID", referencedColumnName = "COUNTYID")
	private CountyEntity county;
		
	@ManyToOne
    @JoinColumn(name = "INFLUENCE_PLAYER_ID", referencedColumnName = "PLAYERID")
	private PlayerEntity player;
		
	@Column(name="AMOUNT")
	private BigDecimal amount;

	public Long getInfluenceId() {
		return influenceid;
	}

	public void setInfluenceId(Long influenceid) {
		this.influenceid = influenceid;
	}

	public County getCounty() {
		return county;
	}

	public void setCounty(CountyEntity county) {
		this.county = county;
	}

    public Long getCountyId() {
        return this.county.getCountyId();
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

    public Long getPlayerId() {
        return this.player.getPlayerId();
    }

}
