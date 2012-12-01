package org.hackermongo.gameofkrowns.access.domain.game;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name="influence")
public interface Influence<PLAYER, COUNTY> extends Serializable {
	
	@XmlAttribute(name="influenceid", required=true)
	public Long getInfluenceid();

	public void setInfluenceid(Long influenceid);

	@XmlAttribute(name="county", required=true)
	public COUNTY getCounty();

	public void setCounty(COUNTY county);
	
	@XmlAttribute(name="amount", required=true)
	public BigDecimal getAmount();

	public void setAmount(BigDecimal amount);

	@XmlAttribute(name="player", required=true)
	public PLAYER getPlayer();

	public void setPlayer(PLAYER player);

}
