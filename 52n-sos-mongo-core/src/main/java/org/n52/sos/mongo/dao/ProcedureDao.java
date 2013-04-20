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

import org.n52.sos.mongo.entities.FeatureRelationship;
import org.n52.sos.mongo.entities.Offering;
import org.n52.sos.mongo.entities.Procedure;
import org.n52.sos.mongo.entities.ProcedureMetadata;
import org.n52.sos.ogc.filter.TemporalFilter;

/**
 * @author Christian Autermann <c.autermann@52north.org>
 */
public interface ProcedureDao {

    void delete(String identifier);

    Procedure get(String identifier, List<TemporalFilter> time);

    Procedure get(String identifier);

    void save(String identifier, String procedureDescriptionFormat, List<Procedure> toMongoObjectList);

    void save(String identifier, List<Offering> offerings, List<String> observableProperty,
              String procedureDescriptionFormat, ProcedureMetadata metaData, Procedure procedure,
              List<FeatureRelationship> features);
}
