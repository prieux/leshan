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

/**
 * A visitor to visit a Downlink Lightweight M2M request.
 */
public interface DownlinkRequestVisitor {
    void visit(ReadRequest request);

    void visit(DiscoverRequest request);

    void visit(WriteRequest request);

    void visit(WriteAttributesRequest request);

    void visit(ExecuteRequest request);

    void visit(CreateRequest request);

    void visit(DeleteRequest request);

    void visit(ObserveRequest request);
}