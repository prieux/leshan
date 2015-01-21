/*******************************************************************************
 * Copyright (c) 2013-2015 Sierra Wireless and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Zebra Technologies - initial API and implementation
 *******************************************************************************/
package org.eclipse.leshan.client.request;

import org.eclipse.leshan.client.request.identifier.ClientIdentifier;

public class DeregisterRequest extends AbstractRegisteredLwM2mClientRequest {

    public DeregisterRequest(final ClientIdentifier clientIdentifier) {
        super(clientIdentifier);
    }

    public DeregisterRequest(final ClientIdentifier clientIdentifier, final long timeout) {
        super(clientIdentifier, timeout);
    }

    @Override
    public void accept(final LwM2mClientRequestVisitor visitor) {
        visitor.visit(this);
    }

}