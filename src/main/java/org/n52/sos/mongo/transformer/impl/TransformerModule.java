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

import org.n52.sos.mongo.entities.Observation;
import org.n52.sos.mongo.entities.ResultEncoding;
import org.n52.sos.mongo.entities.ResultStructure;
import org.n52.sos.mongo.transformer.Transformer;
import org.n52.sos.ogc.om.SosObservation;
import org.n52.sos.ogc.sos.SosResultEncoding;
import org.n52.sos.ogc.sos.SosResultStructure;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;

/**
 * @author Christian Autermann <c.autermann@52north.org>
 */
public class TransformerModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(new TypeLiteral<Transformer<Observation, SosObservation>>() {}).to(ObservationTransformer.class);
        bind(new TypeLiteral<Transformer<ResultStructure, SosResultStructure>>() {}).to(ResultStructureTransformer.class);
        bind(new TypeLiteral<Transformer<ResultEncoding, SosResultEncoding>>() {}).to(ResultEncodingTransformer.class);
    }
}
