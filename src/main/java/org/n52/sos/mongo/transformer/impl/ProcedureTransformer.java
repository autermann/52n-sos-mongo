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

package org.n52.sos.mongo.transformer.impl;

import org.n52.sos.mongo.entities.Procedure;
import org.n52.sos.mongo.transformer.AbstractEntityTransformer;
import org.n52.sos.ogc.sos.SosProcedureDescription;

/**
 * @author Christian Autermann <c.autermann@52north.org>
 */
public class ProcedureTransformer extends AbstractEntityTransformer<Procedure, SosProcedureDescription> {

    @Override
    public Procedure toMongoObject(SosProcedureDescription t) {
        /* TODO implement org.n52.sos.mongo.transformer.ProcedureTransformer.toMongoObject() */
        throw new UnsupportedOperationException("org.n52.sos.mongo.transformer.ProcedureTransformer.transformReverse() not yet implemented");
    }

    @Override
    public SosProcedureDescription toSosObject(Procedure f) {
        /* TODO implement org.n52.sos.mongo.transformer.ProcedureTransformer.toSosObject() */
        throw new UnsupportedOperationException("org.n52.sos.mongo.transformer.ProcedureTransformer.transform() not yet implemented");
    }
}
