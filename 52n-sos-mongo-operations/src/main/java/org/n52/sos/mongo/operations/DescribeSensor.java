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
package org.n52.sos.mongo.operations;

import javax.inject.Inject;

import org.n52.sos.ds.AbstractDescribeSensorDAO;
import org.n52.sos.mongo.dao.IProcedureDao;
import org.n52.sos.mongo.entities.Procedure;
import org.n52.sos.mongo.transformer.EntityTransformer;
import org.n52.sos.ogc.ows.OwsExceptionReport;
import org.n52.sos.ogc.sos.SosProcedureDescription;
import org.n52.sos.request.DescribeSensorRequest;
import org.n52.sos.response.DescribeSensorResponse;

public class DescribeSensor extends AbstractDescribeSensorDAO {
    private EntityTransformer<Procedure, SosProcedureDescription> procedureTransformer;
    private IProcedureDao sensorDao;

    @Override
    public DescribeSensorResponse getSensorDescription(DescribeSensorRequest request) throws OwsExceptionReport {
        Procedure procedure = getSensorDao().get(request.getProcedure(), request.getTime());
        SosProcedureDescription sosProcedure = getProcedureTransformer().toSosObject(procedure);
        DescribeSensorResponse response = new DescribeSensorResponse();
        response.setService(request.getService());
        response.setVersion(request.getVersion());
        response.setOutputFormat(request.getProcedureDescriptionFormat());
        response.setSensorDescription(sosProcedure);
        return response;
    }

    /**
     * @return the procedureTransformer
     */
    public EntityTransformer<Procedure, SosProcedureDescription> getProcedureTransformer() {
        return procedureTransformer;
    }

    /**
     * @param procedureTransformer the procedureTransformer to set
     */
    @Inject
    public void setProcedureTransformer(
            EntityTransformer<Procedure, SosProcedureDescription> procedureTransformer) {
        this.procedureTransformer = procedureTransformer;
    }

    /**
     * @return the sensorDao
     */
    public IProcedureDao getSensorDao() {
        return sensorDao;
    }

    /**
     * @param sensorDao the sensorDao to set
     */
    @Inject
    public void setSensorDao(IProcedureDao sensorDao) {
        this.sensorDao = sensorDao;
    }
}