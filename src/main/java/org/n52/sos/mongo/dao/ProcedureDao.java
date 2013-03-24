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

import java.util.List;

import javax.inject.Inject;

import org.n52.sos.mongo.entities.FeatureRelationship;
import org.n52.sos.mongo.entities.Offering;
import org.n52.sos.mongo.entities.Procedure;
import org.n52.sos.mongo.entities.ProcedureMetadata;
import org.n52.sos.ogc.filter.TemporalFilter;

/**
 * @author Christian Autermann <c.autermann@52north.org>
 */
public class ProcedureDao extends AbstractMongoDao<Procedure> {
    @Inject
    public ProcedureDao(DatastoreProvider ds) {
        super(Procedure.class, ds);
    }

    public void delete(String identifier) {
        /* TODO implement org.n52.sos.mongo.dao.ProcedureDao.delete() */
        throw new UnsupportedOperationException("org.n52.sos.mongo.dao.SensorDao.delete() not yet implemented");
    }

    public Procedure get(String identifier, List<TemporalFilter> time) {
        /* TODO implement org.n52.sos.mongo.dao.ProcedureDao.get() */
        throw new UnsupportedOperationException("org.n52.sos.mongo.dao.SensorDao.get() not yet implemented");
    }

    public Procedure get(String identifier) {
        /* TODO implement org.n52.sos.mongo.dao.ProcedureDao.get() */
        throw new UnsupportedOperationException("org.n52.sos.mongo.dao.SensorDao.get() not yet implemented");
    }

    public void save(String identifier, String procedureDescriptionFormat,
                     List<Procedure> toMongoObjectList) {
        /* TODO implement org.n52.sos.mongo.dao.ProcedureDao.save() */
        throw new UnsupportedOperationException("org.n52.sos.mongo.dao.SensorDao.save() not yet implemented");
    }

    public void save(String identifier, List<Offering> offerings, List<String> observableProperty,
                     String procedureDescriptionFormat, ProcedureMetadata metaData, Procedure procedure,
                     List<FeatureRelationship> features) {
        /* TODO implement org.n52.sos.mongo.dao.ProcedureDao.save() */
        throw new UnsupportedOperationException("org.n52.sos.mongo.dao.SensorDao.save() not yet implemented");
    }
}