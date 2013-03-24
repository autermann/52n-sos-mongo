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

import javax.inject.Inject;

import org.n52.sos.mongo.entities.ObservationConstellation;
import org.n52.sos.mongo.entities.ResultEncoding;
import org.n52.sos.mongo.entities.ResultStructure;
import org.n52.sos.mongo.entities.ResultTemplate;

/**
 * @author Christian Autermann <c.autermann@52north.org>
 */
public class ResultTemplateDao extends AbstractMongoDao<ResultTemplate> {
    private ResultEncodingDao resultEncodingDao;
    private ResultStructureDao resultStructureDao;

    @Inject
    public ResultTemplateDao(DatastoreProvider ds) {
        super(ResultTemplate.class, ds);
    }

    public ResultTemplate get(String offering, String observedProperty) {
        /* TODO implement org.n52.sos.mongo.dao.ResultTemplateDao.get() */
        throw new UnsupportedOperationException("org.n52.sos.mongo.dao.ResultTemplateDao.get() not yet implemented");
    }

    public void save(String identifier, ObservationConstellation oc, ResultEncoding re, ResultStructure rs) {
        /* TODO implement org.n52.sos.mongo.dao.ResultTemplateDao.save() */
        throw new UnsupportedOperationException("org.n52.sos.mongo.dao.ResultTemplateDao.save() not yet implemented");
    }

    public ResultTemplate get(String templateIdentifier) {
        /* TODO implement org.n52.sos.mongo.dao.ResultTemplateDao.get() */
        throw new UnsupportedOperationException("org.n52.sos.mongo.dao.ResultTemplateDao.get() not yet implemented");
    }

    /**
     * @return the resultEncodingDao
     */
    public ResultEncodingDao getResultEncodingDao() {
        return resultEncodingDao;
    }

    /**
     * @param resultEncodingDao the resultEncodingDao to set
     */
    @Inject
    public void setResultEncodingDao(ResultEncodingDao resultEncodingDao) {
        this.resultEncodingDao = resultEncodingDao;
    }

    /**
     * @return the resultStructureDao
     */
    public ResultStructureDao getResultStructureDao() {
        return resultStructureDao;
    }

    /**
     * @param resultStructureDao the resultStructureDao to set
     */
    @Inject
    public void setResultStructureDao(ResultStructureDao resultStructureDao) {
        this.resultStructureDao = resultStructureDao;
    }
}
