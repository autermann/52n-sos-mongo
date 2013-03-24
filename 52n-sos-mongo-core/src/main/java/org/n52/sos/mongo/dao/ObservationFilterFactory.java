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

import org.n52.sos.ogc.filter.ComparisonFilter;
import org.n52.sos.ogc.filter.SpatialFilter;
import org.n52.sos.ogc.filter.TemporalFilter;

/**
 * @author Christian Autermann <c.autermann@52north.org>
 */
public interface ObservationFilterFactory {

    ObservationFilter forFeatureOfInterest(String featureOfInterest);

    Collection<ObservationFilter> forFeatureOfInterests(Collection<String> featureOfInterest);

    ObservationFilter forIdentifier(String identifier);

    Collection<ObservationFilter> forIdentifiers(Collection<String> identifiers);

    Collection<ObservationFilter> forObservedProperties(Collection<String> observedProperty);

    ObservationFilter forObservedProperty(String observedProperty);

    ObservationFilter forOffering(String offering);

    Collection<ObservationFilter> forOfferings(Collection<String> offering);

    ObservationFilter forProcedure(String procedure);

    Collection<ObservationFilter> forProcedures(Collection<String> procedure);

    ObservationFilter forResultFilter(ComparisonFilter comparisonFilter);

    Collection<ObservationFilter> forResultFilters(Collection<ComparisonFilter> comparisonFilter);

    ObservationFilter forSpatialFilter(SpatialFilter spatialFilter);

    Collection<ObservationFilter> forSpatialFilters(Collection<SpatialFilter> spatialFilter);

    ObservationFilter forTemporalFilter(TemporalFilter temporalFilter);

    Collection<ObservationFilter> forTemporalFilters(Collection<TemporalFilter> temporalFilter);
}
