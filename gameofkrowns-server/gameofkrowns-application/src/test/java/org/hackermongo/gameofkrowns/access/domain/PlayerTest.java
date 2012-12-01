package org.hackermongo.gameofkrowns.access.domain;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.hackermongo.gameofkrowns.test.GameofKrownsJpaTestCase;
import org.junit.Test;

public class PlayerTest extends GameofKrownsJpaTestCase {

	@Test
	public void testPersistPlayer() {
		PlayerEntity player = new PlayerEntity();
		player.setPlayerName(PLAYER_NAME);
		entityManager.persist(player);
		entityManager.flush();
	}
	
	@Test
	public void testFindPlayer() {
		PlayerEntity player = new PlayerEntity();
		player.setPlayerName(PLAYER_NAME);
		entityManager.persist(player);
		entityManager.flush();
		PlayerEntity persistedPlayer = entityManager.find(PlayerEntity.class, player.getPlayerId());
		assertThat(persistedPlayer.getPlayerName(), is(equalTo(player.getPlayerName())));
	}
	
	@Test
	public void testRemovePlayer() {
		PlayerEntity player = new PlayerEntity();
		player.setPlayerName(PLAYER_NAME);
		entityManager.persist(player);
		entityManager.flush();
		long id = player.getPlayerId();
		entityManager.remove(player);
		entityManager.flush();
		PlayerEntity deletedPlayer = entityManager.find(PlayerEntity.class, id);
		assertThat(deletedPlayer, is(equalTo(null)));
	}
	
	
}
