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

import java.util.List;

import javax.inject.Inject;

import org.n52.sos.ds.AbstractGetObservationByIdDAO;
import org.n52.sos.mongo.dao.IObservationDao;
import org.n52.sos.mongo.dao.IObservationFilter;
import org.n52.sos.mongo.dao.ObservationFilters;
import org.n52.sos.mongo.entities.Observation;
import org.n52.sos.mongo.transformer.EntityTransformer;
import org.n52.sos.ogc.om.SosObservation;
import org.n52.sos.ogc.ows.OwsExceptionReport;
import org.n52.sos.request.GetObservationByIdRequest;
import org.n52.sos.response.GetObservationByIdResponse;

import com.google.common.collect.Lists;

public class GetObservationById extends AbstractGetObservationByIdDAO {
    private EntityTransformer<Observation, SosObservation> observationTransformer;
    private IObservationDao observationDao;

    @Override
    public GetObservationByIdResponse getObservationById(GetObservationByIdRequest request) throws OwsExceptionReport {
        List<Observation> observations = getObservationDao().get(getFilter(request), request.getSrsName());

        GetObservationByIdResponse response = new GetObservationByIdResponse();
        response.setService(request.getService());
        response.setVersion(request.getVersion());
        response.setResponseFormat(request.getResponseFormat());
        response.setObservationCollection(getObservationTransformer().toSosObjectList(observations));
        return response;
    }

    protected List<IObservationFilter> getFilter(GetObservationByIdRequest request) {
        return Lists.newArrayList(ObservationFilters.forIdentifiers(request.getObservationIdentifier()));
    }

    /**
     * @return the observationTransformer
     */
    public EntityTransformer<Observation, SosObservation> getObservationTransformer() {
        return observationTransformer;
    }

    /**
     * @param observationTransformer the observationTransformer to set
     */
    public void setObservationTransformer(
            EntityTransformer<Observation, SosObservation> observationTransformer) {
        this.observationTransformer = observationTransformer;
    }

    /**
     * @return the observationDao
     */
    public IObservationDao getObservationDao() {
        return observationDao;
    }

    /**
     * @param observationDao the observationDao to set
     */
    @Inject
    public void setObservationDao(IObservationDao observationDao) {
        this.observationDao = observationDao;
    }

}
