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

import org.n52.sos.mongo.entities.ResultStructure;
import org.n52.sos.mongo.transformer.AbstractEntityTransformer;
import org.n52.sos.ogc.sos.SosResultStructure;

/**
 * @author Christian Autermann <c.autermann@52north.org>
 */
public class ResultStructureTransformer extends AbstractEntityTransformer<ResultStructure, SosResultStructure> {

    @Override
    public ResultStructure toMongoObject(SosResultStructure t) {
        /* TODO implement org.n52.sos.mongo.transformer.ResultStructureTransformer.toMongoObject() */
        throw new UnsupportedOperationException("org.n52.sos.mongo.transformer.ResultStructureTransformer.transformReverse() not yet implemented");
    }

    @Override
    public SosResultStructure toSosObject(ResultStructure f) {
        /* TODO implement org.n52.sos.mongo.transformer.ResultStructureTransformer.toSosObject() */
        throw new UnsupportedOperationException("org.n52.sos.mongo.transformer.ResultStructureTransformer.transform() not yet implemented");
    }
}
