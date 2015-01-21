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
package org.eclipse.leshan.server.bootstrap;

/**
 * The different DTLS security modes
 */
public enum SecurityMode {
    PSK(0), RPK(1), X509(2), NO_SEC(3);

    public final int code;

    private SecurityMode(int code) {
        this.code = code;
    }
}