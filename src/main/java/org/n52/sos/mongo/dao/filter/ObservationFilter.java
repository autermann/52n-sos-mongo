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
package org.n52.sos.mongo.dao.filter;

import static com.google.common.collect.Collections2.transform;
import static java.util.Collections.emptyList;

import java.util.Collection;

import org.n52.sos.mongo.dao.QueryFilter;
import org.n52.sos.mongo.dao.filter.FeatureOfInterestObservationFilter.FeatureOfInterestFilterFunction;
import org.n52.sos.mongo.dao.filter.IdentifierObservationFilter.IdentifierFilterFunction;
import org.n52.sos.mongo.dao.filter.ObservedPropertyObservationFilter.ObservedPropertyFilterFunction;
import org.n52.sos.mongo.dao.filter.OfferingObservationFilter.OfferingFilterFunction;
import org.n52.sos.mongo.dao.filter.ProcedureObservationFilter.ProcedureFilterFunction;
import org.n52.sos.mongo.dao.filter.ResultObservationFilter.ResultFilterFunction;
import org.n52.sos.mongo.dao.filter.SpatialObservationFilter.SpatialFilterFunction;
import org.n52.sos.mongo.dao.filter.TemporalObservationFilter.TemporalFilterFunction;
import org.n52.sos.mongo.entities.Observation;
import org.n52.sos.ogc.filter.ComparisonFilter;
import org.n52.sos.ogc.filter.SpatialFilter;
import org.n52.sos.ogc.filter.TemporalFilter;

import com.github.jmkgreen.morphia.query.Query;

/**
 * @author Christian Autermann <c.autermann@52north.org>
 */
public abstract class ObservationFilter implements QueryFilter<Observation> {
    static final ObservationFilter NOOP = new NoopObservationFilter();

    public static ObservationFilter forIdentifier(String identifier) {
        return identifier == null ? NOOP : new IdentifierObservationFilter(identifier);
    }

    public static Collection<ObservationFilter> forIdentifiers(Collection<String> identifiers) {
        if (identifiers == null) {
            return emptyList();
        } else {
            return transform(identifiers, new IdentifierFilterFunction());
        }
    }

    public static ObservationFilter forObservedProperty(String observedProperty) {
        return observedProperty == null ? NOOP : new ObservedPropertyObservationFilter(observedProperty);
    }

    public static Collection<ObservationFilter> forObservedProperties(Collection<String> observedProperty) {
        if (observedProperty == null) {
            return emptyList();
        } else {
            return transform(observedProperty, new ObservedPropertyFilterFunction());
        }
    }

    public static ObservationFilter forFeatureOfInterest(String featureOfInterest) {
        return featureOfInterest == null ? NOOP : new FeatureOfInterestObservationFilter(featureOfInterest);
    }

    public static Collection<ObservationFilter> forFeatureOfInterests(Collection<String> featureOfInterest) {
        if (featureOfInterest == null) {
            return emptyList();
        } else {
            return transform(featureOfInterest, new FeatureOfInterestFilterFunction());
        }
    }

    public static ObservationFilter forProcedure(String procedure) {
        return procedure == null ? NOOP : new ProcedureObservationFilter(procedure);
    }

    public static Collection<ObservationFilter> forProcedures(Collection<String> procedure) {
        if (procedure == null) {
            return emptyList();
        } else {
            return transform(procedure, new ProcedureFilterFunction());
        }
    }

    public static ObservationFilter forOffering(String offering) {
        return offering == null ? NOOP : new OfferingObservationFilter(offering);
    }

    public static Collection<ObservationFilter> forOfferings(Collection<String> offering) {
        if (offering == null) {
            return emptyList();
        } else {
            return transform(offering, new OfferingFilterFunction());
        }
    }

    public static ObservationFilter forTemporalFilter(TemporalFilter temporalFilter) {
        return temporalFilter == null ? NOOP : new TemporalObservationFilter(temporalFilter);
    }

    public static Collection<ObservationFilter> forTemporalFilters(Collection<TemporalFilter> temporalFilter) {
        if (temporalFilter == null) {
            return emptyList();
        } else {
            return transform(temporalFilter, new TemporalFilterFunction());
        }
    }

    public static ObservationFilter forSpatialFilter(SpatialFilter spatialFilter) {
        return spatialFilter == null ? NOOP : new SpatialObservationFilter(spatialFilter);
    }

    public static Collection<ObservationFilter> forSpatialFilters(Collection<SpatialFilter> spatialFilter) {
        if (spatialFilter == null) {
            return emptyList();
        } else {
            return transform(spatialFilter, new SpatialFilterFunction());
        }
    }

    public static ObservationFilter forResultFilter(ComparisonFilter comparisonFilter) {
        return comparisonFilter == null ? NOOP : new ResultObservationFilter(comparisonFilter);
    }

    public static Collection<ObservationFilter> forResultFilters(Collection<ComparisonFilter> comparisonFilter) {
        if (comparisonFilter == null) {
            return emptyList();
        } else {
            return transform(comparisonFilter, new ResultFilterFunction());
        }
    }

    static class NoopObservationFilter extends ObservationFilter {
        @Override
        public Query<Observation> filter(Query<Observation> q) {
            return q;
        }
    }

    

   

    


}
