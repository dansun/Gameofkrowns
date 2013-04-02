package nu.danielsundberg.gameofkrowns.business.service.impl;

import nu.danielsundberg.gameofkrowns.application.service.impl.GameofKrownsControllServiceBeanV1;
import nu.danielsundberg.gameofkrowns.business.service.GameofKrownsControllServiceJSONV1;

import javax.ejb.*;

@Stateless(mappedName="gameofkrownsControllServiceJSONBeanV1")
@TransactionManagement(value= TransactionManagementType.CONTAINER)
@TransactionAttribute(value = TransactionAttributeType.REQUIRED)
public class GameofKrownsControllServiceJSONBeanV1
        extends GameofKrownsControllServiceBeanV1
        implements GameofKrownsControllServiceJSONV1 {

	private static final long serialVersionUID = 1L;
	
}