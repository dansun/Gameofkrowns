package nu.danielsundberg.gameofkrowns.business.service;

import nu.danielsundberg.gameofkrowns.application.exception.*;
import nu.danielsundberg.gameofkrowns.application.service.GameofKrownsControllServiceV1;
import nu.danielsundberg.gameofkrowns.domain.Game;
import nu.danielsundberg.gameofkrowns.domain.Player;

import javax.ejb.Remote;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.math.BigDecimal;
import java.util.Set;

@WebService(name="GameControllService",
        targetNamespace="urn:nu.danielsundberg.gameofkrowns:gamecontrollservice")
@SOAPBinding(style = javax.jws.soap.SOAPBinding.Style.DOCUMENT)
@Remote
public interface GameofKrownsControllServiceWSV1 extends GameofKrownsControllServiceV1 {

    @Override
    @WebMethod(operationName="getPlayer")
    public Player getPlayer(
            @WebParam(name="PlayerName",
                    partName = "PlayerName",
                    targetNamespace="urn:nu.danielsundberg.gameofkrowns:gamecontrollservice:player")
            String playerName,
            @WebParam(name="PlayerPassword",
                    partName = "PlayerPassword",
                    targetNamespace="urn:nu.danielsundberg.gameofkrowns:gamecontrollservice:player")
            String password)
    throws
            PlayerNotFoundException,
            WrongPasswordException;

    @Override
    @WebMethod(operationName="acceptGame")
    public void acceptGame(
            @WebParam(name="PlayerId",
                    partName = "PlayerId",
                    targetNamespace="urn:nu.danielsundberg.gameofkrowns:gamecontrollservice:player")
            Long playerId,
            @WebParam(name="PlayerPassword",
                    partName = "PlayerPassword",
                    targetNamespace="urn:nu.danielsundberg.gameofkrowns:gamecontrollservice:player")
            String password,
            @WebParam(name="GameId",
                    partName = "GameId",
                    targetNamespace="urn:nu.danielsundberg.gameofkrowns:gamecontrollservice:game")
            Long gameId)
    throws
            PlayerNotFoundException,
            WrongPasswordException,
            GameNotFoundException,
            PlayerNotInvitedToGameException,
            IllegalGameStateException;


	@Override
    @WebMethod(operationName="createGame")
    public @WebResult(name="Game",
            partName="Game",
            targetNamespace="urn:nu.danielsundberg.gameofkrowns:gamecontrollservice:game")
            Game
    createGame(
            @WebParam(name="PlayerId",
                    partName = "PlayerId",
                    targetNamespace="urn:nu.danielsundberg.gameofkrowns:gamecontrollservice:player")
                    Long playerId,
            @WebParam(name="PlayerPassword",
                    partName = "PlayerPassword",
                    targetNamespace="urn:nu.danielsundberg.gameofkrowns:gamecontrollservice:player")
                    String password,
            @WebParam(name="GameName",
                    partName = "GameName",
                    targetNamespace="urn:nu.danielsundberg.gameofkrowns:gamecontrollservice:game")
                    String gameName)
    throws
            GameAlreadyExistsException,
            PlayerNotFoundException,
            WrongPasswordException;

	@Override
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @WebMethod(operationName="getGamesForPlayer")
    public @WebResult(name="Game",
            partName="Game",
            targetNamespace="urn:nu.danielsundberg.gameofkrowns:gamecontrollservice:game")
            Set<Game>
    getActiveGamesForPlayer(
            @WebParam(name="PlayerId",
                    partName = "PlayerId",
                    targetNamespace="urn:nu.danielsundberg.gameofkrowns:gamecontrollservice:player")
            Long playerId,
            @WebParam(name="PlayerPassword",
                    partName = "PlayerPassword",
                    targetNamespace="urn:nu.danielsundberg.gameofkrowns:gamecontrollservice:player")
            String password)
    throws
            PlayerNotFoundException,
            WrongPasswordException;

	@Override
    @WebMethod(operationName="invitePlayers")
    public void invitePlayer(
            @WebParam(name="PlayerId",
                    partName = "PlayerId",
                    targetNamespace="urn:nu.danielsundberg.gameofkrowns:gamecontrollservice:player")
            Long playerId,
            @WebParam(name="PlayerPassword",
                    partName = "PlayerPassword",
                    targetNamespace="urn:nu.danielsundberg.gameofkrowns:gamecontrollservice:player")
            String password,
            @WebParam(name="GameId",
                    partName = "GameId",
                    targetNamespace="urn:nu.danielsundberg.gameofkrowns:gamecontrollservice:game")
            Long gameId,
            @WebParam(name="PlayerIdToInvite",
                    partName="PlayerIdToInvite",
                    targetNamespace="urn:nu.danielsundberg.gameofkrowns:gamecontrollservice:player")
            Long playerIdToInvite)
    throws
            PlayerNotFoundException,
            WrongPasswordException,
            GameNotFoundException ;

