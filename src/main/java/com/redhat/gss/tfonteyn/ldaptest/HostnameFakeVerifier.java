/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2014, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package com.redhat.gss.tfonteyn.ldaptest;

import java.security.cert.Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/**
 * Always accept the hostname
 *
 * @author Tom Fonteyne
 */
public class HostnameFakeVerifier implements HostnameVerifier
{

    @Override
    public boolean verify(String hostname, SSLSession session)
    {
        System.out.println("Checking: " + hostname + " in");
        try
        {
            Certificate[] certificates = session.getPeerCertificates();
            for (Certificate cert : certificates)
            {
                System.out.println(cert);
            }
        }
        catch (SSLPeerUnverifiedException e)
        {
            return false;
        }

        return true;
    }
}
