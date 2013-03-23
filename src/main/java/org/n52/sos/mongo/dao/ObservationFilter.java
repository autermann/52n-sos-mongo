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

import org.n52.sos.ogc.filter.ComparisonFilter;
import org.n52.sos.ogc.filter.SpatialFilter;
import org.n52.sos.ogc.filter.TemporalFilter;

import com.google.common.base.Function;

/**
 * @author Christian Autermann <c.autermann@52north.org>
 */
public abstract class ObservationFilter {
    public static final Function<String, ObservationFilter> IDENTIFIER_FILTER_FUNCTION =
                                                            new Function<String, ObservationFilter>() {
        @Override
        public ObservationFilter apply(String input) {
            return new IdentifierObservationFilter(input);
        }
    };
    public static final Function<String, ObservationFilter> OBSERVED_PROPERTY_FILTER_FUNCTION =
                                                            new Function<String, ObservationFilter>() {
        @Override
        public ObservationFilter apply(String input) {
            return new ObservedPropertyObservationFilter(input);
        }
    };
    public static final Function<String, ObservationFilter> FEATURE_OF_INTEREST_FILTER_FUNCTION =
                                                            new Function<String, ObservationFilter>() {
        @Override
        public ObservationFilter apply(String input) {
            return new FeatureOfInterestObservationFilter(input);
        }
    };
    public static final Function<String, ObservationFilter> PROCEDURE_FILTER_FUNCTION =
                                                            new Function<String, ObservationFilter>() {
        @Override
        public ObservationFilter apply(String input) {
            return new ProcedureObservationFilter(input);
        }
    };
    public static final Function<String, ObservationFilter> OFFERING_FILTER_FUNCTION =
                                                            new Function<String, ObservationFilter>() {
        @Override
        public ObservationFilter apply(String input) {
            return new OfferingObservationFilter(input);
        }
    };
    public static final Function<TemporalFilter, ObservationFilter> TEMPORAL_FILTER_FUNCTION =
                                                                    new Function<TemporalFilter, ObservationFilter>() {
        @Override
        public ObservationFilter apply(TemporalFilter input) {
            return new TemporalObservationFilter(input);
        }
    };
    public static final Function<SpatialFilter, ObservationFilter> SPATIAL_FILTER_FUNCTION =
                                                                   new Function<SpatialFilter, ObservationFilter>() {
        @Override
        public ObservationFilter apply(SpatialFilter input) {
            return new SpatialObservationFilter(input);
        }
    };
    public static final Function<ComparisonFilter, ObservationFilter> RESULT_FILTER_FUNCTION =
                                                                      new Function<ComparisonFilter, ObservationFilter>() {
        @Override
        public ObservationFilter apply(ComparisonFilter input) {
            return new ResultObservationFilter(input);
        }
    };

    private static class ObservedPropertyObservationFilter extends ObservationFilter {
        private String observedProperty;

        private ObservedPropertyObservationFilter(String observedProperty) {
            this.observedProperty = observedProperty;
        }

        public String getObservedProperty() {
            return observedProperty;
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
    }

    private static class FeatureOfInterestObservationFilter extends ObservationFilter {
        private String feature;

        private FeatureOfInterestObservationFilter(String feature) {
            this.feature = feature;
        }

        public String getFeature() {
            return feature;
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
    }

    private static class OfferingObservationFilter extends ObservationFilter {
        private String offering;

        private OfferingObservationFilter(String offering) {
            this.offering = offering;
        }

        public String getOffering() {
            return offering;
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
    }

    private static class SpatialObservationFilter extends ObservationFilter {
        private SpatialFilter filter;

        private SpatialObservationFilter(SpatialFilter filter) {
            this.filter = filter;
        }

        public SpatialFilter getFilter() {
            return filter;
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
    }
}
