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

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.n52.sos.ds.GeneralQueryDAO;
import org.n52.sos.ds.GeneralQueryDAO.QueryResult;

public class GeneralQuery implements GeneralQueryDAO {

    @Override
    public QueryResult query(String query) throws SQLException, FileNotFoundException, IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
