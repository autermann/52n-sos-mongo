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
package org.n52.sos.mongo;

import java.util.Properties;

import org.n52.sos.ds.ConnectionProvider;
import org.n52.sos.exception.ConfigurationException;
import org.n52.sos.mongo.dao.DatastoreProvider;
import org.n52.sos.mongo.entities.Observation;
import org.n52.sos.mongo.guice.GuiceInjector;

import com.github.jmkgreen.morphia.Datastore;
import com.github.jmkgreen.morphia.Morphia;
import com.mongodb.Mongo;
import com.mongodb.ServerAddress;

public class MongoConnectionProvider implements ConnectionProvider, DatastoreProvider {

    public static final String HOST = "mongo.host";
    public static final String PORT = "mongo.port";
    public static final String USER = "mongo.user";
    public static final String PASSWORD = "mongo.password";
    public static final String DATABASE = "mongo.database";
    public static final String DEFAULT_DATABASE_NAME = "sos";
    private Mongo mongo;
    private Morphia morphia;
    private Datastore datastore;
    private final GuiceInjector gi = new GuiceInjector();

    @Override
    public Datastore getConnection() {
        return getDatastore();
    }

    @Override
    public Datastore getDatastore() {
        if (!gi.isInitialized()) {
            gi.initialize(this);
        }
        return this.datastore;
    }

    @Override
    public void returnConnection(Object connection) {
        /* nothing to do */
    }

    @Override
    public void initialize(Properties properties) throws ConfigurationException {
        _initialize(properties == null ? new Properties() : properties);
    }

    protected void _initialize(Properties properties) throws ConfigurationException {
        try {
            this.mongo = new Mongo(new ServerAddress(getHost(properties),
                                                     getPort(properties)));
            this.morphia = new Morphia();
            this.morphia.mapPackageFromClass(Observation.class);
            this.datastore = this.morphia.createDatastore(mongo,
                                                          getDatabase(properties),
                                                          getUser(properties),
                                                          getPassword(properties));
            this.datastore.ensureIndexes();
        } catch (Throwable ex) {
            throw new ConfigurationException(ex);
        }
    }

    @Override
    public void cleanup() {
        if (this.mongo != null) {
            this.mongo.close();
        }
    }

    protected String getHost(Properties properties) {
        return properties.getProperty(HOST, ServerAddress.defaultHost());
    }

    protected Integer getPort(Properties properties) throws NumberFormatException {
        return Integer.valueOf(properties.getProperty(PORT, String.valueOf(ServerAddress.defaultPort())));
    }

    protected String getDatabase(Properties properties) {
        return properties.getProperty(DATABASE, DEFAULT_DATABASE_NAME);
    }

    protected String getUser(Properties properties) {
        return properties.getProperty(USER, null);
    }

    protected char[] getPassword(Properties properties) {
        String password = properties.getProperty(PASSWORD, null);
        return password != null ? password.toCharArray() : null;
    }

}
