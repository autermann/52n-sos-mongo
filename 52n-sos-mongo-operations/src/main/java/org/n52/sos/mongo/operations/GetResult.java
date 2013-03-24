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

import org.n52.sos.ds.AbstractGetResultDAO;
import org.n52.sos.mongo.dao.ObservationDao;
import org.n52.sos.mongo.dao.ObservationFilter;
import org.n52.sos.mongo.dao.ObservationFilterFactory;
import org.n52.sos.ogc.ows.OwsExceptionReport;
import org.n52.sos.request.GetResultRequest;
import org.n52.sos.response.GetResultResponse;

import com.google.common.collect.Lists;

public class GetResult extends AbstractGetResultDAO {
    private ObservationDao observationDao;
    private ObservationFilterFactory observationFilterFactory;

    @Override
    public GetResultResponse getResult(GetResultRequest request) throws OwsExceptionReport {
        String resultValues = observationDao.get(request.getObservationTemplateIdentifier(),                                                      getFilter(request));
        GetResultResponse response = new GetResultResponse();
        response.setService(request.getService());
        response.setVersion(request.getVersion());
        response.setResultValues(resultValues);
        return response;
    }

    private List<ObservationFilter> getFilter(GetResultRequest request) {
        List<ObservationFilter> filters = Lists.newLinkedList();
        filters.addAll(observationFilterFactory.forTemporalFilters(request.getTemporalFilter()));
        filters.addAll(observationFilterFactory.forFeatureOfInterests(request.getFeatureIdentifiers()));
        filters.add(observationFilterFactory.forSpatialFilter(request.getSpatialFilter()));
        filters.add(observationFilterFactory.forOffering(request.getOffering()));
        filters.add(observationFilterFactory.forObservedProperty(request.getObservedProperty()));
        return filters;
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
