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

import java.util.List;
import java.util.Map;

import org.n52.sos.ogc.sos.SosProcedureDescription;

import com.github.jmkgreen.morphia.annotations.Indexed;
import com.github.jmkgreen.morphia.annotations.Property;
import com.github.jmkgreen.morphia.annotations.Reference;

/**
 * @author Christian Autermann <c.autermann@52north.org>
 */
public class Procedure extends AbstractEntity {

    private static final String IDENTIFIER = "identifier";
    private static final String DESCRIPTION_FORMAT = "descriptionFormat";
    private static final String OBSERVABLE_PROPERTIES = "observableProperties";
    private static final String FEATURE_OF_INTEREST_TYPES = "featureOfInterestTypes";
    private static final String OBSERVATION_TYPES = "observationTypes";
    
    @Indexed(unique = true)
    @Property(IDENTIFIER)
    private String identifier;
    @Property(DESCRIPTION_FORMAT)
    private String descriptionFormat;
    @Property(OBSERVABLE_PROPERTIES)
    private List<String> observableProperties;
    @Indexed
    @Reference(lazy = false)
    private List<Offering> offerings;
    @Property(FEATURE_OF_INTEREST_TYPES)
    private List<String> featureOfInterestTypes;
    @Property(OBSERVATION_TYPES)
    private List<String> observationTypes;
    
    
    private Map<String, FeatureOfInterest> relatedFeatures;
    
    private SosProcedureDescription procedureDescription;

    @Override
    public boolean equals(Object obj) {
        /* TODO implement org.n52.sos.mongo.entities.Procedure.equals() */
        throw new UnsupportedOperationException("org.n52.sos.mongo.entities.Procedure.equals() not yet implemented");
    }

    @Override
    public String toString() {
        /* TODO implement org.n52.sos.mongo.entities.Procedure.toString() */
        throw new UnsupportedOperationException("org.n52.sos.mongo.entities.Procedure.toString() not yet implemented");
    }

    @Override
    public int hashCode() {
        /* TODO implement org.n52.sos.mongo.entities.Procedure.hashCode() */
        throw new UnsupportedOperationException("org.n52.sos.mongo.entities.Procedure.hashCode() not yet implemented");
    }
}
