/*******************************************************************************
 * Copyright (c) 2013-2015 Sierra Wireless and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Sierra Wireless - initial API and implementation
 *******************************************************************************/
package org.eclipse.leshan.core.request;

import org.eclipse.leshan.core.node.LwM2mPath;
import org.eclipse.leshan.core.response.LwM2mResponse;

public class DeleteRequest extends AbstractDownlinkRequest<LwM2mResponse> {

    /**
     * Creates a request for deleting a particular object instance implemented by a client.
     *
     * @param objectId the object type
     * @param objectInstanceId the object instance
     */
    public DeleteRequest(final int objectId, final int objectInstanceId) {
        this(new LwM2mPath(objectId, objectInstanceId));
    }

    public DeleteRequest(final String target) {
        super(new LwM2mPath(target));
    }

    private DeleteRequest(final LwM2mPath target) {
        super(target);
    }

    @Override
    public void accept(final DownlinkRequestVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public final String toString() {
        return String.format("DeleteRequest [%s]", getPath());
    }
}