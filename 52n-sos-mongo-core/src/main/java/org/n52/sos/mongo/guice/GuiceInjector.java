/**
 * Copyright (C) 2013
 * by 52 North Initiative for Geospatial Open Source Software GmbH
 *
 * Contact: Andreas Wytzisk
 * 52 North Initiative for Geospatial Open Source Software GmbH
 * Martin-Luther-King-Weg 24
 * 48155 Muenster, Germany
 * info@52north.org
 *
 * This program is free software; you can redistribute and/or modify it under
 * the terms of the GNU General Public License version 2 as published by the
 * Free Software Foundation.
 *
 * This program is distributed WITHOUT ANY WARRANTY; even without the implied
 * WARRANTY OF MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program (see gnu-gpl v2.txt). If not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA or
 * visit the Free Software Foundation web page, http://www.fsf.org.
 */

package org.n52.sos.mongo.guice;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.n52.sos.mongo.dao.DatastoreProvider;

import com.google.inject.Injector;

/**
 * @author Christian Autermann <c.autermann@52north.org>
 */
public class GuiceInjector {
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock w = lock.writeLock();
    private final Lock r = lock.readLock();
    private Injector injector;

    public boolean isInitialized() {
        r.lock();
        try {
            return injector != null;
        } finally {
            r.unlock();
        }
    }

    public void initialize(DatastoreProvider dsp) {
        w.lock();
        try {
            if (this.injector == null) {
//                this.injector = Guice.createInjector(new DaoModule(),
//                                                     new EntityTransformerModule(),
//                                                     new DatastoreProviderModule(dsp));
                //TODO this.injector.injectMembers(o);
            }
        } finally {
            w.unlock();
        }
    }
}
