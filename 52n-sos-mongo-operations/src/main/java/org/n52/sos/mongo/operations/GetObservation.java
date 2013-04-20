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
package org.n52.sos.mongo.operations;

import java.util.List;

import javax.inject.Inject;

import org.n52.sos.ds.AbstractGetObservationDAO;
import org.n52.sos.mongo.dao.ObservationDao;
import org.n52.sos.mongo.dao.ObservationFilter;
import org.n52.sos.mongo.dao.ObservationFilterFactory;
import org.n52.sos.mongo.entities.Observation;
import org.n52.sos.mongo.transformer.EntityTransformer;
import org.n52.sos.ogc.om.SosObservation;
import org.n52.sos.ogc.ows.OwsExceptionReport;
import org.n52.sos.request.GetObservationRequest;
import org.n52.sos.response.GetObservationResponse;

import com.google.common.collect.Lists;

public class GetObservation extends AbstractGetObservationDAO {
    private EntityTransformer<Observation, SosObservation> observationTransformer;
    private ObservationFilterFactory observationFilterFactory;
    private ObservationDao observationDao;

    @Override
    public GetObservationResponse getObservation(GetObservationRequest request) throws OwsExceptionReport {
        List<Observation> observations = observationDao.get(getFilters(request), request.getSrid());

        GetObservationResponse response = new GetObservationResponse();
        response.setService(request.getService());
        response.setVersion(request.getVersion());
        response.setResponseFormat(request.getResponseFormat());
        response.setObservationCollection(observationTransformer.toSosObjectList(observations));
        return response;
    }

    private List<ObservationFilter> getFilters(GetObservationRequest request) {
        List<ObservationFilter> filters = Lists.newLinkedList();
        filters.addAll(observationFilterFactory.forTemporalFilters(request.getTemporalFilters()));
        filters.addAll(observationFilterFactory.forProcedures(request.getProcedures()));
        filters.addAll(observationFilterFactory.forOfferings(request.getOfferings()));
        filters.addAll(observationFilterFactory.forObservedProperties(request.getObservedProperties()));
        filters.addAll(observationFilterFactory.forFeatureOfInterests(request.getFeatureIdentifiers()));
        filters.add(observationFilterFactory.forSpatialFilter(request.getSpatialFilter()));
        filters.add(observationFilterFactory.forResultFilter(request.getResult()));
        return filters;

    }

    @Inject
    public void setObservationTransformer(EntityTransformer<Observation, SosObservation> observationTransformer) {
        this.observationTransformer = observationTransformer;
    }

    @Inject
    public void setObservationDao(ObservationDao observationDao) {
        this.observationDao = observationDao;
    }

    @Inject
    public void setObservationFilterFactory(ObservationFilterFactory observationFilterFactory) {
        this.observationFilterFactory = observationFilterFactory;
    }
}
