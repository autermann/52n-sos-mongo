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
package org.n52.sos.mongo.transformer.impl;

import javax.inject.Inject;

import org.n52.sos.mongo.entities.FeatureOfInterest;
import org.n52.sos.mongo.entities.FeatureRelationship;
import org.n52.sos.mongo.transformer.AbstractEntityTransformer;
import org.n52.sos.mongo.transformer.EntityTransformer;
import org.n52.sos.ogc.om.features.SosAbstractFeature;
import org.n52.sos.ogc.swe.SosFeatureRelationship;

/**
 * @author Christian Autermann <c.autermann@52north.org>
 */
public class FeatureRelationshipTransformer extends AbstractEntityTransformer<FeatureRelationship, SosFeatureRelationship> {
    private EntityTransformer<FeatureOfInterest, SosAbstractFeature> featureTransformer;

    @Override
    public SosFeatureRelationship toSosObject(FeatureRelationship fr) {
        SosFeatureRelationship sfr = new SosFeatureRelationship();
        sfr.setRole(fr.getRole());
        sfr.setFeature(featureTransformer.toSosObject(fr.getFeatureOfInterest()));
        return sfr;
    }

    @Override
    public FeatureRelationship toMongoObject(SosFeatureRelationship t) {
        return new FeatureRelationship()
                .setRole(t.getRole())
                .setFeatureOfInterest(featureTransformer.toMongoObject(t.getFeature()));
    }

    @Inject
    public void setFeatureTransformer(EntityTransformer<FeatureOfInterest, SosAbstractFeature> featureTransformer) {
        this.featureTransformer = featureTransformer;
    }
}
