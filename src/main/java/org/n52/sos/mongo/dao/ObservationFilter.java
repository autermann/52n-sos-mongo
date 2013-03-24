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

import org.n52.sos.mongo.entities.Observation;
import org.n52.sos.ogc.filter.ComparisonFilter;
import org.n52.sos.ogc.filter.SpatialFilter;
import org.n52.sos.ogc.filter.TemporalFilter;

import com.github.jmkgreen.morphia.query.Query;
import com.google.common.base.Function;

/**
 * @author Christian Autermann <c.autermann@52north.org>
 */
public abstract class ObservationFilter implements QueryFilter<Observation> {
    private static final ObservationFilter NOOP = new NoopObservationFilter();

    public static ObservationFilter forIdentifier(String identifier) {
        return identifier == null ? NOOP : new IdentifierObservationFilter(identifier);
    }

    public static Collection<ObservationFilter> forIdentifiers(Collection<String> identifiers) {
        if (identifiers == null) {
            return emptyList();
        } else {
            return transform(identifiers, new ObservionFilterFunction<String>() {
                @Override
                public ObservationFilter apply(String input) {
                    return forIdentifier(input);
                }
            });
        }
    }


    public static ObservationFilter forObservedProperty(String observedProperty) {
        return observedProperty == null ? NOOP : new ObservedPropertyObservationFilter(observedProperty);
    }

    public static Collection<ObservationFilter> forObservedProperties(Collection<String> observedProperty) {
        if (observedProperty == null) {
            return emptyList();
        } else {
            return transform(observedProperty, new ObservionFilterFunction<String>() {
                @Override
                public ObservationFilter apply(String input) {
                    return forObservedProperty(input);
                }
            });
        }
    }

    public static ObservationFilter forFeatureOfInterest(String featureOfInterest) {
        return featureOfInterest == null ? NOOP : new FeatureOfInterestObservationFilter(featureOfInterest);
    }

    public static Collection<ObservationFilter> forFeatureOfInterests(Collection<String> featureOfInterest) {
        if (featureOfInterest == null) {
            return emptyList();
        } else {
            return transform(featureOfInterest, new ObservionFilterFunction<String>() {
                @Override
                public ObservationFilter apply(String input) {
                    return forFeatureOfInterest(input);
                }
            });
        }
    }

    public static ObservationFilter forProcedure(String procedure) {
        return procedure == null ? NOOP : new ProcedureObservationFilter(procedure);
    }

    public static Collection<ObservationFilter> forProcedures(Collection<String> procedure) {
        if (procedure == null) {
            return emptyList();
        } else {
            return transform(procedure, new ObservionFilterFunction<String>() {
                @Override
                public ObservationFilter apply(String input) {
                    return forProcedure(input);
                }
            });
        }
    }

    public static ObservationFilter forOffering(String offering) {
        return offering == null ? NOOP : new OfferingObservationFilter(offering);
    }

    public static Collection<ObservationFilter> forOfferings(Collection<String> offering) {
        if (offering == null) {
            return emptyList();
        } else {
            return transform(offering, new ObservionFilterFunction<String>() {
                @Override
                public ObservationFilter apply(String input) {
                    return forOffering(input);
                }
            });
        }
    }

    public static ObservationFilter forTemporalFilter(TemporalFilter temporalFilter) {
        return temporalFilter == null ? NOOP : new TemporalObservationFilter(temporalFilter);
    }
    public static Collection<ObservationFilter> forTemporalFilters(Collection<TemporalFilter> temporalFilter) {
        if (temporalFilter == null) {
            return emptyList();
        } else {
            return transform(temporalFilter, new ObservionFilterFunction<TemporalFilter>() {
                @Override
                public ObservationFilter apply(TemporalFilter input) {
                    return forTemporalFilter(input);
                }
            });
        }
    }
    public static ObservationFilter forSpatialFilter(SpatialFilter spatialFilter) {
        return spatialFilter == null ? NOOP : new SpatialObservationFilter(spatialFilter);
    }
    public static Collection<ObservationFilter> forSpatialFilters(Collection<SpatialFilter> spatialFilter) {
        if (spatialFilter == null) {
            return emptyList();
        } else {
            return transform(spatialFilter, new ObservionFilterFunction<SpatialFilter>() {
                @Override
                public ObservationFilter apply(SpatialFilter input) {
                    return forSpatialFilter(input);
                }
            });
        }
    }
    public static ObservationFilter forResultFilter(ComparisonFilter comparisonFilter) {
        return comparisonFilter == null ? NOOP : new ResultObservationFilter(comparisonFilter);
    }
    public static Collection<ObservationFilter> forResultFilters(Collection<ComparisonFilter> comparisonFilter) {
        if (comparisonFilter == null) {
            return emptyList();
        } else {
            return transform(comparisonFilter, new ObservionFilterFunction<ComparisonFilter>() {
                @Override
                public ObservationFilter apply(ComparisonFilter input) {
                    return forResultFilter(input);
                }
            });
        }
    }
    private static class ObservedPropertyObservationFilter extends ObservationFilter {
        private String observedProperty;

