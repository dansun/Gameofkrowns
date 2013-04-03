package nu.danielsundberg.gameofkrowns.application.service.impl;

import nu.danielsundberg.gameofkrowns.access.domain.GameEntity;
import nu.danielsundberg.gameofkrowns.application.service.GameofKrownsManagerTimerV1;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class GameofKrownsManagerTimerBeanV1 implements GameofKrownsManagerTimerV1 {

	private Logger log = LoggerFactory.getLogger(GameofKrownsManagerTimerBeanV1.class);
	
	@PersistenceContext(unitName = "gameofkrownsPersistenceUnit")
    private EntityManager entityManager;
	
	/**
	 *  Check for timed out games once every hour and log them.
	 */
	@Schedule(hour="*/1", persistent=false)
	public void handleTimeouts() {
		log.info("Checking for timed out games....");
		TypedQuery<GameEntity> timeoutQuery = entityManager.createNamedQuery("findAllTimedOutEvents", GameEntity.class);
		timeoutQuery.setParameter("currentdate", new DateTime().toDate());
		List<GameEntity> timedOutGames = timeoutQuery.getResultList();
		for(GameEntity timedOutGame : timedOutGames) {
			log.warn("Game with gameId "+timedOutGame.getGameId()+" has timed out.");
		}
	}

}
