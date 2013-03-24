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

package org.n52.sos.mongo.dao;

import org.n52.sos.mongo.dao.filter.ObservationFilter;
import java.util.List;

import javax.inject.Inject;

import org.n52.sos.mongo.entities.Observation;
import org.n52.sos.mongo.entities.ResultTemplate;

/**
 * @author Christian Autermann <c.autermann@52north.org>
 */
public class ObservationDao extends AbstractMongoDao<Observation> {
    @Inject
    public ObservationDao(DatastoreProvider ds) {
        super(Observation.class, ds);
    }

    public List<Observation> get(List<ObservationFilter> filter, String srsName) {
        /* TODO implement org.n52.sos.mongo.dao.ObservationDao.get() */
        throw new UnsupportedOperationException("org.n52.sos.mongo.dao.ObservationDao.get() not yet implemented");
    }

    public List<Observation> get(List<ObservationFilter> filter, int srs) {
        /* TODO implement org.n52.sos.mongo.dao.ObservationDao.get() */
        throw new UnsupportedOperationException("org.n52.sos.mongo.dao.ObservationDao.get() not yet implemented");
    }

    public String get(String resultTemplate, List<ObservationFilter> filter) {
        /* TODO implement org.n52.sos.mongo.dao.ObservationDao.get() */
        throw new UnsupportedOperationException("org.n52.sos.mongo.dao.ObservationDao.get() not yet implemented");
    }

    public Observation save(ResultTemplate resultTemplate, String resultValues) {
        /* TODO implement org.n52.sos.mongo.dao.ObservationDao.save() */
        throw new UnsupportedOperationException("org.n52.sos.mongo.dao.ObservationDao.save() not yet implemented");
    }

    public void save(String procedure, List<String> offerings, List<Observation> observations) {
        /* TODO implement org.n52.sos.mongo.dao.ObservationDao.save() */
        throw new UnsupportedOperationException("org.n52.sos.mongo.dao.ObservationDao.save() not yet implemented");
    }
}
