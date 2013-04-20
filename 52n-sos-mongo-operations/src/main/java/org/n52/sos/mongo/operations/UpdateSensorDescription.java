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

import org.n52.sos.ds.AbstractUpdateSensorDescriptionDAO;
import org.n52.sos.mongo.dao.ProcedureDao;
import org.n52.sos.mongo.entities.Procedure;
import org.n52.sos.mongo.transformer.EntityTransformer;
import org.n52.sos.ogc.ows.OwsExceptionReport;
import org.n52.sos.ogc.sos.SosProcedureDescription;
import org.n52.sos.request.UpdateSensorRequest;
import org.n52.sos.response.UpdateSensorResponse;

public class UpdateSensorDescription extends AbstractUpdateSensorDescriptionDAO {
    private ProcedureDao sensorDao;
    private EntityTransformer<Procedure, SosProcedureDescription> procedureTransformer;

    @Override
    public UpdateSensorResponse updateSensorDescription(UpdateSensorRequest request) throws OwsExceptionReport {
        sensorDao.save(request.getProcedureIdentifier(), request.getProcedureDescriptionFormat(),
                       procedureTransformer.toMongoObjectList(request.getProcedureDescriptions()));
        UpdateSensorResponse response = new UpdateSensorResponse();
        response.setService(request.getService());
        response.setVersion(request.getVersion());
        response.setUpdatedProcedure(request.getProcedureIdentifier());
        return response;
    }

    @Inject
    public void setSensorDao(ProcedureDao sensorDao) {
        this.sensorDao = sensorDao;
    }

    @Inject
    public void setProcedureTransformer(EntityTransformer<Procedure, SosProcedureDescription> procedureTransformer) {
        this.procedureTransformer = procedureTransformer;
    }
}
