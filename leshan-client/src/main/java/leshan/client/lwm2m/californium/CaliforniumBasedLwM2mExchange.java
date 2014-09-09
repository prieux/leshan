package leshan.client.lwm2m.californium;

import java.util.List;

import leshan.client.lwm2m.operation.CreateResponse;
import leshan.client.lwm2m.operation.LwM2mExchange;
import leshan.client.lwm2m.operation.LwM2mResponse;
import ch.ethz.inf.vs.californium.coap.CoAP.ResponseCode;
import ch.ethz.inf.vs.californium.server.resources.CoapExchange;

public class CaliforniumBasedLwM2mExchange implements LwM2mExchange {

	private final CoapExchange exchange;

	public CaliforniumBasedLwM2mExchange(final CoapExchange exchange) {
		this.exchange = exchange;
	}

	@Override
	public void respond(final LwM2mResponse response) {
		if (response instanceof CreateResponse) {
			final String objectId = getObjectId();
			exchange.setLocationPath(objectId  + "/" + ((CreateResponse)response).getLocation());
		}

		exchange.respond(ResponseCode.valueOf(response.getCode().getValue()), response.getResponsePayload());
	}

	@Override
	public byte[] getRequestPayload() {
		return exchange.getRequestPayload();
	}

	private String getObjectId() {
		return getUriPaths().get(0);
	}

	@Override
	public boolean hasObjectInstanceId() {
		return getUriPaths().size() > 1;
	}

	@Override
	public int getObjectInstanceId() {
		return Integer.parseInt(getUriPaths().get(1));
	}

	private List<String> getUriPaths() {
		return exchange.getRequestOptions().getURIPaths();
	}

}