/**
 * Copyright (C) 2013 Christian Autermann
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
public class ResultTemplateDaoImpl extends AbstractMongoDao<ResultTemplate> implements ResultTemplateDao {
    private ResultEncodingDaoImpl resultEncodingDao;
    private ResultStructureDaoImpl resultStructureDao;

    @Inject
    public ResultTemplateDaoImpl(DatastoreProvider ds) {
        super(ResultTemplate.class, ds);
    }

    @Override
    public ResultTemplate get(String offering, String observedProperty) {
        /* TODO implement org.n52.sos.mongo.dao.ResultTemplateDaoImpl.get() */
        throw new UnsupportedOperationException("org.n52.sos.mongo.dao.ResultTemplateDao.get() not yet implemented");
    }

    @Override
    public void save(String identifier, ObservationConstellation oc, ResultEncoding re, ResultStructure rs) {
        /* TODO implement org.n52.sos.mongo.dao.ResultTemplateDaoImpl.save() */
        throw new UnsupportedOperationException("org.n52.sos.mongo.dao.ResultTemplateDao.save() not yet implemented");
    }

    @Override
    public ResultTemplate get(String templateIdentifier) {
        /* TODO implement org.n52.sos.mongo.dao.ResultTemplateDaoImpl.get() */
        throw new UnsupportedOperationException("org.n52.sos.mongo.dao.ResultTemplateDao.get() not yet implemented");
    }

    /**
     * @return the resultEncodingDao
     */
    public ResultEncodingDaoImpl getResultEncodingDao() {
        return resultEncodingDao;
    }

    /**
     * @param resultEncodingDao the resultEncodingDao to set
     */
    @Inject
    public void setResultEncodingDao(ResultEncodingDaoImpl resultEncodingDao) {
        this.resultEncodingDao = resultEncodingDao;
    }

    /**
     * @return the resultStructureDao
     */
    public ResultStructureDaoImpl getResultStructureDao() {
        return resultStructureDao;
    }

    /**
     * @param resultStructureDao the resultStructureDao to set
     */
    @Inject
    public void setResultStructureDao(ResultStructureDaoImpl resultStructureDao) {
        this.resultStructureDao = resultStructureDao;
    }
}
