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
package org.n52.sos.mongo.entities;

import com.github.jmkgreen.morphia.annotations.Indexed;
import com.github.jmkgreen.morphia.annotations.Property;

/**
 * TODO JavaDoc
 *
 * @author Christian Autermann <c.autermann@52north.org>
 */
public class Offering extends AbstractEntity {

    private static final String NAME = "name";
    private static final String IDENTIFIER = "identifier";
    
    @Property(NAME)
    private String name;
    @Indexed(unique = true)
    @Property(IDENTIFIER)
    private String identifier;

    public String getName() {
        return name;
    }

    public Offering setName(String name) {
        this.name = name;
        return this;
    }

    public String getIdentifier() {
        return identifier;
    }

    public Offering setIdentifier(String identifier) {
        this.identifier = identifier;
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Offering) {
            Offering o = (Offering) obj;
            return eq(getIdentifier(), o.getIdentifier())
                   && eq(getName(), o.getName());
        }
        return false;
    }

    @Override
    public String toString() {
        return toString("identifier=%s, name=%s", getIdentifier(), getName());
    }

    @Override
    public int hashCode() {
        return hash(3, 71, getIdentifier(), getName());
    }
}
