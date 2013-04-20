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

import static com.google.common.collect.Collections2.transform;
import static java.util.Collections.emptyList;

import java.util.Collection;

import org.n52.sos.mongo.dao.filter.FeatureOfInterestObservationFilter;
import org.n52.sos.mongo.dao.filter.FeatureOfInterestObservationFilter.FeatureOfInterestFilterFunction;
import org.n52.sos.mongo.dao.filter.IdentifierObservationFilter;
import org.n52.sos.mongo.dao.filter.IdentifierObservationFilter.IdentifierFilterFunction;
import org.n52.sos.mongo.dao.filter.ObservedPropertyObservationFilter;
import org.n52.sos.mongo.dao.filter.ObservedPropertyObservationFilter.ObservedPropertyFilterFunction;
import org.n52.sos.mongo.dao.filter.OfferingObservationFilter;
import org.n52.sos.mongo.dao.filter.OfferingObservationFilter.OfferingFilterFunction;
import org.n52.sos.mongo.dao.filter.ProcedureObservationFilter;
import org.n52.sos.mongo.dao.filter.ProcedureObservationFilter.ProcedureFilterFunction;
import org.n52.sos.mongo.dao.filter.ResultObservationFilter;
import org.n52.sos.mongo.dao.filter.ResultObservationFilter.ResultFilterFunction;
import org.n52.sos.mongo.dao.filter.SpatialObservationFilter;
import org.n52.sos.mongo.dao.filter.SpatialObservationFilter.SpatialFilterFunction;
import org.n52.sos.mongo.dao.filter.TemporalObservationFilter;
import org.n52.sos.mongo.dao.filter.TemporalObservationFilter.TemporalFilterFunction;
import org.n52.sos.ogc.filter.ComparisonFilter;
import org.n52.sos.ogc.filter.SpatialFilter;
import org.n52.sos.ogc.filter.TemporalFilter;


/**
 * @author Christian Autermann <c.autermann@52north.org>
 */
public class ObservationFilterFactoryImpl implements ObservationFilterFactory {
    @Override
    public ObservationFilter forIdentifier(String identifier) {
        return identifier == null ? ObservationFilter.NOOP : new IdentifierObservationFilter(identifier);
    }

    @Override
    public Collection<ObservationFilter> forIdentifiers(Collection<String> identifiers) {
        if (identifiers == null) {
            return emptyList();
        } else {
            return transform(identifiers, new IdentifierFilterFunction());
        }
    }

    @Override
    public ObservationFilter forObservedProperty(String observedProperty) {
        return observedProperty == null ? ObservationFilter.NOOP
               : new ObservedPropertyObservationFilter(observedProperty);
    }

    @Override
    public Collection<ObservationFilter> forObservedProperties(Collection<String> observedProperty) {
        if (observedProperty == null) {
            return emptyList();
        } else {
            return transform(observedProperty, new ObservedPropertyFilterFunction());
        }
    }

    @Override
    public ObservationFilter forFeatureOfInterest(String featureOfInterest) {
        return featureOfInterest == null ? ObservationFilter.NOOP
               : new FeatureOfInterestObservationFilter(featureOfInterest);
    }

    @Override
    public Collection<ObservationFilter> forFeatureOfInterests(Collection<String> featureOfInterest) {
        if (featureOfInterest == null) {
            return emptyList();
        } else {
            return transform(featureOfInterest, new FeatureOfInterestFilterFunction());
        }
    }

    @Override
    public ObservationFilter forProcedure(String procedure) {
        return procedure == null ? ObservationFilter.NOOP : new ProcedureObservationFilter(procedure);
    }

    @Override
    public Collection<ObservationFilter> forProcedures(Collection<String> procedure) {
        if (procedure == null) {
            return emptyList();
        } else {
            return transform(procedure, new ProcedureFilterFunction());
        }
    }

    @Override
    public ObservationFilter forOffering(String offering) {
        return offering == null ? ObservationFilter.NOOP : new OfferingObservationFilter(offering);
    }

    @Override
    public Collection<ObservationFilter> forOfferings(Collection<String> offering) {
        if (offering == null) {
            return emptyList();
        } else {
            return transform(offering, new OfferingFilterFunction());
        }
    }

    @Override
    public ObservationFilter forTemporalFilter(TemporalFilter temporalFilter) {
        return temporalFilter == null ? ObservationFilter.NOOP : new TemporalObservationFilter(temporalFilter);
    }

    @Override
    public Collection<ObservationFilter> forTemporalFilters(Collection<TemporalFilter> temporalFilter) {
        if (temporalFilter == null) {
            return emptyList();
        } else {
            return transform(temporalFilter, new TemporalFilterFunction());
        }
    }

    @Override
    public ObservationFilter forSpatialFilter(SpatialFilter spatialFilter) {
        return spatialFilter == null ? ObservationFilter.NOOP : new SpatialObservationFilter(spatialFilter);
    }

    @Override
    public Collection<ObservationFilter> forSpatialFilters(Collection<SpatialFilter> spatialFilter) {
        if (spatialFilter == null) {
            return emptyList();
        } else {
            return transform(spatialFilter, new SpatialFilterFunction());
        }
    }

    @Override
    public ObservationFilter forResultFilter(ComparisonFilter comparisonFilter) {
        return comparisonFilter == null ? ObservationFilter.NOOP : new ResultObservationFilter(comparisonFilter);
    }

    @Override
    public Collection<ObservationFilter> forResultFilters(Collection<ComparisonFilter> comparisonFilter) {
        if (comparisonFilter == null) {
            return emptyList();
        } else {
            return transform(comparisonFilter, new ResultFilterFunction());
        }
    }
}
