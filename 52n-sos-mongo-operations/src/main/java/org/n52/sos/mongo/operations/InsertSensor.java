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

import org.n52.sos.ds.AbstractInsertSensorDAO;
import org.n52.sos.mongo.dao.ProcedureDao;
import org.n52.sos.mongo.entities.FeatureRelationship;
import org.n52.sos.mongo.entities.Offering;
import org.n52.sos.mongo.entities.Procedure;
import org.n52.sos.mongo.entities.ProcedureMetadata;
import org.n52.sos.mongo.transformer.EntityTransformer;
import org.n52.sos.ogc.om.SosOffering;
import org.n52.sos.ogc.ows.OwsExceptionReport;
import org.n52.sos.ogc.sos.SosProcedureDescription;
import org.n52.sos.ogc.swe.SosFeatureRelationship;
import org.n52.sos.ogc.swe.SosMetadata;
import org.n52.sos.request.InsertSensorRequest;
import org.n52.sos.response.InsertSensorResponse;

public class InsertSensor extends AbstractInsertSensorDAO {
    private ProcedureDao sensorDao;
    private EntityTransformer<Procedure, SosProcedureDescription> procedureTransformer;
    private EntityTransformer<FeatureRelationship, SosFeatureRelationship> featureRelationshipTransformer;
    private EntityTransformer<Offering, SosOffering> offeringTransformer;
    private EntityTransformer<ProcedureMetadata, SosMetadata> metaDataTransformer;

    @Override
    public InsertSensorResponse insertSensor(InsertSensorRequest request) throws OwsExceptionReport {
        sensorDao.save(request.getAssignedProcedureIdentifier(),
                       offeringTransformer.toMongoObjectList(request.getAssignedOfferings()),
                       request.getObservableProperty(),
                       request.getProcedureDescriptionFormat(),
                       metaDataTransformer.toMongoObject(request.getMetadata()),
                       procedureTransformer.toMongoObject(request.getProcedureDescription()),
                       featureRelationshipTransformer.toMongoObjectList(request.getRelatedFeatures()));

        InsertSensorResponse response = new InsertSensorResponse();
        response.setService(request.getService());
        response.setVersion(request.getVersion());
        response.setAssignedProcedure(request.getAssignedProcedureIdentifier());
        response.setAssignedOffering(request.getFirstAssignedOffering().getOfferingIdentifier());
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

    @Inject
    public void setFeatureRelationshipTransformer(
            EntityTransformer<FeatureRelationship, SosFeatureRelationship> featureRelationshipTransformer) {
        this.featureRelationshipTransformer = featureRelationshipTransformer;
    }

    @Inject
    public void setOfferingTransformer(EntityTransformer<Offering, SosOffering> offeringTransformer) {
        this.offeringTransformer = offeringTransformer;
    }

    @Inject
    public void setMetaDataTransformer(EntityTransformer<ProcedureMetadata, SosMetadata> metaDataTransformer) {
        this.metaDataTransformer = metaDataTransformer;
    }
}
