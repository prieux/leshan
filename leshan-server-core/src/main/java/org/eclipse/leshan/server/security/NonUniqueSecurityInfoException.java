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
package org.eclipse.leshan.server.security;

public class NonUniqueSecurityInfoException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * Constructs a {@code NonUniqueSecurityInfoException} with the specified message and root cause.
     *
     * @param msg the detail message
     * @param t the root cause
     */
    public NonUniqueSecurityInfoException(String msg, Throwable t) {
        super(msg, t);
    }

    /**
     * Constructs a {@code NonUniqueSecurityInfoException} with the specified message and no root cause.
     *
     * @param msg the detail message
     */
    public NonUniqueSecurityInfoException(String msg) {
        super(msg);
    }

}