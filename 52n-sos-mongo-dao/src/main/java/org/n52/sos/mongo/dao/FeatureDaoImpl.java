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

import java.util.List;

import javax.inject.Inject;

import org.n52.sos.mongo.entities.FeatureOfInterest;

/**
 * @author Christian Autermann <c.autermann@52north.org>
 */
public class FeatureDaoImpl extends AbstractMongoDao<FeatureOfInterest> implements FeatureDao {
    @Inject
    public FeatureDaoImpl(DatastoreProvider datastoreProvider) {
        super(FeatureOfInterest.class, datastoreProvider);
    }

    @Override
    public FeatureOfInterest get(List<FeatureFilter> filters) {
        /* TODO implement org.n52.sos.mongo.dao.FeatureDaoImpl.get() */
        throw new UnsupportedOperationException("org.n52.sos.mongo.dao.FeatureDao.get() not yet implemented");
    }
}
