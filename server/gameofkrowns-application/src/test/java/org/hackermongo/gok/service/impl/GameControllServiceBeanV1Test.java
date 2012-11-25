package org.hackermongo.gok.service.impl;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hackermongo.gameofkrowns.access.domain.Game;
import org.hackermongo.gameofkrowns.access.domain.Player;
import org.hackermongo.gameofkrowns.application.exception.PlayerNotFoundException;
import org.hackermongo.gameofkrowns.application.exception.WrongPasswordException;
import org.hackermongo.gameofkrowns.application.service.impl.GameofKrownsControllServiceBeanV1;
import org.hackermongo.gok.test.GameofKrownsTestCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.internal.util.reflection.Whitebox;

public class GameControllServiceBeanV1Test extends GameofKrownsTestCase {

	private GameofKrownsControllServiceBeanV1 service = new GameofKrownsControllServiceBeanV1();
	private Set<Game> games;
	@Mock EntityManager entityManager;
	@Mock Query query;
	@Mock Player player;
	@Mock Game game;
	
	@Before
	public void setUp() throws Exception {
		Whitebox.setInternalState(service, "entityManager", entityManager);
		games = new HashSet<Game>();
		games.add(game);
		when(entityManager.find(Player.class, PLAYER_ID)).thenReturn(player);
		when(entityManager.createNamedQuery("player.findByPlayerName")).thenReturn(query);
		when(query.getSingleResult()).thenReturn(player);
		when(game.getOwner()).thenReturn(player);
		when(game.getGameName()).thenReturn(GAME_NAME);
		when(game.getGameId()).thenReturn(GAME_ID);
		when(player.getPassword()).thenReturn(PLAYER_PASSWORD);
		when(player.getPlayerName()).thenReturn(PLAYER_NAME);
		when(player.getPlayingGames()).thenReturn(games);
	}
	
	@Test
	public void testGetGamesForPlayer() throws Exception {
		Set<Game> games = service.getActiveGamesForPlayer(PLAYER_ID, PLAYER_PASSWORD);
		assert(games.contains(game));
	}
	
	@Test(expected = PlayerNotFoundException.class)
	public void testGetGamesForNonExistingPlayer() throws Exception {
		when(query.getSingleResult()).thenThrow(new NoResultException());
		service.getActiveGamesForPlayer(NON_EXISTING_PLAYER_ID, PLAYER_PASSWORD);
		verify(entityManager).find(Player.class, NON_EXISTING_PLAYER_ID);
	}
	
	@Test(expected = WrongPasswordException.class)
	public void testGetGamesForPlayerWrongPassword() throws Exception {
		service.getActiveGamesForPlayer(PLAYER_ID, WRONG_PASSWORD);
		verify(entityManager).find(Player.class, PLAYER_ID);
	}
	
}
