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

import org.n52.sos.ds.AbstractGetFeatureOfInterestDAO;
import org.n52.sos.mongo.dao.FeatureFilters;
import org.n52.sos.mongo.dao.IFeatureDao;
import org.n52.sos.mongo.dao.IFeatureFilter;
import org.n52.sos.mongo.entities.FeatureOfInterest;
import org.n52.sos.mongo.transformer.EntityTransformer;
import org.n52.sos.ogc.om.features.SosAbstractFeature;
import org.n52.sos.ogc.ows.OwsExceptionReport;
import org.n52.sos.request.GetFeatureOfInterestRequest;
import org.n52.sos.response.GetFeatureOfInterestResponse;

import com.google.common.collect.Lists;

public class GetFeatureOfInterest extends AbstractGetFeatureOfInterestDAO {
    private IFeatureDao featureDao;
    private EntityTransformer<FeatureOfInterest, SosAbstractFeature> featureTransformer;

    @Override
    public GetFeatureOfInterestResponse getFeatureOfInterest(GetFeatureOfInterestRequest request) throws
            OwsExceptionReport {
        FeatureOfInterest feature = getFeatureDao().get(getFilter(request));

        GetFeatureOfInterestResponse response = new GetFeatureOfInterestResponse();
        response.setService(request.getService());
        response.setVersion(request.getVersion());

        response.setAbstractFeature(getFeatureTransformer().toSosObject(feature));
        return response;
    }

    protected List<IFeatureFilter> getFilter(GetFeatureOfInterestRequest request) {
        List<IFeatureFilter> filters = Lists.newLinkedList();
        filters.addAll(FeatureFilters.forIdentifiers(request.getFeatureIdentifiers()));
        filters.addAll(FeatureFilters.forObservedProperties(request.getObservedProperties()));
        filters.addAll(FeatureFilters.forProcedure(request.getProcedures()));
        filters.addAll(FeatureFilters.forSpatialFilters(request.getSpatialFilters()));
        filters.addAll(FeatureFilters.forTemporalFilters(request.getTemporalFilters()));
        return filters;
    }

    /**
     * @return the featureDao
     */
    public IFeatureDao getFeatureDao() {
        return featureDao;
    }

    /**
     * @param featureDao the featureDao to set
     */
    @Inject
    public void setFeatureDao(IFeatureDao featureDao) {
        this.featureDao = featureDao;
    }

    /**
     * @return the featureTransformer
     */
    public EntityTransformer<FeatureOfInterest, SosAbstractFeature> getFeatureTransformer() {
        return featureTransformer;
    }

    /**
     * @param featureTransformer the featureTransformer to set
     */
    @Inject
    public void setFeatureTransformer(
            EntityTransformer<FeatureOfInterest, SosAbstractFeature> featureTransformer) {
        this.featureTransformer = featureTransformer;
    }

}
