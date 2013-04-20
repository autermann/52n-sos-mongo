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
package org.n52.sos.mongo.operations;

import javax.inject.Inject;

import org.n52.sos.ds.AbstractInsertObservationDAO;
import org.n52.sos.mongo.dao.ObservationDao;
import org.n52.sos.mongo.entities.Observation;
import org.n52.sos.mongo.transformer.EntityTransformer;
import org.n52.sos.ogc.om.SosObservation;
import org.n52.sos.ogc.ows.OwsExceptionReport;
import org.n52.sos.request.InsertObservationRequest;
import org.n52.sos.response.InsertObservationResponse;

public class InsertObservation extends AbstractInsertObservationDAO {
    private ObservationDao observationDao;
    private EntityTransformer<Observation, SosObservation> observationTransformer;

    @Override
    public InsertObservationResponse insertObservation(InsertObservationRequest request) throws OwsExceptionReport {
        observationDao.save(request.getAssignedSensorId(), request.getOfferings(),
                            observationTransformer.toMongoObjectList(request.getObservations()));
        InsertObservationResponse response = new InsertObservationResponse();
        response.setService(request.getService());
        response.setVersion(request.getVersion());
        return response;
    }

    @Inject
    public void setObservationDao(ObservationDao observationDao) {
        this.observationDao = observationDao;
    }

    @Inject
    public void setObservationTransformer(EntityTransformer<Observation, SosObservation> observationTransformer) {
        this.observationTransformer = observationTransformer;
    }
}
