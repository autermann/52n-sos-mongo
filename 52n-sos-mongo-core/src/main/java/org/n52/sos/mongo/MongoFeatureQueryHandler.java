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
package org.n52.sos.mongo;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.n52.sos.ds.FeatureQueryHandler;
import org.n52.sos.ogc.filter.SpatialFilter;
import org.n52.sos.ogc.om.features.SosAbstractFeature;
import org.n52.sos.ogc.om.features.samplingFeatures.SosSamplingFeature;
import org.n52.sos.ogc.ows.OwsExceptionReport;
import org.n52.sos.ogc.sos.SosEnvelope;

public class MongoFeatureQueryHandler implements FeatureQueryHandler {
    @Override
    public SosAbstractFeature getFeatureByID(String featureID, Object connection, String version, int responseSrid)
            throws OwsExceptionReport {
        return null;
    }

    @Override
    public Collection<String> getFeatureIDs(SpatialFilter filter, Object connection) throws OwsExceptionReport {
        return Collections.emptyList();
    }

    @Override
    public Map<String, SosAbstractFeature> getFeatures(
            Collection<String> foiIDs,
            List<SpatialFilter> list, Object connection, String version,
            int responseSrid) throws OwsExceptionReport {
        return Collections.emptyMap();
    }

    @Override
    public SosEnvelope getEnvelopeForFeatureIDs(
            Collection<String> featureIDs, Object connection) throws
            OwsExceptionReport {
        return null;
    }

    @Override
    public String insertFeature(SosSamplingFeature samplingFeature, Object connection) throws OwsExceptionReport {
        return null;
    }

    @Override
    public int getDefaultEPSG() {
        return 0;
    }
}
