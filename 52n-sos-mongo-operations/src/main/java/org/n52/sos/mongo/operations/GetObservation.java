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

import org.n52.sos.ds.AbstractGetObservationDAO;
import org.n52.sos.mongo.dao.IObservationDao;
import org.n52.sos.mongo.dao.IObservationFilter;
import org.n52.sos.mongo.dao.ObservationFilters;
import org.n52.sos.mongo.entities.Observation;
import org.n52.sos.mongo.transformer.EntityTransformer;
import org.n52.sos.ogc.om.SosObservation;
import org.n52.sos.ogc.ows.OwsExceptionReport;
import org.n52.sos.request.GetObservationRequest;
import org.n52.sos.response.GetObservationResponse;

import com.google.common.collect.Lists;

public class GetObservation extends AbstractGetObservationDAO {
    private EntityTransformer<Observation, SosObservation> observationTransformer;
    private IObservationDao observationDao;

    @Override
    public GetObservationResponse getObservation(GetObservationRequest request) throws OwsExceptionReport {
        List<Observation> observations = getObservationDao().get(getFilters(request), request.getSrid());

        GetObservationResponse response = new GetObservationResponse();
        response.setService(request.getService());
        response.setVersion(request.getVersion());
        response.setResponseFormat(request.getResponseFormat());
        response.setObservationCollection(getObservationTransformer().toSosObjectList(observations));
        return response;
    }

    private List<IObservationFilter> getFilters(GetObservationRequest request) {
        List<IObservationFilter> filters = Lists.newLinkedList();
        filters.addAll(ObservationFilters.forTemporalFilters(request.getTemporalFilters()));
        filters.addAll(ObservationFilters.forProcedures(request.getProcedures()));
        filters.addAll(ObservationFilters.forOfferings(request.getOfferings()));
        filters.addAll(ObservationFilters.forObservedProperties(request.getObservedProperties()));
        filters.addAll(ObservationFilters.forFeatureOfInterests(request.getFeatureIdentifiers()));
        filters.add(ObservationFilters.forSpatialFilter(request.getSpatialFilter()));
        filters.add(ObservationFilters.forResultFilter(request.getResult()));
        return filters;
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
    @Inject
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
