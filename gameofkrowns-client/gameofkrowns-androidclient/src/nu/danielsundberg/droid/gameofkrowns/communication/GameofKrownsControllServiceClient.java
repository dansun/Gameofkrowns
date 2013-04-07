package nu.danielsundberg.droid.gameofkrowns.communication;

import nu.danielsundberg.droid.gameofkrowns.game.model.PlayerImpl;
import nu.danielsundberg.gameofkrowns.application.exception.*;
import nu.danielsundberg.gameofkrowns.application.service.GameofKrownsControllServiceV1;
import nu.danielsundberg.gameofkrowns.domain.Game;
import nu.danielsundberg.gameofkrowns.domain.Player;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.net.URI;
import java.util.*;

/**
 * Webservice abstraction
 */
public class GameofKrownsControllServiceClient implements GameofKrownsControllServiceV1{

    private static final String TAG = "ServiceClient";

    private static final String BASE_URL = "http://service.danielsundberg.nu/gameofkrowns-jsonapi-0.0.2-SNAPSHOT/gamecontrollservice/";

    @Override
    public Set<Game<?, ?, ?>> getActiveGamesForPlayer(
            Long playerId,
            String password)
    throws
            PlayerNotFoundException,
            WrongPasswordException {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setAccept(Collections.singletonList(new MediaType("application", "json")));
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);


        URI url = UriComponentsBuilder.fromUriString(BASE_URL)
                .path("game/active")
                .queryParam("playerId", playerId)
                .queryParam("password", password)
                .build()
                .toUri();

        MappingJacksonHttpMessageConverter messageConverter = new MappingJacksonHttpMessageConverter();
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        messageConverters.add(messageConverter);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(messageConverters);

        ResponseEntity<Game[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Game[].class);
        Game[] result = responseEntity.getBody();

        return new LinkedHashSet<Game<?, ?, ?>>(Arrays.<Game<?, ?, ?>>asList(result));
    }

    @Override
    public Player<?> registerPlayer(
            String playerName,
            String password)
    throws
            PlayerAlreadyExistsException {
        return null;
    }

    @Override
    public Player<?> getPlayer(
            String playerName,
            String password)
    throws
            PlayerNotFoundException,
            WrongPasswordException {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setAccept(Collections.singletonList(new MediaType("application", "json")));
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);


        URI url = UriComponentsBuilder.fromUriString(BASE_URL)
                .path("player")
                .queryParam("playerName", playerName)
                .queryParam("password", password)
                .build()
                .toUri();

        MappingJacksonHttpMessageConverter messageConverter = new MappingJacksonHttpMessageConverter();
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        messageConverters.add(messageConverter);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(messageConverters);

        ResponseEntity<PlayerImpl> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, PlayerImpl.class);
        Player result = responseEntity.getBody();

        return result;
    }

    @Override
    public Game<?, ?, ?> createGame(
            Long playerId,
            String password,
            String gameName)
    throws
            GameAlreadyExistsException,
            PlayerNotFoundException,
            WrongPasswordException {
        return null;
    }

    @Override
    public void invitePlayer(
            Long playerId,
            String password,
            Long gameId,
            Long playerToInvite)
    throws
            PlayerNotFoundException,
            WrongPasswordException,
            GameNotFoundException {

    }

    @Override
    public void acceptGame(
            Long playerId,
            String password,
            Long gameId)
    throws
            PlayerNotFoundException,
            WrongPasswordException,
            GameNotFoundException,
            PlayerNotInvitedToGameException,
            IllegalGameStateException {

    }

    @Override
    public Game<?, ?, ?> getGame(
            Long playerId,
            String password,
            Long gameId)
    throws
            PlayerNotFoundException,
            WrongPasswordException,
            GameNotFoundException,
            PlayerNotInvitedToGameException {
        return null;
    }

    @Override
    public void reportBribeMove(
            Long playerId,
            String password,
            Long gameId,
            Long turnId,
            String countyName,
            BigDecimal amount)
    throws
            PlayerNotFoundException,
            WrongPasswordException,
            GameNotFoundException,
            PlayerNotInvitedToGameException,
            IllegalMoveException {

    }

    @Override
    public void reportPropagandaMove(
            Long playerId,
            String password,
            Long gameId,
            Long turnId,
            String countyName,
            BigDecimal amount)
    throws
            PlayerNotFoundException,
            WrongPasswordException,
            GameNotFoundException,
            PlayerNotInvitedToGameException,
            IllegalMoveException {

    }

}
