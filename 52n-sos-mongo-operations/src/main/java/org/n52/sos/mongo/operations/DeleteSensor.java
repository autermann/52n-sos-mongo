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

import org.n52.sos.ds.AbstractDeleteSensorDAO;
import org.n52.sos.mongo.dao.ProcedureDao;
import org.n52.sos.ogc.ows.OwsExceptionReport;
import org.n52.sos.request.DeleteSensorRequest;
import org.n52.sos.response.DeleteSensorResponse;

public class DeleteSensor extends AbstractDeleteSensorDAO {
    private ProcedureDao sensorDao;

    @Override
    public DeleteSensorResponse deleteSensor(DeleteSensorRequest request) throws OwsExceptionReport {
        sensorDao.delete(request.getProcedureIdentifier());

        DeleteSensorResponse response = new DeleteSensorResponse();
        response.setVersion(request.getVersion());
        response.setService(request.getService());
        response.setDeletedProcedure(request.getProcedureIdentifier());
        return response;
    }

    @Inject
    public void setSensorDao(ProcedureDao sensorDao) {
        this.sensorDao = sensorDao;
    }
}
