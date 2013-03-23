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
import org.n52.sos.mongo.dao.ObservationDao;
import org.n52.sos.mongo.dao.ObservationFilter;
import org.n52.sos.mongo.entities.Observation;
import org.n52.sos.mongo.transformer.Transformer;
import org.n52.sos.ogc.om.SosObservation;
import org.n52.sos.ogc.ows.OwsExceptionReport;
import org.n52.sos.request.GetObservationRequest;
import org.n52.sos.response.GetObservationResponse;

import com.google.common.collect.Lists;


public class GetObservation extends AbstractGetObservationDAO {
    @Inject
    private Transformer<Observation, SosObservation> transformer;
    @Inject
    private ObservationDao observationDao;

    @Override
    public GetObservationResponse getObservation(GetObservationRequest request) throws OwsExceptionReport {
        List<Observation> observations = observationDao.get(getFilters(request), request.getSrid());

        GetObservationResponse response = new GetObservationResponse();
        response.setService(request.getService());
        response.setVersion(request.getVersion());
        response.setResponseFormat(request.getResponseFormat());
        response.setObservationCollection(transformer.toSosObjectList(observations));
        return response;
    }

    private List<ObservationFilter> getFilters(GetObservationRequest request) {
        List<ObservationFilter> filters = Lists.newLinkedList();
        if (request.getTemporalFilters() != null) {
            filters.addAll(Lists.transform(request.getTemporalFilters(), ObservationFilter.TEMPORAL_FILTER_FUNCTION));
        }
        if (request.getSpatialFilter() != null) {
            filters.add(ObservationFilter.SPATIAL_FILTER_FUNCTION.apply(request.getSpatialFilter()));
        }
        if (request.getProcedures() != null) {
            filters.addAll(Lists.transform(request.getProcedures(), ObservationFilter.PROCEDURE_FILTER_FUNCTION));
        }
        if (request.getOfferings() != null) {
            filters.addAll(Lists.transform(request.getOfferings(), ObservationFilter.OFFERING_FILTER_FUNCTION));
        }
        if (request.getObservedProperties() != null) {
            filters.addAll(Lists
                    .transform(request.getObservedProperties(), ObservationFilter.OBSERVED_PROPERTY_FILTER_FUNCTION));
        }
        if (request.getFeatureIdentifiers() != null) {
            filters.addAll(Lists
                    .transform(request.getFeatureIdentifiers(), ObservationFilter.FEATURE_OF_INTEREST_FILTER_FUNCTION));
        }
        if (request.getResult() != null) {
            filters.add(ObservationFilter.RESULT_FILTER_FUNCTION.apply(request.getResult()));
        }
        return filters;
    }
}
