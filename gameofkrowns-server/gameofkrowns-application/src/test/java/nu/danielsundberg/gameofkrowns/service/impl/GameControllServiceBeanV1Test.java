package nu.danielsundberg.gameofkrowns.service.impl;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import nu.danielsundberg.gameofkrowns.access.domain.GameEntity;
import nu.danielsundberg.gameofkrowns.access.domain.PlayerEntity;
import nu.danielsundberg.gameofkrowns.application.exception.PlayerNotFoundException;
import nu.danielsundberg.gameofkrowns.application.exception.WrongPasswordException;
import nu.danielsundberg.gameofkrowns.application.service.impl.GameofKrownsControllServiceBeanV1;
import nu.danielsundberg.gameofkrowns.domain.Game;
import nu.danielsundberg.gameofkrowns.domain.Player;
import nu.danielsundberg.gameofkrowns.test.GameofKrownsApplicationTestCase;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.internal.util.reflection.Whitebox;

public class GameControllServiceBeanV1Test extends GameofKrownsApplicationTestCase {

	private GameofKrownsControllServiceBeanV1 service = new GameofKrownsControllServiceBeanV1();
	private Set<GameEntity> games;
	@Mock EntityManager entityManager;
	@Mock Query query;
	@Mock PlayerEntity player;
	@Mock GameEntity game;
	
	@Before
	public void setUp() throws Exception {
		Whitebox.setInternalState(service, "entityManager", entityManager);
		games = new HashSet<GameEntity>();
		games.add(game);
		when(entityManager.find(PlayerEntity.class, PLAYER_ID)).thenReturn(player);
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
		Set<Game<?,?,?>> games = service.getActiveGamesForPlayer(PLAYER_ID, PLAYER_PASSWORD);
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
		verify(entityManager).find(PlayerEntity.class, PLAYER_ID);
	}
	
}
