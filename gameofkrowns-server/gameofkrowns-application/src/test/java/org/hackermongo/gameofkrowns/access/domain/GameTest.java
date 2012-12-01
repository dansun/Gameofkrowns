package org.hackermongo.gameofkrowns.access.domain;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import org.hackermongo.gameofkrowns.test.GameofKrownsJpaTestCase;
import org.junit.Test;

public class GameTest extends GameofKrownsJpaTestCase {

	@Test
	public void testPersistGame() {
		GameEntity game = new GameEntity();
		game.setGameName(GAME_NAME);
		entityManager.persist(game);
		entityManager.flush();
	}
	
	@Test
	public void testFindGame() {
		GameEntity game = new GameEntity();
		game.setGameName(GAME_NAME);
		entityManager.persist(game);
		entityManager.flush();
		GameEntity persistedGame = entityManager.find(GameEntity.class, game.getGameId());
		assertThat(persistedGame.getGameName(), is(equalTo(game.getGameName())));
	}
	
	@Test
	public void testRegistrationTimeGeneration() {
		GameEntity game = new GameEntity();
		game.setGameName(GAME_NAME);
		entityManager.persist(game);
		entityManager.flush();
		GameEntity persistedGame = entityManager.find(GameEntity.class, game.getGameId());
		assertThat(persistedGame.getRegistrationTime(), is(notNullValue()));
	}
	
	@Test
	public void testRemoveGame() {
		GameEntity game = new GameEntity();
		game.setGameName(GAME_NAME);
		entityManager.persist(game);
		entityManager.flush();
		long id = game.getGameId();
		entityManager.remove(game);
		entityManager.flush();
		GameEntity deletedGame = entityManager.find(GameEntity.class, id);
		assertThat(deletedGame, is(equalTo(null)));
	}
}
