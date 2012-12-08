package nu.danielsundberg.gameofkrowns.business.service.impl;

import javax.ejb.Stateless;

import nu.danielsundberg.gameofkrowns.business.service.GameofKrownsControllServiceJSONV1;

import nu.danielsundberg.gameofkrowns.application.service.impl.GameofKrownsControllServiceBeanV1;

@Stateless(mappedName="gameofkrownsControllServiceJSONBeanV1")
public class GameofKrownsControllServiceJSONBeanV1 extends GameofKrownsControllServiceBeanV1 implements GameofKrownsControllServiceJSONV1 {

	private static final long serialVersionUID = 1L;
	
}