package nu.danielsundberg.gameofkrowns.access.domain.game;

import nu.danielsundberg.gameofkrowns.access.domain.GameEntity;
import nu.danielsundberg.gameofkrowns.domain.game.County;
import nu.danielsundberg.gameofkrowns.domain.game.CountyName;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "COUNTIES")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class CountyEntity implements County<GameEntity, InfluenceEntity> {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "COUNTY_SEQUENCE")
    @SequenceGenerator(name = "COUNTY_SEQUENCE", sequenceName = "COUNTY_SEQUENCE")
	@Column(name="COUNTYID")
    private Long countyid;
	
	@Enumerated(EnumType.STRING)
	@Column(name="COUNTYNAME")
	protected CountyName countyname;
	
	@OneToMany(mappedBy = "county")
	private Set<InfluenceEntity> influences = new HashSet<InfluenceEntity>();
	
	@ManyToOne
    @JoinColumn(name = "COUNTY_GAME_ID", referencedColumnName = "GAMEID")
	private GameEntity game;

	public Long getCountyid() {
		return countyid;
	}

	public void setCountyid(Long countyid) {
		this.countyid = countyid;
	}
	
	public Set<InfluenceEntity> getInfluences() {
		return influences;
	}

	public void setInfluences(Set<InfluenceEntity> influences) {
		this.influences = influences;
	}

	public GameEntity getGame() {
		return game;
	}

	public void setGame(GameEntity game) {
		this.game = game;
	}

}
