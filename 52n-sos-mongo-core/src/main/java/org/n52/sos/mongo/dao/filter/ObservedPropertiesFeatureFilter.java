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

package org.n52.sos.mongo.dao.filter;

import org.n52.sos.mongo.dao.IFeatureFilter;
import org.n52.sos.mongo.entities.FeatureOfInterest;

import com.github.jmkgreen.morphia.query.Query;
import com.google.common.base.Function;

/**
 * @author Christian Autermann <c.autermann@52north.org>
 */
public class ObservedPropertiesFeatureFilter implements IFeatureFilter {
    private String observedProperty;

    public ObservedPropertiesFeatureFilter(String observedProperty) {
        this.observedProperty = observedProperty;
    }

    @Override
    public Query<FeatureOfInterest> filter(Query<FeatureOfInterest> q) {
        /* TODO implement org.n52.sos.mongo.dao.IFeatureFilter.ObservedPropertiesFeatureFilter.filter() */
        throw new UnsupportedOperationException("org.n52.sos.mongo.dao.FeatureFilter.ObservedPropertiesFeatureFilter.filter() not yet implemented");
    }

    public static class ObservedPropertyFilterFunction implements Function<String, IFeatureFilter> {
        @Override
        public IFeatureFilter apply(String input) {
            return new ObservedPropertiesFeatureFilter(input);
        }
    }
}
