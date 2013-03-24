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

import org.n52.sos.mongo.entities.FeatureOfInterest;
import org.n52.sos.ogc.filter.SpatialFilter;
import org.n52.sos.ogc.filter.TemporalFilter;

import com.github.jmkgreen.morphia.query.Query;
import com.google.common.base.Function;

/**
 * @author Christian Autermann <c.autermann@52north.org>
 */
public abstract class FeatureFilter implements QueryFilter<FeatureOfInterest> {
    private static final FeatureFilter NOOP = new NoopFeatureFilter();

    public static FeatureFilter forIdentifier(String identifier) {
        return identifier == null ? NOOP : new IdentifierFeatureFilter(identifier);
    }

    public static Collection<FeatureFilter> forIdentifiers(Collection<String> identifiers) {
        if (identifiers == null) {
            return emptyList();
        } else {
            return transform(identifiers, new FeatureFilterFunction<String>() {
                @Override
                public FeatureFilter apply(String input) {
                    return forIdentifier(input);
                }
            });
        }
    }

    public static FeatureFilter forObservedProperty(String observedProperty) {
        return observedProperty == null ? NOOP : new ObservedPropertiesFeatureFilter(observedProperty);
    }

    public static Collection<FeatureFilter> forObservedProperties(Collection<String> observedProperties) {
        if (observedProperties == null) {
            return emptyList();
        } else {
            return transform(observedProperties, new FeatureFilterFunction<String>() {
                @Override
                public FeatureFilter apply(String input) {
                    return forObservedProperty(input);
                }
            });
        }
    }

    public static FeatureFilter forProcedure(String procedure) {
        return procedure == null ? NOOP : new ProcedureFeatureFilter(procedure);
    }

    public static Collection<FeatureFilter> forProcedure(Collection<String> procedures) {
        if (procedures == null) {
            return emptyList();
        } else {
            return transform(procedures, new FeatureFilterFunction<String>() {
                @Override
                public FeatureFilter apply(String input) {
                    return forProcedure(input);
                }
            });
        }
    }

    public static FeatureFilter forSpatialFilter(SpatialFilter spatialFilter) {
        return spatialFilter == null ? NOOP : new SpatialFeatureFilter(spatialFilter);
    }

    public static Collection<FeatureFilter> forSpatialFilters(Collection<SpatialFilter> spatialFilters) {
        if (spatialFilters == null) {
            return emptyList();
        } else {
            return transform(spatialFilters, new FeatureFilterFunction<SpatialFilter>() {
                @Override
                public FeatureFilter apply(SpatialFilter input) {
                    return forSpatialFilter(input);
                }
            });
        }
    }

    public static FeatureFilter forTemporalFilter(TemporalFilter temporalFilter) {
        return temporalFilter == null ? NOOP : new TemporalFeatureFilter(temporalFilter);
    }

    public static Collection<FeatureFilter> forTemporalFilters(Collection<TemporalFilter> temporalFilter) {
        if (temporalFilter == null) {
            return emptyList();
        } else {
            return transform(temporalFilter, new FeatureFilterFunction<TemporalFilter>() {
                @Override
                public FeatureFilter apply(TemporalFilter input) {
                    return forTemporalFilter(input);
                }
            });
        }
    }

    private static class IdentifierFeatureFilter extends FeatureFilter {
        private String identifier;

        private IdentifierFeatureFilter(String identifier) {
            this.identifier = identifier;
        }

        public String getIdentifier() {
            return identifier;
        }

        @Override
        public Query<FeatureOfInterest> filter(
                Query<FeatureOfInterest> q) {
            /* TODO implement org.n52.sos.mongo.dao.FeatureFilter.IdentifierFeatureFilter.filter() */
            throw new UnsupportedOperationException("org.n52.sos.mongo.dao.FeatureFilter.IdentifierFeatureFilter.filter() not yet implemented");
        }
    }

    private static class ObservedPropertiesFeatureFilter extends FeatureFilter {
        private String observedProperty;

        private ObservedPropertiesFeatureFilter(String observedProperty) {
            this.observedProperty = observedProperty;
        }

        public String getObservedProperty() {
            return observedProperty;
        }

        @Override
        public Query<FeatureOfInterest> filter(
                Query<FeatureOfInterest> q) {
            /* TODO implement org.n52.sos.mongo.dao.FeatureFilter.ObservedPropertiesFeatureFilter.filter() */
            throw new UnsupportedOperationException("org.n52.sos.mongo.dao.FeatureFilter.ObservedPropertiesFeatureFilter.filter() not yet implemented");
        }
    }

    private static class ProcedureFeatureFilter extends FeatureFilter {
        private String procedure;

        private ProcedureFeatureFilter(String procedure) {
            this.procedure = procedure;
        }

        public String getProcedure() {
            return procedure;
        }

        @Override
        public Query<FeatureOfInterest> filter(
                Query<FeatureOfInterest> q) {
            /* TODO implement org.n52.sos.mongo.dao.FeatureFilter.ProcedureFeatureFilter.filter() */
            throw new UnsupportedOperationException("org.n52.sos.mongo.dao.FeatureFilter.ProcedureFeatureFilter.filter() not yet implemented");
        }
    }

    private static class SpatialFeatureFilter extends FeatureFilter {
        private SpatialFilter spatialFilter;

        private SpatialFeatureFilter(SpatialFilter spatialFilter) {
            this.spatialFilter = spatialFilter;
        }

        public SpatialFilter getSpatialFilter() {
            return spatialFilter;
        }

        @Override
        public Query<FeatureOfInterest> filter(
                Query<FeatureOfInterest> q) {
            /* TODO implement org.n52.sos.mongo.dao.FeatureFilter.SpatialFeatureFilter.filter() */
            throw new UnsupportedOperationException("org.n52.sos.mongo.dao.FeatureFilter.SpatialFeatureFilter.filter() not yet implemented");
        }
    }

    private static class TemporalFeatureFilter extends FeatureFilter {
        private TemporalFilter temporalFilter;

        private TemporalFeatureFilter(TemporalFilter temporalFilter) {
            this.temporalFilter = temporalFilter;
        }

        public TemporalFilter getTemporalFilter() {
            return temporalFilter;
        }

        @Override
        public Query<FeatureOfInterest> filter(
                Query<FeatureOfInterest> q) {
            /* TODO implement org.n52.sos.mongo.dao.FeatureFilter.TemporalFeatureFilter.filter() */
            throw new UnsupportedOperationException("org.n52.sos.mongo.dao.FeatureFilter.TemporalFeatureFilter.filter() not yet implemented");
        }
    }

    private static class NoopFeatureFilter extends FeatureFilter {
        @Override
        public Query<FeatureOfInterest> filter(Query<FeatureOfInterest> q) {
            return q;
        }
    }

    private interface FeatureFilterFunction<T> extends Function<T, FeatureFilter> {
    }
}
