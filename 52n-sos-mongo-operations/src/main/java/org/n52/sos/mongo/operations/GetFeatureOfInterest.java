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

import org.n52.sos.ds.AbstractGetFeatureOfInterestDAO;
import org.n52.sos.mongo.dao.FeatureDao;
import org.n52.sos.mongo.dao.FeatureFilter;
import org.n52.sos.mongo.dao.FeatureFilterFactory;
import org.n52.sos.mongo.entities.FeatureOfInterest;
import org.n52.sos.mongo.transformer.EntityTransformer;
import org.n52.sos.ogc.om.features.SosAbstractFeature;
import org.n52.sos.ogc.ows.OwsExceptionReport;
import org.n52.sos.request.GetFeatureOfInterestRequest;
import org.n52.sos.response.GetFeatureOfInterestResponse;

import com.google.common.collect.Lists;

public class GetFeatureOfInterest extends AbstractGetFeatureOfInterestDAO {
    private FeatureDao featureDao;
    private FeatureFilterFactory featureFilterFactory;
    private EntityTransformer<FeatureOfInterest, SosAbstractFeature> featureTransformer;

    @Override
    public GetFeatureOfInterestResponse getFeatureOfInterest(GetFeatureOfInterestRequest request) throws
            OwsExceptionReport {
        FeatureOfInterest feature = featureDao.get(getFilter(request));

        GetFeatureOfInterestResponse response = new GetFeatureOfInterestResponse();
        response.setService(request.getService());
        response.setVersion(request.getVersion());

        response.setAbstractFeature(featureTransformer.toSosObject(feature));
        return response;
    }

    protected List<FeatureFilter> getFilter(GetFeatureOfInterestRequest request) {
        List<FeatureFilter> filters = Lists.newLinkedList();
        filters.addAll(featureFilterFactory.forIdentifiers(request.getFeatureIdentifiers()));
        filters.addAll(featureFilterFactory.forObservedProperties(request.getObservedProperties()));
        filters.addAll(featureFilterFactory.forProcedure(request.getProcedures()));
        filters.addAll(featureFilterFactory.forSpatialFilters(request.getSpatialFilters()));
        filters.addAll(featureFilterFactory.forTemporalFilters(request.getTemporalFilters()));
        return filters;
    }

    @Inject
    public void setFeatureDao(FeatureDao featureDao) {
        this.featureDao = featureDao;
    }

    @Inject
    public void setFeatureTransformer(EntityTransformer<FeatureOfInterest, SosAbstractFeature> featureTransformer) {
        this.featureTransformer = featureTransformer;
    }

    @Inject
    public void setFeatureFilterFactory(FeatureFilterFactory featureFilterFactory) {
        this.featureFilterFactory = featureFilterFactory;
    }
}
