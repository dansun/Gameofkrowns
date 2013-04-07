package nu.danielsundberg.gameofkrowns.business.service.impl;

import nu.danielsundberg.gameofkrowns.application.service.impl.GameofKrownsControllServiceBeanV1;
import nu.danielsundberg.gameofkrowns.business.service.GameofKrownsControllServiceWSV1;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 * Game of Krowns game controller SOAP service V1
 */
@Stateless(mappedName="gameofkrownsControllServiceWS-v0.0.2")
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class GameControllServiceWSBeanV1
        extends GameofKrownsControllServiceBeanV1
        implements GameofKrownsControllServiceWSV1 {

    private static final long serialVersionUID = 1L;

}
