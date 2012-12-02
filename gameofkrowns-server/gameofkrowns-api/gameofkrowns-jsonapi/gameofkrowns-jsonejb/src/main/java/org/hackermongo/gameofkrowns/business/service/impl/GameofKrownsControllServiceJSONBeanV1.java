package org.hackermongo.gameofkrowns.business.service.impl;

import javax.ejb.Stateless;

import org.hackermongo.gameofkrowns.application.service.impl.GameofKrownsControllServiceBeanV1;
import org.hackermongo.gameofkrowns.business.service.GameofKrownsControllServiceJSONV1;

@Stateless(mappedName="gameofkrownsControllServiceJSONBeanV1")
public class GameofKrownsControllServiceJSONBeanV1 extends GameofKrownsControllServiceBeanV1 implements GameofKrownsControllServiceJSONV1 {

	private static final long serialVersionUID = 1L;
	
}