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

import org.n52.sos.ogc.gml.time.TimeInstant;
import org.n52.sos.ogc.gml.time.TimePeriod;
import org.n52.sos.ogc.om.IObservationValue;
import org.n52.sos.ogc.om.SosObservationConstellation;

import com.github.jmkgreen.morphia.annotations.Property;
import com.github.jmkgreen.morphia.annotations.Reference;

/**
 * @author Christian Autermann <c.autermann@52north.org>
 */
public class Observation extends AbstractEntity {

    public static final String RESULT_TIME = "resultTime";
    public static final String EVENT_TIME = "eventTime";
    public static final String VALID_TIME = "validTime";
    public static final String OBSERVATION_ID = "observationId";
    public static final String IDENTIFIER = "identifier";
    public static final String VALUE = "value";
    public static final String PROCEDURE = "procedure";
    public static final String OFFERING = "offering";
    @Reference(value = PROCEDURE, lazy = true)
    private Procedure procedure;
    @Reference(value = OFFERING, lazy = true)
    private Offering offering;
    @Property(OBSERVATION_ID)
    private String observationId;
    @Property(IDENTIFIER)
    private Identifier identifier;
    @Property(RESULT_TIME)
    private TimeInstant resultTime;
    @Property(VALID_TIME)
    private TimePeriod validTime;
    
    private String resultType;
    private IObservationValue<?> value;
    private String setId;
    
    private SosObservationConstellation observationConstellation;

    @Override
    public boolean equals(Object obj) {
        /* TODO implement org.n52.sos.mongo.entities.Observation.equals() */
        throw new UnsupportedOperationException("org.n52.sos.mongo.entities.Observation.equals() not yet implemented");
    }

    @Override
    public String toString() {
        /* TODO implement org.n52.sos.mongo.entities.Observation.toString() */
        throw new UnsupportedOperationException("org.n52.sos.mongo.entities.Observation.toString() not yet implemented");
    }

    @Override
    public int hashCode() {
        /* TODO implement org.n52.sos.mongo.entities.Observation.hashCode() */
        throw new UnsupportedOperationException("org.n52.sos.mongo.entities.Observation.hashCode() not yet implemented");
    }
}
