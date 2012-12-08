package nu.danielsundberg.gameofkrowns.domain;

/**
 * All types of events that we want to persist.
 * @author dansun
 *
 */
public enum EventType {
	GAME_START,
	GAME_FINISH,
	GAME_TURN,
	GAME_MOVE
}