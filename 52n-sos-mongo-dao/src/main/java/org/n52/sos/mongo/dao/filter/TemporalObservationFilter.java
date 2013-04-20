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
package org.n52.sos.mongo.dao.filter;

import org.n52.sos.mongo.dao.ObservationFilter;
import org.n52.sos.mongo.entities.Observation;
import org.n52.sos.ogc.filter.TemporalFilter;

import com.github.jmkgreen.morphia.query.Query;
import com.google.common.base.Function;

/**
 * @author Christian Autermann <c.autermann@52north.org>
 */
public class TemporalObservationFilter implements ObservationFilter {
    private TemporalFilter filter;

    public TemporalObservationFilter(TemporalFilter filter) {
        this.filter = filter;
    }

    @Override
    public Query<Observation> filter(Query<Observation> q) {
        /* TODO implement org.n52.sos.mongo.dao.ObservationFilter.TemporalObservationFilter.filter() */
        throw new UnsupportedOperationException("org.n52.sos.mongo.dao.ObservationFilter.TemporalObservationFilter.filter() not yet implemented");
    }

    public static class TemporalFilterFunction implements Function<TemporalFilter, ObservationFilter> {
        @Override
        public ObservationFilter apply(TemporalFilter input) {
            return new TemporalObservationFilter(input);
        }
    }
}
