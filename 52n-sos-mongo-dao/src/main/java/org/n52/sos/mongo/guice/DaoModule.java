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
package org.n52.sos.mongo.guice;

import org.n52.sos.mongo.dao.FeatureDao;
import org.n52.sos.mongo.dao.FeatureDaoImpl;
import org.n52.sos.mongo.dao.ObservationDao;
import org.n52.sos.mongo.dao.ObservationDaoImpl;
import org.n52.sos.mongo.dao.ProcedureDao;
import org.n52.sos.mongo.dao.ProcedureDaoImpl;
import org.n52.sos.mongo.dao.ResultEncodingDaoImpl;
import org.n52.sos.mongo.dao.ResultStructureDaoImpl;
import org.n52.sos.mongo.dao.ResultTemplateDao;
import org.n52.sos.mongo.dao.ResultTemplateDaoImpl;

import com.google.inject.AbstractModule;

/**
 * @author Christian Autermann <c.autermann@52north.org>
 */
public class DaoModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(ProcedureDao.class).to(ProcedureDaoImpl.class);
        bind(FeatureDao.class).to(FeatureDaoImpl.class);
        bind(ObservationDao.class).to(ObservationDaoImpl.class);
        bind(ResultTemplateDao.class).to(ResultTemplateDaoImpl.class);
        bind(ResultEncodingDaoImpl.class);
        bind(ResultStructureDaoImpl.class);
    }
}
