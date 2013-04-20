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
package org.n52.sos.mongo.entities;

import static com.google.common.base.Preconditions.checkNotNull;

import com.github.jmkgreen.morphia.annotations.Property;
import com.github.jmkgreen.morphia.annotations.Reference;

/**
 * @author Christian Autermann <c.autermann@52north.org>
 */
public class FeatureRelationship {
    public static final String ROLE = "role";
    public static final String FEATURE_OF_INTEREST = "featureOfInterest";
    @Property(ROLE)
    private String role;
    @Reference(FEATURE_OF_INTEREST)
    private FeatureOfInterest featureOfInterest;

    public String getRole() {
        return role;
    }

    public FeatureRelationship setRole(String role) {
        this.role = checkNotNull(role);
        return this;
    }

    public FeatureOfInterest getFeatureOfInterest() {
        return featureOfInterest;
    }

    public FeatureRelationship setFeatureOfInterest(FeatureOfInterest featureOfInterest) {
        this.featureOfInterest = checkNotNull(featureOfInterest);
        return this;
    }
}
