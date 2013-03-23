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

import org.n52.sos.ogc.filter.SpatialFilter;
import org.n52.sos.ogc.filter.TemporalFilter;

import com.google.common.base.Function;

/**
 * @author Christian Autermann <c.autermann@52north.org>
 */
public abstract class FeatureFilter {

    public static final Function<String, FeatureFilter> IDENTIFIER_FILTER_FUNCTION =
                                                        new Function<String, FeatureFilter>() {
        @Override
        public FeatureFilter apply(String input) {
            return new IdentifierFeatureFilter(input);
        }
    };
    public static final Function<String, FeatureFilter> OBSERVED_PROPERTIES_FILTER_FUNCTION =
                                                        new Function<String, FeatureFilter>() {
        @Override
        public FeatureFilter apply(String input) {
            return new ObservedPropertiesFeatureFilter(input);
        }
    };
    public static final Function<String, FeatureFilter> PROCEDURE_FILTER_FUNCTION =
                                                        new Function<String, FeatureFilter>() {
        @Override
        public FeatureFilter apply(String input) {
            return new ProcedureFeatureFilter(input);
        }
    };
    public static final Function<SpatialFilter, FeatureFilter> SPATIAL_FILTER_FUNCTION =
                                                               new Function<SpatialFilter, FeatureFilter>() {
        @Override
        public FeatureFilter apply(SpatialFilter input) {
            return new SpatialFeatureFilter(input);
        }
    };
    public static final Function<TemporalFilter, FeatureFilter> TEMPORAL_FILTER_FUNCTION =
                                                                new Function<TemporalFilter, FeatureFilter>() {
        @Override
        public FeatureFilter apply(TemporalFilter input) {
            return new TemporalFeatureFilter(input);
        }
    };

    private static class IdentifierFeatureFilter extends FeatureFilter {
        private String identifier;

        private IdentifierFeatureFilter(String identifier) {
            this.identifier = identifier;
        }

        public String getIdentifier() {
            return identifier;
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
    }

    private static class ProcedureFeatureFilter extends FeatureFilter {
        private String procedure;

        private ProcedureFeatureFilter(String procedure) {
            this.procedure = procedure;
        }

        public String getProcedure() {
            return procedure;
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
    }

    private static class TemporalFeatureFilter extends FeatureFilter {
        private TemporalFilter temporalFilter;

        private TemporalFeatureFilter(TemporalFilter temporalFilter) {
            this.temporalFilter = temporalFilter;
        }

        public TemporalFilter getTemporalFilter() {
            return temporalFilter;
        }
    }
}
