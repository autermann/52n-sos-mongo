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

import org.n52.sos.ds.AbstractInsertResultTemplateDAO;
import org.n52.sos.mongo.dao.ResultTemplateDao;
import org.n52.sos.mongo.entities.ObservationConstellation;
import org.n52.sos.mongo.entities.ResultEncoding;
import org.n52.sos.mongo.entities.ResultStructure;
import org.n52.sos.mongo.transformer.Transformer;
import org.n52.sos.ogc.om.SosObservationConstellation;
import org.n52.sos.ogc.ows.OwsExceptionReport;
import org.n52.sos.ogc.sos.SosResultEncoding;
import org.n52.sos.ogc.sos.SosResultStructure;
import org.n52.sos.request.InsertResultTemplateRequest;
import org.n52.sos.response.InsertResultTemplateResponse;

public class InsertResultTemplate extends AbstractInsertResultTemplateDAO {
    private ResultTemplateDao resultTemplateDao;
    private Transformer<ResultEncoding, SosResultEncoding> encodingTransformer;
    private Transformer<ResultStructure, SosResultStructure> structureTransformer;
    private Transformer<ObservationConstellation, SosObservationConstellation> observationConstellationTransformer;

    @Override
    public InsertResultTemplateResponse insertResultTemplate(InsertResultTemplateRequest request) throws
            OwsExceptionReport {
        getResultTemplateDao().save(request.getIdentifier(),
                                    getObservationConstellationTransformer().toMongoObject(request
                .getObservationTemplate()),
                                    getEncodingTransformer().toMongoObject(request.getResultEncoding()),
                                    getStructureTransformer().toMongoObject(request.getResultStructure()));

        InsertResultTemplateResponse response = new InsertResultTemplateResponse();
        response.setService(request.getService());
        response.setVersion(request.getVersion());
        response.setAcceptedTemplate(request.getIdentifier());
        return response;
    }

    /**
     * @return the resultTemplateDao
     */
    public ResultTemplateDao getResultTemplateDao() {
        return resultTemplateDao;
    }

    /**
     * @param resultTemplateDao the resultTemplateDao to set
     */
    @Inject
    public void setResultTemplateDao(ResultTemplateDao resultTemplateDao) {
        this.resultTemplateDao = resultTemplateDao;
    }

    /**
     * @return the encodingTransformer
     */
    public Transformer<ResultEncoding, SosResultEncoding> getEncodingTransformer() {
        return encodingTransformer;
    }

    /**
     * @param encodingTransformer the encodingTransformer to set
     */
    @Inject
    public void setEncodingTransformer(
            Transformer<ResultEncoding, SosResultEncoding> encodingTransformer) {
        this.encodingTransformer = encodingTransformer;
    }

    /**
     * @return the structureTransformer
     */
    public Transformer<ResultStructure, SosResultStructure> getStructureTransformer() {
        return structureTransformer;
    }

    /**
     * @param structureTransformer the structureTransformer to set
     */
    @Inject
    public void setStructureTransformer(
            Transformer<ResultStructure, SosResultStructure> structureTransformer) {
        this.structureTransformer = structureTransformer;
    }

    /**
     * @return the observationConstellationTransformer
     */
    public Transformer<ObservationConstellation, SosObservationConstellation> getObservationConstellationTransformer() {
        return observationConstellationTransformer;
    }

    /**
     * @param observationConstellationTransformer the observationConstellationTransformer to set
     */
    @Inject
    public void setObservationConstellationTransformer(
            Transformer<ObservationConstellation, SosObservationConstellation> observationConstellationTransformer) {
        this.observationConstellationTransformer = observationConstellationTransformer;
    }
}
