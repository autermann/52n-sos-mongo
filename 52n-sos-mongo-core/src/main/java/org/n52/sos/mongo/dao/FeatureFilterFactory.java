/*
 * Copyright (C) 2013 52north.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package org.n52.sos.mongo.dao;

import java.util.Collection;

import org.n52.sos.ogc.filter.SpatialFilter;
import org.n52.sos.ogc.filter.TemporalFilter;

/**
 * @author Christian Autermann <c.autermann@52north.org>
 */
public interface FeatureFilterFactory {

    FeatureFilter forIdentifier(String identifier);

    Collection<FeatureFilter> forIdentifiers(Collection<String> identifiers);

    Collection<FeatureFilter> forObservedProperties(Collection<String> observedProperties);

    FeatureFilter forObservedProperty(String observedProperty);

    FeatureFilter forProcedure(String procedure);

    Collection<FeatureFilter> forProcedure(Collection<String> procedures);

    FeatureFilter forSpatialFilter(SpatialFilter spatialFilter);

    Collection<FeatureFilter> forSpatialFilters(Collection<SpatialFilter> spatialFilters);

    FeatureFilter forTemporalFilter(TemporalFilter temporalFilter);

    Collection<FeatureFilter> forTemporalFilters(Collection<TemporalFilter> temporalFilter);
}
