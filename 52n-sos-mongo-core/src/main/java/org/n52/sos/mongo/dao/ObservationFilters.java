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
 * FIXME seperate implementations
 *
 * @author Christian Autermann <c.autermann@52north.org>
 */
public abstract class ObservationFilters {
    public static IObservationFilter forIdentifier(String identifier) {
        return identifier == null ? IObservationFilter.NOOP : new IdentifierObservationFilter(identifier);
    }

    public static Collection<IObservationFilter> forIdentifiers(Collection<String> identifiers) {
        if (identifiers == null) {
            return emptyList();
        } else {
            return transform(identifiers, new IdentifierFilterFunction());
        }
    }

    public static IObservationFilter forObservedProperty(String observedProperty) {
        return observedProperty == null ? IObservationFilter.NOOP
               : new ObservedPropertyObservationFilter(observedProperty);
    }

    public static Collection<IObservationFilter> forObservedProperties(Collection<String> observedProperty) {
        if (observedProperty == null) {
            return emptyList();
        } else {
            return transform(observedProperty, new ObservedPropertyFilterFunction());
        }
    }

    public static IObservationFilter forFeatureOfInterest(String featureOfInterest) {
        return featureOfInterest == null ? IObservationFilter.NOOP
               : new FeatureOfInterestObservationFilter(featureOfInterest);
    }

    public static Collection<IObservationFilter> forFeatureOfInterests(Collection<String> featureOfInterest) {
        if (featureOfInterest == null) {
            return emptyList();
        } else {
            return transform(featureOfInterest, new FeatureOfInterestFilterFunction());
        }
    }

    public static IObservationFilter forProcedure(String procedure) {
        return procedure == null ? IObservationFilter.NOOP : new ProcedureObservationFilter(procedure);
    }

    public static Collection<IObservationFilter> forProcedures(Collection<String> procedure) {
        if (procedure == null) {
            return emptyList();
        } else {
            return transform(procedure, new ProcedureFilterFunction());
        }
    }

    public static IObservationFilter forOffering(String offering) {
        return offering == null ? IObservationFilter.NOOP : new OfferingObservationFilter(offering);
    }

    public static Collection<IObservationFilter> forOfferings(Collection<String> offering) {
        if (offering == null) {
            return emptyList();
        } else {
            return transform(offering, new OfferingFilterFunction());
        }
    }

    public static IObservationFilter forTemporalFilter(TemporalFilter temporalFilter) {
        return temporalFilter == null ? IObservationFilter.NOOP : new TemporalObservationFilter(temporalFilter);
    }

    public static Collection<IObservationFilter> forTemporalFilters(Collection<TemporalFilter> temporalFilter) {
        if (temporalFilter == null) {
            return emptyList();
        } else {
            return transform(temporalFilter, new TemporalFilterFunction());
        }
    }

    public static IObservationFilter forSpatialFilter(SpatialFilter spatialFilter) {
        return spatialFilter == null ? IObservationFilter.NOOP : new SpatialObservationFilter(spatialFilter);
    }

    public static Collection<IObservationFilter> forSpatialFilters(Collection<SpatialFilter> spatialFilter) {
        if (spatialFilter == null) {
            return emptyList();
        } else {
            return transform(spatialFilter, new SpatialFilterFunction());
        }
    }

    public static IObservationFilter forResultFilter(ComparisonFilter comparisonFilter) {
        return comparisonFilter == null ? IObservationFilter.NOOP : new ResultObservationFilter(comparisonFilter);
    }

    public static Collection<IObservationFilter> forResultFilters(Collection<ComparisonFilter> comparisonFilter) {
        if (comparisonFilter == null) {
            return emptyList();
        } else {
            return transform(comparisonFilter, new ResultFilterFunction());
        }
    }
}
