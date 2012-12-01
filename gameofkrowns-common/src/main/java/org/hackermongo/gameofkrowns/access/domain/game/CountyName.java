package org.hackermongo.gameofkrowns.access.domain.game;

/**
 * All counties in game.
 * @author dansun
 *
 */
public enum CountyName {
	BLEKINGE("Blekinge län"),
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