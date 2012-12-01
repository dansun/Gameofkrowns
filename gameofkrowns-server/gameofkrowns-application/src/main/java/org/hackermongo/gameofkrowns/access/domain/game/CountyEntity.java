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

import org.hackermongo.gameofkrowns.access.domain.GameEntity;

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
	
	@OneToMany
	private Set<InfluenceEntity> influences = new HashSet<InfluenceEntity>();
	
	@ManyToOne
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
