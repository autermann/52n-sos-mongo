/*
 * Copyright (C) 2013 52north.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package org.n52.sos.mongo.dao;

import java.util.List;

import org.n52.sos.mongo.entities.FeatureRelationship;
import org.n52.sos.mongo.entities.Offering;
import org.n52.sos.mongo.entities.Procedure;
import org.n52.sos.mongo.entities.ProcedureMetadata;
import org.n52.sos.ogc.filter.TemporalFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TODO JavaDoc
 * @author Christian Autermann <c.autermann@52north.org>
 */
public interface IProcedureDao {

    void delete(String identifier);

    Procedure get(String identifier,
                  List<TemporalFilter> time);

    Procedure get(String identifier);

    void save(String identifier, String procedureDescriptionFormat,
              List<Procedure> toMongoObjectList);

    void save(String identifier,
              List<Offering> offerings,
              List<String> observableProperty, String procedureDescriptionFormat, ProcedureMetadata metaData,
              Procedure procedure,
              List<FeatureRelationship> features);
}
