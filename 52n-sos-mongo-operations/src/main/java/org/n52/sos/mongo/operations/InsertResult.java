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
package org.n52.sos.mongo.operations;

import javax.inject.Inject;

import org.n52.sos.ds.AbstractInsertResultDAO;
import org.n52.sos.mongo.dao.ObservationDao;
import org.n52.sos.mongo.dao.ResultTemplateDao;
import org.n52.sos.mongo.entities.Observation;
import org.n52.sos.mongo.entities.ResultTemplate;
import org.n52.sos.mongo.transformer.EntityTransformer;
import org.n52.sos.ogc.om.SosObservation;
import org.n52.sos.ogc.ows.OwsExceptionReport;
import org.n52.sos.request.InsertResultRequest;
import org.n52.sos.response.InsertResultResponse;

public class InsertResult extends AbstractInsertResultDAO {
    private ObservationDao observationDao;
    private ResultTemplateDao resultTemplateDao;
    private EntityTransformer<Observation, SosObservation> transformer;

    @Override
    public InsertResultResponse insertResult(InsertResultRequest request) throws OwsExceptionReport {
        ResultTemplate resultTemplate = resultTemplateDao.get(request.getTemplateIdentifier());
        Observation observation = observationDao.save(resultTemplate, request.getResultValues());
        InsertResultResponse response = new InsertResultResponse();
        response.setService(request.getService());
        response.setVersion(request.getVersion());
        response.setObservation(transformer.toSosObject(observation));
        return response;
    }

    @Inject
    public void setObservationDao(ObservationDao observationDao) {
        this.observationDao = observationDao;
    }

    @Inject
    public void setResultTemplateDao(ResultTemplateDao resultTemplateDao) {
        this.resultTemplateDao = resultTemplateDao;
    }

    @Inject
    public void setTransformer(EntityTransformer<Observation, SosObservation> transformer) {
        this.transformer = transformer;
    }
}
