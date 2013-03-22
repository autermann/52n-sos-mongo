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

import com.github.jmkgreen.morphia.annotations.Embedded;
import com.github.jmkgreen.morphia.annotations.Property;

/**
 * @author Christian Autermann <c.autermann@52north.org>
 */
@Embedded
public class Identifier extends AbstractEntity {

    public static final String NAME = "name";
    public static final String CODE_SPACE = "codeSpace";
    
    @Property(CODE_SPACE)
    private String codeSpace;
    @Property(NAME)
    private String name;

    public Identifier(String codeSpace, String name) {
        this.codeSpace = codeSpace;
        this.name = name;
    }

    public Identifier() {
    }

    public String getCodeSpace() {
        return codeSpace;
    }

    public Identifier setCodeSpace(String codeSpace) {
        this.codeSpace = codeSpace;
        return this;
    }

    public String getName() {
        return name;
    }

    public Identifier setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public int hashCode() {
        return hash(7, 61, getCodeSpace(), getName());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Identifier) {
            Identifier o = (Identifier) obj;
            return eq(getName(), o.getName())
                   && eq(getCodeSpace(), o.getCodeSpace());
        }
        return false;
    }

    @Override
    public String toString() {
        return toString("codeSpace=%s, name=%s", getCodeSpace(), getName());
    }
}
