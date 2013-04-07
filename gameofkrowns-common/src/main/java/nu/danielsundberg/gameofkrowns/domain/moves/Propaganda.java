package nu.danielsundberg.gameofkrowns.domain.moves;

import nu.danielsundberg.gameofkrowns.domain.Move;

import java.math.BigDecimal;

public interface Propaganda extends Move {

    public BigDecimal getAmount();

}
