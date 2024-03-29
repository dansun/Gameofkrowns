package nu.danielsundberg.gameofkrowns.access.domain;

import nu.danielsundberg.gameofkrowns.access.domain.game.CountyEntity;

import javax.persistence.*;

@Entity
@Table(name="GAME_COUNTIES")
public class GameCountyEntity {

    @Id
    @GeneratedValue(generator = "GAME_COUNTY_SEQUENCE_GENERATOR")
    @SequenceGenerator(
            name = "GAME_COUNTY_SEQUENCE_GENERATOR",
            sequenceName = "GAME_COUNTY_SEQUENCE")
    @Column(name="GAME_COUNTYID")
    private long gameCountyId;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "GAME_ID", referencedColumnName = "GAMEID")
    private GameEntity game;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "COUNTY_ID", referencedColumnName = "COUNTYID")
    private CountyEntity county;

    public void setGame(GameEntity gameEntity) {
        this.game = gameEntity;
    }

    public GameEntity getGame() {
        return game;
    }

    public void setCounty(CountyEntity countyEntity) {
        this.county = countyEntity;
    }

    public CountyEntity getCounty() {
        return county;
    }
}
