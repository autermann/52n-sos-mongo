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

import org.n52.sos.ds.AbstractGetResultTemplateDAO;
import org.n52.sos.mongo.dao.ResultTemplateDao;
import org.n52.sos.mongo.entities.ResultEncoding;
import org.n52.sos.mongo.entities.ResultStructure;
import org.n52.sos.mongo.entities.ResultTemplate;
import org.n52.sos.mongo.transformer.EntityTransformer;
import org.n52.sos.ogc.ows.OwsExceptionReport;
import org.n52.sos.ogc.sos.SosResultEncoding;
import org.n52.sos.ogc.sos.SosResultStructure;
import org.n52.sos.request.GetResultTemplateRequest;
import org.n52.sos.response.GetResultTemplateResponse;

public class GetResultTemplate extends AbstractGetResultTemplateDAO {
    private EntityTransformer<ResultEncoding, SosResultEncoding> resultEncodingTransformer;
    private EntityTransformer<ResultStructure, SosResultStructure> resultStructureTransformer;
    private ResultTemplateDao resultTemplateDao;

    @Override
    public GetResultTemplateResponse getResultTemplate(GetResultTemplateRequest request) throws OwsExceptionReport {
        ResultTemplate resultTemplate = resultTemplateDao.get(request.getOffering(), request.getObservedProperty());
        GetResultTemplateResponse response = new GetResultTemplateResponse();
        response.setService(request.getService());
        response.setVersion(request.getVersion());
        response.setResultEncoding(resultEncodingTransformer.toSosObject(resultTemplate.getEncoding()));
        response.setResultStructure(resultStructureTransformer.toSosObject(resultTemplate.getStructure()));
        return response;
    }

    @Inject
    public void setResultEncodingTransformer(
            EntityTransformer<ResultEncoding, SosResultEncoding> resultEncodingTransformer) {
        this.resultEncodingTransformer = resultEncodingTransformer;
    }

    @Inject
    public void setResultStructureTransformer(
            EntityTransformer<ResultStructure, SosResultStructure> resultStructureTransformer) {
        this.resultStructureTransformer = resultStructureTransformer;
    }

    @Inject
    public void setResultTemplateDao(ResultTemplateDao resultTemplateDao) {
        this.resultTemplateDao = resultTemplateDao;
    }
}
