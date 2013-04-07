package nu.danielsundberg.gameofkrowns.domain;

/**
 * All types of events that we want to persist.

 *
 */
public enum EventType {
	GAME_START,
	GAME_FINISH,
	GAME_TURN,
    PLAYER_FUNDING,
	GAME_MOVE
}