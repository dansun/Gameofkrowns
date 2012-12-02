package org.hackermongo.gameofkrowns.business.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.hackermongo.gameofkrowns.test.GameofKrownsJsonAPITestCase;
import org.junit.Test;

public class GameofKrownsControllServiceJSONBeanV1Test extends GameofKrownsJsonAPITestCase {

	private static final String SERVER_PROPERTY = "gameofkrowns.jsontest.serverurl";
	private static final String SERVERROOT_PROPERTY = "gameofkrowns.jsontest.rooturl";
	
	private static String SERVERURL;
	
	static {
		if(System.getProperty(SERVER_PROPERTY)!=null &&
				System.getProperty(SERVERROOT_PROPERTY)!=null) {
			SERVERURL = System.getProperty(SERVER_PROPERTY);
		} else {
			SERVERURL = "127.0.0.1:8880/gameofkrowns-jsonapi-0.0.2-SNAPSHOT/gamecontrollservice";
		}
		
	}
	
	private String getHttp(String urlFromRoot) throws ClientProtocolException, IOException {
		StringBuilder reply = new StringBuilder();
		HttpResponse response = new DefaultHttpClient().execute(new HttpGet("http://"+SERVERURL+urlFromRoot));
		if(response.getStatusLine().getStatusCode()!=HttpStatus.SC_OK) {
			HttpEntity entity = response.getEntity();
			InputStream stream = entity.getContent();
			int intch;
			while ((intch = stream.read()) != -1) {
				reply.append((char) intch);
			}
			return reply.toString();	
		} else {
			throw new ClientProtocolException("No 202 recived.");
		}
	}
	
	@Test
	public void registerPlayer() throws ClientProtocolException, IOException {
		getHttp("/register/player/with/playername/"+PLAYER_NAME+"/and/password/"+PLAYER_PASSWORD);
	}
	
}
