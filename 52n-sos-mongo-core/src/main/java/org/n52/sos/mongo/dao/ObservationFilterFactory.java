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