    @Override
    @WebMethod(operationName="getGame")
    public Game getGame(
            @WebParam(name="PlayerId",
                    partName = "PlayerId",
                    targetNamespace="urn:nu.danielsundberg.gameofkrowns:gamecontrollservice:player")
            Long playerId,
            @WebParam(name="PlayerPassword",
                    partName = "PlayerPassword",
                    targetNamespace="urn:nu.danielsundberg.gameofkrowns:gamecontrollservice:player")
            String password,
            @WebParam(name="GameId",
                    partName = "GameId",
                    targetNamespace="urn:nu.danielsundberg.gameofkrowns:gamecontrollservice:game")
            Long gameId)
    throws
            PlayerNotFoundException,
            WrongPasswordException,
            GameNotFoundException,
            PlayerNotInvitedToGameException;
	
	@Override
    @WebMethod(operationName="registerPlayer")
    public @WebResult(name="Player",
            partName="Player",
            targetNamespace="urn:nu.danielsundberg.gameofkrowns:gamecontrollservice:player")
            Player
    registerPlayer(
            @WebParam(name="PlayerName",
                    partName = "PlayerName",
                    targetNamespace="urn:nu.danielsundberg.gameofkrowns:gamecontrollservice:player")
            String playerName,
            @WebParam(name="PlayerPassword",
                    partName = "PlayerPassword",
                    targetNamespace="urn:nu.danielsundberg.gameofkrowns:gamecontrollservice:player")
            String password)
    throws
            PlayerAlreadyExistsException;

    @Override
    @WebMethod(operationName="reportBribeMove")
    public void reportBribeMove(
            @WebParam(name="PlayerId",
                    partName = "PlayerId",
                    targetNamespace="urn:nu.danielsundberg.gameofkrowns:gamecontrollservice:player")
            Long playerId,
            @WebParam(name="PlayerPassword",
                    partName = "PlayerPassword",
                    targetNamespace="urn:nu.danielsundberg.gameofkrowns:gamecontrollservice:player")
            String password,
            @WebParam(name="GameId",
                    partName = "GameId",
                    targetNamespace="urn:nu.danielsundberg.gameofkrowns:gamecontrollservice:game")
            Long gameId,
            @WebParam(name="TurnId",
                    partName = "TurnId",
                    targetNamespace="urn:nu.danielsundberg.gameofkrowns:gamecontrollservice:game")
            Long turnId,
            @WebParam(name="CountyName",
                    partName = "CaountyName",
                    targetNamespace="urn:nu.danielsundberg.gameofkrowns:gamecontrollservice:county")
            String countyName,
            @WebParam(name="Amount",
                    partName = "Amount",
                    targetNamespace="urn:nu.danielsundberg.gameofkrowns:gamecontrollservice:move")
            BigDecimal amount)
    throws
            PlayerNotFoundException,
            WrongPasswordException,
            GameNotFoundException,
            PlayerNotInvitedToGameException,
            IllegalMoveException ;

    @Override
    @WebMethod(operationName="reportPropagandaMove")
    public void reportPropagandaMove(
            @WebParam(name="PlayerId",
                    partName = "PlayerId",
                    targetNamespace="urn:nu.danielsundberg.gameofkrowns:gamecontrollservice:player")
            Long playerId,
            @WebParam(name="PlayerPassword",
                    partName = "PlayerPassword",
                    targetNamespace="urn:nu.danielsundberg.gameofkrowns:gamecontrollservice:player")
            String password,
            @WebParam(name="GameId",
                    partName = "GameId",
                    targetNamespace="urn:nu.danielsundberg.gameofkrowns:gamecontrollservice:game")
            Long gameId,
            @WebParam(name="TurnId",
                    partName = "TurnId",
                    targetNamespace="urn:nu.danielsundberg.gameofkrowns:gamecontrollservice:game")
            Long turnId,
            @WebParam(name="CountyName",
                    partName = "CaountyName",
                    targetNamespace="urn:nu.danielsundberg.gameofkrowns:gamecontrollservice:county")
            String countyName,
            @WebParam(name="Amount",
                    partName = "Amount",
                    targetNamespace="urn:nu.danielsundberg.gameofkrowns:gamecontrollservice:move")
            BigDecimal amount)
    throws
            PlayerNotFoundException,
            WrongPasswordException,
            GameNotFoundException,
            PlayerNotInvitedToGameException,
            IllegalMoveException;
}
