package nu.danielsundberg.gameofkrowns.access.domain.game;

import nu.danielsundberg.gameofkrowns.access.domain.GameCountyEntity;
import nu.danielsundberg.gameofkrowns.domain.Game;
import nu.danielsundberg.gameofkrowns.domain.game.County;
import nu.danielsundberg.gameofkrowns.domain.game.CountyName;
import nu.danielsundberg.gameofkrowns.domain.game.Influence;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "COUNTIES")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class CountyEntity implements County {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "COUNTY_SEQUENCE")
    @SequenceGenerator(name = "COUNTY_SEQUENCE", sequenceName = "COUNTY_SEQUENCE")
	@Column(name="COUNTYID")
    private Long countyid;
	
	@Enumerated(EnumType.STRING)
	@Column(name="COUNTYNAME", updatable = false)
	protected CountyName countyname;
	
	@OneToMany(mappedBy = "county", fetch = FetchType.EAGER)
	private Set<InfluenceEntity> influences = new HashSet<InfluenceEntity>();

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = true)
	private GameCountyEntity gameCounty;

	public Long getCountyId() {
		return countyid;
	}

	public void setCountyId(Long countyid) {
		this.countyid = countyid;
	}

    @Override
    public CountyName getCountyname() {
        return countyname;
    }

    public Set<Influence> getInfluences() {
        Set<Influence> countyInfluences = new HashSet<Influence>();
        countyInfluences.addAll(influences);
		return countyInfluences;
	}

	public void setInfluences(Set<InfluenceEntity> influences) {
		this.influences = influences;
	}

    public void setGameCounty(GameCountyEntity gameCountyEntity) {
        this.gameCounty = gameCountyEntity;
    }

	public Game getGame() {
		return gameCounty.getGame();
	}

    @Override
    public Long getGameId() {
        return this.gameCounty.getGame().getGameId();
    }
}
