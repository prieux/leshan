package leshan.server.integration.register.normal.register;

import static com.jayway.awaitility.Awaitility.await;
import static org.junit.Assert.*;

import java.net.UnknownHostException;
import java.util.UUID;

import leshan.client.lwm2m.response.OperationResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import ch.ethz.inf.vs.californium.coap.CoAP.ResponseCode;

@RunWith(MockitoJUnitRunner.class)
public class DeregisterTest extends AbstractRegisteringTest {

	private static final String REGISTRATION_ENDPOINT = "/rd/";
	
	@Test
	public void testCannotDeregisterUnregisteredSync() throws UnknownHostException {
		
		validateNoRegisteredClientOnServer();

		final String validNonexistentLocationPathOptions = REGISTRATION_ENDPOINT + UUID.randomUUID().toString();
		
		final OperationResponse deregisterResponseOne = registerUplink.deregister(validNonexistentLocationPathOptions, TIMEOUT_MS);
		
		assertEquals(deregisterResponseOne.getResponseCode(), ResponseCode.NOT_FOUND);
		assertFalse(deregisterResponseOne.isSuccess());

		final OperationResponse registerResponse = registerUplink.register(clientEndpoint, clientParameters, TIMEOUT_MS);
		final String locationPathOptions = new String(registerResponse.getLocation());
		
		validateRegisteredClientOnServer(86400L);
		
		final OperationResponse deregisterResponseTwo = registerUplink.deregister(locationPathOptions, TIMEOUT_MS);
		
		validateResponsesToClient(registerResponse, locationPathOptions, deregisterResponseTwo);

	}
	
	@Test
	public void testCannotDeregisterUnregisteredAsync() throws UnknownHostException {
		validateNoRegisteredClientOnServer();

		final String validNonexistentLocationPathOptions = REGISTRATION_ENDPOINT + UUID.randomUUID().toString();
		
		registerUplink.deregister(validNonexistentLocationPathOptions, callback);
		
		await().untilTrue(callback.isCalled());
		
		final OperationResponse deregisterResponseOne = callback.getResponse();
		
		assertFalse(deregisterResponseOne.isSuccess());
		assertEquals(deregisterResponseOne.getResponseCode(), ResponseCode.NOT_FOUND);

		callback.reset();
		registerUplink.register(clientEndpoint, clientParameters, callback);
		
		await().untilTrue(callback.isCalled());
		
		final OperationResponse registerResponse = callback.getResponse();
		
		final String locationPathOptions = new String(registerResponse.getLocation());
		
		validateRegisteredClientOnServer(86400L);
		
		callback.reset();
		registerUplink.deregister(locationPathOptions, callback);
		
		await().untilTrue(callback.isCalled());
		
		final OperationResponse deregisterResponseTwo = callback.getResponse();
		
		validateResponsesToClient(registerResponse, locationPathOptions, deregisterResponseTwo);

	}

}