        private ObservedPropertyObservationFilter(String observedProperty) {
            this.observedProperty = observedProperty;
        }

        public String getObservedProperty() {
            return observedProperty;
        }

        @Override
        public Query<Observation> filter(
                Query<Observation> q) {
            /* TODO implement org.n52.sos.mongo.dao.ObservationFilter.ObservedPropertyObservationFilter.filter() */
            throw new UnsupportedOperationException("org.n52.sos.mongo.dao.ObservationFilter.ObservedPropertyObservationFilter.filter() not yet implemented");
        }
    }

    private static class IdentifierObservationFilter extends ObservationFilter {
        private String identifier;

        private IdentifierObservationFilter(String identifier) {
            this.identifier = identifier;
        }

        public String getIdentifier() {
            return identifier;
        }

        @Override
        public Query<Observation> filter(
                Query<Observation> q) {
            /* TODO implement org.n52.sos.mongo.dao.ObservationFilter.IdentifierObservationFilter.filter() */
            throw new UnsupportedOperationException("org.n52.sos.mongo.dao.ObservationFilter.IdentifierObservationFilter.filter() not yet implemented");
        }
    }

    private static class FeatureOfInterestObservationFilter extends ObservationFilter {
        private String feature;

        private FeatureOfInterestObservationFilter(String feature) {
            this.feature = feature;
        }

        public String getFeature() {
            return feature;
        }

        @Override
        public Query<Observation> filter(
                Query<Observation> q) {
            /* TODO implement org.n52.sos.mongo.dao.ObservationFilter.FeatureOfInterestObservationFilter.filter() */
            throw new UnsupportedOperationException("org.n52.sos.mongo.dao.ObservationFilter.FeatureOfInterestObservationFilter.filter() not yet implemented");
        }
    }

    private static class ProcedureObservationFilter extends ObservationFilter {
        private String procedure;

        private ProcedureObservationFilter(String procedure) {
            this.procedure = procedure;
        }

        public String getProcedure() {
            return procedure;
        }

        @Override
        public Query<Observation> filter(
                Query<Observation> q) {
            /* TODO implement org.n52.sos.mongo.dao.ObservationFilter.ProcedureObservationFilter.filter() */
            throw new UnsupportedOperationException("org.n52.sos.mongo.dao.ObservationFilter.ProcedureObservationFilter.filter() not yet implemented");
        }
    }

    private static class OfferingObservationFilter extends ObservationFilter {
        private String offering;

        private OfferingObservationFilter(String offering) {
            this.offering = offering;
        }

        public String getOffering() {
            return offering;
        }

        @Override
        public Query<Observation> filter(
                Query<Observation> q) {
            /* TODO implement org.n52.sos.mongo.dao.ObservationFilter.OfferingObservationFilter.filter() */
            throw new UnsupportedOperationException("org.n52.sos.mongo.dao.ObservationFilter.OfferingObservationFilter.filter() not yet implemented");
        }
    }

    private static class TemporalObservationFilter extends ObservationFilter {
        private TemporalFilter filter;

        private TemporalObservationFilter(TemporalFilter filter) {
            this.filter = filter;
        }

        public TemporalFilter getFilter() {
            return filter;
        }

        @Override
        public Query<Observation> filter(
                Query<Observation> q) {
            /* TODO implement org.n52.sos.mongo.dao.ObservationFilter.TemporalObservationFilter.filter() */
            throw new UnsupportedOperationException("org.n52.sos.mongo.dao.ObservationFilter.TemporalObservationFilter.filter() not yet implemented");
        }
    }

    private static class SpatialObservationFilter extends ObservationFilter {
        private SpatialFilter filter;

        private SpatialObservationFilter(SpatialFilter filter) {
            this.filter = filter;
        }

        public SpatialFilter getFilter() {
            return filter;
        }

        @Override
        public Query<Observation> filter(
                Query<Observation> q) {
            /* TODO implement org.n52.sos.mongo.dao.ObservationFilter.SpatialObservationFilter.filter() */
            throw new UnsupportedOperationException("org.n52.sos.mongo.dao.ObservationFilter.SpatialObservationFilter.filter() not yet implemented");
        }
    }

    private static class ResultObservationFilter extends ObservationFilter {
        private ComparisonFilter filter;

        private ResultObservationFilter(ComparisonFilter filter) {
            this.filter = filter;
        }

        public ComparisonFilter getFilter() {
            return filter;
        }

        @Override
        public Query<Observation> filter(
                Query<Observation> q) {
            /* TODO implement org.n52.sos.mongo.dao.ObservationFilter.ResultObservationFilter.filter() */
            throw new UnsupportedOperationException("org.n52.sos.mongo.dao.ObservationFilter.ResultObservationFilter.filter() not yet implemented");
        }
    }

    private static class NoopObservationFilter extends ObservationFilter {
        @Override
        public Query<Observation> filter(Query<Observation> q) {
            return q;
        }
    }

    private interface ObservionFilterFunction<T> extends Function<T, ObservationFilter> {}
}
