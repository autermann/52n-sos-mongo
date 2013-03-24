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

import org.n52.sos.mongo.dao.FeatureFilter;
import org.n52.sos.mongo.dao.FeatureFilterFactory;
import org.n52.sos.mongo.dao.filter.IdentifierFeatureFilter;
import org.n52.sos.mongo.dao.filter.IdentifierFeatureFilter.IdentifierFilterFunction;
import org.n52.sos.mongo.dao.filter.ObservedPropertiesFeatureFilter;
import org.n52.sos.mongo.dao.filter.ObservedPropertiesFeatureFilter.ObservedPropertyFilterFunction;
import org.n52.sos.mongo.dao.filter.ProcedureFeatureFilter;
import org.n52.sos.mongo.dao.filter.ProcedureFeatureFilter.ProcedureFilterFunction;
import org.n52.sos.mongo.dao.filter.SpatialFeatureFilter;
import org.n52.sos.mongo.dao.filter.SpatialFeatureFilter.SpatialFilterFunction;
import org.n52.sos.mongo.dao.filter.TemporalFeatureFilter;
import org.n52.sos.mongo.dao.filter.TemporalFeatureFilter.TemporalFilterFunction;
import org.n52.sos.ogc.filter.SpatialFilter;
import org.n52.sos.ogc.filter.TemporalFilter;


/**
 * @author Christian Autermann <c.autermann@52north.org>
 */
public class FeatureFilterFactoryImpl implements FeatureFilterFactory {
    @Override
    public FeatureFilter forIdentifier(String identifier) {
        return identifier == null ? FeatureFilter.NOOP : new IdentifierFeatureFilter(identifier);
    }

    @Override
    public Collection<FeatureFilter> forIdentifiers(Collection<String> identifiers) {
        if (identifiers == null) {
            return emptyList();
        } else {
            return transform(identifiers, new IdentifierFilterFunction());
        }
    }

    @Override
    public FeatureFilter forObservedProperty(String observedProperty) {
        return observedProperty == null ? FeatureFilter.NOOP : new ObservedPropertiesFeatureFilter(observedProperty);
    }

    @Override
    public Collection<FeatureFilter> forObservedProperties(Collection<String> observedProperties) {
        if (observedProperties == null) {
            return emptyList();
        } else {
            return transform(observedProperties, new ObservedPropertyFilterFunction());
        }
    }

    @Override
    public FeatureFilter forProcedure(String procedure) {
        return procedure == null ? FeatureFilter.NOOP : new ProcedureFeatureFilter(procedure);
    }

    @Override
    public Collection<FeatureFilter> forProcedure(Collection<String> procedures) {
        if (procedures == null) {
            return emptyList();
        } else {
            return transform(procedures, new ProcedureFilterFunction());
        }

    }

    @Override
    public FeatureFilter forSpatialFilter(SpatialFilter spatialFilter) {
        return spatialFilter == null ? FeatureFilter.NOOP : new SpatialFeatureFilter(spatialFilter);
    }

    @Override
    public Collection<FeatureFilter> forSpatialFilters(Collection<SpatialFilter> spatialFilters) {
        if (spatialFilters == null) {
            return emptyList();
        } else {
            return transform(spatialFilters, new SpatialFilterFunction());
        }
    }

    @Override
    public FeatureFilter forTemporalFilter(TemporalFilter temporalFilter) {
        return temporalFilter == null ? FeatureFilter.NOOP : new TemporalFeatureFilter(temporalFilter);
    }

    @Override
    public Collection<FeatureFilter> forTemporalFilters(Collection<TemporalFilter> temporalFilter) {
        if (temporalFilter == null) {
            return emptyList();
        } else {
            return transform(temporalFilter, new TemporalFilterFunction());
        }
    }
}
