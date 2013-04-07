package nu.danielsundberg.gameofkrowns.domain.moves;

import nu.danielsundberg.gameofkrowns.domain.Move;

import java.math.BigDecimal;

public interface Bribe extends Move {

    public BigDecimal getAmount();

}
