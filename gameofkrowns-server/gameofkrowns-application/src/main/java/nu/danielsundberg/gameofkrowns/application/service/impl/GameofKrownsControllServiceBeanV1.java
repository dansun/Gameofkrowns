package nu.danielsundberg.gameofkrowns.application.service.impl;

import nu.danielsundberg.gameofkrowns.access.domain.*;
import nu.danielsundberg.gameofkrowns.access.domain.events.GameStartedEntity;
import nu.danielsundberg.gameofkrowns.access.domain.events.GameTurnEntity;
import nu.danielsundberg.gameofkrowns.access.domain.game.CountyEntity;
import nu.danielsundberg.gameofkrowns.access.domain.game.counties.BlekingeEntity;
import nu.danielsundberg.gameofkrowns.access.domain.game.counties.DalarnaEntity;
import nu.danielsundberg.gameofkrowns.application.exception.*;
import nu.danielsundberg.gameofkrowns.application.service.GameofKrownsControllServiceV1;
import nu.danielsundberg.gameofkrowns.domain.Game;
import nu.danielsundberg.gameofkrowns.domain.Player;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Game of Krowns controller bean V1.
 */
@Stateless(name = "gameofkrownsControllServiceBean-v0.0.2", mappedName="gameofkrownsControllServiceBean-v0.0.2")
@TransactionAttribute(value = TransactionAttributeType.REQUIRED)
public class GameofKrownsControllServiceBeanV1 implements GameofKrownsControllServiceV1, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "gameofkrownsPersistenceUnit")
    private EntityManager entityManager;
	
	/**
	 * Finds all games for specified authorized player.
	 * @param playerId Fetching player id.
	 * @param password Fetching player password.
	 * @return Games which fetching player is playing in.
	 * @throws PlayerNotFoundException
	 * @throws WrongPasswordException
	 */
	public Set<Game<?, ?, ?>> getActiveGamesForPlayer(
		Long playerId, 
		String password) 
	throws 
		PlayerNotFoundException, 
		WrongPasswordException {
		//
		// Find and validate player
		//
		PlayerEntity player = (PlayerEntity) findPlayerById(playerId);
		validatePlayerPassword(player, password);
		//
		// Return games player is participating in
		//
		Set<Game<?,?,?>> games = new HashSet<Game<?,?,?>>();
		games.addAll(player.getPlayingGames());		
		return games;	
	}

	/**
	 * Registers new player with playerName and password.
	 * @param playerName New player name.
	 * @param password New player password.
	 * @return Player that has been registered.
	 * @throws PlayerAlreadyExistsException
	 */
	public Player<?> registerPlayer(
		String playerName, 
		String password) 
	throws 
		PlayerAlreadyExistsException {
		try {
			//
			// Find player, if found throw exception
			//
			findPlayerByName(playerName);
			throw new PlayerAlreadyExistsException("Player with playername "+playerName+" is already registered.");
		} catch (PlayerNotFoundException e) {
			//
			// Create new player
			//
			PlayerEntity newPlayer = new PlayerEntity();
			newPlayer.setPlayerName(playerName);
			newPlayer.setPassword(password);
			entityManager.persist(newPlayer);
			return newPlayer;
		}
	}

	/**
	 * Creates a new game with gameName for the specified authorized player.
	 * @param playerId Creating player id.
	 * @param password Creating player password.
	 * @param gameName Game name of new game.
	 * @return Created new game.
	 * @throws GameAlreadyExistsException
	 * @throws PlayerNotFoundException 
	 * @throws WrongPasswordException 
	 */
	public Game<?,?,?> createGame(
			Long playerId, 
			String password, 
			String gameName) 
	throws 
			GameAlreadyExistsException, 
			PlayerNotFoundException, 
			WrongPasswordException {
		//
		// Find and validate player.
		//
		PlayerEntity player = (PlayerEntity) findPlayerById(playerId);
		validatePlayerPassword(player, password);
		try {
			//
			// Find game, if found throw exception
			//
			findGameByName(gameName);
			throw new GameAlreadyExistsException("Game with gamename "+gameName+" is already created.");
		} catch (GameNotFoundException e) {
			//
			// Create new game.
			//
			GameEntity newGame = new GameEntity();
			newGame.setGameName(gameName);
            entityManager.persist(newGame);

            //
            // Add ownership for registering player
            //
            OwnedGameEntity ownedGameEntity = new OwnedGameEntity();
            ownedGameEntity.setPlayer(player);
            ownedGameEntity.setGame(newGame);
            player.addOwnedGame(ownedGameEntity);
            newGame.setOwner(ownedGameEntity);
            entityManager.persist(ownedGameEntity);

            //
            // Add invitaiont of registering player to game
            //
            GameInvitationEntity gameInvitationEntity = new GameInvitationEntity();
            gameInvitationEntity.setPlayer(player);
            gameInvitationEntity.setGame(newGame);
            player.addInvitationToGame(gameInvitationEntity);
            newGame.addInvitedPlayer(gameInvitationEntity);
            entityManager.persist(gameInvitationEntity);


            //
            // Add registering player as player to game
            //
            GamePlayerEntity gamePlayer = new GamePlayerEntity();
            gamePlayer.setGame(newGame);
            gamePlayer.setPlayer(player);
            player.addGamePlayer(gamePlayer);
            newGame.addGamePlayer(gamePlayer);
            entityManager.persist(gamePlayer);

            //
            // Merge entities
            //
            entityManager.merge(player);
            entityManager.merge(newGame);

            //
            // Flush and refresh game for return.
            //
			entityManager.flush();
			entityManager.refresh(newGame);
			return newGame;
		}
	}

	/**
	 * Invites players with specified playerId´s to specified game.
	 * @param playerId Inviting player id.
	 * @param password Inviting player password.
	 * @param gameId Game to invite player to.
	 * @param playerIdToInvite Player id to invite.
     * @throws PlayerNotFoundException
     * @throws WrongPasswordException
     * @throws GameNotFoundException
	 */
	public void invitePlayer(
			Long playerId, 
			String password, 
			Long gameId, 
			Long playerIdToInvite)
	throws 
			PlayerNotFoundException, 
			WrongPasswordException, 
			GameNotFoundException {
		//
		// Find and validate player.
		//
		PlayerEntity player = (PlayerEntity) findPlayerById(playerId);
		validatePlayerPassword(player, password);
		//
		// Find game to invite players to
		//
		GameEntity gameToInviteTo = null;
		for(GameEntity game : player.getOwnedGames()) {
			if(game.getGameId().equals(gameId)) {
				gameToInviteTo = game;
			}
		}
		if(gameToInviteTo == null) {
			throw new GameNotFoundException("Game with gameId "+gameId+" not found in players started games");
		}

		//
		// Add player, if found, to game
		//
        PlayerEntity playerToInvite = entityManager.find(PlayerEntity.class, playerIdToInvite);
		if(playerToInvite == null) {
		    throw new PlayerNotFoundException("Invited player with playerId "+playerIdToInvite+" could not be found.");
        }

        GameInvitationEntity invitationEntity = new GameInvitationEntity();
        invitationEntity.setPlayer(playerToInvite);
        invitationEntity.setGame(gameToInviteTo);
        entityManager.persist(invitationEntity);
        gameToInviteTo.addInvitedPlayer(invitationEntity);
        playerToInvite.addInvitationToGame(invitationEntity);
        entityManager.merge(gameToInviteTo);
        entityManager.merge(playerToInvite);

	}

    /**
     * Accept invitation to specified game for player with password.
     * @param playerId Accepting player id.
     * @param password Accepting player password.
     * @param gameId Game to accept invitation for.
     * @throws PlayerNotFoundException
     * @throws WrongPasswordException
     * @throws GameNotFoundException
     * @throws PlayerNotInvitedToGameException
     */
	public void acceptGame(
			Long playerId, 
			String password, 
			Long gameId)
    throws
            PlayerNotFoundException,
            WrongPasswordException,
            GameNotFoundException,
            PlayerNotInvitedToGameException, IllegalGameStateException {
		//
		// Find and validate player.
		//
		PlayerEntity player = (PlayerEntity) findPlayerById(playerId);
		validatePlayerPassword(player, password);
		//
		// Find game to accept
		//
		GameEntity gameToAccept = entityManager.find(GameEntity.class, gameId);
		if(gameToAccept == null) {
			throw new GameNotFoundException("Game to accept with gameId '"+gameId+
					"' could not be found.");
		}
		//
		// Accept game
		//
		if(gameToAccept.getInvitedPlayers().contains(player)) {
			GamePlayerEntity gamePlayerEntity = new GamePlayerEntity();
            gamePlayerEntity.setPlayer(player);
            gamePlayerEntity.setGame(gameToAccept);
            entityManager.persist(gamePlayerEntity);
            player.addGamePlayer(gamePlayerEntity);
            gameToAccept.addGamePlayer(gamePlayerEntity);
            entityManager.merge(player);
            entityManager.merge(gameToAccept);
		} else {
			throw new PlayerNotInvitedToGameException("Player with playerId '"+playerId+
					"' has not been invited to game with gameId '"+gameId+"'.");
		}

        //
        // Check for all players and start game if all has responded
        //
        if(gameToAccept.getInvitedPlayers().containsAll(gameToAccept.getPlayers())) {
            //
            // Start game
            //
            GameStartedEntity gameStartedEntity = new GameStartedEntity();
            entityManager.persist(gameStartedEntity);

            GameEventEntity gameEventEntity = new GameEventEntity();
            gameEventEntity.setEvent(gameStartedEntity);
            gameEventEntity.setGame(gameToAccept);
            registerEvent(gameEventEntity);
            //
            // Add new turn to game
            //
            GameTurnEntity gameTurnEntity = new GameTurnEntity();
            gameTurnEntity.setGame(gameToAccept);
            entityManager.persist(gameTurnEntity);

            gameEventEntity = new GameEventEntity();
            gameEventEntity.setEvent(gameTurnEntity);
            gameEventEntity.setGame(gameToAccept);
            registerEvent(gameEventEntity);
        }

	}
	
	/**
	 * Finds unique player with playerName
	 * @param playerName Player name to find.
	 * @return Player with specified name.
	 * @throws PlayerNotFoundException
	 */
	private Player<?> findPlayerByName(
			String playerName) 
	throws 
			PlayerNotFoundException {
		//
		// Find player with playerName and return, else throw exception
		//
		Query playerQuery = entityManager.createNamedQuery("player.findByPlayerName");
		playerQuery.setParameter("playerName", playerName);
		try {
			return (PlayerEntity) playerQuery.getSingleResult();	
		} catch (NoResultException e) {
			throw new PlayerNotFoundException("No player with playername '"+playerName+"' could be found.");
		}
	}
	
	/**
	 * Finds unique game with specified gameName.
	 * @param gameName Game name to find.
	 * @return Game with specified game name.
	 * @throws GameNotFoundException
	 */
	private Game<?,?,?> findGameByName(
			String gameName) 
	throws 
			GameNotFoundException {
		//
		// Find game with gameName and return, else throw exception
		//
		Query gameQuery = entityManager.createNamedQuery("game.findByGameName");
		gameQuery.setParameter("gameName", gameName);
		try {
			return (GameEntity) gameQuery.getSingleResult();	
		} catch (NoResultException e) {
			throw new GameNotFoundException("No game with gameName '"+gameName+"' could be found.");
		}
	}
	
	/**
	 * Validates that players password is correct
	 * @param player Validating player entity.
	 * @param password Password to validate on entity.
	 * @throws WrongPasswordException
	 */
	private void validatePlayerPassword(
			PlayerEntity player, 
			String password) 
	throws 
			WrongPasswordException {
		//
		// Compare give password with that of persisted players
		//
		if(!player.getPassword().equals(password)) {
			throw new WrongPasswordException("Password for player with playerId "+player.getPlayerId()+" is wrong.");
		}
	}
	
	/**
	 * Find player by specified playerId.
	 * @param playerId Find player with specified id.
	 * @return Player with specified id.
	 * @throws PlayerNotFoundException
	 */
	private Player<?> findPlayerById(
			Long playerId) 
	throws 
			PlayerNotFoundException {
		//
		// Find player by entity ID, else throw exception
		//
		PlayerEntity player = entityManager.find(PlayerEntity.class, playerId);
		if(player==null) {
			throw new PlayerNotFoundException("Player with playerId "+playerId+" is not registered.");
		}
		return player;
	}

    /**
     * Retrieve game for player with password.
     * @param playerId Fetching player id.
     * @param password Fetching player password.
     * @param gameId Game id to fetch.
     * @return Game which player is invited to, owning or playing in.
     * @throws PlayerNotFoundException
     * @throws WrongPasswordException
     * @throws GameNotFoundException
     * @throws PlayerNotInvitedToGameException
     */
	@Override
	public GameEntity getGame(
			Long playerId, 
			String password, 
			Long gameId)
	throws 
			PlayerNotFoundException, 
			WrongPasswordException,
			GameNotFoundException, 
			PlayerNotInvitedToGameException {
        //
        // Find and validate fetching player.
        //
        PlayerEntity player = entityManager.find(PlayerEntity.class, playerId);
        validatePlayerPassword(player, password);

        //
        // Find and validate player for specified game.
        //
        GameEntity game = entityManager.find(GameEntity.class, gameId);
        if(game==null) {
            throw new GameNotFoundException("Game with gameId "+gameId+" is not registered.");
        } else if(!game.getOwner().equals(player) &&
                !game.getPlayers().contains(player)) {
            throw new PlayerNotInvitedToGameException("Player with playerId " +
                    playerId + " is not invited to, or owning, game with gameId " + gameId + " .");
        }

		return game;
	}

    /**
     * Report a bribe move for player with password on county in game
     * @param playerId Registering player id
     * @param password Registering player password
     * @param gameId Game id to register move on
     * @param countyName County in specified game
     * @param amount Amount to spend
     * @throws PlayerNotFoundException
     * @throws WrongPasswordException
     * @throws GameNotFoundException
     * @throws PlayerNotInvitedToGameException
     * @throws IllegalMoveException
     */
	@Override
	public void reportBribeMove(
            Long playerId,
            String password,
            Long gameId,
			String countyName,
            BigDecimal amount)
    throws
            PlayerNotFoundException,
            WrongPasswordException,
			GameNotFoundException,
            PlayerNotInvitedToGameException,
			IllegalMoveException {
        //
        // Find and validate registering player.
        //
        PlayerEntity player = entityManager.find(PlayerEntity.class, playerId);
        validatePlayerPassword(player, password);

        //
        // Find and validate player for specified game.
        //
        GameEntity game = entityManager.find(GameEntity.class, gameId);
        if(game==null) {
            throw new GameNotFoundException("Game with gameId "+gameId+" is not registered.");
        } else if(!game.getOwner().equals(player) &&
                !game.getPlayers().contains(player)) {
            throw new PlayerNotInvitedToGameException("Player with playerId " +
                    playerId + " is not invited to, or owning, game with gameId " + gameId + " .");
        }
		
	}

    /**
     * Report a propaganda move for player with password on county in game
     * @param playerId Registering player id
     * @param password Registering player password
     * @param gameId Game to register move on
     * @param countyName County in game
     * @param amount Amount to spend on propaganda
     * @throws PlayerNotFoundException
     * @throws WrongPasswordException
     * @throws GameNotFoundException
     * @throws PlayerNotInvitedToGameException
     * @throws IllegalMoveException
     */
	@Override
	public void reportPropagandaMove(
            Long playerId,
            String password,
			Long gameId,
            String countyName,
            BigDecimal amount)
    throws
            PlayerNotFoundException,
            WrongPasswordException,
			GameNotFoundException,
            PlayerNotInvitedToGameException,
			IllegalMoveException {
		// TODO Auto-generated method stub
		
	}

    /**
     * Reports move to game and calculates action based on game state.
     * @param gameEventEntity Game and move to register.
     * @throws IllegalMoveException
     * @throws IllegalGameStateException
     */
    protected void reportMove(GameEventEntity gameEventEntity)
    throws
            IllegalMoveException,
            IllegalGameStateException {
        //
        // Validate player move on turn in game
        //
        if (!(gameEventEntity.getEvent() instanceof MoveEntity)) {
            throw new IllegalMoveException("Event must be a move.");
        }

        TypedQuery<MoveEntity> moveQuery =
                entityManager.createNamedQuery("move.findByPlayerAndGameTurn",
                        MoveEntity.class);
        moveQuery.setParameter("player", ((MoveEntity)gameEventEntity.getEvent()).getPlayer());
        moveQuery.setParameter("gameTurn", ((MoveEntity)gameEventEntity.getEvent()).getGameTurn());
        if(moveQuery.getResultList().isEmpty()) {
            registerEvent(gameEventEntity);
        } else {
            throw new IllegalMoveException("Player with playerId "
                    + ((MoveEntity)gameEventEntity.getEvent()).getPlayer().getPlayerId()
                    + " has registered move for specified turn.");
        }
        //
        // Check if all players has made moves in turn
        //
        TypedQuery<MoveEntity> movesQuery =
                entityManager.createNamedQuery("move.findMovesForGameTurn",
                        MoveEntity.class);
        movesQuery.setParameter("gameTurn", ((MoveEntity)gameEventEntity.getEvent()).getGameTurn());
        if(gameEventEntity.getEvent().getGame().getPlayers().size() == movesQuery.getResultList().size()) {
            //
            // Start new turn
            //
            GameTurnEntity nextGameTurn = new GameTurnEntity();
            nextGameTurn.setGame(gameEventEntity.getEvent().getGame());
            GameEventEntity gameTurnEventEntity = new GameEventEntity();
            gameTurnEventEntity.setEvent(nextGameTurn);
            gameTurnEventEntity.setGame(gameEventEntity.getEvent().getGame());
            registerEvent(gameTurnEventEntity);
        }

    }

    /**
     * Register event on game and take action based on game state.
     * @param gameEventEntity Game and event to register.
     * @throws IllegalGameStateException
     */
    protected void registerEvent(
            GameEventEntity gameEventEntity)
    throws
            IllegalGameStateException {
        //
        // Validate and take action on event
        //
        switch(gameEventEntity.getGame().getGameState()) {
            case CREATED:
                if(gameEventEntity.getEvent() instanceof GameStartedEntity) {
                    //
                    // Add Blekinge
                    //
                    CountyEntity countyEntity = new BlekingeEntity();
                    entityManager.persist(countyEntity);

                    GameCountyEntity gameCountyEntity = new GameCountyEntity();
                    gameCountyEntity.setGame(gameEventEntity.getGame());
                    gameCountyEntity.setCounty(countyEntity);
                    entityManager.persist(gameCountyEntity);

                    gameEventEntity.getGame().addGameCounty(gameCountyEntity);

                    //
                    // Add Dalarna
                    //
                    countyEntity = new DalarnaEntity();
                    entityManager.persist(countyEntity);

                    gameCountyEntity = new GameCountyEntity();
                    gameCountyEntity.setGame(gameEventEntity.getGame());
                    gameCountyEntity.setCounty(countyEntity);
                    entityManager.persist(gameCountyEntity);

                    gameEventEntity.getGame().addGameCounty(gameCountyEntity);

                    entityManager.merge(gameEventEntity.getGame());
                }
                break;
            case RUNNING:
                if(gameEventEntity.getEvent() instanceof GameStartedEntity) {
                    throw new IllegalGameStateException("Game is already started.");
                }
                break;
            case FINISHED:
                throw new IllegalGameStateException("Game is finished and cannot add new events.");
            default:
                throw new IllegalGameStateException("Game is in an illegal state.");
        }
        //
        // Persist game event.
        //
        entityManager.persist(gameEventEntity);
    }

	/**
	 * Get player with player name and password
	 * @param playerName Name of player to find
	 * @param password Password of player to find
	 * @return Player
	 * @throws PlayerNotFoundException
	 * @throws WrongPasswordException  
	 */
	public Player<?> getPlayer(
			String playerName, 
			String password)
	throws 
			PlayerNotFoundException, 
			WrongPasswordException {
		PlayerEntity player = (PlayerEntity) findPlayerByName(playerName);
		validatePlayerPassword(player, password);
		return player;
	}
	
}